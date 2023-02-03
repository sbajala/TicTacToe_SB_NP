package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BoardPanel extends JPanel {

    private final JButton button1;
    private final JButton button2;
    private final JButton button3;
    private final JButton button4;
    private final JButton button5;
    private final JButton button6;
    private final JButton button7;
    private final JButton button8;
    private final JButton button9;
    private final JButton button10;
    private final JButton button11;
    private final JButton button12;
    private final JButton button13;
    private final JButton button14;
    private final JButton button15;
    private final JButton button16;
    private final JButton button17;
    private final JButton button18;
    private final JButton button19;
    private final JButton button20;
    private final JButton button21;
    private final JButton button22;
    private final JButton button23;
    private final JButton button24;
    private final JButton button25;
    public ArrayList<JButton> buttons;
    private JPanel board;
    private int boardSize;

    public BoardPanel() {
        button1 = new JButton("1");   button2 = new JButton("2");
        button3 = new JButton("3");   button4 = new JButton("4");
        button5 = new JButton("5");   button6 = new JButton("6");
        button7 = new JButton("7");   button8 = new JButton("8");
        button9 = new JButton("9");   button10 = new JButton("10");
        button11 = new JButton("11"); button12 = new JButton("12");
        button13 = new JButton("13"); button14 = new JButton("14");
        button15 = new JButton("15"); button16 = new JButton("16");
        button17 = new JButton("17"); button18 = new JButton("18");
        button19 = new JButton("19"); button20 = new JButton("20");
        button21 = new JButton("21"); button22 = new JButton("22");
        button23 = new JButton("23"); button24 = new JButton("24");
        button25 = new JButton("25");
        initializeButtonsArrayList();
        initializeButtonsLayout();
        setBoardSize();
    }

    private void initializeButtonsArrayList() {
        buttons = new ArrayList<>();
        buttons.add(button1);  buttons.add(button2);
        buttons.add(button3);  buttons.add(button4);
        buttons.add(button5);  buttons.add(button6);
        buttons.add(button7);  buttons.add(button8);
        buttons.add(button9);  buttons.add(button10);
        buttons.add(button11); buttons.add(button12);
        buttons.add(button13); buttons.add(button14);
        buttons.add(button15); buttons.add(button16);
        buttons.add(button17); buttons.add(button18);
        buttons.add(button19); buttons.add(button20);
        buttons.add(button21); buttons.add(button22);
        buttons.add(button23); buttons.add(button24);
        buttons.add(button25);
    }

    private void initializeButtonsLayout() {
        for (JButton button : buttons){
            button.setOpaque(true);
            button.setBackground(Color.white);
        }
    }

    public int setBoardSize() {
        Object[] options = {"3 x 3", "4 x 4 ", "5 x 5"};
        int selection = JOptionPane.showOptionDialog(null,"Select a board size", "Tic Tac Toe",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, options, null);
        switch(selection) {
            case (JOptionPane.YES_OPTION):
                boardSize = 3;
                board = createBoard3Times3();
                add(board);
                break;
            case(JOptionPane.NO_OPTION):
                boardSize = 4;
                board = createBoard4Times4();
                add(board);
                break;
            case(JOptionPane.CANCEL_OPTION):
                boardSize = 5;
                board = createBoard5Times5();
                board.setPreferredSize(new Dimension(500, 500));
                add(board);
                break;
            default:
                System.exit(0);
                break;
        }
        return boardSize;
    }

    public int getBoardSize(){
        return boardSize;
    }

    public JPanel createBoard3Times3() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));
        panel.setPreferredSize(new Dimension(350,350));

        for (int i = 0; i < 9; i++) {
            panel.add(buttons.get(i));
            buttons.get(i).setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        }
        return panel;
    }

    public JPanel createBoard4Times4() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));
        panel.setPreferredSize(new Dimension(400,400));

        for (int i = 0; i < 16; i++) {
            panel.add(buttons.get(i));
            buttons.get(i).setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
        }
        return panel;
    }

    public JPanel createBoard5Times5() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,5));
        panel.setPreferredSize(new Dimension(420,420));

        for (int i = 0; i < 25; i++) {
            panel.add(buttons.get(i));
            buttons.get(i).setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
        }
        return panel;
    }


    //listeners
    public void addButton1Listener(ActionListener listener) {
        button1.addActionListener(listener);
    }
    public void addButton2Listener(ActionListener listener) {
        button2.addActionListener(listener);
    }
    public void addButton3Listener(ActionListener listener) {
        button3.addActionListener(listener);
    }
    public void addButton4Listener(ActionListener listener) {
        button4.addActionListener(listener);
    }
    public void addButton5Listener(ActionListener listener) {
        button5.addActionListener(listener);
    }
    public void addButton6Listener(ActionListener listener) {
        button6.addActionListener(listener);
    }
    public void addButton7Listener(ActionListener listener) {
        button7.addActionListener(listener);
    }
    public void addButton8Listener(ActionListener listener) {
        button8.addActionListener(listener);
    }
    public void addButton9Listener(ActionListener listener) {
        button9.addActionListener(listener);
    }
    public void addButton10Listener(ActionListener listener){
        button10.addActionListener(listener);
    }
    public void addButton11Listener(ActionListener listener){
        button11.addActionListener(listener);
    }
    public void addButton12Listener(ActionListener listener){
        button12.addActionListener(listener);
    }
    public void addButton13Listener(ActionListener listener){
        button13.addActionListener(listener);
    }
    public void addButton14Listener(ActionListener listener){
        button14.addActionListener(listener);
    }
    public void addButton15Listener(ActionListener listener){
        button15.addActionListener(listener);
    }
    public void addButton16Listener(ActionListener listener){
        button16.addActionListener(listener);
    }
    public void addButton17Listener(ActionListener listener){
        button17.addActionListener(listener);
    }
    public void addButton18Listener(ActionListener listener){
        button18.addActionListener(listener);
    }
    public void addButton19Listener(ActionListener listener){
        button19.addActionListener(listener);
    }
    public void addButton20Listener(ActionListener listener){
        button20.addActionListener(listener);
    }
    public void addButton21Listener(ActionListener listener){
        button21.addActionListener(listener);
    }
    public void addButton22Listener(ActionListener listener){
        button22.addActionListener(listener);
    }
    public void addButton23Listener(ActionListener listener){
        button23.addActionListener(listener);
    }
    public void addButton24Listener(ActionListener listener){
        button24.addActionListener(listener);
    }
    public void addButton25Listener(ActionListener listener){
        button25.addActionListener(listener);}


    public JButton getJButton(int index) {
        return buttons.get(index);
    }

    public void freezeButtons(){
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }

    public void unfreezeButtons() {
        for (JButton button : buttons) {
            button.setEnabled(true);
        }
    }
}
