
# Tic Tac Toe
Classic Tic Tac Toe game using Java Swing graphical user interface.

## Point of entry

In the point of entry, we created a view panel that includes 3 components: scoreboard, board, and option buttons. We also create players, a board of coordinates and customed values. Once these are created, we add them to the board arraylist. Finally, we linked the view and model (TicTacToe game) together by using listeners to the buttons and grid. 

The controller essentially links the view and model together. It manages user input and updates the model accordingly. The view is subscribed to the model as a listener, so whenever there is a change within the model, the view will then change accordingly.

## Optional functionalities

As optional functionalities, we display players' score and give the users the option to change the board size (3x3 (default), 4x4 or 5x5).


## Improvements made to the game

We decided to display a message on top of the board so that the players know which player is playing as well as when a player wins a round. Whenever a player wins a round, we also made the buttons freeze so that the players can see how the round was won (row, column, or diagonal line). By freezing the buttons, it equally allows players to choose to play again by clicking on the "play again" button or ending the game by closing the window.


## Other relevant information

In terms of the winning conditions, we decided that a win for each board would be an entire row, column, or a diagonal line as we were unsure of the winning conditions for a 4x4 or a 5x5 board.

A last detail we have left would be a message for the Draw condition. We have implemented a message for the winning player but have not implemented a message for a Draw which means the players would have to click on the "play again" button for a new round.

## Credits
Created by Sharmaine Bajala and [Nicolas Perdomo](https://github.com/nicolasperdomol).
