// Assignment #: 8
//         Name: Vishnu Kadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30pm
//  Description: Definition of club name comparator class
import java.util.Comparator;

// Assignment #: 8
//         Name: Vishnu Kadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30pm
//  Description: Club name comparator class 
public class ClubNameComparator implements Comparator<Club>
{
	public int compare(Club a,Club b)
	{
		return(a.getClubName().compareTo(b.getClubName()));
	}

}
