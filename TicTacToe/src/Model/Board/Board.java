package Model.Board;


import java.awt.event.ActionListener;
import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board
{

    private int boardSize;
    ArrayList<Model.Board.Grid> board;

    public Board(int boardSize)
    {
        setBoardSize(boardSize);
        initializeBoard();
    }

    public void initializeBoard()
    {
        board = new ArrayList<Grid>();
        for(int y=0; y<boardSize; y++)
        {
            for(int x=0; x<boardSize; x++)
            {
                Coordinate coordinate = new Coordinate(x,y);
                Grid grid = new Grid(coordinate, Grid.Square.EMPTY);
                //System.out.println(grid.toString());
                board.add(grid);
            }
        }
    }

    public void cleanBoard()
    {
        for(int y=0; y<boardSize; y++)
        {
            for(int x=0; x<boardSize; x++)
                setGridValue(new Coordinate(x,y), Grid.Square.EMPTY);
        }
    }


    public Grid.Square getGridValue(Coordinate gridCoordinate)
    {
        for(int i=0; i<board.size(); i++)
        {
            boolean sameCoordinateX = board.get(i).getGridCoordinateX() == gridCoordinate.getX();
            boolean sameCoordinateY = board.get(i).getGridCoordinateY() == gridCoordinate.getY();

            if (sameCoordinateX && sameCoordinateY)
                return board.get(i).getValue();
        }
        return Grid.Square.NOTFOUND;
    }

    public void setGridValue(Coordinate coordinateToSetValue, Grid.Square value)
    {
        for(int i=0; i<board.size(); i++) {
            boolean sameCoordinateX = board.get(i).getGridCoordinateX() == coordinateToSetValue.getX();
            boolean sameCoordinateY = board.get(i).getGridCoordinateY() == coordinateToSetValue.getY();

            if (sameCoordinateX && sameCoordinateY)
                board.get(i).setValue(value);
        }
    }

    public String toString()
    {
        String text = "";
        for (int i=0; i<board.size(); i++)
        {
            text += board.get(i).toString() + "\n";
        }
        return text;
    }


    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    //WIN CONDITIONS -----------------------------------------------------------------------------
    public boolean isVictory(Grid.Square squareValue)
    {
        return isRowVictory(squareValue) || isColumnVictory(squareValue) || isDiagonalVictory(squareValue);
    }



    private boolean isRowVictory(Grid.Square squareValue)
    {
        for (int y=0; y<boardSize; y++)
        {
            //1.new ArrayList to store the square values in a row (in x).
            ArrayList<Grid.Square> squareValues = new ArrayList<>();

            for(int x=0; x<boardSize; x++)
            {
                if(getGridValue(new Coordinate(x,y))==squareValue)
                    squareValues.add(squareValue);

                if(squareValues.size()==boardSize)
                    return true;
            }
        }

        return false;
    }

    private boolean isColumnVictory(Grid.Square squareValue)
    {
        for(int x=0; x<boardSize; x++)
        {
            ArrayList<Grid.Square>squareValues = new ArrayList<>();
            for(int y=0; y<boardSize; y++)
            {
                if(getGridValue(new Coordinate(x,y)) == squareValue)
                    squareValues.add(squareValue);

                if(squareValues.size()==boardSize)
                    return true;
            }
        }
        return false;
    }

    private boolean isDiagonalVictory(Grid.Square squareValue)
    {
        return isTopLeftDiagonalVictory(squareValue) || isBottomLeftDiagonalVictory(squareValue);
    }


    private boolean isTopLeftDiagonalVictory(Grid.Square squareValue)
    {
        //0,0 && 1,1 && 2,2
        ArrayList<Grid.Square> squareValues = new ArrayList<>();
        for(int i=0; i<boardSize; i++)
        {
            if(getGridValue(new Coordinate(i,i))==squareValue) {
                squareValues.add(squareValue);
            }
        }
        return squareValues.size() == boardSize;
    }

    private boolean isBottomLeftDiagonalVictory(Grid.Square squareValue)
    {
        //0,3 && 1,2 && 2,1 && 3,0
        ArrayList<Grid.Square> squareValues = new ArrayList<>();
        int x=0, y=boardSize-1;
        do
        {
            if(getGridValue(new Coordinate(x,y)) == squareValue)
                squareValues.add(squareValue);
            x++;
            y--;
        }while(x!=boardSize);
        return squareValues.size()==boardSize;
    }

    public Grid getGrid(int index){return board.get(index);}
    public int getBoardArraySize(){return board.size();}

}
