package gordon.joel.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;

public class MiscData {
	
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
