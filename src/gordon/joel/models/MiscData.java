package gordon.joel.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;

public class MiscData {
	
	public static boolean writeCustomID(String ID) {
		String dataFolderPath = "./Data";
		String patientIDFolderPath = dataFolderPath + "/" + ID.toLowerCase();
		
		File f = new File(dataFolderPath);
		File patientIDFolder = new File(patientIDFolderPath);
		if(!f.exists()) {
			f.mkdir();
		}
		if(!patientIDFolder.exists()) {
			f.mkdir();
			return true;
		}
		else
			return false;
	}
	
	
	/**
	 * This method simply reads the patient count and returns the count+1
	 * @return
	 */
	public static String getNewID() {
		String dataFolderPath = "./Data";
		String patientCount = dataFolderPath + "/patientCount.txt";
		int count = 0;
		
		File f = new File(patientCount);
		File dir = new File(dataFolderPath);
		if(!dir.exists()) {
			dir.mkdir();
		}
		if(!f.exists()) {
			count = 1;
			FileWriter fw;
			try {
				f.createNewFile();
				fw = new FileWriter(f, true);
				fw.write(Integer.toString(count));
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(patientCount));
				count = Integer.parseInt(reader.readLine()) + 1; 
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return Integer.toString(count);
	}
	
	/**
	 * This method will get read the patient count increment it, write the new count, and return the new count.
	 * @return
	 */
	public static String writeNewID() {
		String dataFolderPath = "./Data";
		String patientCount = dataFolderPath + "/patientCount.txt";
		int count = 0;
		
		File f = new File(patientCount);
		File dir = new File(dataFolderPath);
		if(!dir.exists()) {
			dir.mkdir();
		}
		if(!f.exists()) {
			count = 1;
			FileWriter fw;
			try {
				f.createNewFile();
				fw = new FileWriter(f, true);
				fw.write(Integer.toString(count));
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(patientCount));
				count = Integer.parseInt(reader.readLine()) + 1; 
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
			FileWriter fw;
			try {
				fw = new FileWriter(new File(patientCount), false);
				fw.write(Integer.toString(count));
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return Integer.toString(count);
	}
}
