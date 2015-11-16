package de.goeuro.io;

import java.util.List;

import de.goeuro.exception.GoEuroException;
import de.goeuro.vo.Location;

public interface LocationWriter {

	/**
	 * Writes a list of locations.
	 * 
	 * @param cityName City name the query was issued for.
	 * @param locations List of locations to write.
	 * @return Name of the file created.
	 * @throws If there is an I/O error processing the output.
	 */
	String write(String cityName, List<Location> locations) throws GoEuroException;
}
