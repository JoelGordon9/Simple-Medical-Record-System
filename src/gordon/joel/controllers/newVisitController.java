package gordon.joel.controllers;

import java.io.IOException;
import java.time.LocalDateTime;

import application.Main;
import gordon.joel.models.DetailedPatientData;
import gordon.joel.models.MiscData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class newVisitController {

	@FXML private Label firstName;
	@FXML private Label lastName;
	@FXML private Label birthday;
	@FXML private Label ID;
	@FXML private Label currentDate;
	@FXML private TextArea visitNotes;
	
	@FXML
	private void initialize(){
		LocalDateTime currentTime = LocalDateTime.now();
		String date = currentTime.getYear() + "_" + currentTime.getMonth() + "_" + currentTime.getDayOfMonth();
		currentDate.setText(date);
	}
	
	public void setData(String firstName, String lastName, String dob, String ID) {
		this.firstName.setText(firstName);
		this.lastName.setText(lastName);
		birthday.setText(dob);
		this.ID.setText(ID);
	}
	
	public void submitVisit() {
		DetailedPatientData.submitPatientVisit(ID.getText(), currentDate.getText(), visitNotes.getText());
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
	
	public void cancelNewVisit() {
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
