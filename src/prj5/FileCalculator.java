/**
 * 
 */
package prj5;

/**
 * @author Abishek Satnur
 * @version 2021.11.18
 *
 */
public class FileCalculator {
    private SLList<State> states;

    /**
     * Constructor class for FileCalculator
     * 
     * @param tempStateList
     *            a linked list of state objects
     */
    public FileCalculator(SLList<State> tempStateList) {
        states = tempStateList;
    }


    /**
     * Sorts a linked list of state objects and 
     * 
     * @throws StateDataException
     *             when states is empty
     */
    public void sortByAlpha(SLList<State> tempStateList) {
        
        for (int i = 0; i < tempStateList.getLength(); i++) {
            SLList<Race> sortedList = tempStateList.getEntry(i).toSLList();
            sortedList.insertionSort(new CompareAlpha());
            tempStateList.getEntry(i).setAlpha(sortedList);
            System.out.println(tempStateList.getEntry(i).getAlphaRaces()); 
        }
    }


    /**
     * 
     * @param state
     *            The state object to be sorted
     * @return String of information sorted via CFR
     */
    public void sortByCFR(SLList<State> tempStateList) {   
        for (int i = 0; i < tempStateList.getLength(); i++) {
            SLList<Race> sortedList = tempStateList.getEntry(i).toSLList();
            sortedList.insertionSort(new CompareCFR());
            tempStateList.getEntry(i).setCFR(sortedList); 
            System.out.println(tempStateList.getEntry(i).getCfrRaces());
        }       
    }

}
