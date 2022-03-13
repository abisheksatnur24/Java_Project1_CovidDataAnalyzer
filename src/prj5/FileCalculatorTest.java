package prj5;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

/**
 * 
 * @author Tyler Levine
 * @author Abishek Satnur
 * 
 * @version 2021.11.19
 *
 */
public class FileCalculatorTest extends TestCase {
    private final ByteArrayOutputStream outputStreamCaptor =
        new ByteArrayOutputStream();
    private FileCalculator calc;

    /**
     * setUp for test method
     */
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        SLList<State> list = new SLList<State>();
        State dc = new State("dc", 70678, 179563, 97118, 5407, 108784, 1924,
            13365, 2269, 254, 170);
        State md = new State("md", 534910, 764514, 635420, 47733, 539893, 44759,
            42863, 11343, 3999, 2103);
        State tn = new State("tn", 1140754, 491709, 443364, 25846, 847967,
            16929, 9442, -1, 403, 2122);
        list.add(dc);
        list.add(md);
        list.add(tn);
        calc = new FileCalculator(list);
    }


    /**
     * tests sortByAlpha
     */
    public void testSortByAlpha() {
        Exception e = null;
        try {
            //calc.sortByAlpha();
        }
        catch (Exception exception) {
            e = exception;
        }

        assertEquals("dc\r\n" + "asian: 5407 cases, 4.7% CFR\r\n"
            + "black: 179563 cases, 7.4% CFR\r\n"
            + "latinX: 97118 cases, 2.3% CFR\r\n"
            + "other: 108784 cases, 0.2% CFR\r\n"
            + "white: 70678 cases, 2.7% CFR\r\n" + "====\r\n"
            + "black: 179563 cases, 7.4% CFR\r\n"
            + "    asian: 5407 cases, 4.7% CFR\r\n"
            + "    white: 70678 cases, 2.7% CFR\r\n"
            + "    latinX: 97118 cases, 2.3% CFR\r\n"
            + "    other: 108784 cases, 0.2% CFR\r\n" + "    ====\r\n"
            + "    md\r\n" + "    asian: 47733 cases, 8.4% CFR\r\n"
            + "    black: 764514 cases, 5.6% CFR\r\n"
            + "    latinX: 635420 cases, 1.8% CFR\r\n"
            + "    other: 539893 cases, 0.4% CFR\r\n"
            + "    white: 534910 cases, 8.4% CFR\r\n" + "    ====\r\n"
            + "    asian: 47733 cases, 8.4% CFR\r\n"
            + "    white: 534910 cases, 8.4% CFR\r\n"
            + "    black: 764514 cases, 5.6% CFR\r\n"
            + "    latinX: 635420 cases, 1.8% CFR\r\n"
            + "    other: 539893 cases, 0.4% CFR\r\n" + "    ====\r\n"
            + "    tn\r\n" + "    asian: 25846 cases, 1.6% CFR\r\n"
            + "    black: 491709 cases, 1.9% CFR\r\n"
            + "    latinX: 443364 cases, -1% CFR\r\n"
            + "    other: 847967 cases, 0.3% CFR\r\n"
            + "    white: 1140754 cases, 1.5% CFR\r\n" + "    ====\r\n"
            + "    black: 491709 cases, 1.9% CFR\r\n"
            + "    asian: 25846 cases, 1.6% CFR\r\n"
            + "    white: 1140754 cases, 1.5% CFR\r\n"
            + "    other: 847967 cases, 0.3% CFR\r\n"
            + "    latinX: 443364 cases, -1% CFR\r\n"
            + "other: 847967 cases, 0.3% CFR\r\n"
            + "white: 1140754 cases, 1.5% CFR\r\n" + "====", outputStreamCaptor
                .toString().trim());
    }

}
