public class President 
{	
	//declaration of private instance variables of President class
	private String firstName;
	private String lastName ;
	private String academicLevel ;
	//default constructor 
	public President() 
	{
		firstName="?";
		lastName="?";
		academicLevel="?";			
	}
	//accessor functions
	public String getFirstName() 
	{
		return firstName;
		
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public String getAcademicLevel() 
	{
		return academicLevel;		
	}
	
	//=========================================
	//mutator functions
	
	public void setFirstName(String fName) 
	{
		firstName=fName;		
	}
	
	public void setLastName(String lName) 
	{
		lastName=lName;		
	}
	
	public void setAcademicLevel(String alevel) 
	{
		academicLevel = alevel;		
	}
	//toString function of President class
	public String toString() 
	{
		return lastName+","+firstName+"("+academicLevel+")";
		
		
	}
	
}