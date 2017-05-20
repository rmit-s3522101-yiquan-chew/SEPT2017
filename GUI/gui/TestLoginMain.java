package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mainpageGUI.SceneManager;

public class TestLoginMain extends Application {

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(new StackPane());
	    
	    SceneManager loginManager = new SceneManager(scene);
	    loginManager.showLoginScene();

	    stage.setScene(scene);
	    stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}