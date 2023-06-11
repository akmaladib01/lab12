package lab12_Exercise7;

import java.io.BufferedReader;
import java.io.FileReader;

public class RainFallInput {
	
	public static void main(String[] args) {
		String referFile = "report_3.txt";
		System.out.println("Reading data from " + referFile + "\n");
		
		try {
			
			BufferedReader inputStream = new BufferedReader(new FileReader(referFile));
			
			double totalDailyRainfall = 0.0; // Variable to store the total daily rainfall
			int count = 0; // Variable to count the number of rainfall data
			
			String data;
			String saveData[] = null; // Array to store the split data
			
			while ((data = inputStream.readLine()) != null) {
				
				saveData = data.split(","); // Split the data by comma and store it in saveData
			}
			
			String station = saveData[0]; // Extract the station name
			System.out.println(station);
			System.out.print("Data Rainfall: ");
			
			// Loop through the saveData array to print rainfall values and calculate total and count
			for (int i = 1; i < saveData.length; i++) {
				
				System.out.print(saveData[i] + ", ");
				totalDailyRainfall += Double.parseDouble(saveData[i]);
				count++;
			}
			
			inputStream.close();
			
			double averageRF = totalDailyRainfall / count; // Calculate average daily rainfall
			System.out.print("\nAverage daily rainfall for " + count + " day in " + station + ": " + averageRF);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
