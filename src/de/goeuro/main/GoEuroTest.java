package de.goeuro.main;

import java.util.List;

import com.google.gson.JsonArray;

import de.goeuro.exception.GoEuroException;
import de.goeuro.io.LocationParser;
import de.goeuro.io.LocationReader;
import de.goeuro.io.LocationWriter;
import de.goeuro.io.impl.LocationCSVWriter;
import de.goeuro.io.impl.LocationJsonReader;
import de.goeuro.io.impl.LocationParserImpl;
import de.goeuro.vo.Location;

public class GoEuroTest {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Error: Please provide a city name");
		} else {
			queryLocations(args[0]);			
		}
	}

	private static void queryLocations(String cityName) {
		LocationReader reader = new LocationJsonReader();
		LocationParser parser = new LocationParserImpl();
		LocationWriter writer = new LocationCSVWriter();
		try {
			JsonArray array = reader.getLocationsAsJson(cityName);
			List<Location> locations = parser.parse(array);
			int locationsCount = locations.size();
			if (locationsCount > 0) {
				String filename = writer.write(cityName, locations);
				System.out.println(String.format("%d results found, exported on %s",
						locationsCount, filename));
			} else {
				System.out.println("No location found. No output file generated");
			}
		} catch (GoEuroException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
