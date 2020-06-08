// Assignment #: 11
// Name: Vishnu Kadaba 
// StudentID: 1217459815
// Lecture: Tu Th 1:30PM
// Description: This program manages patient queues, assigns patients to doctors,
//              release them to check out, etc.

import java.util.LinkedList;

public class PatientManagement 
 {
    private LinkedList<Patient> highPriorityQueue; //Requires immediate life-saving intervention
    private LinkedList<Patient> intermediateQueue; //Requires significant intervention within two to four hours.
    private LinkedList<Patient> delayedCareQueue; //Needs medical treatment, but this can safely be delayed.

    private LinkedList<Patient> checkOutQueue; //queue for patients that need to check out

    private Doctor[] doctorList; //an array of doctors
     
  //Constructor to initialize member variables
  public PatientManagement(int numOfDoctors)
    {
        highPriorityQueue = new LinkedList<Patient>();
        intermediateQueue = new LinkedList<Patient>();
        delayedCareQueue = new LinkedList<Patient>();
        checkOutQueue = new LinkedList<Patient>();

        //creating doctor objects
        doctorList = new Doctor[numOfDoctors];
        for (int i=0; i<doctorList.length; i++)
        {
            doctorList[i] = new Doctor(i);
        }
    }
     
   //The printQueue prints out the content
   //of the queues and the array of doctors
   public void printPatientQueues()
     {
         System.out.print("\nHigh Priority Queue:\n" + highPriorityQueue.toString() + "\n");
         System.out.print("\nIntermediate Queue:\n" + intermediateQueue.toString() + "\n");
         System.out.print("\nDelayed Care Queue:\n" + delayedCareQueue.toString() + "\n\n");
         for (int i = 0; i < doctorList.length; i++)
         {
             System.out.println(doctorList[i].toString());
         }
         System.out.print("\nCheck Out Queue:\n" + checkOutQueue.toString() + "\n\n");
     }
   
   public boolean addPatient(int patId, String condPat)
   {
	   boolean flag=false; //flag for returning statement 
	   	if(condPat.equalsIgnoreCase("High Priority")) //checks to see which queue the new patient falls under... 
	   	{
	   		Patient newPat = new Patient(patId,condPat);
	   		highPriorityQueue.add(newPat);
	   		flag=true;
	   	}
	   	else if(condPat.equalsIgnoreCase("Intermediate"))
	   	{
	   		Patient newPat = new Patient(patId,condPat);
	   		intermediateQueue.add(newPat);
	   		flag=true;
	   	}
	   	else if(condPat.equalsIgnoreCase("Delayed Care"))
	   	{
	   		Patient newPat = new Patient(patId,condPat);
	   		delayedCareQueue.add(newPat);
	   		flag=true;
	   	}
	   	return flag;
   }
   
   public Patient assignPatientToDoctor() //assigning a patient to a free doctor 
   {
	   
       if (highPriorityQueue.size() != 0) //checks to see if there are any high priority patients in the queue who may require immediate treatment
       {
           Patient patient = highPriorityQueue.getFirst();
           for (int i = 0; i < doctorList.length; i++) //checks all the doctors to see if they have a patient
           {
               if (doctorList[i].hasPatient()) 
               {
                   doctorList[i].assignPatient(patient);
                   highPriorityQueue.removeFirst();
                   return patient;
               }
           }
       }
       else if (intermediateQueue.size() != 0)  // if all the high priority patients are treated , then the doctors can move onto the next batch of patients 
       {
           Patient patient = intermediateQueue.getFirst();
           for (int i = 0; i < doctorList.length; i++)
           {
               if (doctorList[i].hasPatient())
               {
                   doctorList[i].assignPatient(patient);
                   intermediateQueue.removeFirst();
                   return patient;
               }
           }
       } 
       else if (delayedCareQueue.size() != 0) //and finally onto the delayed care of patients 
       {
           Patient patient = delayedCareQueue.getFirst();
           for (int i = 0; i < doctorList.length; i++) 
           {
               if (doctorList[i].hasPatient()) {
                   doctorList[i].assignPatient(patient);
                   delayedCareQueue.removeFirst();
                   return patient;
               }
           }
       }
       return null;
   }

   //method to release a patient from a doctor into the checkout queue 
   Patient releasePatientFromDoctorToCheckOutQueue(int doctorID)
   {
       if (doctorList[doctorID].hasPatient() == false) //checks to see if theres a patient 
       {
           Patient patient = doctorList[doctorID].releasePatient();
           checkOutQueue.add(patient);
           return patient;
       }
       return null;
   }
   
   // checking out the patient from the checkOutQueue
   Patient checkOutPatient() 
   {
       if (checkOutQueue.isEmpty() == false) 
       {
           Patient patient = checkOutQueue.getFirst();
           checkOutQueue.removeFirst();
           return patient;
       }
       return null;
   }
     

     
     
 }