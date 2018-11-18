package gordon.joel.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import application.Main;
import gordon.joel.models.BasicPatientData;
import gordon.joel.models.MiscData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class addNewPatientController  {
//	implements Initializable
	@FXML private TextField first;
	@FXML private TextField last;
	@FXML private DatePicker birthday;
	@FXML private TextField ID;
	@FXML private Label patientID;
	
	
	
//	@FXML
//	private void initialize(){
//		//ID.setText(MiscData.getNewID());
//	}

	
	public void addPatientClick() {
		System.out.println("Add Patient Button");
		String firstName, lastName, id;
		LocalDate dob;
		boolean existsFlag = false;
		String flagText = "Le Numero a deja Existe'";
				
		firstName = first.getText();
		lastName = last.getText();
		dob = birthday.getValue();
		id = ID.getText();
		if(dob == null) {
			if(!ID.getText().equals(flagText)) {
				existsFlag = BasicPatientData.addNewPatient(firstName, lastName, "", id);
				if(existsFlag)
					ID.setText(flagText);
			}
		}
		else {
			if(!ID.getText().equals(flagText)) {
				existsFlag = BasicPatientData.addNewPatient(firstName, lastName, dob.toString(), id);
				if(existsFlag)
					ID.setText(flagText);
			}
		}
		//MiscData.writeNewID();
		if(!existsFlag && !ID.getText().equals(flagText)) {
			System.out.println("Patient Added, Go back");
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/gordon/joel/views/mainPage.fxml"));
				Main.getWindow().setScene(new Scene(root, 800, 800));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void cancelNewPatientClick() {
		System.out.println("cancel New Patient, Go back");
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/gordon/joel/views/mainPage.fxml"));
			Main.getWindow().setScene(new Scene(root, 800, 800));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
