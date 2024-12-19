package yunus.fadhila;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
/**
 * Purpose: Creating and exploring the game: shut the box
 * Author: Fadhila Yunus
 * Date: December 19, 2024
 */
public class GUIDriver extends Application {

	Die d1 = new Die();
	Die d2 = new Die();
	Game player1 = new Game();
	Game player2 = new Game();

	@Override
	public void start(Stage stage) throws Exception {
		stage.show();

		// create and display the title of game:

		VBox Vbox = new VBox(20);
		Label title = new Label("Shut the box");

		HBox tileBox = new HBox(10);

		Button[] tileBtns = new Button[9];
		Tile[] tiles = new Tile[9];

		for (int i = 0; i < tileBtns.length; i++) {
			tileBtns[i] = new Button(String.valueOf(i + 1));
			tileBtns[i].setStyle("-fx-background-color:#eeeeee;"); // clear grey color
			tiles[i] = new Tile(i + 1);
			tileBox.getChildren().add(tileBtns[i]);

		}
		Button btnRoll = new Button("ROLL DICE");
		Button lockIn = new Button("Locked in");
		Label lblValue = new Label();
		Button oneRoll = new Button("ROLL ONE DIE");
		oneRoll.setDisable(true);
		Button end = new Button ("DONE");
		Button switchPlayers = new Button ("Switch Players");
		

		
		for (Button b : tileBtns) {
			b.setOnAction(e -> {

				if (b.getStyle().equals("-fx-background-color:#eeeeee;")) { // if the sum
					b.setStyle("-fx-background-color:#11f7d9;"); // light blue color
				} else {
					b.setStyle("-fx-background-color:#eeeeee;");
				}

			});
		}

		lockIn.setOnAction(e -> { // needs to check if the tiles selected equals to sum
			// calculating the sum of selected tiles
			
			int inputSum = 0;
			
			for (Button btn : tileBtns) {
				if (btn.getStyle().equals("-fx-background-color:#11f7d9;")) {
					inputSum += Integer.valueOf(btn.getText());
				}
			}
			//System.out.println(inputSum);
			//checking if tiles selected equals the die
			if (Integer.valueOf(lblValue.getText()) == inputSum) {
				btnRoll.setDisable(false); //reinable the tiles
				// wanna disable buttons selected

				for (Button btn : tileBtns) {
					if (btn.getStyle().equals("-fx-background-color:#11f7d9;")) {
						btn.setDisable(true);
						btn.setStyle("-fx-background-color:#101010;"); //dark grey (needed a third color)
						//System.out.println("Disabled button " + btn.getText());

					}
				}
			}
			
			if(tileBtns[6].equals("-fx-background-color:#101010;") && tileBtns[7].equals("-fx-background-color:#101010;") && tileBtns[8].equals("-fx-background-color:#101010;")) {
				
				oneRoll.setDisable(false);
				
			}

		});

		tileBox.setAlignment(Pos.CENTER);
		Vbox.getChildren().add(tileBox);

		Label result = new Label("Result");
		Label total = new Label("The score is: " );
	//	Label total1 = new Label();
	//	Label total2 = new Label();
		Label p1 = new Label ("Player 1: ");
		Label p2 = new Label ("Player 2: ");
		
		// create container node and add controls
		
		Vbox.getChildren().addAll(title, btnRoll, result, lblValue, lockIn, oneRoll, end, total, switchPlayers, p1,p2);
		Vbox.setAlignment(Pos.CENTER);
		
		

		// result should equal to the two dices sum:
		btnRoll.setOnAction(e -> {
			lblValue.setText(String.valueOf(d1.roll() + d2.roll()));// need to declare the d1 somewhere
		//	System.out.println(d1.getValue());
		//	System.out.println(d2.getValue());
		});

		oneRoll.setOnAction(e->{
			
				int results = d1.roll();
				
				oneRoll.setText(String.valueOf(results));
		
		});

		Scene scene = new Scene(Vbox, 500, 800);
		stage.setScene(scene);
		stage.show();
		
		end.setOnAction(e->{
			int totals = 0;
			for(Button btn: tileBtns) {
				if(btn.getStyle().equals("-fx-background-color:#eeeeee;")) {
					totals += Integer.valueOf(btn.getText());
					
				}
				//System.out.println(totals);
			}
			total.setText(String.valueOf(totals));
			
		});
		
		
		switchPlayers.setOnAction(e->{
			for(Button btn: tileBtns) {
				if(btn.getStyle().equals("-fx-background-color:#101010;")) {
					btn.setDisable(false);
					btn.setStyle("-fx-background-color:#eeeeee;");
				
					
					//create a total for player one
					//create a total for player two
				}
			}
			
		});
		
		
	}

	
	public static void main(String[] args) {
		launch(args);

	}

}
