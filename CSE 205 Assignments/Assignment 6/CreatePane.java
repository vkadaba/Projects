package application;

// Assignment #: Arizona State University CSE205 #6
//         Name: Vishnu Kadaba
//    StudentID: 1217459815
//      Lecture: Tu Th 1:30-2:45
//  Description: CreatePane generates a pane where a user can enter
//  a club information and create a list of available clubs.

import java.util.ArrayList;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;	//**Need to import
import javafx.event.EventHandler;	//**Need to import
import javafx.geometry.Insets;
//import all other necessary javafx classes here
//----
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
//all imports were made with the help of eclipse and were not manually added 

public class CreatePane extends HBox
{
	//declaring variables
	ArrayList<Club> clubList;
	TextField txt1;
	TextField txt2;
	TextField txt3;
	Label errorLabel;
	TextArea clubInfo;

    //The relationship between CreatePane and SelectPane is Aggregation
    private SelectPane selectPane;

	//constructor
	public CreatePane(ArrayList<Club> list, SelectPane sePane)
	{
		this.clubList = list; 
		this.selectPane = sePane;

        
        
        //initialize each instance variable (textfields, labels, textarea, button, etc.)
        //and set up the layout
        //----
		//initializing text fields:
		this.txt1 = new TextField();
		this.txt2 = new TextField();
		this.txt3 = new TextField();

		//setting the size of the text fields 
		txt1.setPrefColumnCount(15);
		txt2.setPrefColumnCount(15);
		txt3.setPrefColumnCount(15);
		        		
			
		//initializing the labels: 
		Label titlelabel = new Label("Title");
		Label numMembersLabel = new Label("Number of Members:");
		Label universityLabel = new Label("University");
		this.errorLabel= new Label();
		
		//initializing Text Area: 
	
		this.clubInfo = new TextArea();
		
		//initializing button:
		Button createClub = new Button("Create Club");
		
		
        //create a GridPane hold those labels & text fields.
        //you can choose to use .setPadding() or setHgap(), setVgap()
        //to control the spacing and gap, etc.
        //----
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.add(titlelabel, 0, 0);
        gridPane.add(txt1, 1, 0);
        gridPane.add(numMembersLabel, 0, 1);
        gridPane.add(txt2, 1, 1);
        gridPane.add(universityLabel, 0, 2);
        gridPane.add(txt3, 1, 2);
        
      
        
        
        
        //You might need to create a sub pane to hold the button
        //----
        HBox buttonHolder = new HBox();
        buttonHolder.getChildren().add(createClub);
        buttonHolder.setPadding(new Insets(10,10,10,10));
        
        //Set up the layout for the left half of the CreatePane.
        //----
        VBox leftPane = new VBox();
        leftPane.getChildren().addAll(gridPane,buttonHolder);
        
        
        
        
        //the right half of the CreatePane is simply a TextArea object
        //Note: a ScrollPane will be added to it automatically when there are no
        //enough space
 
        VBox rightPane = new VBox(clubInfo);
        
        //Add the left half and right half to the CreatePane
        //Note: CreatePane extends from HBox
        //----
        BorderPane layout = new BorderPane();
        layout.setTop(errorLabel);
        layout.setCenter(leftPane);
        //layout.setBottom(buttonHolder);
        layout.setRight(rightPane);
        getChildren().add(layout);
        
        
        //register/link source object with event handler
        //----
        createClub.setOnAction(new ButtonHandler());
        

	} //end of constructor

    //Create a ButtonHandler class
    //ButtonHandler listens to see if the button "Create" is pushed or not,
    //When the event occurs, it get a club's Title, its number of members, and its university
    //information from the relevant text fields, then create a new club and add it inside
    //the clubList. Meanwhile it will display the club's information inside the text area.
    //using the toString method of the Club class.
    //It also does error checking in case any of the textfields are empty,
    //or a non-numeric value was entered for its number of members
    private class ButtonHandler implements EventHandler<ActionEvent> 
   	 {
   	    //Override the abstact method handle()
   	    public void handle(ActionEvent event)
        {
            //declare any necessary local variables here
            //---
   	    	boolean check=true;
   	    	Club cubs = new Club();
   	    	
            if(txt1.getText().trim().isEmpty()||txt2.getText().trim().isEmpty()||txt3.getText().trim().isEmpty())
            {
            	errorLabel.setTextFill(Color.RED);
            	errorLabel.setText("Please fill all fields");
            	
            }
   	    	
            else{
            	try 
            	{
            		int num = Integer.parseInt(txt2.getText()); 
            	}
   	    		
            	catch(NumberFormatException e)
            	{
   	    		errorLabel.setText("Please enter a numerical value");
   	    		errorLabel.setTextFill(Color.RED);
   	    		check=true;
            	}
            	
       	    		for(int i = 0 ; i<clubList.size();i++)
       	    		{
       	    			if(((Club)clubList.get(i)).getClubName().equals(txt1.getText()))
       	    			{
       	    				check=false;
       	    				errorLabel.setText("Duplicate Club detected");
       	    				errorLabel.setTextFill(Color.RED);
       	    					break;
       	    			}
       	    		}
       	    		if(check==true)
       	    		{
	                	//String fieldContent = new StringBuilder(""); 
	                	int num1 = Integer.parseInt(txt2.getText());
	                	cubs.setClubName(txt1.getText());
	                	cubs.setNumberOfMembers(num1);
	                	cubs.setUniversity(txt3.getText());
	                	clubList.add(cubs);
	                	selectPane.updateClubList(cubs);
	                	errorLabel.setText("Club Added");
	                	//System.out.println("check");
	                	clubInfo.appendText(cubs.toString());
	                	
	                		//clubInfo.setText(fieldContent);
	                }
       	    		}	
                
               }//end of handle() method
        
   	 		} //end of buttonHandler() method
            
      } //end of create pane class

                	
            	
            
            	
            
            
            
            
            

		
   


