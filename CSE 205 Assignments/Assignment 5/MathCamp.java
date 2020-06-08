// Assignment #: 5
// Arizona State University - CSE205
//         Name: VishnuKadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30-2:45
//  Description: Creates an object of math class. 
public class MathCamp extends SummerCamp //inheriting summer camp 
{
	private boolean testTaking; //instance variables
	String a; // test taking variable
	public MathCamp(String a,String b,double c,int d,String e) //constructor
	{
		super.SummerCamp(a, b, c, d);
		if(e.equalsIgnoreCase("no"))
			testTaking=false;
		else 
			testTaking=true;
		
	}
	public void computeTotalCosts() //definition of compute total costs for math camp
	{
		totalCost=weeklyRate*numberOfWeeks;
		if(testTaking)
			totalCost+=25;
		
	}
	public String toString() //overridden toString
	{
		if(testTaking)
			a="yes";
		else 
			a="no";
		return "\nMath Camp:"+super.toString()+"\nTest Taking:\t\t"+a+"\n\n";
	}
		
}
