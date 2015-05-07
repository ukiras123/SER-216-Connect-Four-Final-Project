package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import connect.four.Game;
import connect.four.board.Board;
import connect.four.player.ConsolePlayer;
import connect.four.player.Player;

/**
 * Tests the ConsolePlayer class' dumpBoard(ReadBoard board) class by creating three mock boards of various conditions.
 * @author carlos
 * @version 1.0
 */
public class ConsolePlayerTest {
	Board testboard1, testboard2, testboard3;
	ConsolePlayer symX, symO;
	Game game;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		symX = new ConsolePlayer("X");							/////-----Will Fix this shortly boards are 7x6-----///
		symO = new ConsolePlayer("O");
		
		//condition 1
		ConsolePlayer[][] config1 = {{ null, null, null, null, null, null, null },
									 { null, null, null, null, null, null, null },
									 { null, null, null, null, null, null, null },
									 { null, null, null, null, null, null, null },
									 { null, null, null, null, null, null, null },
									 { null, null, null, null, null, null, null }};
									
		//condition 2
		ConsolePlayer[][] config2  ={{ null, null, null, null, null, null, null },
				 					 { null, null, null, null, null, null, null },
				 					 { null, null, null, null, null, null, null },
				 					 { null, symO, null, null, null, null, null },
				 					 { null, symX, null, null, null, symO, null },
				 					 { symO, symX, null, null, null, symX, null }};
		//condition 3
		ConsolePlayer[][] config3 = {{ null, null, null, symX, null, null, null },
				 					 { null, null, null, symO, null, null, null },
				 					 { null, null, null, symX, null, null, null },
				 					 { null, null, null, symO, null, null, null },
				 					 { null, null, null, symX, null, null, null },
				 					 { null, null, null, symO, null, null, null }};
		
		//----------Temp Tests, Created by Carlos-------//
		//testboard1 = new Board(config1);
		//game = new Game(new Player[] {symX, symO}, testboard1, 4);
	
		
		//testboard2 = new Board(config2);
		//game = new Game(new Player[] {symX, symO}, testboard2, 4);

		
		testboard3 = new Board(config3);
		game = new Game(new Player[] {symX, symO}, testboard3, 4);

		game.start();		

	}

	@After
	public void tearDown() throws Exception {
	}

	//-----------------ConsolePlayer Constructor --------------------------//
	@Test
	public void testConsolePlayer() {
		
	}

	
	//-----------------ConsolePlayer Method that runs private dumpBoard(ReadableBoard Board) --------------------------//
	@Test
	public void testPerformPlay() {
		

	}

}