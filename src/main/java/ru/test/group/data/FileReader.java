package ru.test.group.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    private Path path;

    public FileReader(String filePath) {
        this.path = Paths.get(filePath);
    }

    public String readFirstLine() throws IOException {
        String line = Files.lines(path)
                .findFirst()
                .get();
        return line;
    }

    public void readAllLine(SumOperation sumOperation, Integer skip) {
        try (Stream<String> stream = Files.lines(path).skip(skip)) {
            stream.forEach(line -> sumOperation.run(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
