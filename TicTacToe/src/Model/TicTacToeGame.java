package Model;

import Model.Board.Board;
import Model.Player.Player1;
import Model.Player.Player2;

public class TicTacToeGame
{
    private Player1 player1;
    private Player2 player2;

    private Board board;

    public TicTacToeGame(int boardSize)
    {
        board = new Board(boardSize);
        player1 = new Player1(true,board);
        player1.setScore(0,true);
        player2 = new Player2(false,board);
        player2.setScore(0,false);
    }

    public Player1 getPlayer1(){return player1;}
    public Player2 getPlayer2(){return player2;}
    public Board getBoard(){return board;}
    public void setBoard(Board board) {
        this.board = board;
    }

}
