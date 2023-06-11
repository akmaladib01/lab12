package lab12_Exercise6;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class RainFallInput {

public static void main(String[] args) {
        
		// File name to read the data from
        String inputFile = "report_2.txt";
        System.out.println("Reading data from " + inputFile + "\n");

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(inputFile))) {
           
        	// Variables for processing byte-based data
            double totalDailyRainfall = 0.0;
            double dailyRainfall = 0.0;
            String district; 
            String code; 
            String station;
            int count = 0; 

            while (inputStream.available() > 0) {
                // Read district, code, and station from the input stream
                district = inputStream.readUTF();
                System.out.println("District: " + district);

                code = inputStream.readUTF();
                System.out.println("Code ID: " + code);

                station = inputStream.readUTF();
                System.out.println("Station: " + station);

                for (int i = 0; i < 6; i++) {
                	
                    // Read daily rainfall data from the input stream
                    dailyRainfall = inputStream.readDouble();
                    totalDailyRainfall += dailyRainfall;
                    count++;
                    System.out.println("Data day " + count + ": " + dailyRainfall + " mm");
                }

                // Calculate the average daily rainfall
                double averageRainfall = totalDailyRainfall / count;

                // Print the result
                System.out.println("\nAverage rainfall for " + count + " days in " + station + " are: " + String.format("%.2f", averageRainfall) + " mm");
                System.out.println("\n");

                // Reset variables for the next set of data
                dailyRainfall = 0;
                count = 0;
                totalDailyRainfall = 0;
            }

        } catch (IOException e) {
            // Handle any IO exceptions that may occur
            e.printStackTrace();
        }
    }
}
