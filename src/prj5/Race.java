package prj5;
// import java.text.DecimalFormat;

/**
 * 
 * @author Abby Searles
 * @version 2021.11.16
 *
 */
public class Race {

    // fields -------------------------------

    private String name;
    private int cases;
    private int deaths;
    private double cfr;

    // constructor --------------------------
    /**
     * constructor
     * 
     * @param raceName
     *            name of the race
     * @param raceCases
     *            amount of cases for that race
     * @param raceDeaths
     *            amount of deaths for that race
     * 
     */
    public Race(String raceName, int raceCases, int raceDeaths) {
        name = raceName;
        cases = raceCases;
        deaths = raceDeaths;
        if ((cases == -1) || (deaths == -1)) {
            cfr = -1.0;
        }
        else {
            // DecimalFormat tempFormatter = new DecimalFormat("0.0");
            cfr = ((double)raceDeaths / (double)raceCases) * 100;
        }

    }

    // methods -------------------------------


    /**
     * getter method for race name
     * 
     * @return String of name
     */
    public String getName() {
        return name;
    }


    /**
     * getter method for race cases
     * 
     * @return int no of cases
     */
    public int getCases() {
        return cases;
    }


    /**
     * getter method for race deaths
     * @return int no of deaths
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * getter method for cfr
     * 
     * @return double cfr percentage
     */
    public double getCFR() {
        return cfr;
    }


    /**
     * creates array of race name, cases, and deaths
     * 
     * @return Object[] array of array
     * 
     */
    public Object[] toArray() {

        Object[] array;
        array = (Object[])new Object[3];

        array[0] = name;
        array[1] = cases;
        array[2] = deaths;

        return array;

    }


    /**
     * creates string of race name, cases, and deaths
     * 
     * @return String of race name, cases, and deaths
     */
    public String toString() {

        StringBuilder builder = new StringBuilder("");
        builder.append("[");
        builder.append(this.getName());
        builder.append(", ");
        builder.append(this.getCases());
        builder.append(", ");
        builder.append(this.getDeaths());
        builder.append("]");

        return builder.toString();
    }


    /**
     * compares to races to see if they're the same
     * 
     * @param obj
     *            object to be compared
     * 
     * @return boolean true if two races are equal
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        else {
            if (this.getClass().equals(obj.getClass())) {
                Race object = (Race)obj;
                return (this.getName().equals(object.getName()) && this
                    .getCases() == object.getCases() && this
                        .getDeaths() == object.getDeaths());
            }
            return false;
        }
    }

}
