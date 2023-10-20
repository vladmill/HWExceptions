package ui;

import presenter.Presenter;

import java.io.IOException;

public class ViewConsole implements View {
    private Presenter presenter;
    private InputData inputData;
    public ViewConsole() {
        this.inputData = new InputData(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        try {
            presenter.setData(inputData.getData());
            System.out.println("Data saved successfully.");
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


}
