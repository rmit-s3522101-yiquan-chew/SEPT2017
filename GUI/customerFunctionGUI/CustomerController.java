package customerFunctionGUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.File;

import function.Activity;
import function.Booking;
import function.Mainpage;
import gui.SceneManager;
import gui.Main;
import user.*;
import main.*;

public class CustomerController {
	//customer details tab
	@FXML private Text customerName;
	@FXML private Text customerAddress;
	@FXML private Text customerPhone;
	@FXML private Button logout;
	
	//CustomerBookingTab - display all booking for customer.
	@FXML private TableView<Booking> cBookingTable;
	@FXML private TableColumn<Booking, String> cBookingCustomer;
	@FXML private TableColumn<Booking, String> cBookingDate;
	@FXML private TableColumn<Booking, String> cBookingTime;
	@FXML private TableColumn<Booking, String> cBookingEmployee;
	@FXML private TableColumn<Booking, String> cBookingActivity;
	
	//BookingTab - for customer to add booking
	@FXML private TableView<Employee> employeeTable;
	@FXML private TableColumn<Employee, String> employeeName;
	@FXML private TableColumn<Employee, String> eWorkingDate;
	@FXML private TableColumn<Employee, String> eWorkingTime;
	@FXML private TableColumn<Employee, Activity> activity;
	@FXML private Button addBooking;
	
	public void initialize(){}
	
	public void initManager(final SceneManager manager){
		try{
			//logout button
			logout.setOnAction(new EventHandler<ActionEvent>(){
		    	@Override
		    	public void handle(ActionEvent event){
		    		manager.showLoginScene();
		    		Mainpage.loginUser = null;
		    	}
		    });
			customerDetails();
			
			customerBookingDetails();
			
			//bookingTab
			employeeDetails();
			addBooking.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event){
					Employee employee = employeeTable.getSelectionModel().getSelectedItem();
					if(employee != null){
						Customer customer = (Customer)Mainpage.loginUser;
						boolean confirmClicked = manager.showAddBooking(customer.getName(), employee);
						if(confirmClicked){
							cBookingTable.refresh();
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
			
			//button for add booking
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void customerDetails(){
		Customer customer = (Customer) Mainpage.loginUser;
		customerName.setText(customer.getName());
		customerAddress.setText(customer.getAddress());
		customerPhone.setText(customer.getCNumber());
	}
	
	public void customerBookingDetails() throws Exception{
		//display all booking
		Customer customer = (Customer) Mainpage.loginUser;
		final ObservableList<Booking> booking = FXCollections.observableArrayList(Data.bookingDetails(customer.getName()+"Booking.txt"));
		
		cBookingTable.setEditable(true);
		cBookingCustomer.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookName"));
		cBookingDate.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookDate"));
		cBookingActivity.setCellValueFactory(new PropertyValueFactory<Booking, String>("activity"));
		cBookingTime.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookTime"));
		cBookingEmployee.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookEmployee"));
		
		cBookingTable.setItems(booking);
		cBookingTable.getColumns().addAll(cBookingCustomer, cBookingDate, cBookingActivity, cBookingTime, cBookingEmployee);
	}
	
	public void employeeDetails() throws Exception{
		//display all employee details in table
		final ObservableList<Employee> employee = FXCollections.observableArrayList(Data.employeeArray("employee.txt"));
		
		employeeTable.setEditable(true);
		employeeName.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeName"));
		eWorkingDate.setCellValueFactory(new PropertyValueFactory<Employee, String>("date"));
		eWorkingTime.setCellValueFactory(new PropertyValueFactory<Employee, String>("time"));
		activity.setCellValueFactory(new PropertyValueFactory<Employee, Activity>("activity"));
		
		employeeTable.setItems(employee);
		employeeTable.getColumns().addAll(employeeName, eWorkingDate, eWorkingTime, activity);
	}
}
