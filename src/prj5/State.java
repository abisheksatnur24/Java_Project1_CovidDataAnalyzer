package prj5;

import java.text.DecimalFormat;

/**
 * 
 * @author Abby Searles
 * @version 2021.11.16
 *
 * @author Abishek Satnur
 * @version 2021.11.18
 *
 */
public class State {

    // fields ------------------------
    private String name;
    private Race white;
    private Race black;
    private Race latin;
    private Race asian;
    private Race other;
    private SLList<Race> alphaRaces;
    private SLList<Race> cfrRaces;

    /**
     * constructor
     * 
     * @param stateName
     *            name of state
     * @param whiteCases
     *            number of cases
     * @param blackCases
     *            number of cases
     * @param latinCases
     *            number of cases
     * @param asianCases
     *            number of cases
     * @param otherCases
     *            number of cases
     * @param whiteDeaths
     *            number of deaths
     * @param blackDeaths
     *            number of deaths
     * @param latinDeaths
     *            number of deaths
     * @param asianDeaths
     *            number of deaths
     * @param otherDeaths
     *            number of deaths
     */
    public State(
        String stateName,
        int whiteCases,
        int blackCases,
        int latinCases,
        int asianCases,
        int otherCases,
        int whiteDeaths,
        int blackDeaths,
        int latinDeaths,
        int asianDeaths,
        int otherDeaths) {
        name = stateName;
        white = new Race("white", whiteCases, whiteDeaths);
        black = new Race("black", blackCases, blackDeaths);
        latin = new Race("latinX", latinCases, latinDeaths);
        asian = new Race("asian", asianCases, asianDeaths);
        other = new Race("other", otherCases, otherDeaths);
        alphaRaces = new SLList<Race>(); 
        cfrRaces = new SLList<Race>();
    }


    /**
     * 
     * @param stateName
     *            name of state
     * @param race1
     *            race object
     * @param race2
     *            race object
     * @param race3
     *            race object
     * @param race4
     *            race object
     * @param race5
     *            race object
     */
    public State(
        String stateName,
        Race race1,
        Race race2,
        Race race3,
        Race race4,
        Race race5) {
        name = stateName;
        white = race1;
        black = race2;
        latin = race3;
        asian = race4;
        other = race5;
    }

    // methods --------------------------


    /**
     * getter for state name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * getter for race white
     * 
     * @return Race object
     */
    public Race getWhiteInfo() {
        return white;
    }


    /**
     * getter for race black
     * 
     * @return Race object
     * 
     */
    public Race getBlackInfo() {
        return black;
    }


    /**
     * getter for race latin
     * 
     * @return Race object
     * 
     */
    public Race getLatinInfo() {
        return latin;
    }


    /**
     * getter for race asian
     * 
     * @return Race object
     * 
     */
    public Race getAsianInfo() {
        return asian;
    }


    /**
     * getter for race other
     * 
     * @return Race object
     */
    public Race getOtherInfo() {
        return other;
    }

    /**
     * getter for alphaRaces
     */
    public SLList<Race> getAlphaRaces(){
        return this.alphaRaces; 
    }
    
    /**
     * getter for cfrRaces
     */
    public SLList<Race> getCfrRaces(){
        return this.cfrRaces; 
    }

    
    /**
     * Sets a new SLList of races for alphaRaces
     * @param raceList sorted list of races
     */
    public void setAlpha(SLList<Race> raceList) {
        this.alphaRaces = raceList;    
    }
    
    /**
     * Sets a new SLList of races
     * @param raceList sorted list of races
     */
    public void setCFR(SLList<Race> raceList) {
        this.cfrRaces = raceList;    
    }
    
    /**
     * creates an array of state
     * 
     * @return Object[] array of object[]
     */
    public Object[] raceArray() {
        Object[] array;
        array = (Object[])new Object[6];

        array[0] = name;
        array[1] = white;
        array[2] = black;
        array[3] = latin;
        array[4] = asian;
        array[5] = other;

        return array;
    }


    /**
     * State toString method
     * 
     * @return String of description of state
     */
    public String toString() {
        StringBuilder bob = new StringBuilder();
        // bob.append(name);
        // bob.append("\n");

        Race[] raceArr = new Race[5];

        raceArr[0] = white;
        raceArr[1] = black;
        raceArr[2] = latin;
        raceArr[3] = asian;
        raceArr[4] = other;

        for (int i = 0; i < raceArr.length; i++) {
            DecimalFormat tempFormatter = new DecimalFormat("###.#");
            String cfrString = String.valueOf(tempFormatter.format(raceArr[i]
                .getCFR()));
            bob.append(raceArr[i].getName() + ": " + raceArr[i].getCases()
                + " cases, " + cfrString + "% CFR");
            bob.append("\n");
        }
        bob.append("====");
        return bob.toString();
    }


    /**
     * Converts the races in the state to a linked list and returns this list
     * 
     * @return Linked list of states
     */
    public SLList<Race> toSLList() {
        SLList<Race> raceList = new SLList<Race>();
        Race[] raceArr = new Race[5];

        raceArr[0] = white;
        raceArr[1] = black;
        raceArr[2] = latin;
        raceArr[3] = asian;
        raceArr[4] = other;

        for (int i = 0; i < raceArr.length; i++) {
            raceList.add((raceArr[i]));
        }
        return raceList;
    }
}
