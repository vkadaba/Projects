public class Club 
{
	//declaring private instance variables for the Club class
	private String clubName;
	private int numberOfMembers;
	private String university;
	private President currentPresident;
	//default constructor 
	public Club() 
	{
		university="?";
		clubName ="?";
		numberOfMembers =0;
		currentPresident = new President();
	}
	//Declaration of Accessors 
	public String getClubName() 
	{	
		return clubName;		
	}
	
	public int getNumberOfMembers() 
	{
		return numberOfMembers;
	}
	
	public String getUniversity() 
	{
		return university;
	}
	
	public President getCurrentPresident() 
	{
		return currentPresident;
	}
	//==========================================================
	//Declaration of Mutators 
	public void setNumberOfMembers(int num) 
	{
		numberOfMembers = num;
	}
	public void setUniversity(String univ) 
	{
		university = univ;
	}
	public void setClubName (String cname) 
	{
		clubName = cname;
	}
	public void setCurrentPresident(String fname , String lname , String aclevel) 
	{
		 currentPresident.setFirstName(fname);
		 currentPresident.setLastName(lname);
		 currentPresident.setAcademicLevel(aclevel);		 
	}
	//toString output of the Club class
	public String toString() 
	{
		return "\nClub Name:\t\t" + clubName + "\nNumber Of Members:\t"+numberOfMembers+
				"\nUniversity:\t\t"+university+"\nPresident:\t\t"+currentPresident.toString()+"\n\n"; 
				
		
	}
	
	

}
