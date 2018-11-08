package gordon.joel.controllers;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class patientInfoController {
	
	@FXML private Label firstName;
	@FXML private Label lastName;
	@FXML private Label birthday;
	@FXML private Label ID;
	
	public void setData(String firstName, String lastName, String dob, String ID) {
		this.firstName.setText(firstName.trim());
		this.lastName.setText(lastName.trim());
		birthday.setText(dob.trim());
		this.ID.setText(ID.trim());
	}
	
	public void addNewVisit() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gordon/joel/views/newVisitPage.fxml"));
			Parent root = loader.load();
			newVisitController controller = loader.<newVisitController>getController();
			controller.setData(firstName.getText(), lastName.getText(), birthday.getText(), ID.getText());
			Main.getWindow().setScene(new Scene(root, 800, 800));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exitPatientPageClick() {
		System.out.println("Cancel Patient Page, Go back");
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/gordon/joel/views/searchPage.fxml"));
			Main.getWindow().setScene(new Scene(root, 800, 800));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
