// Assignment #: 8
//         Name: Vishnu Kadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30pm
//  Description: Definition of sort function
import java.util.*;
import java.util.Comparator;
public class Sorts {
	public static void sort(Club[] clubList, int size, Comparator<Club> c) {
		quickSort(clubList, 0, size - 1, c);
//The quick sort is apply in this class
	}

	public static void quickSort(Club[] clubList, int from, int to, Comparator<Club> c) {
		// when the pivot number smaller then last number, the system will run
		if (from < to) {
			int p = partition(clubList, from, to, c);

			quickSort(clubList, from, p, c);// run quicksort for left half list
			quickSort(clubList, p + 1, to, c);// run quicksort for left right list
		}
	}

	public static int partition(Club[] clubList, int from, int to, Comparator<Club> c) {
		Club pivot = clubList[from];
		int i = from - 1;
		int j = to + 1;
		// initialize the pivot number,i and j
		while (i < j) {
			i++;
			while (c.compare(clubList[i], pivot) < 0)
				i++;
			// when the left array smaller than pivot we pass to next one
			j--;
			while (c.compare(clubList[j], pivot) > 0)
				j--;
			// when the right array larger than pivot we pass to next one
			if (i < j) {
				Club temp = clubList[i];
				clubList[i] = clubList[j];
				clubList[j] = temp;
				//when all method above stop, we swap the number
			}
		}
		return j;
		// return the j that is the middle index in array
	}
}