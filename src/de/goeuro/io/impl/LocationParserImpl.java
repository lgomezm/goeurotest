package de.goeuro.io.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.goeuro.exception.GoEuroException;
import de.goeuro.io.LocationParser;
import de.goeuro.vo.Location;

public class LocationParserImpl implements LocationParser {

	@Override
	public List<Location> parse(JsonArray jArray) throws GoEuroException {
		List<Location> locations = new ArrayList<>();
		for (JsonElement jsonElement : jArray) {
			Location location = parseLocation(jsonElement);
			locations.add(location);
		}
		return locations;
	}

	private Location parseLocation(JsonElement jsonElement) {
		Location location = new Location();
		JsonObject locJson = jsonElement.getAsJsonObject();
		JsonObject geoPos = locJson.getAsJsonObject("geo_position");
		location.setId(locJson.get("_id").getAsInt());
		location.setName(locJson.get("name").getAsString());
		location.setType(locJson.get("type").getAsString());
		location.setLatitude(geoPos.get("latitude").getAsDouble());
		location.setLongitude(geoPos.get("longitude").getAsDouble());
		return location;
	}
}
