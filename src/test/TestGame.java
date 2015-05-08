package test;

import static org.junit.Assert.*;

import org.junit.Test;

import connect.four.Game;
import connect.four.board.*;
import connect.four.player.*;

public class TestGame {

	@Test
	public void testDetectWinner() {
		
		//Variable that controls how many game chips must be in a line to win
		int inRow = 4;
		
		//Instantiate the console players:
		ConsolePlayer plyX = new ConsolePlayer("X");
		ConsolePlayer plyO = new ConsolePlayer("@");
		
		//Setup the six board configurations:
		//Diagonal Win plyO
		ConsolePlayer[][] board1Config = {{ plyO, null, null, null, null, null }, 
										  { plyO, plyO, plyO, null, null, null }, 
										  { plyX, plyX, plyO, null, null, null }, 
										  { plyO, plyX, plyO, plyO, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }};
		//Horizontal win plyO
		ConsolePlayer[][] board2Config = {{ plyO, null, null, null, null, null }, 
										  { plyO, plyX, plyO, null, null, null }, 
										  { plyO, plyX, plyX, null, null, null }, 
										  { plyO, plyX, plyO, plyX, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }};
		//Diagonal win plyO
		ConsolePlayer[][] board3Config = {{ plyX, plyX, plyX, plyO, null, null }, 
										  { plyX, plyX, plyO, null, null, null }, 
										  { plyX, plyO, plyO, null, null, null }, 
										  { plyO, plyX, plyO, plyO, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }};
		//Vertical win plyX
		ConsolePlayer[][] board4Config = {{ plyX, plyX, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { plyX, plyO, plyO, plyO, null, null }, 
										  { plyX, plyX, plyX, plyX, null, null }, 
										  { plyO, plyO, null, null, null, null }, 
										  { plyO, null, null, null, null, null }};
		//No winner
		ConsolePlayer[][] board5Config = {{ plyX, plyX, null, null, null, null }, 
										  { plyX, plyX, plyX, null, null, null }, 
										  { plyO, plyX, plyO, plyX, null, null }, 
										  { plyX, plyO, null, null, null, null }, 
										  { plyX, plyO, plyX, plyO, plyO, plyX }, 
										  { plyO, plyO, plyX, null, null, null }, 
										  { plyO, plyX, plyO, plyO, plyO, plyX }};
		//No winner
		ConsolePlayer[][] board6Config = {{ null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }, 
										  { null, null, null, null, null, null }};

		
		Board board1 = new Board(board1Config);
		Board board2 = new Board(board2Config);
		Board board3 = new Board(board3Config);
		Board board4 = new Board(board4Config);
		Board board5 = new Board(board5Config);
		Board board6 = new Board(board6Config);
		
		//Test boards with winners:
		assertEquals(plyO, Game.detectWinner(board1, inRow));
		assertEquals(plyO, Game.detectWinner(board2, inRow));
		assertEquals(plyO, Game.detectWinner(board3, inRow));
		assertEquals(plyX, Game.detectWinner(board4, inRow));
		
		//Test boards with no winners:
		assertNull(Game.detectWinner(board5, inRow));
		assertNull(Game.detectWinner(board6, inRow));
	}

}
