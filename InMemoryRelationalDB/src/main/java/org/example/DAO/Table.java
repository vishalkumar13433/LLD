package org.example.DAO;

import java.lang.reflect.Type;
import java.util.*;

public class Table {
    private Map<Integer, Row> rows;
    private List<Column> cols;

    private String tableName;

    private Index idx;



    public Table(String name, List<Column> cols) {
        this.tableName = name;
        this.rows = new HashMap<>();
        this.cols = cols;
    }

    public Map<Integer, Row> getRows() {
        return rows;
    }

    public void setRows(Map<Integer, Row> rows) {
        this.rows = rows;
    }

    public List<Column> getCols() {
        return cols;
    }

    public void setCols(List<Column> cols) {
        this.cols = cols;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void addRow(List<Object> rowValues) throws Exception {
        // TODO:: should be thread safe
        String validationMsg = runValidation(rowValues);
        if (!validationMsg.isEmpty()) {
            throw new Exception(validationMsg);
        }
        int id = (int)rowValues.get(0);
        Row row = new Row(id, rowValues);
        this.rows.put(id, row);

        // TODO:: add to index
    }

    private String runValidation(List<Object> rowValues) {
        if (rowValues.size() != cols.size()) {
            return "row does not match column size";
        }
        int id = (int)rowValues.get(0);
        if (rows.get(id) != null) {
            return "row already exist";
        }
        return runColumnValidation(rowValues);
    }

    private String runColumnValidation(List<Object> rowValues) {
        for (int i=0; i< cols.size() ; i++) {
            Object obj = rowValues.get(i);
            String colType = cols.get(i).getType();
            // ADD VALIDATIONS HERE
            boolean typeMismatch = (obj instanceof Integer && !colType.equals("INTEGER")) || (obj instanceof String && !colType.equals("STRING"));
            if (typeMismatch) {
                return "type mismatch";
            }
        }
        return "";
    }

    public void updateRow(int rowId, Map<String, Object> columnValues) throws Exception {
        // TODO:: should be thread safe
        Row row = rows.get(rowId);
        if (row == null) {
            return ;
        }

        for (Map.Entry<String, Object> e : columnValues.entrySet()) {
            String columnName = e.getKey();
            for (int i = 0; i< cols.size() ; i++) {
                if (cols.get(i).getName().equals(columnName)) {
                    row.getValues().set(i, e.getValue());
                }
            }
        }
        // TODO:: there is a problem , we are updating the row and then doing validations. it should be opposite
        String validationMsg = runColumnValidation(row.getValues());
        if (!validationMsg.isEmpty()) {
            throw new Exception(validationMsg);
        }
        // TODO:: update index
    }

    public void printRow(int rowId) {
        Row row = rows.get(rowId);
        if (row == null) {
            return ;
        }
        System.out.println(row);
    }

    public void deleteRow(int rowId) {
        Row row = rows.get(rowId);
        if (row == null) {
            return ;
        }
        rows.remove(row.getId());
        if (idx != null) {
            int colNo = idx.getColOn();
            String rowToDelete = (String) row.getValues().get(colNo);
            List<Row> r =  idx.getIdxMap().get(rowToDelete);
            r.remove(row);
        }
    }

    public void createIndex(String columnName) throws Exception {
        if (this.idx != null) {
            throw new Exception("we are only supporting one coolumn indexs");
        }

        int size = this.getCols().size();
        int i = 0;
        for (; i < size; i++) {
            if (this.getCols().get(i).getName().equals(columnName)) {
                break;
            }
        }
        if (i == size) {
            throw new Exception("index on column does not exist in table");
        }
        this.idx = new Index(columnName+ "_idx", i);
        for (Row r : rows.values()) {
            String idxColValue = (String) r.getValues().get(i);
            List<Row> idxVals =  this.idx.getIdxMap().get(idxColValue);
            if (idxVals == null ) {
                idxVals = new ArrayList<>();
                this.idx.getIdxMap().put(idxColValue, idxVals);
            }
            idxVals.add(r);
        }
    }
}
