package de.goeuro.io.impl;

import java.util.List;

import de.goeuro.io.LocationWriter;
import de.goeuro.vo.Location;

public class LocationCSVWriter implements LocationWriter {

	@Override
	public void write(List<Location> locations) {
		for (Location location : locations) {
			System.out.println(String.format("%d,%s,%s,%f,%f", 
					location.getId(), location.getName(),
					location.getType(), location.getLatitude(), 
					location.getLongitude()));
		}
	}
}
