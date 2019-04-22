package ru.test.group.data;

import java.util.Map;

public class HandlerOperation<T> {

    private Map<T,Double> map;

    public Map<T,Double> getMap() {
        return map;
    }

    public HandlerOperation(Map<T, Double> map) {
        this.map = map;
    }

    public void update(T key, double value) {
        if (map.containsKey(key)) {
            double newSum = map.get(key) + value;
            map.put(key, newSum);
        } else {
            map.put(key, value);
        }
    }


}
