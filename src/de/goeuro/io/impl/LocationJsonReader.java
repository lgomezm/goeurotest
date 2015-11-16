package de.goeuro.io.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import de.goeuro.exception.GoEuroException;
import de.goeuro.io.LocationReader;

public class LocationJsonReader implements LocationReader {
	
	private static final String URL_PATTERN = "http://api.goeuro.com/api/v2/position/suggest/en/%s";
	
	@Override
	public JsonArray getLocationsAsJson(String cityName) throws GoEuroException {
		String queryUrl = String.format(URL_PATTERN, cityName);
		try {
			URL url = new URL(queryUrl);
			return queryLocations(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new GoEuroException("Malformed query URL: " + queryUrl);
		}
	}
	
	private JsonArray queryLocations(URL url) throws GoEuroException {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
			for (String line; (line = br.readLine()) != null; ) {
				sb.append(line);
		    }
			return new Gson().fromJson(sb.toString(), JsonArray.class);
		} catch (IOException e) {
			e.printStackTrace();
			throw new GoEuroException("An error occured while getting the results");
		}
	}
}
