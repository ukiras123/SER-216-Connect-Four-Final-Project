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

public class TestConsolePlayer {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}

	
	@Test
	public void testDumpBoard() {
		
		//Instantiate the console players, and create a method variable for dumpBoard():
		ConsolePlayer greg = new ConsolePlayer("greg the @ player");
		ConsolePlayer scott = new ConsolePlayer("scott the X player");
		Method dumpBoard = null;
		
		//Setup the strings representing the expected output:
		String expectedOutput1 = "@ is you, X is the other player, and - is empty." + System.lineSeparator() +
								 "-------" + System.lineSeparator() +
								 "-------" + System.lineSeparator() +
								 "-------" + System.lineSeparator() +
								 "-------" + System.lineSeparator() +
								 "-------" + System.lineSeparator() +
								 "-------" + System.lineSeparator() +
								 "1234567" + System.lineSeparator();
		
		String expectedOutput2 = "@ is you, X is the other player, and - is empty." + System.lineSeparator() +
								 "-------" + System.lineSeparator() +
								 "-------" + System.lineSeparator() +
								 "-------" + System.lineSeparator() +
								 "-@-----" + System.lineSeparator() +
								 "-X---@-" + System.lineSeparator() +
								 "@X@--X-" + System.lineSeparator() +
								 "1234567" + System.lineSeparator();
		
		String expectedOutput3 = "@ is you, X is the other player, and - is empty." + System.lineSeparator() +
								 "---X---" + System.lineSeparator() +
								 "---@---" + System.lineSeparator() +
								 "---X---" + System.lineSeparator() +
								 "---@---" + System.lineSeparator() +
								 "---X---" + System.lineSeparator() +
								 "---@---" + System.lineSeparator() +
								 "1234567" + System.lineSeparator();
		
		//Setup the three board configurations:
		ConsolePlayer[][] board1Config = {{ null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
									          { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }};
		
		ConsolePlayer[][] board2Config = {{ greg, null, null, null, null, null }, 
										  { scott, scott, greg, null, null, null }, 
										  { greg, null, null, null, null, null }, 
										  { null, null, null, null, null, null },
										  { null, null, null, null, null, null }, 
										  { scott, greg, null, null, null, null }, 
										  { null, null, null, null, null, null }};
		
		ConsolePlayer[][] board3Config = {{ null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { greg, scott, greg, scott, greg, scott },
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }};
		
		//Create the boards with the three board configurations
		Board board1 = new Board(board1Config);
		Board board2 = new Board(board2Config);
		Board board3 = new Board(board3Config);
		
		//Get the private method dumpBoard out of class ConsolePlayer so we can test it:
		try{
			dumpBoard = ConsolePlayer.class.getDeclaredMethod("dumpBoard", new Class[] { ReadableBoard.class });
		}
		catch(NoSuchMethodException e){
			fail("No such method exception thrown.");
		}
		catch(Exception e){
			fail("ERROR");
		}
		
		//dumpBoard is private, make it so we can access it
		dumpBoard.setAccessible(true);
		
		//Perform the tests:
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
		}
		catch(Exception e){
			fail("ERROR");
		}
	}

}
