package org.example.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Index {
    private String name;
    private int colOn;
    private Map<String, List<Row>> idxMap;


    public Index(String name, int colOn) {
        this.name = name;
        this.colOn = colOn;
        this.idxMap = new HashMap<>();
    }

    public Index(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColOn() {
        return colOn;
    }

    public void setColOn(int colOn) {
        this.colOn = colOn;
    }

    public Map<String, List<Row>> getIdxMap() {
        return idxMap;
    }

    public void setIdxMap(Map<String, List<Row>> idxMap) {
        this.idxMap = idxMap;
    }
}
