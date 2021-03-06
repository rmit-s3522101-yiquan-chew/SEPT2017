package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.setPrimaryStage(primaryStage);
		Scene scene = new Scene(new StackPane());
	    
	    SceneManager loginManager = new SceneManager(scene);
	    loginManager.showLoginScene();

	    primaryStage.setTitle("Appointment Booking System");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}

	public static void gui(String[] args) {
		launch(args);
	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public static void main(String[] args) throws IOException {
		//to complie to excutable jar
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				gui(args);
			};
		});
	}
}