package presenter;

import model.Model;
import ui.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.setPresenter(this);
    }

    public void setData(String[] arr) throws IOException {
        model.dataProcessing(arr);
    }
}
