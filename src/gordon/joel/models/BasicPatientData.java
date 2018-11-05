package gordon.joel.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class BasicPatientData {
	
	public static void addNewPatient(String firstName, String lastName, String birthday, String ID) {
		String dataFolderPath = "./Data";
		String patientListPath = dataFolderPath + "/patientList.txt";
		JSONObject obj = new JSONObject();
		obj.put("first", firstName);
		obj.put("last", lastName);
		obj.put("birthday", birthday);
		obj.put("ID", ID);
		
		System.out.print(obj.toString());
		System.out.println("asdfasdfasdfasdf");
		
		File f = new File(patientListPath);
		File dir = new File(dataFolderPath);
		if(!dir.exists()) {
			dir.mkdir();
		}
		if(!f.exists()) {
			JSONArray jsonArray = new JSONArray();
			jsonArray.add(obj);
			FileWriter fw;
			try {
				f.createNewFile();
				fw = new FileWriter(f, true);
				fw.write(jsonArray.toString());
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			JSONParser jsonParser = new JSONParser();
			try{
				FileReader reader = new FileReader(patientListPath);
				Object jsonObj = jsonParser.parse(reader);
				JSONArray patientList = (JSONArray) jsonObj;
				patientList.add(obj);
				reader.close();
				
				FileWriter fw = new FileWriter(new File(patientListPath), false);
				fw.write(patientList.toString());
				fw.close();
			} catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}
}
