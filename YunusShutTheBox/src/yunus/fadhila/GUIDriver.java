package yunus.fadhila;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class GUIDriver extends Application {

	Die d1 = new Die();
	Die d2 = new Die();
	@Override
	public void start(Stage stage) throws Exception {
		stage.show();
		
		//create and display the title of game:
		
		VBox Vbox = new VBox (20);
		Label title = new Label ("Shut the box");
		
		HBox tileBox = new HBox(10);
		
		Button[] tileBtns = new Button[9];
		Tile[] tiles = new Tile[9];
		
		for (int i = 0; i<tileBtns.length; i++) {
			tileBtns[i] = new Button(String.valueOf(i+1));
			tileBtns[i].setStyle("-fx-background-color:#eeeeee;"); // clear grey color
			tiles[i] = new Tile(i+1);
			tileBox.getChildren().add(tileBtns[i]);
			
		}
	
		for(Button b: tileBtns) {
			b.setOnAction(e->{
				b.setStyle("-fx-background-color:#000088;"); // dark blue
				if(b.getStyle().equals("-fx-background-color:#eeeeee;") ) { //if the sum 
					b.disabledProperty();
					//b.setStyle("-fx-background-color:#000088;") = b.setStyle("-fx-background-color:##ed0c80;");
				}
			});
		}
		Button lockIn = new Button("Locked in");
		
			lockIn.setOnAction(e->{
				
			});
		
		
		tileBox.setAlignment(Pos.CENTER);
		Vbox.getChildren().add(tileBox);
		
		Button btnRoll = new Button("ROLL DICE");
		Label result = new Label("Result");
		Label lblValue = new Label(); //:output of results
		
		Button die1 = new Button("roll Die 1");
		Button die2 = new Button("roll 2 Dices"); // should start by rolling 2 dices
		//Button lockIn = new Button("Locked in");
		//create container node and add controls
		
		Vbox.getChildren().addAll(title,btnRoll,result,lblValue,lockIn);
		Vbox.setAlignment(Pos.CENTER);
		
		
		// result should equal to the two dices sum:
		
		
		btnRoll.setOnAction(e->{
			lblValue.setText(String.valueOf(d1.roll()+d2.roll()));// need to declare the d1 somewhere
			
		});

		lockIn.setOnAction(e->{
			
			
		});
		
		
		
		
		System.out.println(d1.roll());
	
		System.out.println(d2.roll());
		
		
		// Things to do:
		// Disable buttons that are not being used
		
		// start of game:
		
		
	
		Scene scene = new Scene(Vbox, 500,800);
		stage.setScene(scene);
		stage.show();
		
		
		
	}
	

	public static void main(String[] args) {
		launch(args);
		

	}

}
