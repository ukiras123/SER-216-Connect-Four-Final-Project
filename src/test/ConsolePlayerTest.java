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

public class ConsolePlayerTest {
	Board testboard1, testboard2, testboard3;
	ConsolePlayer plyX;
	ConsolePlayer plyO;
	
	Game game;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		plyX = new ConsolePlayer("X");						
		ply@ = new ConsolePlayer("@");
		
		// Nothing 7x6
		ConsolePlayer[][] layout1 = {{ null, null, null, null, null, null },
									 { null, null, null, null, null, null },
									 { null, null, null, null, null, null },
									 { null, null, null, null, null, null },
									 { null, null, null, null, null, null },
									 { null, null, null, null, null, null },
									 { null, null, null, null, null, null }};
									
		//condition 2
		ConsolePlayer[][] layout2  ={{ null, null, null, null, null, null },
									 { null, null, null, null, null, null },
				 					 { null, null, null, null, null, null },
				 					 { null, null, null, null, null, null },
				 					 { null, plyO, null, null, null, null },
				 					 { null, plyX, null, null, null, plyO },
				 					 { plyO, plyX, null, null, null, plyX }};
		//condition 3
		ConsolePlayer[][] layout3 = {{ null, null, null, plyX, null, null },
									 { null, null, null, null, null, null },
				 					 { null, null, null, plyO, null, null },
				 					 { null, null, null, plyX, null, null },
				 					 { null, null, null, plyO, null, null },
				 					 { null, null, null, plyX, null, null },
				 					 { null, null, null, plyO, null, null }};
		
		testboard1 = new Board(layout1);
		game = new Game(new Player[] {plyX, plyO}, testboard1, 4);
		
		testboard2 = new Board(layout2);
		game = new Game(new Player[] {plyX, plyO}, testboard2, 4);

		
		testboard3 = new Board(layout3);
		game = new Game(new Player[] {plyX, plyO}, testboard3, 4);

		game.start();		

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConsolePlayer() {
		
	}
	
	//-----------------ConsolePlayer Method that runs private dumpBoard(ReadableBoard Board) --------------------------//
	@Test
	public void testPerformPlay() {
		

	}

}
