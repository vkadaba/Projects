// Assignment #: 8
//         Name: Vishnu Kadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30pm
//  Description: The President class describes a President.
//               It also provides their accessor, mutator methods,
//               and toString method.

public class President
{
 private String firstName;
 private String lastName;
 private String academicLevel;

 //Constructor method to initialize intance variables.
 public President()
  {
      firstName = new String("?");
      lastName= new String("?");
      academicLevel = new String("?");
  }

 //Accessor method for first name
 public String getFirstName()
  {
   return firstName;
  }

 //Accessor method for last name
 public String getLastName()
  {
   return lastName;
  }

  //Accessor method for academic level
  public String getAcademicLevel()
   {
    return academicLevel;
   }

 //modifier method for first name
 public void setFirstName(String someFirstName)
  {
   firstName = someFirstName;
  }

 //modifier method for last name
 public void setLastName(String someLastName)
  {
   lastName = someLastName;
  }

 //modifier method for academic level
 public void setAcademicLevel(String someAcademicLevel)
  {
   academicLevel = someAcademicLevel;
  }
 public void setNewPrez(String fname,String lname,String alevel)
 {
	 this.setFirstName(fname);
	 this.setLastName(lname);
	 this.setAcademicLevel(alevel);
 }

 //This method return a string containing the attribute information of a President
 public String toString()
  {
   String result;

      result = lastName + "," + firstName + "(" + academicLevel + ")";

   return result;
  }

}
