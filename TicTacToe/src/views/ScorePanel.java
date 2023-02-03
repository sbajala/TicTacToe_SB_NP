package views;

import interfaces.IPlayerListener;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel implements IPlayerListener {

    private final JLabel player1Label;
    private final JLabel player2Label;
    private JLabel player1Score;
    private JLabel player2Score;
    private JLabel message;
    private Boolean win;

    public ScorePanel() {
        win = false;

        player1Label = new JLabel("Player X: ");
        player1Label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        player1Score = new JLabel("Score");
        player1Score.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        JPanel player1Section = new JPanel();
        player1Section.setLayout(new FlowLayout(FlowLayout.CENTER));
        player1Section.add(player1Label);
        player1Section.add(player1Score);

        player2Label = new JLabel("Player O: ");
        player2Label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        player2Score = new JLabel("Score");
        player2Score.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        JPanel player2Section = new JPanel();
        player2Section.setLayout(new FlowLayout((FlowLayout.CENTER)));
        player2Section.add(player2Label);
        player2Section.add(player2Score);

        message = new JLabel("Player X starts");
        message.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));

        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(1,4));
        scorePanel.add(player1Section);
        scorePanel.add(Box.createRigidArea(new Dimension(50,10)));
        scorePanel.add(player2Section);

        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        messagePanel.add(Box.createRigidArea(new Dimension(10,20)));
        messagePanel.add(message);

        JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new GridLayout(2,0));
        combinedPanel.add(scorePanel);
        combinedPanel.add(messagePanel);

        add(combinedPanel);
    }

    public void setPlayer1Score(int score) {
        player1Score.setText(Integer.toString(score));
    }

    public void setPlayer2Score(int score) {
        player2Score.setText(Integer.toString(score));
    }

    public void setMessage(String message) {
        (this.message).setText(message);
    }

    @Override
    public void scoreChanged(int score, boolean isPlayer1)
    {
        if(isPlayer1)
        {
            setPlayer1Score(score);
            setMessage("PLAYER X WON!");

        }
        else
        {
            setPlayer2Score(score);
            setMessage("PLAYER O WON!");
        }
    }

    @Override
    public void turnChanged(boolean isPlayer1Turn) {

           if (isPlayer1Turn) {
               if (!win) {
                   setMessage("Player X turn");
               }
           }


           if (!isPlayer1Turn) {
               if (!win) {
                   setMessage("Player O turn");
               }
           }
    }

    public void setWin(boolean win) {
        this.win = win;
    }

}




