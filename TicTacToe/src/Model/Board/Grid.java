package Model.Board;

import interfaces.IGridListener;
import interfaces.IPlayerListener;
import java.util.ArrayList;
public class Grid
{
    private Coordinate coordinate;
    private Square value;
    private ArrayList<IGridListener> listeners;
    /*0=null, 1=player1, 2=player2*/
    public enum Square
    {
        EMPTY,
        X,
        O,
        NOTFOUND
    }

    public Grid(Model.Board.Coordinate coordinate, Square value)
    {
        listeners = new ArrayList<>();
        this.coordinate = coordinate;
        setValue(value);
    }

    public int getGridCoordinateX(){return coordinate.getX();}
    public int getGridCoordinateY(){return coordinate.getY();}
    public Square getValue(){return value;}

    public void setValue(Square value)
    {
        this.value=value;
        for (IGridListener listener : listeners)
            listener.squareValueChanged(value);
    }

    //listeners
    public void addListener(IGridListener listener){listeners.add(listener);}
    public void removeListener(IGridListener listener){listeners.remove(listener);}

    public static String parseValue(Square value)
    {
        switch (value)
        {
            case EMPTY: return "";
            case X: return "X";
            case O: return "O";
            default: return "ERROR!";
        }
    }
    public String toString(){return "Coordinate= ["+ coordinate.toString()+"], Value="+value.toString();}
}
