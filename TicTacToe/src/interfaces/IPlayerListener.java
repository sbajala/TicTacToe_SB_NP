package interfaces;

public interface IPlayerListener
{
    void scoreChanged(int score, boolean isPlayer1);
    void turnChanged(boolean isPlayer1Turn);

}
