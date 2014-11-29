-- Command keys as defined in lircd.conf
-- Used for sending appropriate infrared commands
command = {"KEY_UP", "KEY_DOWN", "KEY_LEFT", "KEY_RIGHT",
  "KEY_0", "KEY_1", "KEY_2", "KEY_3", "KEY_4",
  "KEY_5", "KEY_6", "KEY_7", "KEY_8", "KEY_9",
  "BTN_0", "BTN_1", "BTN_2", "BTN_3", "BTN_4",
  "BTN_5", "BTN_6", "BTN_7", "BTN_8", "BTN_9"}


local socket = require ("socket")
local MQTT = require("mqtt_library")

debug = true
running = true
value = "none"
--INTERVAL = 500
now = socket.gettime()*1000
--sendtime = now + INTERVAL
angeltime = now
angelstate = false

-- MQTT settings
MQTT_SERVER_URL = "lun.lunifera.org"
--MQTT_SERVER_URL = "10.0.0.40"
MQTT_SERVER_PORT = "1883"
MQTT_CLIENT_ID = "xmasraspi"
MQTT_TOPIC = "xmastree_command"
--MQTT_SEND_TOPIC = "xmastree_pic"
MQTT_VALUE_SEPARATOR = ":"



local function main()
  if debug then print("Started XmasTreeController ...") end

  -- setup board
  cmd="gpio mode 1 pwm"
  os.execute(cmd)
  cmd="gpio pwm 1 0"
  os.execute(cmd)

  cmd="gpio mode 5 out"
  os.execute(cmd)
  cmd="gpio write 5 0"
  os.execute(cmd)

  -- setup and connect MQTT client
 -- if debug then MQTT.Utility.set_debug(true) end
  mqtt_client = MQTT.client.create(MQTT_SERVER_URL, MQTT_SERVER_PORT, callback)
  mqtt_client:connect(MQTT_CLIENT_ID)
  mqtt_client:subscribe({ MQTT_TOPIC })

  while running == true do
    -- check for incoming commands
    mqtt_client:handler()
    if debug then print ("Status: "..value) end

    -- turn off angel if required
    now = socket.gettime()*1000
      if (angelstate == true and now > angeltime) then
        cmd = "gpio pwm 1 0"
	os.execute(cmd)
        angelstate = false
      end
    socket.sleep(0.2)
  end

  cmd="irsend SEND_ONCE ledband "..command[3]
  if debug then print(cmd) end
  os.execute(cmd)
end


function callback(
topic,    -- string
message)  -- string

 -- if debug then 
 --   print("Received: " .. topic .. ", message: '" .. message .. "'") 
 -- end

  mqttcommand, value = string.match(message,"(%a+)%s*"..MQTT_VALUE_SEPARATOR.."%s*(-?%d+)",init)
  if debug then
    print("command: "..mqttcommand)
    print("value: "..value)
  end
  value = tonumber(value)

  if mqttcommand == "button" then
    if value == 25 then
      cmd = "gpio write 5 1"
      os.execute(cmd)
      cmd = "sleep 0.2"
      os.execute(cmd)
      cmd = "gpio write 5 0"
      os.execute(cmd)
      if debug then print("Sent star command ") end
    elseif value == 26 then
      cmd ="gpio pwm 1 800"
      os.execute(cmd)
      angelstate = true
      now = socket.gettime()*1000
      angeltime = now + 15000
      if debug then print("Sent angel command ") end
    else
      cmd = "irsend SEND_ONCE ledband "..command[value]
      os.execute(cmd)
      if debug then print("Sent "..command[value]) end
    end
  elseif mqttcommand == "off" then 
    running = false
  end
end

main()

