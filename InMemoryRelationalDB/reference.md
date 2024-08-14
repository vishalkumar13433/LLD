
Interview Question:
Ask the candidate to implement an in-memory based DBMS. Application should take in
normal SQLs as inputs and perform the respective actions. In the interest of time, SQL parsing can be skipped and the respective methods can be called directly.
These methods createTable and insertRow should implement the underlying DB (In-memory).

Implement an in-memory relational data store Features:
1. Create table
2. Delete Table
3. Insert row
4. Update row
5. Delete row
6. Create Index on a single column

A. Create Table
Create a store for a specific table. We can assume all fields of type string. Table name and column names should be persisted as metadata either on the table itself or on a separate entity.
createTable(<table name>, [Column list])
B. Insert Row
Generate unique ID for the to-be-created row. Add the row into the table and return the newly-created-row’s ID.
insertRow(<table name>, [value list in the same order of table
creation])
C. Update Row
Search for the row to be updated. Perform an in-place update with the columns to be updated with the new values. If a column need not be updated
updateRow(<table name>, [map of column name to updated value])

D. Delete Row
deleteRow(<table name>, [map of column name to delete value])

E. Create Index
createIndex(<table name>, <column_name>)



Evaluation Matrix:
   SDE1 → Create, Insert, update (no locking), id based indexing (in memory) SDE2 → SDE1 + delete (compaction, re-indexing)
   SDE3 → SDE2 + concurrency ( locks), alter table or constraints
   Create Table
   Create a store for a specific table. We can assume all fields of type string. Table name and column names should be persisted as metadata either on the table itself or on a separate entity.
   createTable(<table name>, [Column list])
   Insert Row
   Generate unique ID for the to-be-created row. Add the row into the table and return the newly-created-row’s ID.
   insertRow(<table name>, [value list in the same order of table
   creation])
   Update Row
   Search for the row to be updated. Perform an in-place update with the columns to be updated with the new values. If a column need not be updated
   updateRow(<table name>, [map of column name to updated value])