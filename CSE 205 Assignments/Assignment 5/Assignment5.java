// Assignment #: 5
// Arizona State University - CSE205
//         Name: VishnuKadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30-2:45
//  Description: The Assignment 5 class displays a menu of choices
//               (add summer camp, search summer camp title,
//               list summer camps, quit, display menu) to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList
import java.text.NumberFormat;
import java.util.Locale; 	//to use NumberFormat
import java.io.FileInputStream;
import java.io.IOException;
//numberFormat declaration



//main driver program
public class Assignment5
 {
  public static void main (String[] args)
   {
	  /*try{
			 System.setIn(new FileInputStream("C:\\Users\\vishn\\eclipse-workspace/Assignment4/test/input1.txt"));
			}catch(IOException e){
			 e.printStackTrace();
			}*/
	 
	 NumberFormat numF = NumberFormat.getInstance(Locale.US);
     char input1;
     String inputInfo = new String();
     String line = new String();
     boolean operation = false;

     // ArrayList object is used to store SummerCamp objects
     ArrayList summerCampList = new ArrayList();

     try
      {
       printMenu();     // print out menu

       // create a BufferedReader object to read input from a keyboard
       InputStreamReader isr = new InputStreamReader (System.in);
       BufferedReader stdin = new BufferedReader (isr);

       do
        {
         System.out.println("What action would you like to perform?");
         line = stdin.readLine().trim();
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)
          {
           switch (input1)
            {
             case 'A':   //Add SummerCamp
               System.out.print("Please enter some summer camp information to add:\n");
               inputInfo = stdin.readLine().trim();
               summerCampList.add(SummerCampParser.parseStringToSummerCamp(inputInfo));
               break;
             case 'C':   
                	for(int i = 0 ; i < summerCampList.size();i++) 
                	{
                		SummerCamp temp = (SummerCamp) summerCampList.get(i);
                		temp.computeTotalCosts();
                 	}
                	System.out.print("total costs computed\n");
                
               break;
             case 'D':   //Search for SummerCamp
               System.out.print("Please enter a summer camp title to search:\n");
               inputInfo = stdin.readLine().trim();
               operation = false;
               
            	   for(int i =0 ; i<summerCampList.size();i++) 
            	   {
            		   if(((SummerCamp) summerCampList.get(i)).getCampTitle().equalsIgnoreCase(inputInfo)) 
            		   {
            			   operation=true;
            		   }
            		  
            	   }
               
                if (operation == true)
                 System.out.print("SummerCamp found\n");
                else
                 System.out.print("SummerCamp not found\n");
               break;
             case 'L':   //List SummerCamps
                
            	 if(summerCampList.size()>0) 
            	 {
            		 for(int i =0;i<summerCampList.size();i++) 
            		 {
            			 SummerCamp temp2 = (SummerCamp) summerCampList.get(i);
            			 System.out.print(temp2.toString());
            		 }
            	 }
            	 else
            		 System.out.println("no summer camp");
               break;
             case 'Q':   //Quit
               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
         }
        else
         {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q'); // stop the loop when Q is read
      }
     catch (IOException exception)
      {
        System.out.println("IO Exception");
      }
  }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd SummerCamp\n" +
                      "C\t\tCompute Total Costs\n" +
                      "D\t\tSearch for SummerCamp\n" +
                      "L\t\tList SummerCamps\n" +
                      "Q\t\tQuit\n" +
                      "?\t\tDisplay Help\n\n");
  }
}



