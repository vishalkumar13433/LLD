package org.example.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private String name;
    private Map<String, Table> tables;


    public Database(String name) {
        this.tables = new HashMap<>();
        this.name = name;
    }

    public Map<String, Table> getTables() {
        return tables;
    }

    public void setTables(Map<String, Table> tables) {
        this.tables = tables;
    }
}
