package mainpageGUI;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;

import function.*;

public class MainpageController {
	//loginPage
	@FXML private TextField loginUsername;
	@FXML private PasswordField loginPassword;
	
	@FXML private Button loginButton;
	@FXML private Button registerPage;
	
	@FXML private Text loginStatus;
	
	public void initialize(){}
	
	public void initManager(final MainpageManager tManager) {		
	    loginButton.setOnAction(new EventHandler<ActionEvent>() {
	      @Override 
	      public void handle(ActionEvent event) {
	        String status = null;
			try {
				status = authorize();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(status.equals("owner") || status.equals("customer")){
				loginStatus.setFill(Color.GREEN);
			}else
				loginStatus.setFill(Color.FIREBRICK);
	        loginStatus.setText(status);
	      }
	    });
	    
	    registerPage.setOnAction(new EventHandler<ActionEvent>(){
	    	@Override
	    	public void handle(ActionEvent event){
	    		tManager.showRegisterScene();
	    	}
	    });	    
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