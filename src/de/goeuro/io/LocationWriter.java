package de.goeuro.io;

import java.util.List;

import de.goeuro.vo.Location;

public interface LocationWriter {

	/**
	 * Writes a list of locations.
	 * 
	 * @param locations List of locations to write.
	 */
	void write(List<Location> locations);
}
