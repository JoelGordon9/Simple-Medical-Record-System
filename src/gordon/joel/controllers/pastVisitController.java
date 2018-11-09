package gordon.joel.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import application.Main;
import gordon.joel.models.DetailedPatientData;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class pastVisitController {

	@FXML private Label firstName;
	@FXML private Label lastName;
	@FXML private Label birthday;
	@FXML private Label ID;
	@FXML private Label visitFile;
	@FXML private TextArea visitNotes;
	
		
	public void setData(String firstName, String lastName, String dob, String ID, String visitFile) {
		this.firstName.setText(firstName.trim());
		this.lastName.setText(lastName.trim());
		birthday.setText(dob.trim());
		this.ID.setText(ID.trim());
		this.visitFile.setText(visitFile);
		
		System.out.println("./Data/" + ID + "/visits/" + visitFile);
		visitNotes.setText(DetailedPatientData.readPastVisit(ID, visitFile));
		
	}
	
	public void backToPatientPage() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gordon/joel/views/patientInfoPage.fxml"));
			Parent root = loader.load();
			patientInfoController controller = loader.<patientInfoController>getController();
			controller.setData(firstName.getText(), lastName.getText(), birthday.getText(), ID.getText());
			Main.getWindow().setScene(new Scene(root, 800, 800));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
