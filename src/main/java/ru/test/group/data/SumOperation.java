package ru.test.group.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SumOperation {

    private static int indexDate;
    private static int indexSale;
    private static int indexSum;

    private static HandlerOperation handlerOperationOfDate = new HandlerOperation(new TreeMap<LocalDate, Double>());
    private static HandlerOperation handlerOperationOfOffice = new HandlerOperation(new TreeMap<String, Double>());

    public void init(String firstLine) {
        String[] line = firstLine.split(Variable.SEPARATOR);
        List<String> lineList = Arrays.asList(line);
        indexDate = lineList.indexOf(Variable.DATE);
        indexSale = lineList.indexOf(Variable.SALE_POINT_NUMBER);
        indexSum = lineList.indexOf(Variable.SUM_OPERATION);
    }

    public Map getStatsDate() {
        return handlerOperationOfDate.getMap();
    }

    public Map getStatsOffice() {
        return handlerOperationOfOffice.getMap();
    }

    public static void run(String line) {
        String[] splitLine = line.split(Variable.SEPARATOR);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Variable.FORMAT_DATE);
        LocalDate localDate = LocalDate.parse((splitLine[indexDate]), formatter);
        String office = (splitLine[indexSale]);
        double sumOperation = Double.parseDouble(splitLine[indexSum]);

        handlerOperationOfDate.update(localDate, sumOperation);
        handlerOperationOfOffice.update(office, sumOperation);
    }


}