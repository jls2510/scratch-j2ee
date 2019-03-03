/**
 * 
 */
package test.gamestuff;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import main.gamestuff.GameNumber;

/**
 * @author jls
 *
 */
public class TestGameNumber
{

    /**
     * Test method for {@link main.gamestuff.GameNumber#GameNumber()}.
     */
    @Test
    public void testGameNumber()
    {
        GameNumber gameNumber = new GameNumber();
        int actual = gameNumber.getValue();
        int expected = 0;
        assertEquals(expected, actual);
    }

    /**
     * Test method for {@link main.gamestuff.GameNumber#GameNumber(int)}.
     */
    @Test
    public void testGameNumberInt()
    {
        GameNumber gameNumber = new GameNumber(23);
        int actual = gameNumber.getValue();
        int expected = 23;
        assertEquals(expected, actual);
    }

    /**
     * Test method for {@link main.gamestuff.GameNumber#setRandom(int, int)}.
     */
    @Test
    public void testSetRandom()
    {
        GameNumber gameNumber = new GameNumber();
        gameNumber.setRandom(0, 1000);
        int actual = gameNumber.getValue();
        assertTrue(actual >= 0 && actual <= 1000);
    }

    /**
     * Test method for {@link main.gamestuff.GameNumber#increment()}.
     */
    @Test
    public void testIncrement()
    {
        GameNumber gameNumber = new GameNumber(23);
        gameNumber.increment();
        int actual = gameNumber.getValue();
        int expected = 24;
        assertEquals(expected, actual);
    }

    /**
     * Test method for {@link main.gamestuff.GameNumber#setValue(int)}.
     */
    @Test
    public void testSetValue()
    {
        GameNumber gameNumber = new GameNumber();
        gameNumber.setValue(23);
        int actual = gameNumber.getValue();
        int expected = 23;
        assertEquals(expected, actual);
    }

    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(TestGameNumber.class);
        
        int numberOfTests = result.getRunCount();
        int numberOfFailures = result.getFailureCount();
        
        System.out.println("Ran " + numberOfTests + " tests with " + numberOfFailures + " failure(s).");

        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }

    }

}
