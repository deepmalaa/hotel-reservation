// Name: Deepmala Bhomi          Date Assigned: 03/10/2020
//
// Course: CSCI 2003 42733       Date Due: 03/17/2020
//
// Instructor: Ms. Greer
//
// File name: HotelReservations.java
//
// Program Description: This program stimulates a small hotel with 18 room's online reservation.
//                      This program will let user reserve hotel rooms multiple times.
//                      The user can update the reservation if they have made a mistake. 
//                      The room prices are determined according to the number of nights. 
//                      



//importing Scanner class
import java.util.Scanner;


/**
 * Lets user reserve hotel rooms.
 */

public class HotelReservations
{
   /**
    * Creating main method
      @param args stores command line arguments
    */
   public static void main(String[] args)
   {  
   
      //Creating Scanner object
      Scanner in = new Scanner(System.in);
      
      
      //initializing variable to use later in the loops
      int availableRooms = 18;
      String userInput2 = "y";
      int numberOfStays = 0;
      int children;
      int adults;
      double price = 0.0;
      String ticket="";
      double subtotal= 0.0;
      double subTotal = 0.0;
      int totalAdults = 0;
      int totalChildren = 0;
      
      
      /*initilizing while loop to allow registration when user enters 'y'
      when asked if they want to reserve another room*/
      while (userInput2.equals("y") && availableRooms!=0)
      {
         
         //displaying header
         System.out.println("Online Hotel Reservations");
         System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=\n");
            
         System.out.println("Reserve Your Room");
         System.out.println("=================\n");
         
         
         //displaying the numbers of rooms currently available 
         System.out.println("     +-----------------------------------+");
         System.out.println("     |                                   |");
         System.out.printf("%6s%3d rooms are currently available. |\n" , "|" , availableRooms);
         System.out.println("     |                                   |");
         System.out.println("     +-----------------------------------+\n");
         
         
         //displaying duration of stay header 
         System.out.println("Duration of Your Stay");
         System.out.println("=====================\n");
         
           
         String userInput ="n";
         
         
         //executes the loop when the value for userInput is 'n'
         //alows user to update incorrect reservation information
         do
         {
         
            //displaying price chart
            System.out.println("     +-----------+-----------------+");
            System.out.println("     | Nights    | Price per Night |");
            System.out.println("     +-----------+-----------------+");
            System.out.println("     | 1         | $99.99          |");
            System.out.println("     +-----------+-----------------+");
            System.out.println("     | 2         | $89.99          |");
            System.out.println("     +-----------+-----------------+");
            System.out.println("     | 3         | $79.99          |");
            System.out.println("     +-----------+-----------------+\n");
            
            
            //asking user to enter number of nights
            System.out.print("Enter number of nights: ");
            numberOfStays = in.nextInt();
            
            
            //displaying number of people header
            System.out.println("\n\nNumber of People in Your Party");
            System.out.println("==============================\n");
            
            
            //asking user to enter number of adults
            System.out.print("Enter number of adults: ");
            adults = in.nextInt();
            
            
            //asking user to input number of children
            System.out.print("Enter number of children: ");
            children = in.nextInt();
            
            
            //assigning price per day based on number of nights chosen
            if (numberOfStays == 1)
            {  
               price = 99.99;
               
            }
            
            else if (numberOfStays == 2)
            {
               price = 89.99;
            }
            
            else if (numberOfStays >= 3)
            {
               price = 79.99;
            }
            
            
            
            //calculating subtotal based on number of days chosen
            subtotal = numberOfStays*price;
            
            
            //displaying reservation information
            System.out.println("\n\n     ===========================");
            System.out.println("     | Reservation Information |");
            System.out.println("     ===========================");
            System.out.printf("     | %-10s%13d |\n","Adults", adults);
            System.out.printf("     | %-10s%13d |\n","Children", children);
            System.out.println("     |                         |");
            System.out.printf("     | %-10s%5d x %5.2f |\n","Nights", numberOfStays, price);
            System.out.println("     ===========================\n");
            
            
            //asking user if the reservation information displayed is correct or not.
            System.out.print("Is this information correct? (y/n) : ");
            
            userInput = in.next();
            
            // letting the user update their reservation if they enter "n"
            if (userInput.equals("n"))
            {
               System.out.println("--------------------------------------\n");
               System.out.println("Update Information Below\n");
            }
            
            
            /*adding an else statement so that the incorrect information wont be saved and 
            dispalyed in the finalized information*/
            else
            
            {
             //saving information abouth each reservation in String variable ticket using concatination
               ticket +="     | Nights        "+numberOfStays + " x " + price +" |\n";
             
             
             //adding subtotal after each reservation
               subTotal+= subtotal;
            
            
             //adding total number of adults after each registration
               totalAdults += adults;
             
             
             //adding total number of children after each registration
               totalChildren += children;
            } 
          
            
         }            // ending do while loop
         
         
         
         //initilizing do while loop to let user update reservation information
         while (!(userInput.equals("y")));
         
         //calculating tax 
         double tax = 0.11 *subTotal;
         
         //calculating total
         double total = tax+ subTotal;
         
         
         
         ///displaying finalized information
         System.out.println("\n     ===========================");
         System.out.println("     |  Finalized Information  |");
         System.out.println("     ===========================");
         System.out.printf("     | %-10s%13d |\n","Adults", totalAdults);
         System.out.printf("     | %-10s%13d |\n","Children", totalChildren);
         System.out.println("     |                         |");
         System.out.print(ticket);              /*String ticket contains the reservation information 
                                                  of previous reservations*/
         System.out.println("     ===========================");
         System.out.printf("     | %-10s%13.2f |\n","Subtotal", subTotal);
         System.out.printf("     | %-10s%13.2f |\n","Tax", tax);
         System.out.printf("     | %-10s%13.2f |\n","Total", total);
         System.out.println("     ===========================\n");
         
                
                
         //asking user if they want to reserve another room or not
         System.out.print("Would you like to reserve another room? (y/n): ");
         userInput2 = in.next();
         
         
         System.out.println("------------------------------------------------\n");
         
         
         // decreasing number of available rooms after each registration
         availableRooms -=1;
         
         
      }           //ends while loop that allows multiple reservations
      
      
      if (availableRooms == 0)
      {
         //dispalying no rooms availabe message when availabe rooms is 0
         System.out.println("Sorry! No rooms are available.");
      }
      
      else
      {  
         //displaying farewell message
         System.out.println("Please come again!");
      }
      
      
      
   }     //end main method
   
}        //end class