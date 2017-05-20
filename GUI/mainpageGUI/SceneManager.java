package mainpageGUI;

import java.io.IOException;
import java.util.logging.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;

public class SceneManager {
	private Scene scene;
	
	public SceneManager(Scene scene){
		this.scene = scene;
	}
	
	public void logout() {
	    showLoginScene();
	}
	
	public void register(){
		showRegisterScene();
	}
	
	public void showLoginScene() {
	    try {
	      FXMLLoader login = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
	      
	      scene.setRoot((Parent) login.load());
	      
	      MainpageController controller = login.<MainpageController>getController();
	      controller.initManager(this);
	      
	    } catch (IOException ex) {
	      Logger.getLogger(SceneManager.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	public void showRegisterScene(){
		try{
			FXMLLoader register = new FXMLLoader(getClass().getResource("RegisterScene.fxml"));
			
			scene.setRoot((Parent) register.load());
			
			RegisterController controller = register.<RegisterController>getController();
		    controller.initManager(this);		
			
			
		}catch (IOException e){
			Logger.getLogger(SceneManager.class.getName()).log(Level.SEVERE, null, e);
		}
	}	
}