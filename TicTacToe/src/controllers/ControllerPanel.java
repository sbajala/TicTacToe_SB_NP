package controllers;

import Model.Board.Coordinate;
import Model.Board.Grid;
import Model.TicTacToeGame;
import views.*;
import views.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ControllerPanel {
    private final ViewPanel viewPanel;
    private final BoardPanel boardPanel;
    private final ScorePanel scorePanel;
    private final OptionPanel optionPanel;
    private TicTacToeGame model;
    private final Window window;
    private Coordinate coordinate;

    public ControllerPanel(ViewPanel view, TicTacToeGame model, Window window) {
        this.viewPanel = view;
        scorePanel = view.getScorePanel();
        boardPanel = view.getBoardPanel();
        optionPanel = view.getOptionPanel();
        this.model = model;
        this.window = window;

        initializeViewPanel();
        addButtonListeners();
        makeBondGridButton();

        coordinate = new Coordinate(-1,-1);
    }

    //NEW COURSE: EACH GRID IN THE BOARD ARRAY LIST// LISTENER: EACH BUTTON IN THE BUTTONARRAYLIST (1 to 1)
    private void makeBondGridButton() {
        for (int i = 0; i <model.getBoard().getBoardArraySize(); i++){
             Grid currentGrid = model.getBoard().getGrid(i);
             JButton currentButton = boardPanel.getJButton(i);

             JButtonPlus buttonPlus = new JButtonPlus(currentButton);
             currentGrid.addListener(buttonPlus);

             //2. INITIAL CALL TO SET BUTTON TEXT TO EMPTY
             currentGrid.setValue(Grid.Square.EMPTY);
        }
    }

    private void initializeViewPanel() {

        int boardSize = boardPanel.getBoardSize();
        model.getBoard().setBoardSize(boardSize);

        int score1 = model.getPlayer1().getScore();
        scorePanel.setPlayer1Score(score1);

        int score2 = model.getPlayer2().getScore();
        scorePanel.setPlayer2Score(score2);
    }

    private void addButtonListeners() {
        boardPanel.addButton1Listener((ActionEvent e) -> onButton1Clicked());
        boardPanel.addButton2Listener((ActionEvent e) -> onButton2Clicked());
        boardPanel.addButton3Listener((ActionEvent e) -> onButton3Clicked());
        boardPanel.addButton4Listener((ActionEvent e) -> onButton4Clicked());
        boardPanel.addButton5Listener((ActionEvent e) -> onButton5Clicked());
        boardPanel.addButton6Listener((ActionEvent e) -> onButton6Clicked());
        boardPanel.addButton7Listener((ActionEvent e) -> onButton7Clicked());
        boardPanel.addButton8Listener((ActionEvent e) -> onButton8Clicked());
        boardPanel.addButton9Listener((ActionEvent e) -> onButton9Clicked());
        boardPanel.addButton10Listener((ActionEvent e) -> onButton10Clicked());
        boardPanel.addButton11Listener((ActionEvent e) -> onButton11Clicked());
        boardPanel.addButton12Listener((ActionEvent e) -> onButton12Clicked());
        boardPanel.addButton13Listener((ActionEvent e) -> onButton13Clicked());
        boardPanel.addButton14Listener((ActionEvent e) -> onButton14Clicked());
        boardPanel.addButton15Listener((ActionEvent e) -> onButton15Clicked());
        boardPanel.addButton16Listener((ActionEvent e) -> onButton16Clicked());
        boardPanel.addButton17Listener((ActionEvent e) -> onButton17Clicked());
        boardPanel.addButton18Listener((ActionEvent e) -> onButton18Clicked());
        boardPanel.addButton19Listener((ActionEvent e) -> onButton19Clicked());
        boardPanel.addButton20Listener((ActionEvent e) -> onButton20Clicked());
        boardPanel.addButton21Listener((ActionEvent e) -> onButton21Clicked());
        boardPanel.addButton22Listener((ActionEvent e) -> onButton22Clicked());
        boardPanel.addButton23Listener((ActionEvent e) -> onButton23Clicked());
        boardPanel.addButton24Listener((ActionEvent e) -> onButton24Clicked());
        boardPanel.addButton25Listener((ActionEvent e) -> onButton25Clicked());

        optionPanel.addPlayAgainListener((ActionEvent e) -> onPlayAgainClicked());
        optionPanel.addChangeBoardSizeListener((ActionEvent e) -> onChangeBoardSizeClicked());

        model.getPlayer1().addListener(scorePanel);
        model.getPlayer2().addListener(scorePanel);
    }
    private void p1Turn()
    {
        model.getPlayer1().setTurn(true,false);
        model.getPlayer2().setTurn(false,true);
    }

    private void p2Turn()
    {
        model.getPlayer1().setTurn(false,true);
        model.getPlayer2().setTurn(true,false);
    }

    private void didPlayer1Win()
    {
        if(model.getBoard().isVictory(Grid.Square.X))
        {
            model.getPlayer1().setScore(model.getPlayer1().getScore()+1,true);
            //model.getBoard().cleanBoard();
            scorePanel.setWin(true);
            boardPanel.freezeButtons();
        }
    }

    private void didPlayer2Win()
    {
        if(model.getBoard().isVictory(Grid.Square.O))
        {
            model.getPlayer2().setScore(model.getPlayer2().getScore()+1, false);
            //model.getBoard().cleanBoard();
            scorePanel.setWin(true);
            boardPanel.freezeButtons();
        }
    }

    private void player1Move(Coordinate coordinate)
    {
        model.getPlayer1().playerMove(coordinate);
        didPlayer1Win();
        p2Turn();
    }

    private void player2Move(Coordinate coordinate)
    {
        model.getPlayer2().playerMove(coordinate);
        didPlayer2Win();
        p1Turn();
    }

    private void playerMoveInCoordinate(Coordinate coordinate) {
        if(model.getPlayer1().isPlaying() && model.getBoard().getGridValue(coordinate)== Grid.Square.EMPTY)
        {
            player1Move(coordinate);
        }

        else if(model.getPlayer2().isPlaying() && model.getBoard().getGridValue(coordinate)== Grid.Square.EMPTY)
        {
            player2Move(coordinate);
        }
    }



    private void onButton1Clicked() {
        coordinate = new Coordinate(0,0);
        playerMoveInCoordinate(coordinate);
    }

    private void onButton2Clicked() {
        coordinate = new Coordinate(1,0);
        playerMoveInCoordinate(coordinate);
    }
    private void onButton3Clicked() {
        coordinate = new Coordinate(2,0);
        playerMoveInCoordinate(coordinate);
    }
    private void onButton4Clicked()
    {
        switch(boardPanel.getBoardSize())
        {
            case 3: coordinate = new Coordinate(0,1);break;
            case 4:
            case 5: coordinate = new Coordinate(3,0);break;
        }
        playerMoveInCoordinate(coordinate);
    }
    private void onButton5Clicked() {
        switch(boardPanel.getBoardSize())
        {
            case 3: coordinate = new Coordinate(1,1);break;
            case 4: coordinate = new Coordinate(0,1);break;
            case 5: coordinate = new Coordinate(4,0);break;
        }
        playerMoveInCoordinate(coordinate);
    }
    private void onButton6Clicked() {
        switch(boardPanel.getBoardSize())
        {
            case 3: coordinate = new Coordinate(2,1);break;
            case 4: coordinate = new Coordinate(1,1);break;
            case 5: coordinate = new Coordinate(0,1);break;
        }
        playerMoveInCoordinate(coordinate);
    }
    private void onButton7Clicked() {
        switch(boardPanel.getBoardSize())
        {
            case 3: coordinate = new Coordinate(0,2);break;
            case 4: coordinate = new Coordinate(2,1);break;
            case 5: coordinate = new Coordinate(1,1);break;
        }
        playerMoveInCoordinate(coordinate);
    }

    private void onButton8Clicked() {
        switch(boardPanel.getBoardSize())
        {
            case 3: coordinate = new Coordinate(1,2);break;
            case 4: coordinate = new Coordinate(3,1);break;
            case 5: coordinate = new Coordinate(2,1);break;
        }
        playerMoveInCoordinate(coordinate);
    }
    private void onButton9Clicked() {
        switch(boardPanel.getBoardSize())
        {
            case 3: coordinate = new Coordinate(2,2);break;
            case 4: coordinate = new Coordinate(0,2);break;
            case 5: coordinate = new Coordinate(3,1);break;
        }
        playerMoveInCoordinate(coordinate);
    }
    private void onButton10Clicked(){
        switch(boardPanel.getBoardSize())
        {
            case 4: coordinate = new Coordinate(1,2);break;
            case 5: coordinate = new Coordinate(4,1);break;
        }
        playerMoveInCoordinate(coordinate);
    }
    private void onButton11Clicked(){
        switch(boardPanel.getBoardSize())
        {
            case 4: coordinate = new Coordinate(2,2);break;
            case 5: coordinate = new Coordinate(0,2);break;
        }
        playerMoveInCoordinate(coordinate);
    }
    private void onButton12Clicked(){
        switch(boardPanel.getBoardSize())
        {
            case 4: coordinate = new Coordinate(3,2);break;
            case 5: coordinate = new Coordinate(1,2);break;
        }
        playerMoveInCoordinate(coordinate);
    }
    private void onButton13Clicked(){
        switch(boardPanel.getBoardSize())
        {
            case 4: coordinate = new Coordinate(0,3);break;
            case 5: coordinate = new Coordinate(2,2);break;
        }
        playerMoveInCoordinate(coordinate);
    }
    private void onButton14Clicked(){
        switch(boardPanel.getBoardSize())
        {
            case 4: coordinate = new Coordinate(1,3);break;
            case 5: coordinate = new Coordinate(3,2);break;
        }
        playerMoveInCoordinate(coordinate);
    }
    private void onButton15Clicked(){
        switch(boardPanel.getBoardSize())
        {
            case 4: coordinate = new Coordinate(2,3);break;
            case 5: coordinate = new Coordinate(4,2);break;
        }
        playerMoveInCoordinate(coordinate);
    }
    private void onButton16Clicked(){
        switch(boardPanel.getBoardSize())
        {
            case 4: coordinate = new Coordinate(3,3);break;
            case 5: coordinate = new Coordinate(0,3);break;
        }
        playerMoveInCoordinate(coordinate);
    }
    private void onButton17Clicked(){
        coordinate = new Coordinate(1,3);
        playerMoveInCoordinate(coordinate);
    }
    private void onButton18Clicked(){
        coordinate = new Coordinate(2,3);
        playerMoveInCoordinate(coordinate);
    }
    private void onButton19Clicked(){
        coordinate = new Coordinate(3,3);
        playerMoveInCoordinate(coordinate);
    }
    private void onButton20Clicked(){
        coordinate = new Coordinate(4,3);
        playerMoveInCoordinate(coordinate);
    }
    private void onButton21Clicked(){
        coordinate = new Coordinate(0,4);
        playerMoveInCoordinate(coordinate);
    }
    private void onButton22Clicked(){
        coordinate = new Coordinate(1,4);
        playerMoveInCoordinate(coordinate);
    }
    private void onButton23Clicked(){
        coordinate = new Coordinate(2,4);
        playerMoveInCoordinate(coordinate);
    }
    private void onButton24Clicked(){
        coordinate = new Coordinate(3,4);
        playerMoveInCoordinate(coordinate);
    }
    private void onButton25Clicked(){
        coordinate = new Coordinate(4,4);
        playerMoveInCoordinate(coordinate);
    }

    private void onPlayAgainClicked() {
            scorePanel.setWin(false);
            boardPanel.unfreezeButtons();
            model.getBoard().cleanBoard();
            model.getPlayer1().setTurn(true, true);
    }

    private void onChangeBoardSizeClicked() {
        int selection = JOptionPane.showConfirmDialog(viewPanel, "This will reset your board.",
                "Changing Board Size", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
        switch (selection) {
            case(JOptionPane.OK_OPTION):
                window.dispose();
                ViewPanel view = new ViewPanel();
                Window newWindow = new Window("Tic Tac Toe", view);
                TicTacToeGame model = new TicTacToeGame(view.getBoardPanel().getBoardSize());
                ControllerPanel controller = new ControllerPanel(view, model, newWindow);
                newWindow.setVisible(true);
                initializeViewPanel();
            break;
            case(JOptionPane.CANCEL_OPTION):
            default:
                break;
        }
    }

}
