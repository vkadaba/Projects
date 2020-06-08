package application;

// Assignment #: Arizona State University CSE205 #6
//         Name: Vishnu Kadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30-2:45
//  Description: ReviewPane displays a list of available clubs
//  from which a user can select and compute their total number of members.

import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;	//**Need to import
import javafx.event.EventHandler;	//**Need to import
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Node;

//import all other necessary javafx classes here
//----

public class SelectPane extends BorderPane
{
   private ArrayList<Club> clubList;
   //initializing all the variables 
   ArrayList clubs = new ArrayList();
   BorderPane pane;
   VBox clubs1;
   int sum;
   SelectionHandler sHandler;
   CheckBox box;
   Label total;
   //constructor
   public SelectPane(ArrayList<Club> list)
   {
   	   //initialize instance variables
       this.clubList = list;
       pane = new BorderPane();
       //set up the layout
       //----
       Label header = new Label("Select club");
       header.setMinWidth(10);
       total = new Label("The number of members present in the clubs selected: "+sum); //sum label
       
       TilePane top = new TilePane();//pane to hold the sum label
       top.getChildren().add(total);
       
       
       clubs1= new VBox();
       Pane selection = new Pane(); //selection pane 
       selection.getChildren().add(header);
       selection.getChildren().addAll(clubs1);
       pane.setTop(selection);
       pane.setBottom(top);
       
       this.getChildren().addAll(pane);
       
       sHandler = new SelectionHandler(); //a check box selection function 
   } //end of constructor

 //This method uses the newly added parameter Club object
 //to create a CheckBox and add it to a pane created in the constructor
 //Such check box needs to be linked to its handler class
 public void updateClubList(Club newClub)
 {
     box = new CheckBox(newClub.toString()); //initializing checkbox 
     box.setOnAction(sHandler); //linking checkbox to handler function 
     clubs.add(box); //adding it to a temp arraylist 
     this.clubs1.getChildren().add(box); //adding the box to the clubs1 vbox 
     
 }

 //create a SelectionHandler class
 private class SelectionHandler implements EventHandler<ActionEvent>
    {
        //Override the abstact method handle()
        public void handle(ActionEvent event)
        {
        	sum=0;
        	for(int i =0;i<clubList.size();i++)
        	{
        		if(((CheckBox)clubs.get(i)).isSelected())
        		{
        			sum+=(clubList.get(i).getNumberOfMembers());//adds the number of members 
        		}
        	}
            //When any radio button is selected or unselected
            //the total number of members of selected clubs should be updated
            //and displayed using a label.
        	total.setText("The number of members present in the clubs selected: "+sum);//setting the total label to the new label with the updated sum

     }
   } //end of SelectHandler class
} //end of SelectPane class
