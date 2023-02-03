package interfaces;
import Model.Board.Grid;
public interface IGridListener
{
    //X,O,NOTFOUND, EMPTY
    void squareValueChanged(Grid.Square squareValue);
}