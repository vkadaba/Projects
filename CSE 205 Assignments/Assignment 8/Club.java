// Assignment #: 8
//         Name: Vishnu Kadaba
//    StudentID: 1217459815
//      Lecture: tuTh 1:30
//  Description: Club class

public class Club
 {
   private String clubName;
   private int numberOfMembers;
   private String university;
   private President currentPresident;

   //Constructor to initialize all member variables
   public Club()
    {
      clubName = "?";
      university = "?";
      numberOfMembers = 0;
      currentPresident = new President();
    }
   public void copy(Club other)
   {
	   if(other!=null)
	   {
		   this.clubName=other.clubName;
		   this.numberOfMembers=other.numberOfMembers;
		   this.university=other.university;
		   this.currentPresident=other.currentPresident;
	   }
   }

   //Accessor method for club name
   public String getClubName()
    {
      return clubName;
    }

   //Accessor method for university
   public String getUniversity()
    {
      return university;
    }

   //Accessor method for number of members
   public int getNumberOfMembers()
    {
	   return numberOfMembers;
	}

   //Accessor method for current president
   public President getCurrentPresident()
    {
      return currentPresident;
    }

   //Modifier method for club name
   public void setClubName(String someClubName)
    {
     clubName = someClubName;
    }

   //Modifier method for university
   public void setUniversity(String someUniversity)
    {
     university = someUniversity;
    }

   //Modifier method for number of members
   public void setNumberOfMembers(int someNumber)
    {
        numberOfMembers = someNumber;
    }

   //Modifier method for current president
   public void setCurrentPresident(String fname, String lname, String level)
    {
        currentPresident.setFirstName(fname);
        currentPresident.setLastName(lname);
        currentPresident.setAcademicLevel(level);
    }

   public void setClub(String a,int b,String c,President d)
   {
	   this.setClubName(a);
	   this.setNumberOfMembers(b);
	   this.setUniversity(c);
	   this.setCurrentPresident(d.getFirstName(),d.getLastName(),d.getAcademicLevel());
   }
   //toString() method returns a string containg its name, number of members, university
   //and current president
   public String toString()
    {
      String result = "\nClub Name:\t\t" + clubName
                    + "\nNumber Of Members:\t" + numberOfMembers
                    + "\nUniversity:\t\t" + university
                    + "\nPresident:\t\t"
                    + currentPresident.toString() + "\n\n";
      return result;
     }
  }
