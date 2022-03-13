package prj5;

import student.TestCase;

/**
 * 
 * @author Abby Searles
 * @version 2021.11.16
 *
 */
public class StateDataExceptionTest extends TestCase {

    /**
     * tests StateDataException
     * 
     * @throws StateDataException
     */
    public void testException() throws StateDataException {

        // StateData exception

        Exception e = null;
        try {
            throw new StateDataException("");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertNotNull(e);

    }

}
