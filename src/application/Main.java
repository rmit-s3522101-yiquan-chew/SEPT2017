package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("JavaFX Welcome");
			
			//grid padding
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));
			
			//text, labels and text fields
			Text scenetitle = new Text("Title goes here");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);
			
			Label username = new Label("User Name:");
			grid.add(username, 0, 1);
			TextField userTextField = new TextField();
			grid.add(userTextField, 1, 1);
			
			Label password = new Label("Password:");
			grid.add(password, 0, 2);
			//PassField for password
			PasswordField pwTextField = new PasswordField();
			grid.add(pwTextField, 1, 2);
			
			
			//button
			Button btn = new Button("Sign in");
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(btn);
			grid.add(hbBtn, 1 , 4);
			
			//text for displaying message
			final Text actiontarget = new Text();
			grid.add(actiontarget, 1, 6);
			
			//event handling
			btn.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent e){
					String test = userTextField.getText();
					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText("User Name = " + test);
				}
			});
			
			//scene
			Scene scene = new Scene(grid, 300, 275);
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
