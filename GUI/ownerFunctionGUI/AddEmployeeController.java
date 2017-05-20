package ownerFunctionGUI;

import java.io.IOException;

import function.Activity;
import function.OwnerFunction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.Data;
import user.Employee;

public class AddEmployeeController {
	@FXML private TextField employeeName;
	@FXML private TextField date;
	@FXML private TextField time;
	@FXML private ListView<String> activityList;
	@FXML private TextField activitySelect;
	//to be added
//	@FXML TextField activity;
	
	private Stage dialogStage;
	private Employee employee;
	private Activity activity;
	private Activity[] actList;
	private boolean confirmClicked = false;
	
	@FXML
	private void initialize(){}
	
	//set the stage of this dialog
	public void setDialogStage(Stage dialogStage){
		this.dialogStage = dialogStage;
	}
	
	//set the employee to be edited
	public void setEmployeeDateTime(Employee employee){
		this.employee = employee;
		
		employeeName.setText(employee.getEmployeeName());
	}
	
	//set actList
	public void setActList() throws IOException{
		actList = Data.ActivityDetails("activity.txt");
	}
	
	//list activity
	public void listActivity() throws IOException{
		Activity[] activity = Data.ActivityDetails("activity.txt");
		ObservableList<String> items = FXCollections.observableArrayList();
		
		for(int i=0; i<activity.length; i++){
			if(activity[i] == null)
				break;
			
			items.add(activity[i].getActivityname());
		}
		
		activityList.setItems(items);
	}
	
	//return confirm Clicked
	public boolean isConfirmClicked(){
		return confirmClicked;
	}
	
	//handle confirm button
	@FXML
	private void handleConfirm(){
		if(isInputValid()){
			employee.setEmployeeName(employeeName.getText());
			employee.setDate(date.getText());
			employee.setTime(time.getText());
			
			//getActivity
			int temp = Integer.parseInt(activitySelect.getText());
			activity = actList[temp];
			
			OwnerFunction.addEmployee(employee, activity);
			
			confirmClicked = true;
			dialogStage.close();
		}
	}
	
	//handle cancel button
	@FXML
	private void handleCancel(){
		dialogStage.close();
	}
	
	//validate input
	private boolean isInputValid() {
        String errorMessage = "";

        if (employeeName.getText() == null || employeeName.getText().length() == 0) {
            errorMessage += "No valid Name!\n"; 
        }
        if (date.getText() == null || date.getText().length() == 0) {
            errorMessage += "No valid date!\n";
        }
        if (time.getText() == null || time.getText().length() == 0) {
            errorMessage += "No valid time!\n"; 
        }
        
        int temp = Integer.parseInt(activitySelect.getText());
        if(temp < 0 || temp > actList.length){
        	errorMessage += "Invalid activity selection!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
	
}
