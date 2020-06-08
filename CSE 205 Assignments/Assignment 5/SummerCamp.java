import java.text.NumberFormat;
import java.util.Locale;

// Assignment #: 5
// Arizona State University - CSE205
//         Name: VishnuKadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30-2:45
//  Description: The abstract class required to implement the code.
public abstract class SummerCamp 
{	
	NumberFormat numF = NumberFormat.getCurrencyInstance(Locale.US); // numberformat declaration
	//instance variables
	protected String title; 
	protected String location;
	protected double weeklyRate;
	protected int numberOfWeeks;
	protected double totalCost; 
	
	public void SummerCamp(String a,String b,double c,int d )  //constructor 
	{
		title=a;
		location=b;
		weeklyRate=c;
		numberOfWeeks=d;
		totalCost=0.0;
	}
	public String getCampTitle() //accessor for title
	{
		return title;
	}
	public abstract void computeTotalCosts();//abstract method to compute total costs
	public String toString() //default toString for all classes 
	{
		return "\nCamp Title:\t\t"+title+"\nLocation:\t\t"+location+"\nWeekly Rate:\t\t"+numF.format(weeklyRate)+"\nWeeks:\t\t\t"+numberOfWeeks+"\nTotal Cost:\t\t"+numF.format(totalCost);
	}	

}
