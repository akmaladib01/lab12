package lab12_Exercise6;

import java.io.FileOutputStream;
import java.io.DataOutputStream;

public class RainFallOutput {

	public static void main(String[] args) {
		
		// Define the output file name
        String fileName = "report_2.txt";
        
        // Define the rainfall data for different locations
        String Location[][] = {	{"Alor Gajah", "2321006", "Ladang Lendu", "0.0", "3.0", "4.0", "0.0", "0.0", "5.0"},
                				{"Alor Gajah", "2222002", "Durian Tunggal", "0.0", "37.0", "6.0", "9.0", "0.0", "5.0"},
                				{"Jasin", "2225044", "Chohong", "0.0", "39.0", "14.5", "24.5", "0.5", "3.5"},
                				{"Jasin", "2125002", "Telok Rimba", "1.0", "69.0", "53.0", "4.0", "0.0", "89.0"},
                				{"Melaka Tengah", "2222033", "Batu Hampar", "0.0", "30.0", "11.5", "22.0", "0.0", "21.5"},
                				{"Melaka Tengah", "2222005", "Klebang Besar D/S", "0.0", "75.5", "25.5", "20.5", "0.0", "10.0"} };

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))) {
        
        	// Loop through each location
        	for (String[] location : Location) {
               
        		// Extract the relevant data for the location
        		String district = location[0];
                String code = location[1];
                String station = location[2];
                String[] rainfall = {location[3], location[4], location[5], location[6], location[7], location[8]};

                // Write the district, code, and station information to the data stream
                outputStream.writeUTF(district);
                outputStream.writeUTF(code);
                outputStream.writeUTF(station);

                // Loop through each rainfall value and write it to the data stream
                for (String rainFall : rainfall) {
                	outputStream.writeDouble(Double.parseDouble(rainFall));
                }
            }
        	
            System.out.println("Data has been entered into " + fileName);

        } catch (Exception e) {
        	
            e.printStackTrace();
        }
    }
}
