package gordon.joel.controllers;

import java.io.IOException;
import java.time.LocalDate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import application.Main;
import gordon.joel.models.BasicPatientData;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class searchPatientController {

	@FXML private TextField firstName;
	@FXML private TextField lastName;
	@FXML private DatePicker birthday;
	@FXML private TextField patientID;
	
	@FXML private ListView<String> resultList;
	
	public void selectPatient() {
		
		ObservableList<String> topics; 
		topics = resultList.getSelectionModel().getSelectedItems();
//		System.out.println(topics.toString());
		
		String [] patientInfo = topics.get(0).split(",");
		
		System.out.println("Select Patient");
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gordon/joel/views/patientInfoPage.fxml"));
			Parent root = loader.load();
			patientInfoController controller = loader.<patientInfoController>getController();
			controller.setData(patientInfo[1], patientInfo[0], patientInfo[2], patientInfo[3]);
			Main.getWindow().setScene(new Scene(root, 800, 800));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void searchPatient() {
		String first, last, id;
		LocalDate dob;
		JSONArray results;
		
		first = firstName.getText();
		last = lastName.getText();
		dob = birthday.getValue();
		id = patientID.getText();
		if(dob == null)
			results = BasicPatientData.searchPatient(first, last, "", id);
		else
			results = BasicPatientData.searchPatient(first, last, dob.toString(), id);
		
		JSONObject tempObj;
		for(int i = 0; i < results.size(); i++) {
			StringBuilder strBld = new StringBuilder();
			tempObj = (JSONObject)results.get(i);
			strBld.append(tempObj.get("last") + ", " + tempObj.get("first") + ", " + tempObj.get("birthday") + ", " + tempObj.get("ID"));
			resultList.getItems().add(strBld.toString());
		}
		
	}
	
	
	public void goBackClick() {
		System.out.println("Search Patient, Go back");
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/gordon/joel/views/mainPage.fxml"));
			Main.getWindow().setScene(new Scene(root, 800, 800));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
