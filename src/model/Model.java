package model;

import ui.InputData;

import java.io.IOException;

public class Model {
    Writer writer;

    public Model() {
        this.writer = new WriterTxt(this);
    }

    public void dataProcessing(String[] arr) throws IOException {
        writer.saveData(arr);

    }

}
