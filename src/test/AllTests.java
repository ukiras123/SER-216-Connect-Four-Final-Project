/**
 * @author SWD
 */
 
package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestBoard.class, BoardTest.class, TestConsolePlayer.class, TestGame.class })

public class AllTests {
}
