import java.text.NumberFormat;
import java.util.Locale;

// Assignment #: 5
// Arizona State University - CSE205
//         Name: VishnuKadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30-2:45
//  Description: Creates an object of debate class. 
public class DebateCamp extends SummerCamp
{
	NumberFormat numF = NumberFormat.getCurrencyInstance(Locale.US); // number format declaration
	//instance variables declaration 
	private double materialFee;
	private boolean groupDiscount;
	String a; // group discount variable
	public DebateCamp(String a,String b,double c,int d,double e,String f) //constructor 
	{
		super.SummerCamp(a, b, c, d);
		setMaterialFee(e);
		if(f.equalsIgnoreCase("no"))
			groupDiscount=false;
		else
			groupDiscount=true;
		
	}
	public void computeTotalCosts() //definition for computing total costs for debate camp
	{
		totalCost=weeklyRate*numberOfWeeks;
		if(groupDiscount)
			totalCost=(totalCost*0.9);
		totalCost = totalCost+materialFee;
		
	}
	public String toString() //overriden toString for debate camp object
	{
		if(groupDiscount)
			a="yes";
		else
			a="no";
		return "\nDebate Camp:"+super.toString()+"\nMaterial Fee:\t\t"+numF.format(getMaterialFee())+"\nGroup Discount:\t\t"+a+"\n\n";
		
	}
	public double getMaterialFee() //accessor material fee of debate camp
	{
		return materialFee;
	}
	public void setMaterialFee(double materialFee) //mutator for material fee
	{
		this.materialFee = materialFee;
	}
	
	
	
}
