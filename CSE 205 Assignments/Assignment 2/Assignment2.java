// Assignment #2 
// Arizona State University - CSE 205 
// Name: Vishnu Kadaba 
// Student ID: 1217459815
// Lecture: T Th 1:30 - 2:45 pm 
// Description: Review assignment of CSE110 - Construction of a program that reads in an unspecified number of integers and performs some calculations on it. 
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
public class Assignment2
{
	public static void main(String[] args) 
	{
		try{
			 System.setIn(new FileInputStream("C:\\Users\\vishn\\eclipse-workspace/Assignment2/test/input1.txt"));
			}catch(IOException e){
			 e.printStackTrace();
			}

		Scanner scan = new Scanner(System.in);
		int num;
		int pos=0,total=0,count=0,odd=0,even=0;
		int min=0,max=0;
		while((num=scan.nextInt())!=0) 
		{
			if(num%2!=0)
				odd++;
			if(num%2==0&&num>max)
				even = num;
				
				
			if(num<min)
				min=num;			
			if(num>0)
				pos +=num;
			total+=num;
			count++;
			
			
		}
		
		System.out.println("The minimum integer is "+min+"\nThe count of odd integers in the sequence is "+odd+
				"\nThe largest even integer in the sequence is "+even+"\nThe sum of positive integers is "+pos);
		
		
		
		
	}

}