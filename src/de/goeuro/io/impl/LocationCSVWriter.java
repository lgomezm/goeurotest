package de.goeuro.io.impl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import de.goeuro.exception.GoEuroException;
import de.goeuro.io.LocationWriter;
import de.goeuro.vo.Location;

public class LocationCSVWriter implements LocationWriter {

	@Override
	public void write(String cityName, List<Location> locations) throws GoEuroException {
		String filename = createFileName(cityName);
		try (PrintWriter writer = new PrintWriter(filename, "UTF-8")) {
			for (Location location : locations) {
				writer.println(String.format("%d,%s,%s,%f,%f", 
						location.getId(), location.getName(),
						location.getType(), location.getLatitude(), 
						location.getLongitude()));
			}
		} catch (FileNotFoundException e) {
			throw new GoEuroException("The file could not be created");
		} catch (UnsupportedEncodingException e) {
			throw new GoEuroException("UTF-8 character encoding not supported");
		}
	}

	private String createFileName(String cityName) {
		return cityName + "-results.csv";
	}
}
