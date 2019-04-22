package ru.test.group.data;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class Group {

    public static LinkedHashMap<String, Double> sortedDValueDec(Map<String, Double> map) {
        Map<String, Double> sorted = map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                LinkedHashMap::new));
        return (LinkedHashMap<String, Double>) sorted;
    }

    public static void main(String args[]) throws IOException, ParseException {

        if (args.length >= 2) {

            FileWriter fileWriterDate = new FileWriter(args[0]);
            fileWriterDate.createWriter();
            fileWriterDate.write(Variable.FIRST_FILE_DATE);

            FileWriter fileWriterOffice = new FileWriter(args[1]);
            fileWriterOffice.createWriter();
            fileWriterOffice.write(Variable.FIRST_FILE_OFFICE);

            SumOperation sumOperation = new SumOperation();

            for (int i = 2; i < args.length; i++) {
                FileReader fileReader = new FileReader(args[i]);
                String firstLine = fileReader.readFirstLine();
                sumOperation.init(firstLine);
                fileReader.readAllLine(sumOperation, 1);
            }

            Map statsDate = sumOperation.getStatsDate();
            Map statsOffice = sumOperation.getStatsOffice();

            fileWriterDate.write(statsDate);
            fileWriterOffice.write(sortedDValueDec(statsOffice));

            fileWriterDate.close();
            fileWriterOffice.close();
        } else {
            System.out.println("Enter input values");
        }
    }
}
