package org.example.DAO;

import java.util.List;

public class Row {
    private Integer id;
    private List<Object> values;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object obj: values) {
            sb.append(obj.toString()).append("| ");
        }
        return sb.toString();
    }

    public Row(Integer id, List<Object> values) {
        this.id = id;
        this.values = values;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }
}
