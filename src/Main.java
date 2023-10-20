import model.Model;
import presenter.Presenter;
import ui.View;
import ui.ViewConsole;

public class Main {
    public static void main(String[] args) {
        View view = new ViewConsole();
        Model model = new Model();
        new Presenter(view, model);
        view.start();
    }
}