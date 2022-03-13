/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;

/**
 * @author Abishek Satnur
 * @version 2021.12.04
 *
 */
public class Input {
    public static void main(String[] args) throws FileNotFoundException {
        // throws FileNotFoundException,
        // StateDataException,
        // bsh.ParseException
        if (args.length == 1) {
            FileReader covidData = new FileReader(args[0]);
        }
        else {
            // FileReader covidData = new
            // FileReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
            FileReader covidData2 = new FileReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
    }
}
