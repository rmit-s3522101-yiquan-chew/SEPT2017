package ownerFunctionGUI;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.*;
import javafx.util.Callback;

import java.io.IOException;

import function.Activity;
import function.Booking;
import function.Mainpage;
import function.OwnerFunction;
import gui.SceneManager;
import gui.Main;
import user.*;
import main.*;

public class OwnerController {
	//OwnerDetails tab - Display owner details and logout
	@FXML private Text title;
	@FXML private Text businessName;
	@FXML private Text businessAddress;
	@FXML private Text ownerPhone;
	@FXML private Button logout;
	
	//EmployeeTab - display employee, add and edit employee
	@FXML private TableView<Employee> employeeTable;
	@FXML private TableColumn<Employee, String> employeeName;
	@FXML private TableColumn<Employee, String> eWorkingDate;
	@FXML private TableColumn<Employee, String> eWorkingTime;
	@FXML private TableColumn<Employee, String> activityName;
	@FXML private Button addEmployee;
	@FXML private Button addBooking;
	
	//BookingTab - display all booking, add, addbooking
	@FXML private TableView<Booking> bookingTable;
	@FXML private TableColumn<Booking, String> bookingCustomer;
	@FXML private TableColumn<Booking, String> bookingDate;
	@FXML private TableColumn<Booking, String> bookingTime;
	@FXML private TableColumn<Booking, String> bookingEmployee;
	@FXML private TableColumn<Booking, String> bookingActivity;
	
	//ActivityTab - display and add activity
	@FXML private ListView<String> activityList;
	@FXML private TextField getName;
	@FXML private TextField getDuration;
	@FXML private Button addActivity;
	
	public void initialize(){}

	public void initManager(final SceneManager manager) {
		try {
			logout.setOnAction(new EventHandler<ActionEvent>(){
		    	@Override
		    	public void handle(ActionEvent event){
		    		manager.showLoginScene();
		    		Mainpage.loginUser = null;
		    	}
		    });
			ownerDetails();
			
			//employee tab
			employeeDetails();
			addEmployee.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event){
					Employee tempEmployee = null;
					boolean confirmAdd = manager.showPersonEditDialog(tempEmployee);
					if(confirmAdd){
						try {
							employeeTable.refresh();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
						
			//bookingTab
			allBookingDetails();
			
			addBooking.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event){
					Employee employee = employeeTable.getSelectionModel().getSelectedItem();
					if(employee != null){
						boolean confirmClicked = manager.showAddBooking(null, employee);
						if(confirmClicked){
							bookingTable.refresh();
						}
					}
					else {
						// Nothing selected.
						Alert alert = new Alert(AlertType.WARNING);
						alert.initOwner(Main.getPrimaryStage());
						alert.setTitle("No Selection");
						alert.setHeaderText("Invalid Selection");
						alert.setContentText("Please select a person in the table.");

						alert.showAndWait();
					}
				}
			});
			
			//activity tab
			listActivity();
			
			addActivity.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event){
					String activityname = getName.getText();
					int duration = Integer.parseInt(getDuration.getText());
					
					try {
						OwnerFunction.addActivity(activityname, duration);
						
						getName.clear();
						getDuration.clear();
						activityList.refresh();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void ownerDetails(){
		Owner owner = (Owner) Mainpage.loginUser;
		title.setText(owner.getName());
		businessName.setText(owner.getBname());
		businessAddress.setText(owner.getAddress());
		ownerPhone.setText(owner.getCnumber());			
	}
	
	public void employeeDetails(){
		//display all employee details in table
		ObservableList<Employee> employee;
		try {
			employee = FXCollections.observableArrayList(Data.employeeArray("employee.txt"));
			employeeTable.setEditable(true);
			employeeName.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeName"));
			eWorkingDate.setCellValueFactory(new PropertyValueFactory<Employee, String>("date"));
			eWorkingTime.setCellValueFactory(new PropertyValueFactory<Employee, String>("time"));
			
			activityName.setCellValueFactory(new PropertyValueFactory<Employee, String>("activity"));
					
			employeeTable.setItems(employee);
			
			employeeTable.getColumns().addAll(employeeName, eWorkingDate, eWorkingTime, activityName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void allBookingDetails() throws Exception{
		//display all booking
		try{
			final ObservableList<Booking> booking = FXCollections.observableArrayList(Data.bookingDetails("booking.txt"));
			
			bookingTable.setEditable(true);
			bookingCustomer.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookName"));
			bookingDate.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookDate"));
			bookingActivity.setCellValueFactory(new PropertyValueFactory<Booking, String>("activity"));
			bookingTime.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookTime"));
			bookingEmployee.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookEmployee"));
			
			bookingTable.setItems(booking);
			bookingTable.getColumns().addAll(bookingCustomer, bookingDate, bookingActivity, bookingTime, bookingEmployee);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//activity tab
	//list activity
	public void listActivity(){
		try{
			Activity[] activity = Data.ActivityDetails("activity.txt");
			ObservableList<String> items = FXCollections.observableArrayList();
			
			for(int i=0; i<activity.length; i++){
				if(activity[i] == null)
					break;
				items.add(i + ". " + activity[i].getActivityname() + "\t : " + activity[i].getDuration() + "min(s)");
			}
			
			activityList.setItems(items);
		}catch (IOException ioe){
			ioe.printStackTrace();
		}
	}	
}
