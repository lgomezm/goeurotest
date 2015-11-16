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
			System.out.println("Error: Please provide a city name");
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
			writer.write(cityName, locations);
		} catch (GoEuroException e) {
			System.out.println(e.getMessage());
		}
	}
}
