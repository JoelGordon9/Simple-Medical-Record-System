package gordon.joel.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class patientInfoController {
	
	@FXML private Label firstName;
	@FXML private Label lastName;
	@FXML private Label birthday;
	@FXML private Label ID;
	
	public void setData(String firstName, String lastName, String dob, String ID) {
		this.firstName.setText(firstName);
		this.lastName.setText(lastName);
		birthday.setText(dob);
		this.ID.setText(ID);
	}
}
