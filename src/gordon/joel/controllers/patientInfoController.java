package gordon.joel.controllers;

import java.io.File;
import java.io.IOException;

import application.Main;
import gordon.joel.models.DetailedPatientData;
import gordon.joel.models.MiscData;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class patientInfoController {
	
	@FXML private Label firstName;
	@FXML private Label lastName;
	@FXML private Label birthday;
	@FXML private Label ID;
	
	@FXML private ListView<String> recentVisits;
	@FXML private TextArea patientNotes;
	
	@FXML
	private void initialize(){
		patientNotes.setText(DetailedPatientData.getPatientNotes(ID.getText().toLowerCase()));
	}
	
	public void setPatientNotes() {
		DetailedPatientData.setPatientNotes(patientNotes.getText(), ID.getText().toLowerCase());
	}
	
	public void setData(String firstName, String lastName, String dob, String ID) {
		this.firstName.setText(firstName.trim());
		this.lastName.setText(lastName.trim());
		birthday.setText(dob.trim());
		this.ID.setText(ID.trim());
		File folder = new File("./Data/" + ID.trim() + "/visits");
		File[] listOfFiles = folder.listFiles();
		for(int i = 0; i < listOfFiles.length; i++) {
			recentVisits.getItems().add(listOfFiles[i].getName());
		}
		patientNotes.setText(DetailedPatientData.getPatientNotes(ID.toLowerCase()));
	}
	
	public void getPatientNotes() {
		
	}
	
	
	public void viewVisit() {
		ObservableList<String> topics; 
		topics = recentVisits.getSelectionModel().getSelectedItems();
		if(topics.size() > 0) {
			System.out.println(topics.get(0));
			
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/gordon/joel/views/pastVisitPage.fxml"));
				Parent root = loader.load();
				pastVisitController controller = loader.<pastVisitController>getController();
				controller.setData(firstName.getText(), lastName.getText(), birthday.getText(), ID.getText(), topics.get(0));
				Main.getWindow().setScene(new Scene(root, 800, 800));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
