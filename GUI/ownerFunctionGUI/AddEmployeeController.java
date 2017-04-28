package ownerFunctionGUI;

import function.OwnerFunction;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import user.Employee;

public class AddEmployeeController {
	@FXML private TextField employeeName;
	@FXML private TextField date;
	@FXML private TextField time;
	//to be added
//	@FXML TextField activity;
	
	private Stage dialogStage;
	private Employee employee;
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
			OwnerFunction.addEmployee(employee);
			
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
