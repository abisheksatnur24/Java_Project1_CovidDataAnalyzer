/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * @author Abishek Satnur
 * @version 2021.12.04
 *
 */
public class CompareCFR implements Comparator<Race> {
    
    @Override
    public int compare(Race race1, Race race2) {
        if (race1.getCFR() < race2.getCFR()) {
            return 1;
        } 
        else if (race1.getCFR() > race2.getCFR()) {
            return -1;
        } 
        return 0; 
    }

}
