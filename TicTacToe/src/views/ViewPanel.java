package views;


import javax.swing.*;

public class ViewPanel extends JPanel {

    private final ScorePanel scorePanel;
    private BoardPanel boardPanel;
    private final OptionPanel optionPanel;

    public ViewPanel() {
        scorePanel = new ScorePanel();
        boardPanel = new BoardPanel();
        optionPanel = new OptionPanel();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(scorePanel);
        add(boardPanel);
        add(optionPanel);
    }

    public ScorePanel getScorePanel() {
        return scorePanel;
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public OptionPanel getOptionPanel() {
        return optionPanel;
    }


}
