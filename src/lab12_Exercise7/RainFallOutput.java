package lab12_Exercise7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class RainFallOutput {
	
	public static void main(String[] args) {
		
		String fileName = "report_3.txt";
		String station = "Simpang Ampat";
		String coma = ",";
		double rainfall[] = {0.0, 6.0, 19.0, 1.0, 0.0, 61.0};
		
		try {
			
			BufferedWriter outputStream = new BufferedWriter(new FileWriter(fileName));
			PrintWriter printWriter = new PrintWriter(outputStream);
			
			// Write the station name
			printWriter.print(station);
			
			// Process rainfall data
			for (double rainFallData : rainfall) {
				// Write comma separator
				printWriter.print(coma);
				
				// Write rainfall data
				printWriter.print(rainFallData);
			}
			
			printWriter.flush(); // Flush the writer
			printWriter.close(); // Close the writer
			
			System.out.println("Rainfall data has been written to the file: " + fileName);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
