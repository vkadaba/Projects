import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Assignment #: Arizona State University CSE205 #7
//         Name: Vishnu Kadaba
//    StudentID: 1217459815
//      Lecture: TTH 1:30pm
//  Description: Assignment #9 will be the construction of a program that reads in a sequence of integers from
//              standard input until 0 is read, and store them in an array (including 0). This is done using iteration (choose one of for, while, or do while loop).
public class Assignment9 
{
	public static void main(String[] args) throws IOException
	{
	//reading in the 1D array
	int i=0;
	InputStreamReader in = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(in);
	//System.out.println("test");
	int[] array = new int[100];
	do
	{
		array[i]=Integer.parseInt(br.readLine());
		i++;
	}while(array[i-1]!=0);
	//System.out.print("Bruh");
	//output lines
	System.out.println("The minimum number is "+findMin(array,0,i-1));
	System.out.println("The count of odd integers in the sequence is " + countOddNumbers(array,0,i-1));
	System.out.println("The largest even integer in the sequence is "+computeLargestEven(array,0,i));
	System.out.println("The sum of numbers larger than the first is "+sumOfNumbersLargerThanFirst(array,0,i,array[0]));
	
	};//end of main 

	//individual methods for each function 
	 public static int findMin(int[] numbers, int startIndex, int endIndex) 
	 {
		 int middle,top,bottom; //splitting the array into two parts and checking the minimum in each part and consolidating 
		 if(startIndex==endIndex)
		 {
			 return numbers[startIndex];
		 }//if there is only one element in the array 
		 middle=(startIndex+endIndex)/2; //determining middle
		 top=findMin(numbers,startIndex,middle); //finding minimum in the top part 
		 bottom=findMin(numbers,middle+1,endIndex); //finding minimum in the bottom part 
		 if(top<=bottom)
			 return top;
		 else
			 return bottom;
	 }

	 public static int countOddNumbers(int[] elements, int startIndex, int endIndex)
	 {
		//int number=0;
		if(startIndex==endIndex)
		{
			if(elements[startIndex]%2==1)//checks if it is an odd number 
				return 1;//returns 1 if its an odd number 
			else
				return 0;//returns 0 if its an even number 
		}//if there is only one element in the array 
		else{
				if(elements[startIndex]%2!=0)
				{
					return 1+countOddNumbers(elements,startIndex+1,endIndex);//adds one and then checks it if there are more odd numbers 
				}
				else
					return countOddNumbers(elements,startIndex+1,endIndex);//otherwise returns the function 
			}
			
		}
		
	 
		/* if(startIndex==endIndex)
		 {
			return elements[startIndex]%2==1?1:0;
		 }
		 if(elements[startIndex]%2==1)
			 return 1+countOddNumbers(elements,startIndex+1,endIndex);
		 else
			 return countOddNumbers(elements,startIndex+1,endIndex);*/
				
		 

	 public static int computeLargestEven(int[] elements, int startIndex, int endIndex)
	 {
		if(startIndex==endIndex)
		{
			if(elements[startIndex]%2==0)
				{return elements[startIndex];}
			else
				{return 0;}
		}//if there is only one element in the array 
		else if(elements[startIndex]>computeLargestEven(elements,startIndex+1,endIndex))
			{
				if(elements[startIndex]%2==0)
					return elements[startIndex];
				else
					return computeLargestEven(elements,startIndex+1,endIndex);
			}
		else
			return computeLargestEven(elements,startIndex+1,endIndex);
	 }
	 
	 public static int sumOfNumbersLargerThanFirst(int[] elements, int startIndex, int endIndex, int firstNumber) 
	 {
		 if(startIndex==endIndex)
		 {
			 return elements[startIndex];
		 }//only one element in the array 
		 else//else if there are many 
		 {
			 if
			 (elements[startIndex]>firstNumber)//if element[startindex] is greater than first it returns the function added to the element 
			 {
				 return sumOfNumbersLargerThanFirst(elements,startIndex+1,endIndex,firstNumber)+elements[startIndex];
			 }
			 else//if it isnt then it just returns the function 
				 return sumOfNumbersLargerThanFirst(elements,startIndex+1,endIndex,firstNumber);
			 
		 }
	 }//end of methods
}//end of class 		
		
	
