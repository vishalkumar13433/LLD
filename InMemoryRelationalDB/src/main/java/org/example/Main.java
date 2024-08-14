package org.example;

import org.example.DAO.*;

import java.util.*;

//Refer this: https://github.com/deepanshujain92/MemorySQL/blob/master/src/com/memorysql/model/Table.java

public class Main {
    public static void main(String[] args) {
        String dbName = "database"; // TODO:: read this from scanner
        Database db = createDatabase(dbName);

        List<Column> cols = new ArrayList<>();
        cols.add(new Column("id", "INTEGER", null));
        cols.add(new Column("name", "STRING", 50));
        cols.add(new Column("age", "INTEGER", null));
        cols.add(new Column("gender", "STRING", 10));

        String tableName = "person"; // TODO:: read this from scanner
        try {
            createTable(db, tableName, cols);
        } catch (Exception e) {
            System.out.println("Unable to create table: " + e.getMessage());
            return;
        }

//        tableName = "person"; // TODO:: read this from scanner
//        try {
//            createTable(db, tableName, cols);
//        } catch (Exception e) {
//            //Unable to create table: Table -person Already exist!!
//            System.out.println("Unable to create table: " + e.getMessage());
//            return;
//        }

        Table table = getTable(db, tableName);
        if (table == null) {
            System.out.println("No such table found " + tableName);
            return;
        }

        List<Object> rowValues= new ArrayList<>();
        rowValues.add(2);
        rowValues.add(1);
        rowValues.add(29);
        rowValues.add("Male");

//        try {
//            createRow(table, rowValues);
//        } catch (Exception e) {
//            //Unable to create row: type mismatch
//            System.out.println("Unable to create row: " + e.getMessage());
//            return ;
//        }

        rowValues= new ArrayList<>();
        rowValues.add(1);
        rowValues.add("Vishal");
        rowValues.add(29);
        rowValues.add("Male");
        try {
            createRow(table, rowValues);
        } catch (Exception e) {
            System.out.println("Unable to create row: " + e.getMessage());
            return ;
        }

//        rowValues= new ArrayList<>();
//        rowValues.add(1);
//        rowValues.add("Tanuj");
//        rowValues.add(29);
//        rowValues.add("Male");
//        try {
//            createRow(table, rowValues);
//        } catch (Exception e) {
//            //Unable to create row: row already exist
//            System.out.println("Unable to create row: " + e.getMessage());
//            return ;
//        }

        rowValues= new ArrayList<>();
        rowValues.add(2);
        rowValues.add("Tanuj");
        rowValues.add(29);
        rowValues.add("Male");
        try {
            createRow(table, rowValues);
        } catch (Exception e) {
            System.out.println("Unable to create row: " + e.getMessage());
            return ;
        }

        int rowId = 2;
        Map<String, Object> columnsToUpdate = new HashMap<>();
        columnsToUpdate.put("name", "TK");
        columnsToUpdate.put("age", "30");
//        try {
//            updateRow(table, rowId, columnsToUpdate);
//        } catch (Exception e) {
//            //Unable to update row: type mismatch
//            System.out.println("Unable to update row: " + e.getMessage());
//            return ;
//        }

        columnsToUpdate = new HashMap<>();
        columnsToUpdate.put("name", "TK");
        columnsToUpdate.put("age", 30);
        try {
            updateRow(table, rowId, columnsToUpdate);
        } catch (Exception e) {
            System.out.println("Unable to update row: " + e.getMessage());
            return ;
        }

        rowValues= new ArrayList<>();
        rowValues.add(3);
        rowValues.add("Bhogi");
        rowValues.add(29);
        rowValues.add("Male");
        try {
            createRow(table, rowValues);
        } catch (Exception e) {
            System.out.println("Unable to update row: " + e.getMessage());
            return ;
        }

        String columnName = "name";
        try {
            addIdx(table, columnName);
        } catch (Exception e) {
            System.out.println("Unable to create iddx: " + e.getMessage());
            return ;
        }

        selectRow(table, 1);
        selectRow(table, 2);
        selectRow(table, 3);

        deleteRow(table, 3);


        rowValues= new ArrayList<>();
        rowValues.add(4);
        rowValues.add("Vishal");
        rowValues.add(29);
        rowValues.add("Female");
        try {
            createRow(table, rowValues);
        } catch (Exception e) {
            System.out.println("Unable to update row: " + e.getMessage());
        }
        selectRow(table, 1);
        selectRow(table, 2);
        selectRow(table, 3);
        selectRow(table, 4);


    }

    private static void addIdx(Table table, String columnName) throws Exception {
        table.createIndex(columnName);
    }

    private static void deleteRow(Table table, int rowId) {
        table.deleteRow(rowId);
    }

    private static void selectRow(Table table, int rowId) {
        table.printRow(rowId);
    }

    private static void updateRow(Table table, int rowId, Map<String, Object> columnValues) throws Exception {
        table.updateRow(rowId, columnValues);
    }

    private static void createRow(Table table, List<Object> rowValues) throws Exception {
        table.addRow(rowValues);
    }

    private static Table getTable(Database db, String tableName) {
        Map<String, Table> tables =  db.getTables();
        if (tables != null && tables.get(tableName) != null) {
            return tables.get(tableName);
        }
        return null;
    }



    private static void createTable(Database db, String tableName, List<Column> cols) throws Exception{
        Map<String, Table> tables =  db.getTables();
        if (tables != null && tables.get(tableName) != null) {
            throw new Exception("Table -" + tableName + " Already exist!!");
        }
        Table table = new Table(tableName, cols);
        tables.put(tableName, table);
    }

    private static Database createDatabase(String databaseName) {
        return new Database(databaseName);
    }
}