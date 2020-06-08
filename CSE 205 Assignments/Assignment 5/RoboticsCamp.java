// Assignment #: 5
// Arizona State University - CSE205
//         Name: VishnuKadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30-2:45
//  Description: class for robotics camp 
public class RoboticsCamp extends SummerCamp //inherited summer camp class
{
	//instance variables
	private double facilityFee;
	private double competitionFee;
	
	public RoboticsCamp(String a,String b,double c,int d, double e,double f) //constructor 
	{
		super.SummerCamp(a, b, c, d);
		setCompetitionFee(f);
		setFacilityFee(e);
	}
	public void computeTotalCosts() //compute total costs for robotics camp 
	{
		totalCost=weeklyRate*numberOfWeeks+getFacilityFee()+getCompetitionFee();
		
	}
	public String toString() //overridden toString method for robotics camp
	{
		return "\nRobotics Camp:"+super.toString()+"\nFacility Fee:\t\t"+numF.format(getFacilityFee())+"\nCompetition Fee:\t"+numF.format(getCompetitionFee())+"\n\n";
	}
	
	//accessors and mutator functions for facility fee and competition fees. 
	public double getFacilityFee() 
	{
		return facilityFee;
	}
	public void setFacilityFee(double facilityFee) 
	{
		this.facilityFee = facilityFee;
	}
	public double getCompetitionFee() 
	{
		return competitionFee;
	}
	public void setCompetitionFee(double competitionFee)
	{
		this.competitionFee = competitionFee;
	}
	

}
