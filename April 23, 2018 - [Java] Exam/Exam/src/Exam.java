import java.util.Scanner;
public class Exam
{
   public static void main(String[] args)
   {
   Scanner keyboard = new Scanner(System.in);
   
   int[] array = new int[20];
   int counterOdd = 0;
   int counterEven = 0;
   int counterPos = 0;
   int counterNeg = 0;
   int sumNegNums = 0;
   
   for(int a = 0; a < 20; a++)
      {
      System.out.println("Enter an integer:");
      array[a] = keyboard.nextInt();
      if(array[a] > 0)
         counterPos += 1;
      else if(array[a] < 0)
         counterNeg += 1;
      else
         counterPos += 0;
         
      if(((array[a]%2) == 1)||(array[a]%2 == -1))
         counterOdd += 1;
      else if((array[a]%2) == 0)
         counterEven += 1;
      else
         counterOdd += 0;
      }
    
    int[] oddArray = new int[20];
    int[] evenArray = new int[20];
    int[] positiveArray = new int[20];
    int[] negativeArray = new int[20];
    int w = 0;
    int x = 0;
    int y = 0;
    int z = 0;
    
    for(int b = 0; b < 20; b++)
      {
         if(array[b] > 0)
         {
            positiveArray[w]=array[b];
            w++;
         }
         else if(array[b] < 0)
         {
            negativeArray[x]=array[b];
            x++;
         }
         else
         x+=0;
         
         if((array[b]%2) == 1)
         {
            oddArray[y] = array[b];
            y++;
         }
         else if((array[b]%2) == 0)
         {
            evenArray[z] = array[b];
            z++;
         }
         else
         z+=0;
      }
    
    int highestPosNum = positiveArray[0];
    int lowestPosNum = positiveArray[0];
    
    //Difference between highest/lowest pos sum
    
    for(int c = 0; c < counterPos; c++)
      {
      if(positiveArray[c] > highestPosNum)
         highestPosNum = positiveArray[c];
      else
         highestPosNum+=0;
         
      if(positiveArray[c] < lowestPosNum)
         lowestPosNum = positiveArray[c];
      else
         lowestPosNum += 0;
      }
      
    int difference = highestPosNum - lowestPosNum;
    
    //Sum of all Neg Nums
    
    for(int d = 0; d < counterNeg; d++)
      sumNegNums += negativeArray[d];
    
    //Desired Output at User's Request
    int choice;
    System.out.println("Enter number for following \n1. Original Array \n2. Odd Numbers \n3. Even Numbers \n4. Positive Numbers \n5. Negative Numbers \n6. Highest/Lowest Positive Number and Difference");
    System.out.println("7. Sum of Negative Numbers \n8. All Positive Numbers less than 50 \n9. All Even Numbers in Reverse Order \n10. All 5 multiples(Positive/Negative) ");
    choice = keyboard.nextInt();
    
    switch(choice)
    {
      case 1:
      {
         System.out.println("Original Array:");
         for(int e = 0; e < 20; e++)
            System.out.println(array[e]);
      }
      break;
      case 2:
      {
         System.out.println("Array of Odd Numbers:");
         for(int f = 0; f < counterOdd; f++)
            System.out.println(oddArray[f]);
      }
      break;
      case 3:
      {
         System.out.println("Array of Even Numbers:");
         for(int g = 0; g < counterEven; g++)
            System.out.println(evenArray[g]);
      }
      break;
      case 4:
      {
         System.out.println("Array of Positive:");
         for(int h = 0; h < counterPos; h++)
            System.out.println(positiveArray[h]);
      }
      break;
      case 5:
      {
         System.out.println("Array of Negative:");
         for(int i = 0; i < counterNeg; i++)
            System.out.println(negativeArray[i]);
      }
      break;
      case 6:
         System.out.println("Highest Pos Number: "+highestPosNum+"\nLowest Pos Number: "+lowestPosNum+"Difference: "+difference);
      break;
      case 7:
         System.out.println("Sum of Neg Numbers: "+sumNegNums);
      break;
      case 8:
      {
         System.out.println("Positive Numbers Less Than 50: ");
         for(int j = 0; j < counterPos; j++)
         {
            if(positiveArray[j] < 50)
            System.out.println(positiveArray[j]);
            else
            j+=0;
         }
      }
      break;
      case 9:
      {
         System.out.println("Even Numbers in Rev Order: ");
         for(int k = counterNeg; k > 0; k--)
            System.out.println(negativeArray[k-1]);
      }
      break;
      case 10:
      {
         System.out.println("All numbers (5 multiple): ");
         for(int l = 0; l < 20; l++)
            {
               if((array[l]%5) == 0)
                  System.out.println(array[l]);
               else
                  l+=0;
            }
      }
      break;
      default:
         {
         System.out.println("Invalid Input, Try Again:");
         choice = keyboard.nextInt();
         }
      } 
   }
}