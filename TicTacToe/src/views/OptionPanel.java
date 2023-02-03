package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OptionPanel extends JPanel {
    private final JButton playAgain;
    private final JButton changeBoardSize;
    public OptionPanel(){

        changeBoardSize = new JButton("Change Board Size");
        playAgain = new JButton("Play Again");
        playAgain.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        bottomPanel.add(Box.createRigidArea(new Dimension (bottomPanel.getWidth(), 15)));
        bottomPanel.add(changeBoardSize);
        bottomPanel.add(Box.createRigidArea(new Dimension (40,10)));
        bottomPanel.add(playAgain);

        add(bottomPanel);
    }
    public void addPlayAgainListener(ActionListener listener) {
        playAgain.addActionListener(listener);
    }

    public void addChangeBoardSizeListener(ActionListener listener) {
        changeBoardSize.addActionListener(listener);
    }

}

