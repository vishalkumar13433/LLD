package org.example.DAO;

public class Column {
    private String name;
    private String type;

    private Integer limit;

    public Column(String name, String type, Integer limit) {
        this.name = name;
        this.type = type;
        this.limit = limit;
    }

    public Column() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
