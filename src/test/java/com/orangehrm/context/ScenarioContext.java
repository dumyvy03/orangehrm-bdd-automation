package com.orangehrm.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private final Map<String, Object> dataMap;

    public ScenarioContext() {
        this.dataMap = new HashMap<>();
    }

    public void setDataMap(String key, Object value) {
        dataMap.put(key, value);
    }

    public Object get(String key) {
        if (!dataMap.containsKey(key)) {
            throw new IllegalArgumentException("No value found for key: " + key);
        }
        return dataMap.get(key);
    }

    public boolean containsKey(String key) {
        return dataMap.containsKey(key);
    }


    public void clearDataMap() {
        dataMap.clear();
    }
}
