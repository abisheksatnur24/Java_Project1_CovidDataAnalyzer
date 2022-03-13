/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * @author Abishek Satnur 
 * @version 2021.11.04
 *
 */
public class CompareAlpha implements Comparator<Race> {

    @Override
    public int compare(Race race1, Race race2) {
        if (race1.getName().compareTo(race2.getName()) > 0) {
            return 1;
        }
        else if (race1.getName().compareTo(race2.getName()) < 0) {
            return -1;
        }
        return 0; 
    }
}
