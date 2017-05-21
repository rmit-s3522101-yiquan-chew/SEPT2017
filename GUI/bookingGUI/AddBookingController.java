package bookingGUI;

import java.io.IOException;
import java.util.List;

import function.Booking;
import function.Mainpage;
import function.OwnerFunction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Data;
import user.Employee;
import util.Time;

/* v0.1.4 customer will be able to made booking based on selection. 
 * Similar booking will be fixed soon 
 */

public class AddBookingController {
	@FXML private TextField customerName;
	@FXML private Text employeeName;
	@FXML private Text eWorkingDate;
	@FXML private Text activity;
	@FXML private ListView<String> actTime;
	@FXML private TextField selectTime;
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
	public void showAvailability(String name, Employee employee) throws IOException{
		this.employee = employee;
		customerName.setText(name);		
		employeeName.setText(employee.getEmployeeName());
		eWorkingDate.setText(employee.getDate());
		activity.setText(employee.getActivity().getActivityname());
		
		ObservableList<String> items = FXCollections.observableArrayList();
		
		List<String> tempList = Data.selectTimeSlot(employee);
		for(int i=0; i<tempList.size(); i++){
			String[] details = (tempList.get(i).toString()).split(":");
			String build;
			if(details[1].equals("true")){
				build = i + ". " + details[0];
				items.add(build);
			}
		}
		actTime.setItems(items);
	}
	
	@FXML
	private void handleConfirm(){
		try {
			if(isInputValid()){
				int select = Integer.parseInt(selectTime.getText());
				Time.selectTimeSlot(select, employee);
				
				String[] timeSlot = Data.selectTimeSlot(employee).get(select).split(":");
				
				Booking.addBooking(customerName.getText(), eWorkingDate.getText(), activity.getText(), timeSlot[0], employeeName.getText());
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
