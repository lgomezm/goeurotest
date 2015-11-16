package de.goeuro.io;

import com.google.gson.JsonArray;

import de.goeuro.exception.GoEuroException;

public interface LocationReader {

	/**
	 * Uses the GoEuro API to query locations, based on a city name.
	 * 
	 * @param cityName Name of the city.
	 * @return A json array with the result of the query.
	 * @throws GoEuroException If an I/O error occurs.
	 */
	JsonArray getLocationsAsJson(String cityName) throws GoEuroException;
}
