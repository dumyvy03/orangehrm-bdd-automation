package com.orangehrm.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ScenarioContext {
    private final Map<String, Object> dataMap;

    public ScenarioContext() {
        this.dataMap = new HashMap<>();
    }

    public void setDataMap(String key, Object value) {
        dataMap.put(key, value);
    }

    public Optional<Object> getOptional(String key) {
        return Optional.ofNullable(dataMap.get(key));
    }

    public boolean containsKey(String key) {
        return dataMap.containsKey(key);
    }


    public void clearDataMap() {
        dataMap.clear();
    }
}
