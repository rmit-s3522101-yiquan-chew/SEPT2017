package mainpageGUI;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;

import function.*;

public class RegisterController {
	@FXML private TextField fullName;
	@FXML private TextField userName;
	@FXML private PasswordField pw;
	@FXML private PasswordField confirmPW;
	@FXML private TextArea address;
	@FXML private TextField phone;
	
	@FXML private Button registerButton;
	@FXML private Button back;
		
	@FXML private Text text;
	
	public void initialize(){}
	
	public void initManager(final MainpageManager tManager){
		registerButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				String status = null;
				try{
					status = registerStatus();
				}catch (Exception e){
					e.printStackTrace();
				}
				if(status.equals("noFill")){
					text.setFill(Color.FIREBRICK);
					text.setText("Please fill in all the field provided");
				}
				else if(status.equals("wrongPW")){
					text.setFill(Color.FIREBRICK);
					text.setText("Please make sure you type in both password correctly");
				}
				else{
					tManager.showLoginScene();
				}
			}
		});
		
		back.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				tManager.showLoginScene();
			}
		});
	}
	
	private String registerStatus() throws IOException{
		String fName = fullName.getText();
		String uName = userName.getText();
		String pw1 = pw.getText();
		String pw2 = confirmPW.getText();
		String add = address.getText();
		String pNum = phone.getText();
		
		String status = Mainpage.register(fName, uName, pw1, pw2, add, pNum);
		
		return status;
	}

}