// Assignment #: 8
//         Name: Vishnu Kadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30pm
//  Description: Definition of MemberNumber comparator class
import java.util.Comparator;

// Assignment #: 8
//         Name: Vishnu Kadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30pm
//  Description: Member number comparator 

public class MemberNumberComparator implements Comparator<Club>
{
	public int compare(Club a,Club b)
	{
		return(a.getNumberOfMembers()-b.getNumberOfMembers());
	}

}
