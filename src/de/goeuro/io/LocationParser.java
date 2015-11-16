package de.goeuro.io;

import java.util.List;

import com.google.gson.JsonArray;

import de.goeuro.exception.GoEuroException;
import de.goeuro.vo.Location;

public interface LocationParser {

	/**
	 * Maps a json array to a list of locations.
	 * 
	 * @param jArray Json array containing locations info.
	 * @return {@link List} of locations.
	 * @throws GoEuroException If an I/O error occurs while parsing.
	 */
	List<Location> parse(JsonArray jArray) throws GoEuroException;
}
