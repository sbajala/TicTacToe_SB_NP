package controllers;

import Model.Board.Grid;
import interfaces.IGridListener;
import javax.swing.*;
public class JButtonPlus extends JButton implements IGridListener
{
    private final JButton button;
    public JButtonPlus(JButton button)
    {
        this.button = button;
    }


    @Override
    public void squareValueChanged(Grid.Square squareValue)
    {
        String text = Grid.parseValue(squareValue);
        button.setText(text);
    }
}


