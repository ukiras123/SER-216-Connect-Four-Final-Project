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
	ConsolePlayer plyX, plyO;
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
		plyO = new ConsolePlayer("@");
		
		// Nothing 7x6
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
				 					 { null, plyO, null, null, null, null, null },
				 					 { null, plyX, null, null, null, plyO, null },
				 					 { plyO, plyX, null, null, null, plyX, null }};
		//condition 3
		ConsolePlayer[][] config3 = {{ null, null, null, plyX, null, null, null },
				 					 { null, null, null, plyO, null, null, null },
				 					 { null, null, null, plyX, null, null, null },
				 					 { null, null, null, plyO, null, null, null },
				 					 { null, null, null, plyX, null, null, null },
				 					 { null, null, null, plyO, null, null, null }};
		
		//----------Temp Tests, Created by Carlos-------//
		//testboard1 = new Board(config1);
		//game = new Game(new Player[] {plyX, plyO}, testboard1, 4);
	
		
		//testboard2 = new Board(config2);
		//game = new Game(new Player[] {plyX, plyO}, testboard2, 4);

		
		testboard3 = new Board(config3);
		game = new Game(new Player[] {plyX, plyO}, testboard3, 4);

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
