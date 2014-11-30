#include <Servo.h> 
 
Servo myservo;            //  create servo object to control a servo 
 
int pos = 0;              //  servo position 
int in = 7;               //  input pin triggered by Raspberry Pi
boolean active = false;   //  flag to avoid triggering while already active
 
void setup() 
{ 
  pinMode(in, INPUT);     //  define input pin
  myservo.attach(9);      //  define servo pin 
} 

void loop()
{
  myservo.write(180);     //  set servo to neutral
  if(active==false && digitalRead(in)==HIGH) {
    active = true;
    wave();               //  move servo when triggered
    delay(50);
  }
  delay(50);
}
 
void wave() 
{ 
  for(pos = 180; pos>=30; pos-=1)     //  go from 180 degrees to 0 degrees 
  {                                
    myservo.write(pos);               //  tell servo to go to position in variable 'pos' 
    delay(25);                        //  wait for the servo to reach the position 
  } 
  for(pos = 30; pos < 180; pos += 1)  //  go from 0 degrees back to 180 degrees 
  {                                    
    myservo.write(pos);               //  tell servo to go to position in variable 'pos' 
    delay(25);                        //  wait for the servo to reach the position 
  } 
  active = false;
}
