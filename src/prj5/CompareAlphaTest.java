/**
 * 
 */
package prj5;

/**
 * @author Abishek Satnur
 * @version 2021.11.04
 *
 */
public class CompareAlphaTest extends student.TestCase{
    Race race1; 
    Race race2;
    CompareAlpha comp; 
    
    public void setUp() {
        race1 = new Race("Alabama", 2, 6);                 
        race2 = new Race("Virginia", 3, 8);
        comp = new CompareAlpha();
    }
    
    public void testCompare1() {
        assertEquals(-1, comp.compare(race1, race2));        
    }
    
    public void testCompare2() {
        assertEquals(1, comp.compare(race2, race1));        
    }
    
    public void testCompare3() {
        assertEquals(0, comp.compare(race1, race1));        
    }

}
