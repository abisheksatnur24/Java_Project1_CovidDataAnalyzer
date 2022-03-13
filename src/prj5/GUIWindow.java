package prj5;

import java.awt.Color;
import java.text.DecimalFormat;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * 
 * @author abby searles
 * @author abishek satnur
 * @version 2021.12.01
 *
 */
public class GUIWindow {

    // fields ----------------------------
    private Window window;
    private State state;
    private Button quit;
    private Button sortAlpha;
    private Button sortCFR;
    private Button repDC;
    private Button repGA;
    private Button repMD;
    private Button repNC;
    private Button repTN;
    private Button repVA;

    private Shape[] graphShapes;
    private FileCalculator calculator;
    private SLList<State> statesList;

    // constructor -----------------------
    /**
     * constructor for GUIWindow
     * 
     * @param calc
     *            The calculator to sort
     * @param reader
     *            to get LList of states
     */
    public GUIWindow(FileCalculator calc, SLList<State> list) {
        window = new Window();
        window.setTitle("Abishek Satnur, Abby Searles, Tyler Levine");

        calculator = calc;
        statesList = list;
        

        sortAlpha = new Button("Sort by Alpha");
        sortAlpha.onClick(this, "clickedSortAlpha");
        
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");

        sortCFR = new Button("Sort by CFR");
        sortCFR.onClick(this, "clickedSortCFR");

        repDC = new Button("Represent DC");
        repDC.onClick(this, "clickedDC");

        repGA = new Button("Represent GA");
        repGA.onClick(this, "clickedGA");

        repMD = new Button("Represent MD");
        repMD.onClick(this, "clickedMD");

        repNC = new Button("Represent NC");
        repNC.onClick(this, "clickedNC");

        repTN = new Button("Represent TN");
        repTN.onClick(this, "clickedTN");

        repVA = new Button("Represent VA");
        repVA.onClick(this, "clickedVA");

        window.addButton(sortAlpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortCFR, WindowSide.NORTH);

        window.addButton(repDC, WindowSide.SOUTH);
        window.addButton(repGA, WindowSide.SOUTH);
        window.addButton(repMD, WindowSide.SOUTH);
        window.addButton(repNC, WindowSide.SOUTH);
        window.addButton(repTN, WindowSide.SOUTH);
        window.addButton(repVA, WindowSide.SOUTH);
    }

    // methods ---------------------------


    /**
     * quits program
     * 
     * @param button
     *            the button clicked
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * sorts by alpha
     * 
     * @param button
     *            the button clicked
     */
    public void clickedSortAlpha(Button button) {
        calculator.sortByAlpha(statesList);
        drawShapesAlpha(state);
    }


    /**
     * sorts by CFR
     * 
     * @param button
     *            the button clicked
     */
    public void clickedSortCFR(Button button) {
        calculator.sortByCFR(statesList);
        drawShapesCFR(state);
    }


    /**
     * presents DC data
     * 
     * @param button
     *            the button clicked
     */
    public void clickedDC(Button button) {
        state = statesList.getEntry(0);
        String title = state.getName() + " Case Fatality Ratios by Race";
        TextShape titleShape = new TextShape(250, 30, title);
        window.addShape(titleShape);

        drawShapes(state);
    }


    /**
     * presents GA data
     * 
     * @param button
     *            the button clicked
     */
    public void clickedGA(Button button) {
        state = statesList.getEntry(1);
        String title = state.getName() + " Case Fatality Ratios by Race";
        TextShape titleShape = new TextShape(250, 30, title);
        window.addShape(titleShape);

        drawShapes(state);
    }


    /**
     * presents MD data
     * 
     * @param button
     *            the button clicked
     */
    public void clickedMD(Button button) {
        state = statesList.getEntry(2);
        String title = state.getName() + " Case Fatality Ratios by Race";
        TextShape titleShape = new TextShape(250, 30, title);
        window.addShape(titleShape);

        drawShapes(state);
    }


    /**
     * presents NC data
     * 
     * @param button
     *            the button clicked
     */
    public void clickedNC(Button button) {
        state = statesList.getEntry(3);
        String title = state.getName() + " Case Fatality Ratios by Race";
        TextShape titleShape = new TextShape(250, 30, title);
        window.addShape(titleShape);

        drawShapes(state);
    }


    /**
     * presents TN data
     * 
     * @param button
     *            the button clicked
     */
    public void clickedTN(Button button) {
        state = statesList.getEntry(4);
        String title = state.getName() + " Case Fatality Ratios by Race";
        TextShape titleShape = new TextShape(250, 30, title);
        window.addShape(titleShape);

        drawShapes(state);
    }


    /**
     * presents VA data
     * 
     * @param button
     *            the button clicked
     */
    public void clickedVA(Button button) {
        state = statesList.getEntry(5);
        String title = state.getName() + " Case Fatality Ratios by Race";
        TextShape titleShape = new TextShape(250, 30, title);
        window.addShape(titleShape);

        drawShapes(state);
    }


    /**
     * draws the default bar shapes
     */
    private void drawShapes(State currentState) {

        window.removeAllShapes();
        DecimalFormat cfr = new DecimalFormat("#.#");
        Shape bar = new Shape(100, 300 - (int)currentState.getAsianInfo()
            .getCFR() * 30, 20, (int)currentState.getAsianInfo().getCFR() * 30,
            Color.BLUE);
        window.addShape(bar);
        bar = new Shape(200, 300 - (int)currentState.getBlackInfo().getCFR()
            * 30, 20, (int)currentState.getBlackInfo().getCFR() * 30,
            Color.BLUE);
        window.addShape(bar);
        bar = new Shape(300, 300 - (int)currentState.getLatinInfo().getCFR()
            * 30, 20, (int)currentState.getLatinInfo().getCFR() * 30,
            Color.BLUE);
        window.addShape(bar);
        bar = new Shape(400, 300 - (int)currentState.getOtherInfo().getCFR()
            * 30, 20, (int)currentState.getOtherInfo().getCFR() * 30,
            Color.BLUE);
        window.addShape(bar);
        bar = new Shape(500, 300 - (int)currentState.getWhiteInfo().getCFR()
            * 30, 20, (int)currentState.getWhiteInfo().getCFR() * 30,
            Color.BLUE);
        window.addShape(bar);
        TextShape raceShape = new TextShape(100, 320, "asian");
        TextShape CFRShape = new TextShape(100, 340, String.valueOf(
            (cfr.format(currentState.getAsianInfo().getCFR()))));
        window.addShape(raceShape);
        window.addShape(CFRShape);
        raceShape = new TextShape(200, 320, "black");
        CFRShape = new TextShape(200, 340, String.valueOf(cfr.format(currentState
            .getBlackInfo().getCFR())));
        window.addShape(raceShape);
        window.addShape(CFRShape);
        raceShape = new TextShape(300, 320, "latinx");
        CFRShape = new TextShape(300, 340, String.valueOf(cfr.format(currentState
            .getLatinInfo().getCFR())));
        window.addShape(raceShape);
        window.addShape(CFRShape);
        raceShape = new TextShape(400, 320, "other");
        CFRShape = new TextShape(400, 340, String.valueOf(cfr.format(currentState
            .getOtherInfo().getCFR())));
        window.addShape(raceShape);
        window.addShape(CFRShape);
        raceShape = new TextShape(500, 320, "white");
        CFRShape = new TextShape(500, 340, String.valueOf(cfr.format(currentState
            .getWhiteInfo().getCFR())));
        window.addShape(raceShape);
        window.addShape(CFRShape);

    }


    /**
     * draws the default bar shapes
     */
    private void drawShapesAlpha(State currentState) {
        window.removeAllShapes();
        DecimalFormat cfr = new DecimalFormat("#.#");
        SLList<Race> alphaRaces = currentState.getAlphaRaces();
        Shape bar = new Shape(100, 300 - (int)alphaRaces.getEntry(0).getCFR()
            * 30, 20, (int)alphaRaces.getEntry(0).getCFR() * 30, Color.BLUE);
        window.addShape(bar);
        bar = new Shape(200, 300 - (int)alphaRaces.getEntry(1).getCFR() * 30,
            20, (int)alphaRaces.getEntry(1).getCFR() * 30, Color.BLUE);
        window.addShape(bar);
        bar = new Shape(300, 300 - (int)alphaRaces.getEntry(2).getCFR() * 30,
            20, (int)alphaRaces.getEntry(2).getCFR() * 30, Color.BLUE);
        window.addShape(bar);
        bar = new Shape(400, 300 - (int)alphaRaces.getEntry(3).getCFR() * 30,
            20, (int)alphaRaces.getEntry(3).getCFR() * 30, Color.BLUE);
        window.addShape(bar);
        bar = new Shape(500, 300 - (int)alphaRaces.getEntry(4).getCFR() * 30,
            20, (int)alphaRaces.getEntry(4).getCFR() * 30, Color.BLUE);
        window.addShape(bar);
        TextShape raceShape = new TextShape(100, 320, alphaRaces.getEntry(0)
            .getName());
        TextShape CFRShape = new TextShape(100, 340, String.valueOf(
            cfr.format(alphaRaces.getEntry(0).getCFR())));
        window.addShape(raceShape);
        window.addShape(CFRShape);
        raceShape = new TextShape(200, 320, alphaRaces.getEntry(1).getName());
        CFRShape = new TextShape(200, 340, String.valueOf(cfr.format(alphaRaces
            .getEntry(1).getCFR())));
        window.addShape(raceShape);
        window.addShape(CFRShape);
        raceShape = new TextShape(300, 320, alphaRaces.getEntry(2).getName());
        CFRShape = new TextShape(300, 340, String.valueOf(cfr.format(alphaRaces
            .getEntry(2).getCFR())));
        window.addShape(raceShape);
        window.addShape(CFRShape);
        raceShape = new TextShape(400, 320, alphaRaces.getEntry(3).getName());
        CFRShape = new TextShape(400, 340, String.valueOf(cfr.format(alphaRaces
            .getEntry(3).getCFR())));
        window.addShape(raceShape);
        window.addShape(CFRShape);
        raceShape = new TextShape(500, 320, alphaRaces.getEntry(4).getName());
        CFRShape = new TextShape(500, 340, String.valueOf(cfr.format(alphaRaces
            .getEntry(4).getCFR())));
        window.addShape(raceShape);
        window.addShape(CFRShape);

    }


    /**
     * draws the default bar shapes
     */
    private void drawShapesCFR(State currentState) {
        window.removeAllShapes();
        DecimalFormat cfr = new DecimalFormat("#.#");
        SLList<Race> cfrRaces = currentState.getCfrRaces();
        Shape bar = new Shape(100, 300 - (int)cfrRaces.getEntry(0).getCFR()
            * 30, 20, (int)cfrRaces.getEntry(0).getCFR() * 30, Color.BLUE);
        window.addShape(bar);
        bar = new Shape(200, 300 - (int)cfrRaces.getEntry(1).getCFR() * 30, 20,
            (int)cfrRaces.getEntry(1).getCFR() * 30, Color.BLUE);
        window.addShape(bar);
        bar = new Shape(300, 300 - (int)cfrRaces.getEntry(2).getCFR() * 30, 20,
            (int)cfrRaces.getEntry(2).getCFR() * 30, Color.BLUE);
        window.addShape(bar);
        bar = new Shape(400, 300 - (int)cfrRaces.getEntry(3).getCFR() * 30, 20,
            (int)cfrRaces.getEntry(3).getCFR() * 30, Color.BLUE);
        window.addShape(bar);
        bar = new Shape(500, 300 - (int)cfrRaces.getEntry(4).getCFR() * 30, 20,
            (int)cfrRaces.getEntry(4).getCFR() * 30, Color.BLUE);
        window.addShape(bar);
        TextShape raceShape = new TextShape(100, 320, cfrRaces.getEntry(0)
            .getName());
        TextShape CFRShape = new TextShape(100, 340, String.valueOf(
            cfr.format(cfrRaces.getEntry(0).getCFR())));
        window.addShape(raceShape);
        window.addShape(CFRShape);
        raceShape = new TextShape(200, 320, cfrRaces.getEntry(1).getName());
        CFRShape = new TextShape(200, 340, String.valueOf(cfr.format(cfrRaces
            .getEntry(1).getCFR())));
        window.addShape(raceShape);
        window.addShape(CFRShape);
        raceShape = new TextShape(300, 320, cfrRaces.getEntry(2).getName());
        CFRShape = new TextShape(300, 340, String.valueOf(cfr.format(cfrRaces
            .getEntry(2).getCFR())));
        window.addShape(raceShape);
        window.addShape(CFRShape);
        raceShape = new TextShape(400, 320, cfrRaces.getEntry(3).getName());
        CFRShape = new TextShape(400, 340, String.valueOf(cfr.format(cfrRaces
            .getEntry(3).getCFR())));
        window.addShape(raceShape);
        window.addShape(CFRShape);
        raceShape = new TextShape(500, 320, cfrRaces.getEntry(4).getName());
        CFRShape = new TextShape(500, 340, String.valueOf(cfr.format(cfrRaces
            .getEntry(4).getCFR())));
        window.addShape(raceShape);
        window.addShape(CFRShape);

    }


    /**
     * updates the window
     */
    public void update() {
        window.removeAllShapes();
    }

}
