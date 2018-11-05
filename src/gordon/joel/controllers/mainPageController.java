package gordon.joel.controllers;

import java.io.IOException;

import application.Main;
import gordon.joel.models.MiscData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class mainPageController {
	
	
	public void searchButtonClick() {
		System.out.println("Search Button");
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/gordon/joel/views/searchPage.fxml"));
			Main.getWindow().setScene(new Scene(root, 800, 800));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addNewPatientClick() {
		System.out.println("Add new Patient");
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/gordon/joel/views/newPatientPage.fxml"));
			Main.getWindow().setScene(new Scene(root, 800, 800));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
