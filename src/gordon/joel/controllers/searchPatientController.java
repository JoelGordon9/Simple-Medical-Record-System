package gordon.joel.controllers;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class searchPatientController {

	
	
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
