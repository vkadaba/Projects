// Assignment #: 8
//         Name: Vishnu Kadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30pm
//  Description: all functions related to the club management section of the program
import java.io.Serializable;

public class ClubManagement implements Serializable
{
	//variables
	private Club[] clubList; // to store all te clubs
	private int numberOfClubs;
	private int maxSize;
	
	//methods
	public ClubManagement(int a)
	{
		clubList = new Club[a];
		numberOfClubs = 0;
		maxSize =a;		
	}
	
	public int clubExists(String a,String b)
	{
		for(int i=0;i<numberOfClubs;i++)
		{
			if(a.compareTo(clubList[i].getClubName())==0 && b.compareTo(clubList[i].getUniversity())==0)
			{
				return i;
			}
			
		}
		return -1;
	}
	
	public int currentPresidentExists(String a,String b,String c)
	{
		
		for(int i=0;i<numberOfClubs;i++)
		{
			if (a.compareTo(clubList[i].getCurrentPresident().getFirstName()) == 0
					&& b.compareTo(clubList[i].getCurrentPresident().getLastName()) == 0
					&& c.compareTo(clubList[i].getCurrentPresident().getAcademicLevel()) == 0) {
				return i;}
		}
		return -1;
		
	}
	
	public boolean addClub(String cname,int nmem,String uni,String fn,String ln,String al)
	{
		/*boolean exitCode=false;
		int appendIndex = 0;
		//President appPrex = new President();
		for(int i=0;i<maxSize;i++)
		{
			if(clubList[i].getClubName()==cname&&clubList[i].getUniversity()==uni)
			{
				exitCode = false;
				break;
			}
			else if(nmem==maxSize)
			{
				exitCode =false;
				break;
			}
			else 
			{
				for(int j=0;j<maxSize;j++)
				{
					if(clubList[j].getClubName()!=null)
						{
						appendIndex=j;
						break;
						}
					//President appPrez = new President();
					//appPrez.setNewPrez(fn,ln,al);
					clubList[appendIndex].setClubName(cname);	
					clubList[appendIndex].setNumberOfMembers(nmem);
					clubList[appendIndex].setUniversity(uni);
					clubList[appendIndex].setCurrentPresident(fn,ln,al);
					exitCode = true;
					
				}
			}
		}
		return exitCode;*/
		if(numberOfClubs>=maxSize)
			return false;
		for(int i =0;i<numberOfClubs;i++)
		{
			if(cname.compareTo(clubList[i].getClubName())==0
					&&nmem==clubList[i].getNumberOfMembers()
					&&uni.compareTo(clubList[i].getUniversity())==0
					&&fn.compareTo(clubList[i].getCurrentPresident().getFirstName())==0
					&&ln.compareTo(clubList[i].getCurrentPresident().getLastName())==0
					&&al.compareTo(clubList[i].getCurrentPresident().getAcademicLevel())==0)
				{return false;}
		}
		clubList[numberOfClubs] = new Club();
		clubList[numberOfClubs].setClubName(cname);
		clubList[numberOfClubs].setNumberOfMembers(nmem);
		clubList[numberOfClubs].setUniversity(uni);
		clubList[numberOfClubs].setCurrentPresident(fn, ln, al);
		numberOfClubs++;
		return true;		
		
	}
	
	public boolean RemoveClub(String cname, String uni)
	{
		for(int i =0;i<numberOfClubs;i++)
		{
			if(cname.compareTo(clubList[i].getClubName())==0
					&&uni.compareTo(clubList[i].getUniversity())==0)
			{
				for(int j = i ; j < numberOfClubs;j++)
				{
					clubList[j] = clubList[j+1];
							
				}
				numberOfClubs--;
				return true;
			}
		}
		return false;
	}
	
	public void sortByClubNames()
	{
		ClubNameComparator comp = new ClubNameComparator();
		Sorts.sort(clubList, numberOfClubs, comp);
	}
	
	public void sortByMemberNumbers()
	{
		MemberNumberComparator comp = new MemberNumberComparator();
		Sorts.sort(clubList, numberOfClubs, comp);
	}
		
	public void sortByCurrentPresidents()
	{
		CurrentPresidentComparator comp = new CurrentPresidentComparator();
		Sorts.sort(clubList, numberOfClubs, comp);
	}
	
	public String listClubs()
	{
		String result = " ";
		if(numberOfClubs ==0)
		{
			result = "\n no club\n\n";
			return result;
		}
		for(int i =0;i<numberOfClubs;i++)
		{
			result += clubList[i].toString();
		}
		result = "\n"+result+"\n";
		return result;
	}
	
	public void closeClubManagement()
	{
		for(int i =0;i<numberOfClubs;i++)
		{
			clubList[i]=null;
		}
		numberOfClubs=0;
	}
	
	
}
