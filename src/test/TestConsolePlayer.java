package test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import connect.four.player.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Class;
import java.lang.reflect.Method;
import connect.four.board.*;

/**
*Test the consolePlayer
*/
public class TestConsolePlayer {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}//end setUpStreams
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}//end cleanUpStreams

	
	@Test
	public void testDumpBoard() {
		
		/**
		*Initialize the console players Scott and Greg 
		*/
		ConsolePlayer greg = new ConsolePlayer("greg the @ player");
		ConsolePlayer scott = new ConsolePlayer("scott the X player");
		Method dumpBoard = null;
		
		/**
		*String representation 1 of expected output
		*/
		String expectedOutput1 = "@ is you, X is the other player, and - is empty." + System.lineSeparator() +
					 "- - - - - - -" + System.lineSeparator() +
					 "- - - - - - -" + System.lineSeparator() +
					 "- - - - - - -" + System.lineSeparator() +
					 "- - - - - - -" + System.lineSeparator() +
					 "- - - - - - -" + System.lineSeparator() +
					 "- - - - - - -" + System.lineSeparator() +
					 "=============" + System.lineSeparator() +
					 "1 2 3 4 5 6 7" + System.lineSeparator();
		/**
		*String representation 2 of expected output
		*/
		String expectedOutput2 = "@ is you, X is the other player, and - is empty." + System.lineSeparator() +
					 "- - - - - - -" + System.lineSeparator() +
					 "- - - - - - -" + System.lineSeparator() +
					 "- - - - - - -" + System.lineSeparator() +
					 "- @ - - - - -" + System.lineSeparator() +
					 "- X - - - @ -" + System.lineSeparator() +
					 "@ X @ - - X -" + System.lineSeparator() +
					 "=============" + System.lineSeparator() +
					 "1 2 3 4 5 6 7" + System.lineSeparator();
		/**
		*String representation 3 of expected output
		*/
		String expectedOutput3 = "@ is you, X is the other player, and - is empty." + System.lineSeparator() +
					 "- - - X - - -" + System.lineSeparator() +
					 "- - - @ - - -" + System.lineSeparator() +
					 "- - - X - - -" + System.lineSeparator() +
					 "- - - @ - - -" + System.lineSeparator() +
					 "- - - X - - -" + System.lineSeparator() +
					 "- - - @ - - -" + System.lineSeparator() +
					 "=============" + System.lineSeparator() +
					 "1 2 3 4 5 6 7" + System.lineSeparator();
		/**
		*Setup board layout 1
		*/
		ConsolePlayer[][] board1Layout = {{ null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }};
		/**
		*Setup board layout 2
		*/
		ConsolePlayer[][] board2Layout = {{ greg, null, null, null, null, null }, 
						  { scott, scott, greg, null, null, null }, 
						  { greg, null, null, null, null, null }, 
						  { null, null, null, null, null, null },
						  { null, null, null, null, null, null }, 
						  { scott, greg, null, null, null, null }, 
						  { null, null, null, null, null, null }};
		/**
		*Setup board layout 3
		*/
		ConsolePlayer[][] board3Layout = {{ null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { greg, scott, greg, scott, greg, scott },
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }};
		
		/**
		*Create the three boad layouts
		*/
		Board board1 = new Board(board1Layout);
		Board board2 = new Board(board2Layout);
		Board board3 = new Board(board3Layout);
		
		/**
		*Grab dumpBoard function from ConsolePlayer so it can be tested.
		*/
		try{
			dumpBoard = ConsolePlayer.class.getDeclaredMethod("dumpBoard", new Class[] { ReadableBoard.class });
		}//end try
		
		catch(NoSuchMethodException e){
			fail("No such method exception thrown.");
		}//end catch NoSuchMethod
		
		catch(Exception e){
			fail("ERROR");
		}//end catch Exception
		
		/**
		*Make dumpBoard accessible
		*/
		dumpBoard.setAccessible(true);
		
		/**
		*Preform the tests.
		*/
		try{
			//Test 1 
			dumpBoard.invoke(greg, new Object[] { board1 });
			assertEquals(expectedOutput1, outContent.toString());
			outContent.reset();
			
			//Test 2 
			dumpBoard.invoke(greg, new Object[] { board2 });
			assertEquals(expectedOutput2, outContent.toString());
			outContent.reset();
			
			//Test 3 
			dumpBoard.invoke(greg, new Object[] { board3 });
			assertEquals(expectedOutput3, outContent.toString());
			outContent.reset();
		}//end try
		
		catch(Exception e){
			fail("ERROR");
		}//end catch
	}//end testDumpBoard

}//end TestConsolePlayer
