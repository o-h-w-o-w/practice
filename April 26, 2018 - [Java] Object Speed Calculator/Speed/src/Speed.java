
import java.util.Scanner;

public class Speed
{
   public static void main(String[] args)
   {
      float t = 0;
      float d = 0;
      float s = 0;
      int counter = 0, c;
      Scanner keyboard = new Scanner(System.in);
      
      greeting();
      System.out.println("How many times do you want to run this: ");
      c = keyboard.nextInt();
      
      while(counter < c)
      {
    	  t = inputTime();
      d = inputDistance();
      
      s = processSpeed(t, d);
      
      output(d, t, s);
      
      c++;
      }
      
   }
   //Greeting
   public static void greeting()
   {
      System.out.println("Hello! This program determines the speed of an object");
   }
   //Input
   public static float inputTime()
   {
      Scanner keyboard = new Scanner(System.in);
      float time;
      
      System.out.println("Please enter the amount of time:");
      time = keyboard.nextFloat();
      
      return time;
   }
   
   public static float inputDistance()
   {
      Scanner keyboard = new Scanner(System.in);
      float distance;
      
      System.out.println("Please enter the distance within that time: ");
      distance = keyboard.nextFloat();
      
      return distance;
   }
   //Process
   
   public static float processSpeed(float time, float distance)
   {
      float speed;
      speed = distance / time;
      
      System.out.println(speed);
      
      return speed;
   }
   //Output
   public static void output(float distance, float time, float speed)
   {
      System.out.println("Distance: "+distance);
      System.out.println("Time: "+time);
      System.out.println("Speed: "+speed);
   }
}