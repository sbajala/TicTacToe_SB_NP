package Model.Player;

import Model.Board.Board;
import Model.Board.Coordinate;
import Model.Board.Grid;

public class Player2 extends Model.Player.Player
{
    public Player2(boolean turn, Board board)
    {
        super(turn, board);
    }

    @Override
    public void playerMove(Coordinate coordinate)
    {
        board.setGridValue(coordinate, Grid.Square.O);
    }
}