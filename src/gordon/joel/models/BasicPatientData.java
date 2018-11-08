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
	
	public static JSONArray searchPatient(String searchFirst, String searchLast, String searchDOB, String searchID) {
		String dataFolderPath = "./Data";
		String patientListPath = dataFolderPath + "/patientList.txt";
		JSONArray results = new JSONArray();
		
		searchFirst = searchFirst.toLowerCase();
		searchLast = searchLast.toLowerCase();
		searchDOB = searchDOB.toLowerCase();
		searchID = searchID.toLowerCase();
		
		File f = new File(patientListPath);
		File dir = new File(dataFolderPath);
		if(!dir.exists()) {
			System.out.println("Error, directory does not exist");
		}
		if(!f.exists()) {
			System.out.println("Error, file does not exist");
		}
		else {
			JSONParser jsonParser = new JSONParser();
			try{
				FileReader reader = new FileReader(patientListPath);
				Object jsonObj = jsonParser.parse(reader);
				JSONArray patientList = (JSONArray) jsonObj;
				reader.close();
				
				String lastTemp, firstTemp, dobTemp, IDTemp;
				JSONObject tempObj;
				for(int i = 0; i < patientList.size(); i++) {
					tempObj = (JSONObject)patientList.get(i);
					lastTemp = (String) tempObj.get("last");
					firstTemp = (String) tempObj.get("first");
					dobTemp = (String) tempObj.get("birthday");
					IDTemp = (String) tempObj.get("ID");
					
					if(lastTemp.indexOf(searchLast) >= 0 && firstTemp.indexOf(searchFirst) >= 0 && dobTemp.indexOf(searchDOB) >= 0 && IDTemp.indexOf(searchID) >= 0) {
						results.add(tempObj);
					}
				}
//				System.out.println(results.toString());
				
			} catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		return results;
	}
	
	
	public static void addNewPatient(String firstName, String lastName, String birthday, String ID) {
		firstName = firstName.toLowerCase();
		lastName = lastName.toLowerCase();
		birthday = birthday.toLowerCase();
		ID = ID.toLowerCase();
		
		String dataFolderPath = "./Data";
		String patientListPath = dataFolderPath + "/patientList.txt";
		String patientFolder = dataFolderPath + "/" + ID;
		String patientVisitList = patientFolder + "/visits";
		String patientInfo = patientFolder + "/patientInfo.txt";
		JSONObject obj = new JSONObject();
		obj.put("first", firstName);
		obj.put("last", lastName);
		obj.put("birthday", birthday);
		obj.put("ID", ID);
		
		System.out.print(obj.toString());
		
		File f = new File(patientListPath);
		File dir = new File(dataFolderPath);
		File patientDir = new File(patientFolder);
		File visitDir = new File(patientVisitList);
		File patientInfoPath = new File(patientInfo);
		if(!dir.exists()) {
			dir.mkdir();
		}
		if(!patientDir.exists()) {
			patientDir.mkdir();
			visitDir.mkdir();
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
		FileWriter fw;
		try {
			patientInfoPath.createNewFile();
			fw = new FileWriter(patientInfoPath, true);
			fw.write(firstName + System.lineSeparator());
			fw.write(lastName + System.lineSeparator());
			fw.write(birthday + System.lineSeparator());
			fw.write(ID + System.lineSeparator());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
