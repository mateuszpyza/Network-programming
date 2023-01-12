package websiteToHtml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSaver {
    public static void createFileTxt(String pathToFile, String text) {
        if (text != null && pathToFile != null) {
            try {
                File data = new File(pathToFile);
                data.createNewFile();
                Files.write(Path.of(pathToFile), (text).getBytes());
            } catch (IOException e) {
                throw new RuntimeException("File creation problem!");
            }
        } else {
            throw new RuntimeException("Input data is null.");
        }

    }
}