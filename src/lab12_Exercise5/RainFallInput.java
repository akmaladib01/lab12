package lab12_Exercise5;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class RainFallInput {
	
	public static void main(String[] args) {
        
		// File path of the input data
        String inputFile = "report.txt";
        System.out.println("Reading data from " + inputFile + "\n");

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(inputFile))) {
            
        	// Variables for processing byte-based data
            double totalDailyRainfall = 0.0;  
            double dailyRainfall = 0.0;  
            String station;  
            int count = 0;

            // Read the station name from the input stream
            station = inputStream.readUTF();

            // Process the remaining data
            while (inputStream.available() > 0) {
            	
                // Read the daily rainfall value from the input stream
                dailyRainfall = inputStream.readDouble();

                // Update the total sum and count
                totalDailyRainfall += dailyRainfall;
                count++;
                System.out.println("Rainfall for day " + count + " in " + station + " is: " + dailyRainfall);
            }

            // Calculate the average daily rainfall
            double averageRainfall = totalDailyRainfall / count;

            // Print the result
            System.out.println("\nAverage rainfall for " + count + " days in " + station + " are: " + String.format("%.2f",averageRainfall));
        } catch (IOException e) {
        	
            // Handle any IO exceptions that may occur
            e.printStackTrace();
        }
    }
}
