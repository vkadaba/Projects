// Assignment #: 8
//         Name: Vishnu Kadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30pm
//  Description: Definition of president comparator class
import java.util.Comparator;

// Assignment #: 8
//         Name: Vishnu Kadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30pm
//  Description: Current president comparator function

public class CurrentPresidentComparator implements Comparator<Club>
{
	public int compare(Club a, Club b) 
	{
		int result = 0;
		President prez1 = a.getCurrentPresident();
		President prez2 = b.getCurrentPresident();
		//comparing and setting exit result integer
		result = prez1.getLastName().compareTo(prez2.getLastName());
		if(result==0)
		{
			result = prez1.getFirstName().compareTo(prez2.getFirstName());
		}
		return result;
	}
}
