package lab12_Exercise5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RainFallOutput {
	
	public static void main(String[] args) {
        
		// File name to write the rainfall data
        String fileName = "report.txt";

        // Station name
        String station = "Simpang Ampat";

        // Array of rainfall data for 6 days
        double rainfall[] = {0.0, 6.0, 19.0, 1.0, 0.0, 61.0};

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            
        	// Write the station name to the data stream
            outputStream.writeUTF(station);

            // Write the rainfall data to the data stream
            for (double rain : rainfall) {
            	
                outputStream.writeDouble(rain);
            }

            // Print a message indicating that the data has been successfully written
            System.out.println("Data has been entered into " + fileName);
        } catch (IOException e) {
        	
            // Handle any IO exceptions that may occur
            e.printStackTrace();
        }
    }
}
