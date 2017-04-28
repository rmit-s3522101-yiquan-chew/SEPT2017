package bookingGUI;

import java.io.IOException;

import function.Booking;
import function.Mainpage;
import function.OwnerFunction;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import user.Employee;

/* v0.1.4 customer will be able to made booking based on selection. 
 * Similar booking will be fixed soon 
 */

public class AddBookingController {
	@FXML private TextField customerName;
	@FXML private Text employeeName;
	@FXML private Text eWorkingDate;
	@FXML private Text eWorkingTime;
	@FXML private Button confirm;
	@FXML private Button cancel;
	
	private Stage dialogStage;
	private Employee employee;
	private boolean confirmBooked = false;
	
	@FXML
	private void initialized(){}
	
	public void setDialogStage(Stage dialogStage){
		this.dialogStage = dialogStage;
	}
	
	//return confirm Clicked
	public boolean isBookClicked(){
		return confirmBooked;
	}
		
	//show worker availability
	public void showAvailability(String name, Employee employee){
		this.employee = employee;
		customerName.setText(name);		
		employeeName.setText(employee.getEmployeeName());
		eWorkingDate.setText(employee.getDate());
		eWorkingTime.setText(employee.getTime());
	}
	
	@FXML
	private void handleConfirm(){
		try {
			if(isInputValid()){
				Booking.addBooking(customerName.getText(), eWorkingDate.getText(), eWorkingTime.getText(), employeeName.getText());
				confirmBooked = true;
				dialogStage.close();
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

        if (customerName.getText() == null || customerName.getText().length() == 0) {
            errorMessage += "Invalid customer name !\n";
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
