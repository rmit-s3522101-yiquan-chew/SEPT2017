package mainpageGUI;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.io.IOException;

import function.*;
import gui.SceneManager;

public class MainpageController {
	//loginPage
	@FXML private TextField loginUsername;
	@FXML private PasswordField loginPassword;
	
	@FXML private Button loginButton;
	@FXML private Button registerPage;
	
	@FXML private Text loginStatus;
	
	public void initialize(){}
	
	public void initManager(final SceneManager tManager) {		
	    loginButton.setOnAction(new EventHandler<ActionEvent>() {
	      @Override 
	      public void handle(ActionEvent event) {
	        login(tManager);
	      }
	    });
	    
	    loginPassword.setOnKeyPressed(new EventHandler<KeyEvent>(){
	    	@Override
	    	public void handle(KeyEvent keyEvent){
	    		if(keyEvent.getCode() == KeyCode.ENTER){
	    			login(tManager);
	    		}
	    	}
	    	
	    });
	    
	    registerPage.setOnAction(new EventHandler<ActionEvent>(){
	    	@Override
	    	public void handle(ActionEvent event){
	    		tManager.showRegisterScene();
	    	}
	    });	    
	  }
	@FXML
	private void login(SceneManager manager){
		String status = null;
		try {
			status = authorize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status.equals("owner")){
			loginStatus.setFill(Color.GREEN);
			manager.showOwnerDetails();
		}
		else if(status.equals("customer")){
			loginStatus.setFill(Color.GREEN);
			manager.showCustomerDetails();
		}
		else{
			loginStatus.setFill(Color.FIREBRICK);
			loginStatus.setText("Invalid Username/Password, please try again.");
		}
	}
	
	private String authorize() throws IOException{
		String status = null;
		String uName, pw = null;
		
		uName = loginUsername.getText();
		pw = loginPassword.getText();
		
		status = Mainpage.check(uName, pw);
		
		return status;		
	}	
}