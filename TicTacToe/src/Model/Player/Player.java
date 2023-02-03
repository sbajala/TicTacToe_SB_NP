package Model.Player;

import Model.Board.Board;
import Model.Board.Coordinate;
import Model.Board.Grid;
import interfaces.IPlayerListener;

import java.util.ArrayList;

abstract public class Player
{
    private ArrayList<IPlayerListener>listeners;
    protected boolean turn;
    protected int score;
    protected Board board;

    public Player(boolean turn, Board board)
    {
        listeners = new ArrayList<>();
        this.turn = turn;
        this.board = board;
    }

    public void setTurn(boolean turn, boolean isPlayer1)
    {
        this.turn=turn;
        for (IPlayerListener listener : listeners)
            listener.turnChanged(isPlayer1);
    }
    public void setScore(int score, boolean isPlayer1)
    {
        this.score=score;
        for (IPlayerListener listener : listeners)
            listener.scoreChanged(score,isPlayer1);
    }

    public boolean isPlaying(){return turn;}
    public int getScore(){return score;}

    public abstract void playerMove(Coordinate coordinate);

    public void addListener(IPlayerListener listener)
    {
        try
        {
            listeners.add(listener);
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }
    }

    public void removeListener(IPlayerListener listener)
    {
        listeners.remove(listener);
    }

}
