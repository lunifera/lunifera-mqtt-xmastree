#include <Servo.h> 
 
Servo myservo;  // create servo object to control a servo 
                // a maximum of eight servo objects can be created 
 
int pos = 0;    // variable to store the servo position 
int in = 7;
boolean active = false;
 
void setup() 
{ 
  pinMode(in, INPUT);
  myservo.attach(9);  // attaches the servo on pin 9 to the servo object 
} 

void loop()
{
  myservo.write(180);
  if(active==false && digitalRead(in)==HIGH) {
    active = true;
    wave();
    delay(50);
  }
  delay(50);
}
 
void wave() 
{ 
  active = true;
  for(pos = 180; pos>=30; pos-=1)     // goes from 180 degrees to 0 degrees 
  {                                
    myservo.write(pos);              // tell servo to go to position in variable 'pos' 
    delay(25);                       // waits 15ms for the servo to reach the position 
  } 
  for(pos = 30; pos < 180; pos += 1)  // goes from 0 degrees to 180 degrees 
  {                                  // in steps of 1 degree 
    myservo.write(pos);              // tell servo to go to position in variable 'pos' 
    delay(25);                       // waits 15ms for the servo to reach the position 
  } 
  active = false;
}
