// Assignment #: 5
// Arizona State University - CSE205
//         Name: VishnuKadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30-2:45
//  Description: Parser class which returns an object of type SummerClass from given input as a string. 
public class SummerCampParser 
{
	public static SummerCamp parseStringToSummerCamp(String lineToParse) 
	{
		String camps[] = lineToParse.split(":"); // to get a string array of each individual parameters 
		if(camps[0].equalsIgnoreCase("DebateCamp")) // if the type is debate camp 
		{
			DebateCamp tempcamp = new DebateCamp(camps[1],camps[2],Double.parseDouble(camps[3]),Integer.parseInt(camps[4]),Double.parseDouble(camps[5]),camps[6]) ;
			return tempcamp;
		}
		else if(camps[0].equalsIgnoreCase("RoboticsCamp")) // type robotics camp
		{
			RoboticsCamp tempcamp = new RoboticsCamp(camps[1],camps[2],Double.parseDouble(camps[3]),Integer.parseInt(camps[4]),Double.parseDouble(camps[5]),Double.parseDouble(camps[6]));
			return tempcamp;
		}
		else //math camp 
		{
			MathCamp tempcamp = new MathCamp(camps[1],camps[2],Double.parseDouble(camps[3]),Integer.parseInt(camps[4]),camps[5]);
			return tempcamp;
		}
		
		
		
	}

}
