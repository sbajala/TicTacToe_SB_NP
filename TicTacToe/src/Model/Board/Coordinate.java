package Model.Board;

public class Coordinate
{
    private final int x;
    private final int y;

    public Coordinate(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public int getX(){return x;}
    public int getY(){return y;}

    public String toString(){return "x= " + Integer.toString(getX()) + ", y= " + Integer.toString(getY());}

}
