package Model.Player;

import Model.Board.Board;
import Model.Board.Coordinate;
import Model.Board.Grid;
import interfaces.IPlayerListener;

public class Player1 extends Player
{
    public Player1(boolean turn, Board board)
    {
        super(turn, board);
    }

    @Override
    public void playerMove(Coordinate coordinate)
    {
        board.setGridValue(coordinate, Grid.Square.X);
    }
}
