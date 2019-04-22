package ru.test.group.data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class FileWriter<T> {
    private String filePath;
    BufferedWriter writer;

    public FileWriter(String filePath)  {
        this.filePath = filePath;
    }

    public void createWriter() {
        try {
            writer = new BufferedWriter(new java.io.FileWriter(filePath));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String string) {
        try {
            writer.write(string);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void write(Map<T,Double> map) {
        try {
            for (T key: map.keySet()) {
                writer.write(key.toString() + Variable.SEPARATOR + BigDecimal.valueOf(map.get(key)).setScale(2,BigDecimal.ROUND_HALF_UP) + "\n");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
            if (writer!=null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}
