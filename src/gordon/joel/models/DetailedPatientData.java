package gordon.joel.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DetailedPatientData {

	public static void submitPatientVisit(String ID, String date, String Notes) {
		System.out.println(Notes);
		String filePath = "./Data/" + ID.trim() + "/visits/" + date.trim() + ".txt";
		File file = new File(filePath);
		FileWriter fw;
		try {
			file.createNewFile();
			fw = new FileWriter(file, false);
			fw.write(Notes);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String readPastVisit(String ID, String visitFile) {
		StringBuilder strBld = new StringBuilder();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("./Data/" + ID + "/visits/" + visitFile));
			String line = reader.readLine();
			while(line != null) {
				strBld.append(line + System.lineSeparator());
				line = reader.readLine() ;
			}
			reader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return strBld.toString();
	}
}
