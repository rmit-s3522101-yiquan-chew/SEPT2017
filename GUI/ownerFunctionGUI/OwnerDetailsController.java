package ownerFunctionGUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import function.Booking;
import function.Mainpage;
import function.OwnerFunction;
import gui.SceneManager;
import gui.Main;
import user.*;
import main.*;

public class OwnerDetailsController {
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
	@FXML private Button addEmployee;
	@FXML private Button addBooking;
	
	//BookingTab - display all booking, add, addbooking
	@FXML private TableView<Booking> bookingTable;
	@FXML private TableColumn<Booking, String> bookingCustomer;
	@FXML private TableColumn<Booking, String> bookingDate;
	@FXML private TableColumn<Booking, String> bookingTime;
	@FXML private TableColumn<Booking, String> bookingEmployee;
	
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
					String tempName = null, tempDate = null, tempTime = null;
					Employee tempEmployee = new Employee(tempName, tempDate, tempTime);
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
			
			//to be done
//			editEmployee.setOnAction(new EventHandler<ActionEvent>(){
//				@Override
//				public void handle(ActionEvent event){
//					Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
//					if (selectedEmployee != null) {
//				        boolean okClicked = manager.showPersonEditDialog(selectedEmployee);
//				        if (okClicked) {
//				        	try {
//				        		employeeTable.refresh();
//							} catch (Exception e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//				        }
//
//				    } else {
//				        // Nothing selected.
//				        Alert alert = new Alert(AlertType.WARNING);
//				        alert.initOwner(TestLoginMain.getPrimaryStage());
//				        alert.setTitle("No Selection");
//				        alert.setHeaderText("No Person Selected");
//				        alert.setContentText("Please select a person in the table.");
//
//				        alert.showAndWait();
//				    }
//				}
//			});
			
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
	
	public void employeeDetails() throws Exception{
		//display all employee details in table
		final ObservableList<Employee> employee = FXCollections.observableArrayList(Data.employeeArray("employee.txt"));
		
		employeeTable.setEditable(true);
		employeeName.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeName"));
		eWorkingDate.setCellValueFactory(new PropertyValueFactory<Employee, String>("date"));
		eWorkingTime.setCellValueFactory(new PropertyValueFactory<Employee, String>("time"));
		
		employeeTable.setItems(employee);
		employeeTable.getColumns().addAll(employeeName, eWorkingDate, eWorkingTime);
	}
	
	public void allBookingDetails() throws Exception{
		//display all booking
		final ObservableList<Booking> booking = FXCollections.observableArrayList(Data.bookingDetails("booking.txt"));
		
		bookingTable.setEditable(true);
		bookingCustomer.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookName"));
		bookingDate.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookDate"));
		bookingTime.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookTime"));
		bookingEmployee.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookEmployee"));
		
		bookingTable.setItems(booking);
		bookingTable.getColumns().addAll(bookingCustomer, bookingDate, bookingTime, bookingEmployee);
	}
	
	public void viewLatestBooking() {
		
	}
}
