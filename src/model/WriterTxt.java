package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterTxt implements Writer {
    Model model;

    public WriterTxt(Model model) {
        this.model = model;
    }

    public void saveData(String[] arr) throws IOException {
        String pathProject = System.getProperty("user.dir");
        String pathDir = pathProject.concat("/src/files");
        String pathFile = pathDir.concat("/"+arr[0].toLowerCase()+".txt");
        System.out.println(pathFile);
        File file = new File(pathFile);
        try (FileWriter fw = new FileWriter(file, true)){
            if (file.length() > 0){
                fw.write('\n');
            }
            fw.write(String.format("<%s>", String.join("> <",arr)));
        }
    }
}