package prj5;

import student.TestCase;

/**
 * 
 * @author Abby Searles
 * @author Tyler Levine
 * @version 2021.11.16
 *
 */
public class StateTest extends TestCase {

    private State dc;
    private State virginia;
    private Race raceWhiteDC;
    private Race raceWhiteVA;
    private Race raceBlackDC;
    private Race raceBlackVA;
    private Race raceLatinDC;
    private Race raceLatinVA;
    private Race raceAsianDC;
    private Race raceAsianVA;
    private Race raceOtherDC;
    private Race raceOtherVA;

    /**
     * set up
     */
    public void setUp() {
        virginia = new State("Virginia", 616402, 426362, 738177, -1, 137703,
            34311, 14702, -1, -1, 2131);
        raceWhiteDC = new Race("white", 70678, 1924);
        raceWhiteVA = new Race("white", 616402, 34311);
        raceBlackDC = new Race("black", 179563, 13365);
        raceBlackVA = new Race("black", 426362, 14702);
        raceLatinDC = new Race("latinX", 97118, 2269);
        raceLatinVA = new Race("latinX", 738177, -1);
        raceAsianDC = new Race("asian", 5407, 254);
        raceAsianVA = new Race("asian", -1, -1);
        raceOtherDC = new Race("other", 91880, -1);
        raceOtherVA = new Race("other", 137703, 2131);
        dc = new State("DC", raceWhiteDC, raceBlackDC, 
            raceLatinDC, raceAsianDC, raceOtherDC);
    }


    /**
     * tests getName()
     */
    public void testGetName() {
        assertEquals("DC", dc.getName());
        assertEquals("Virginia", virginia.getName());
    }


    /**
     * tests getWhiteInfo()
     */
    public void testGetWhiteInfo() {
        String whiteDC = raceWhiteDC.toString();
        String whiteVA = raceWhiteVA.toString();
        String whiteDCInfo = dc.getWhiteInfo().toString();
        String whiteVAInfo = virginia.getWhiteInfo().toString();

        assertEquals(whiteDC, whiteDCInfo);
        assertEquals(whiteVA, whiteVAInfo);
    }


    /**
     * tests getBlackInfo()
     */
    public void testGetBlackInfo() {
        String blackDC = raceBlackDC.toString();
        String blackVA = raceBlackVA.toString();
        String blackDCInfo = dc.getBlackInfo().toString();
        String blackVAInfo = virginia.getBlackInfo().toString();

        assertEquals(blackDC, blackDCInfo);
        assertEquals(blackVA, blackVAInfo);
    }


    /**
     * tests getLatinInfo()
     */
    public void testGetLatinInfo() {
        String latinDC = raceLatinDC.toString();
        String latinVA = raceLatinVA.toString();
        String latinDCInfo = dc.getLatinInfo().toString();
        String latinVAInfo = virginia.getLatinInfo().toString();

        assertEquals(latinDC, latinDCInfo);
        assertEquals(latinVA, latinVAInfo);
    }


    /**
     * tests getAsianInfo()
     */
    public void testAsianInfo() {
        String asianDC = raceAsianDC.toString();
        String asianVA = raceAsianVA.toString();
        String asianDCInfo = dc.getAsianInfo().toString();
        String asianVAInfo = virginia.getAsianInfo().toString();

        assertEquals(asianDC, asianDCInfo);
        assertEquals(asianVA, asianVAInfo);
    }


    /**
     * tests getOtherInfo()
     */
    public void testGetOtherInfo() {
        String otherDC = raceOtherDC.toString();
        String otherVA = raceOtherVA.toString();
        String otherDCInfo = dc.getOtherInfo().toString();
        String otherVAInfo = virginia.getOtherInfo().toString();

        assertEquals(otherDC, otherDCInfo);
        assertEquals(otherVA, otherVAInfo);
    }


    /**
     * tests raceArray()
     */
    public void testRaceArray() {
        Object[] arrayDC = { "DC", raceWhiteDC, raceBlackDC, raceLatinDC,
            raceAsianDC, raceOtherDC };
        Object[] arrayVA = { "Virginia", raceWhiteVA, raceBlackVA, raceLatinVA,
            raceAsianVA, raceOtherVA };

        Object[] dcArray = dc.raceArray();
        Object[] vaArray = virginia.raceArray();

        for (int i = 0; i < arrayDC.length; i++) {
            assertTrue(dcArray[i].equals(arrayDC[i]));
        }

        for (int i = 0; i < arrayVA.length; i++) {
            assertTrue(vaArray[i].equals(arrayVA[i]));
        }

    }


    /**
     * testing toString method
     */
    public void testToString() {
        assertEquals("white: 70678 cases, 2.7% CFR\r\n"
            + "black: 179563 cases, 7.4% CFR\r\n"
            + "latinX: 97118 cases, 2.3% CFR\r\n"
            + "asian: 5407 cases, 4.7% CFR\r\n"
            + "other: 91880 cases, -1% CFR\r\n" + "====", dc.toString());
    }
    
    /**
     * Tests toSLList() method
     */
    public void testToSLList()
    {
        assertEquals("{[white, 70678, 1924],"
            + "[black, 179563, 13365],"
            + "[latinX, 97118, 2296],"
            + "[asian, 5407, 254],"
            + "[other, 91880, -1]}", dc.toSLList());
    }
    
    /**
     * Tests setAlpha() method
     */
    public void testSetAlpha()
    {
        dc.setAlpha(dc.toSLList());
        assertEquals("{[asian, 5407, 254],"
            + "[black, 179563, 13365],"
            + "[latinX, 97118, 2296],"
            + "[other, 91880, -1]"
            + "[white, 70678, 1924]}", dc.toSLList());
    }
    
    /**
     * Tests setCFR() method
     */
    public void testSetCFR()
    {
        dc.setCFR(dc.toSLList());
        assertEquals("{[asian, 5407, 254],"
            + "[black, 179563, 13365],"
            + "[latinX, 97118, 2296],"
            + "[other, 91880, -1]"
            + "[white, 70678, 1924]}",dc.toSLList());
    }
}
