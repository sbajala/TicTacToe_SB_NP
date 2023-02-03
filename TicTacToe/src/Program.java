import Model.TicTacToeGame;
import controllers.ControllerPanel;
import views.Window;
import views.ViewPanel;

public class Program {

    public static void main(String[] args){
        ViewPanel view = new ViewPanel();
        TicTacToeGame model = new TicTacToeGame(view.getBoardPanel().getBoardSize());
        Window window = new Window("Tic Tac Toe", view);
        window.setVisible(true);

        ControllerPanel controller = new ControllerPanel(view, model, window);

    }
}
