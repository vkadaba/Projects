//package application;
// Assignment #: Arizona State University CSE205
//         Name: Vishnu Kadaba
//    StudentID: 1217459815
//      Lecture: T Th 1:30pm
//  Description: PaneWithRectangles class creates a pane where we can use
//               mouse key to drag on grids and there will be some color following
//               the mouse. We can also use combo boxes to change its colors and stroke widths

//import any classes necessary here
//----
import javafx.scene.control.Label;
import javafx.collections.*;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class PaneWithRectangles extends BorderPane
{
   private ComboBox<String> primaryColorCombo;
   private ComboBox<String> backColorCombo;
   private ComboBox<String> widthCombo;

   private Color primaryColor, secondaryColor, backgroundColor;
   private double selectWidth;

   private Rectangle[][] rectArray;
   private GridPane rects;
   


   public PaneWithRectangles()
   {
	   //Setting defaults
       primaryColor = Color.BLACK; 
       secondaryColor = Color.GRAY;
       backgroundColor = Color.WHITE;
       selectWidth = 1.0;

        //Instantiate and initialize labels, combo boxes
		Label primc = new Label("PrimaryColor");
		Label backc = new Label("BackgroundColor");
		Label strow = new Label("StrokeWidth");

		//creating combo boxes with the observable array lists inside 	
		primaryColorCombo = new ComboBox(FXCollections.observableArrayList("Black","Blue","Red","Green")); 
		backColorCombo = new ComboBox(FXCollections.observableArrayList("White","Yellow","Orange"));		
		widthCombo = new ComboBox(FXCollections.observableArrayList("1","3","5","7"));
		
		// setting default values for the primary background and width combo boxes 
		widthCombo.setValue("1");
		backColorCombo.setValue("White");
		primaryColorCombo.setValue("Black");

		//creating rectarray of type rectangle 
		rectArray = new Rectangle[7][7];
		for(int x=0;x<7;x++)
		{
		   for(int y=0;y<7;y++)
		   {
			   Rectangle r = new Rectangle();
			   rectArray[x][y] = r;
		   }
	    }

       //right side gridpane to hold the rectangles 
       GridPane rects = new GridPane();
       for(int x=0;x<7;x++)
       {
		   for(int y=0;y<7;y++)
		   {
			   Rectangle r = rectArray[x][y];
			   r.setHeight(390/7); // setting height to be given size by 7 
			   r.setWidth(470/7);  // setting width to be given size by 7
			   r.setStrokeWidth(1);	// setting default stroke width of each rectangle 
			   r.setStroke(Color.BLACK);//setting default colors 
			   r.setFill(Color.WHITE);
			   rects.add(r,x,y);
			   
		   }
	   }

       //creating left pane
       VBox left = new VBox();
       left.setSpacing(10);
       left.setPadding(new Insets(10, 0, 10, 0));
       left.getChildren().addAll(primc,primaryColorCombo,backc,backColorCombo,strow,widthCombo);

       //adding it to the pane with rectangles class
       this.setLeft(left);
       this.setCenter(rects);

      //registering the source objects
      rects.setOnMouseDragged(new MouseHandler()); 
      //rects.setOnMouseClicked(new MouseHandler()); 
      backColorCombo.setOnAction(new BackColorHandler()); 
      primaryColorCombo.setOnAction(new PrimColorHandler()); 
      widthCombo.setOnAction(new WidthHandler()); 
     
   }


   //Mouse handler class 
   private class MouseHandler implements EventHandler<MouseEvent>
   {
      public void handle(MouseEvent event)
       {
    	  if(event.getEventType()==MouseEvent.MOUSE_DRAGGED)
    	  {
    		  double x = event.getX();
    		  double y = event.getY();
    		  
    		  for(int i=0;i<7;i++)
    		  {
    			  for(int j=0;j<7;j++)
    			  {
    				  rectArray[i][j].setFill(backgroundColor);
    			  }
    		  }
    		  //to get position in the rectangle grid pnae
    		  x/=(470/7);
    		  y/=(390/7);
    		  //filling the pointer location with primary color
    		  try 
    		  {
    			  (rectArray[(int) x][(int)y]).setFill(primaryColor); 
    		  } 
    		  catch (Exception e)
    		  {
    			  System.out.print(" ");
    		  }
    		  //filling adjacent rectangles with secondary color 
    		  try 
    		  {
    			  (rectArray[(int) x+1][(int)y]).setFill(secondaryColor);
    		  } 
    		  catch (Exception e)
    		  {
    			  System.out.print(" ");
    		  }
    		  
    		  try 
    		  {
    			  (rectArray[(int) x-1][(int)y]).setFill(secondaryColor);
    		  } 
    		  catch (Exception e)
    		  {
    			  System.out.print(" ");
    		  }
    		  
    		  try 
    		  {
    			  (rectArray[(int) x][(int)y+1]).setFill(secondaryColor);
    		  } 
    		  catch (Exception e)
    		  {
    			  System.out.print(" ");
    		  }
    		  
    		  try 
    		  {
    			  (rectArray[(int) x][(int)y-1]).setFill(secondaryColor);
    		  } 
    		  catch (Exception e)
    		  {
    			  System.out.print(" ");
    		  }
    		  
    	 }

      }//end handle()

   }//end MouseHandler

   //Primary color handler 
   private class PrimColorHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent event)
      {
          //write your own codes here
          //checks primary color combo value and sets the colors based on the option clicked 
      		if(primaryColorCombo.getValue().equals("Black"))
      		{
				primaryColor = Color.BLACK;
				secondaryColor = Color.GRAY;
			}
			else if(primaryColorCombo.getValue().equals("Blue")) 
			{
				primaryColor = Color.BLUE;
				secondaryColor = Color.POWDERBLUE;
			}
			else if(primaryColorCombo.getValue().equals("Red"))
			{
				primaryColor = Color.RED;
				secondaryColor = Color.PINK;
			}
			else
			{
				primaryColor = Color.GREEN;
				secondaryColor = Color.LIGHTGREEN;
     		}
      }
   }//end PrimColorHandler

   //Background color handler function for the rectangle grid pane 
    private class BackColorHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {//same as the primary color it checks the combo box option selected and sets the color for the rect array element 
            if(backColorCombo.getValue().equals("White"))
            {
            	backgroundColor = Color.WHITE;
				for(int x=0;x<7;x++)
				{
				   for(int y=0;y<7;y++)
				   {
						rectArray[x][y].setFill(Color.WHITE);
			   		}
	   			}
			}
			else if(backColorCombo.getValue().equals("Yellow"))
			{
				backgroundColor = Color.YELLOW;
				for(int x=0;x<7;x++)
				{
				   for(int y=0;y<7;y++)
				   {
						rectArray[x][y].setFill(Color.YELLOW);
			   		}
	   			}
			}
			else
			{
				backgroundColor = Color.ORANGE;
				for(int x=0;x<7;x++)
				{
				   for(int y=0;y<7;y++)
				   {
						rectArray[x][y].setFill(Color.ORANGE);
			   		}
	   			}
			}
        }
    }//end BackColorHandler

    //A handler class used to handle stroke width
    private class WidthHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {//same as the above handler functions but for stroke width 
            if(widthCombo.getValue().equals("1"))
            {
				for(int x=0;x<7;x++)
				{
					for(int y=0;y<7;y++)
					{
						rectArray[x][y].setStrokeWidth(1);
				   	}
				}
			}
			else if(widthCombo.getValue().equals("3"))
			{
				for(int x=0;x<7;x++)
				{
					for(int y=0;y<7;y++)
					{
						rectArray[x][y].setStrokeWidth(3);
				   	}
				}
			}
			else if(widthCombo.getValue().equals("5"))
			{
				for(int x=0;x<7;x++)
				{
					for(int y=0;y<7;y++)
					{
						rectArray[x][y].setStrokeWidth(5);
				   	}
				}
			}
			else{
				for(int x=0;x<7;x++)
				{
					for(int y=0;y<7;y++)
					{
						rectArray[x][y].setStrokeWidth(7);
			  		}
					}
				}
     		}
    }//end WidthHandler
} //end of PaneWithRectangles