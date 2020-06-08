// Assignment #: 11
// Name: Vishnu Kadaba 
// StudentID: 1217459815
// Lecture: Tu Th 1:30PM
// Description: Doctor class represents a doctor object and gives the relavent methods to this class.


public class Doctor
 {
  private int doctorID;
  private Patient currentPatient;

  //Constructor to initialize member variables
  //Initially no patient is assigned
  public Doctor(int id)
   {
    this.doctorID = id;
    currentPatient = null;
   }

  //toString method returns a string containing
  //the information of a doctor 
  public String toString()
   {
    String result = "Doctor id " + doctorID;

    if (currentPatient == null)
      result += " is not seeing any patient";
    else
      result += " is seeing a patient with id " + currentPatient.getPatientID();

    return result;
   }
     
  public boolean hasPatient()
  {
	  boolean flag=false;
	  if(currentPatient==null)
		  flag=true;
	  return flag;	  
  }
  
  public boolean assignPatient(Patient newPat)
  {
	  boolean flag=false;
	  if(currentPatient==null)
		  {
		  currentPatient=newPat;
		  flag=true;
		  }
	  return flag;
  }
  
  public Patient releasePatient() 
  {
	  if(currentPatient!=null)
	  {
		  Patient releasePat = currentPatient;
		  currentPatient=null;
		  return releasePat;
	  }
	  return null;	
  }
 
     
 }
