package gui;

import java.io.IOException;
import java.util.logging.*;

import bookingGUI.AddBookingController;
import customerFunctionGUI.CustomerController;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;
import mainpageGUI.MainpageController;
import mainpageGUI.RegisterController;
import ownerFunctionGUI.*;
import user.Employee;

public class SceneManager {
	private Scene scene;
	
	public SceneManager(Scene scene){
		this.scene = scene;
	}
	
	public void logout() {
	    showLoginScene();
	}
	
	public void register(){
		showRegisterScene();
	}
	
	public void showLoginScene() {
	    try {
	      FXMLLoader login = new FXMLLoader(getClass().getResource("/mainpageGUI/LoginScene.fxml"));
	      
	      scene.setRoot((Parent) login.load());
	      
	      MainpageController controller = login.<MainpageController>getController();
	      controller.initManager(this);
	      
	    } catch (IOException ex) {
	      Logger.getLogger(SceneManager.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	public void showRegisterScene(){
		try{
			FXMLLoader register = new FXMLLoader(getClass().getResource("/mainpageGUI/RegisterScene.fxml"));
			
			scene.setRoot((Parent) register.load());
			
			RegisterController controller = register.<RegisterController>getController();
		    controller.initManager(this);		
			
			
		}catch (IOException e){
			Logger.getLogger(SceneManager.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	//owner
	public void showOwnerDetails(){
		try{
			FXMLLoader ownerDetails = new FXMLLoader(getClass().getResource("/ownerFunctionGUI/OwnerScene.fxml"));
			
			scene.setRoot((Parent)ownerDetails.load());
			
			OwnerController controller = ownerDetails.<OwnerController>getController();
			controller.initManager(this);
		}
		catch(IOException e){
			Logger.getLogger(SceneManager.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	//customer
	public void showCustomerDetails(){
		try{
			FXMLLoader customerDetails = new FXMLLoader(getClass().getResource("/customerFunctionGUI/CustomerScene.fxml"));
			
			scene.setRoot((Parent)customerDetails.load());
			
			CustomerController controller = customerDetails.<CustomerController>getController();
			controller.initManager(this);
		}
		catch(IOException e){
			Logger.getLogger(SceneManager.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	//add/edit employee
	public boolean showPersonEditDialog(Employee employee) {
	    try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ownerFunctionGUI/addEmployee.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Add/Edit employee");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(Main.getPrimaryStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        AddEmployeeController controller = loader.getController();
	        controller.setDialogStage(dialogStage);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isConfirmClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	//add booking
    public boolean showAddBooking(String name, Employee employee) {
		try {
		    // Load the fxml file and create a new stage for the popup dialog.
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("/bookingGUI/AddBooking.fxml"));
		    AnchorPane page = (AnchorPane) loader.load();

		    // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Add Booking");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(Main.getPrimaryStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        AddBookingController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.showAvailability(name, employee);;

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isBookClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}	
}