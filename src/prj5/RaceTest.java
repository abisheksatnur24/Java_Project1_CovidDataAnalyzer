package prj5;

import student.TestCase;
import java.util.Arrays;

/**
 * 
 * @author Abby Searles
 * @version 2021.11.16
 *
 */
public class RaceTest extends TestCase {

    private Race raceWhite;
    private Race raceBlack;
    private Race raceOther;

    /**
     * set up
     */
    public void setUp() {
        raceWhite = new Race("White", 70678, 1924);
        raceBlack = new Race("Black", 179563, 13365);
        raceOther = new Race("Other", 91880, -1);

    }


    /**
     * test for getName()
     */
    public void testGetName() {
        assertEquals("White", raceWhite.getName());
        assertEquals("Black", raceBlack.getName());
        assertEquals("Other", raceOther.getName());
    }


    /**
     * test for getCases()
     */
    public void testGetCases() {
        assertEquals(70678, raceWhite.getCases());
        assertEquals(179563, raceBlack.getCases());
        assertEquals(91880, raceOther.getCases());
    }


    /**
     * test for getDeaths()
     */
    public void testGetDeaths() {
        assertEquals(1924, raceWhite.getDeaths());
        assertEquals(13365, raceBlack.getDeaths());
        assertEquals(-1, raceOther.getDeaths());
    }


    /**
     * test for getting CFR
     */
    public void testGetCFR() {
        Race test = new Race("White", 40, 20);
        assertEquals(50.0, test.getCFR(), 0.00001);
    }


    /**
     * test for getting CFR
     */
    public void testGetCFR2() {
        Race test = new Race("White", -1, 20);
        assertEquals(-1, test.getCFR(), 0.00001);
    }


    /**
     * test for toArray()
     */
    public void testToArray() {
        Object[] arrayWhite = { "White", 70678, 1924 };
        Object[] arrayBlack = { "Black", 179563, 13365 };
        Object[] arrayOther = { "Other", 91880, -1 };

        assertTrue(Arrays.equals(arrayWhite, raceWhite.toArray()));
        assertTrue(Arrays.equals(arrayBlack, raceBlack.toArray()));
        assertTrue(Arrays.equals(arrayOther, raceOther.toArray()));

    }


    /**
     * test for toString()
     */
    public void testToString() {
        String stringWhite = "[White, 70678, 1924]";
        String stringBlack = "[Black, 179563, 13365]";
        String stringOther = "[Other, 91880, -1]";

        assertEquals(stringWhite, raceWhite.toString());
        assertEquals(stringBlack, raceBlack.toString());
        assertEquals(stringOther, raceOther.toString());
    }


    /**
     * test for equals()
     */
    public void testEquals() {
        Race raceNull = null;
        Object object = new Object();

        Race raceWhite2 = new Race("White", 70678, 1924);
        Race raceWhite3 = new Race("White", 70675, 1924);
        Race raceWhite4 = new Race("White", 70678, 1926);

        assertTrue(raceWhite.equals(raceWhite));
        assertTrue(raceWhite.equals(raceWhite2));
        assertFalse(raceWhite.equals(raceBlack));
        assertFalse(raceBlack.equals(raceWhite2));
        assertFalse(raceWhite.equals(raceNull));
        assertFalse(raceWhite.equals(object));
        assertFalse(raceWhite2.equals(raceWhite3));
        assertFalse(raceWhite2.equals(raceWhite4));
    }

}
