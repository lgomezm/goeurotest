Java Developer Test
===================

This is my solution to the Java developer test at GoEuro. It basically takes an input from the command line like this:

    java -jar dist/GoEuroTest.jar Berlin

After running, it generates a .csv file containing the results of querying the GoEuro API for the given city name.

The Json parsing was implemented by using Google's Gson (https://github.com/google/gson).
