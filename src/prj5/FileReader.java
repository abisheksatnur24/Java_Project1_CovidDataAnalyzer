/**
 * 
 */
package prj5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Abishek Satnur
 * @author Tyler Levine
 * @version 2021.10.17
 *
 */
public class FileReader {
    private SLList<State> states;
    private FileCalculator calc;
    private GUIWindow gui;

    public FileReader(String args) throws FileNotFoundException {
        // ParseException,
        // StateDataException
        states = readData(args);
        calc = new FileCalculator(states);
        calc.sortByAlpha(states);
        calc.sortByCFR(states);
        gui = new GUIWindow(calc, states);
    }


    private SLList<State> readData(String args)
        throws FileNotFoundException {
        // throws FileNotFoundException,
        // ParseException {
        File file = new File(args);
        Scanner scanner = new Scanner(file);
        SLList<State> stateList = new SLList<State>();

        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            String[] currentArgs = currentLine.split(",");
            if (currentArgs.length != 11) {
                scanner.close();
                // throw new ParseException();
            }

            // ADD SPACEDATA EXCPTION FOR SOMETHING

            // Creating variables for all values
            String state = currentArgs[0];
            int casesWhite = NAHelper(currentArgs[1]);
            int casesBlack = NAHelper(currentArgs[2]);
            int casesLatinX = NAHelper(currentArgs[3]);
            int casesAsian = NAHelper(currentArgs[4]);
            int casesOthers = NAHelper(currentArgs[5]);
            int deathsWhite = NAHelper(currentArgs[6]);
            int deathsBlack = NAHelper(currentArgs[7]);
            int deathsLatinX = NAHelper(currentArgs[8]);
            int deathsAsian = NAHelper(currentArgs[9]);
            int deathsOthers = NAHelper(currentArgs[10]);

            State tempState = new State(state, casesWhite, casesBlack,
                casesLatinX, casesAsian, casesOthers, deathsWhite, deathsBlack,
                deathsLatinX, deathsAsian, deathsOthers);
            stateList.add(tempState);

        }
        scanner.close();
        return stateList;
    }


    private int NAHelper(String str) {
        if (str.equals("NA")) {
            return -1;
        }
        else {
            return Integer.parseInt(str);
        }
    }
}

