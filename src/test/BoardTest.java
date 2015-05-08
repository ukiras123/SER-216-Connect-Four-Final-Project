package test;

import connect.four.board.Board;
import connect.four.board.ColumnFullException;
import connect.four.board.ReadableBoard;
import connect.four.player.ComputerPlayer;
import connect.four.player.ConsolePlayer;
import connect.four.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private static Board board;
    private static ConsolePlayer console;
    private static ComputerPlayer computer;

    @Before
    public void initialiseTest() {
        //Create a new Board
        board = new Board(new ReadableBoard() {
            @Override
            public Player whoPlayed(int x, int y) {
                return null;
            }

            @Override
            public int getWidth() {
                return 7;
            }

            @Override
            public int getHeight() {
                return 6;
            }

            @Override
            public int getColumnHeight(int x) {
                return 0;
            }

            @Override
            public int getMoveCount() {
                return 0;
            }
        });

        //Create two new Players to populate the board
        console = createConsolePlayer();
        computer = createComputerPlayer();
    }

    @Test
    public void testPlay() {
        //First case x=0
        board.play(0, console);
        Assert.assertEquals("First slot in first column must be filled", console, board.whoPlayed(0, 0));
        Assert.assertEquals("Only one move should be registered to the board", 1, board.getMoveCount());

        //second case x=1
        board.clear();
        board.play(0, console);
        board.play(1, computer);
        board.play(1, computer);
        board.play(2, console);
        board.play(5, computer);
        board.play(5, console);

        board.play(1, console); //The changing play
        Assert.assertEquals("Changing play must be filled", console, board.whoPlayed(1, 2));
        Assert.assertEquals("Only 7 moves should be registered to the board", 7, board.getMoveCount());

        
    }
    //Third case in testFailedPlay()
    @Test(expected = ColumnFullException.class)
    public void testFailedPlay() {
        //Third case x=3
        board.play(3, console);
        board.play(3, computer);
        board.play(3, console);
        board.play(3, computer);
        board.play(3, console);
        board.play(3, computer);

        board.play(3, console); //The column should be full right here
    }

    @Test
    public void testGetColumnHeight() {
        
        //Zero case x=0
        board.play(0, computer);
        board.play(1, console);
        board.play(1, console);
        board.play(1, console);
        board.play(2, computer);
        board.play(2, console);
        Assert.assertEquals("Height of column 0 should be 1", 1, board.getColumnHeight(0));
        
        //First case x=1
        board.play(0, computer);
        board.play(1, console);
        board.play(1, console);
        board.play(1, console);
        board.play(2, computer);
        board.play(2, console);
        Assert.assertEquals("Height of column 1 should be 3", 3, board.getColumnHeight(1));

        //Second case x=2
        board.clear();
        board.play(0, computer);
        board.play(1, console);
        board.play(1, console);
        board.play(1, console);
        board.play(2, computer);
        board.play(2, console);
        Assert.assertEquals("Height of column 2 should be 2", 2, board.getColumnHeight(2));

        //Third case x=3
        board.clear();
        board.play(0, computer);
        board.play(1, console);
        board.play(1, console);
        board.play(1, console);
        board.play(2, computer);
        board.play(2, console);
        Assert.assertEquals("Height of column 3 should be 0", 0, board.getColumnHeight(3));

        //Fourth case x=4
        board.clear();
        board.play(0, computer);
        board.play(1, console);
        board.play(1, console);
        board.play(1, console);
        board.play(4, computer);
        board.play(4, console);
        Assert.assertEquals("Height of column 4 should be 2", 2, board.getColumnHeight(4));

        //Fifth case x=5
        board.clear();
        Assert.assertEquals("Height of column 5 should be 0", 0, board.getColumnHeight(5));

        //Sixth case x=6
        board.clear();
        board.play(0, computer);
        board.play(1, console);
        board.play(1, computer);
        board.play(3, computer);
        board.play(3, computer);
        board.play(3, computer);
        board.play(3, console);
        board.play(3, computer);
        board.play(3, console);
        board.play(5, console);
        board.play(6, console);
        board.play(6, computer);
        Assert.assertEquals("Height of column 6 should be 2", 2, board.getColumnHeight(6));
    }

    @Test
    public void testClear() {
        //First case
        board.play(0, console);
        board.clear();
        Assert.assertEquals("Board must be empty", 0, board.getMoveCount());

        //second case
        console = createConsolePlayer();
        board.play(0, computer);
        board.play(1, console);
        board.play(1, computer);
        board.play(4, console);
        board.play(4, computer);
        board.play(6, console);
        board.play(5, computer);
        board.play(6, console);
        board.play(4, console);
        board.play(2, computer);
        board.play(1, console);
        board.clear();
        Assert.assertEquals("Board must be empty", 0, board.getMoveCount());

        //Third case
        console = createConsolePlayer();
        computer = createComputerPlayer();
        board.clear();
        Assert.assertEquals("Board must be empty", 0, board.getMoveCount());
    }

    private ConsolePlayer createConsolePlayer() {
        return new ConsolePlayer("HumanPlayer");
    }

    private ComputerPlayer createComputerPlayer() {
        return new ComputerPlayer();
    }
}
