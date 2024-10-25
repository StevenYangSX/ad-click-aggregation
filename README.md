### Useful Commands
1. 进入 docker cassandra shell
    ```docker exec -it cassandra-db-new bash```
2. 运行cqlsh 
   ```cqlsh```
3. 进入一个数据库
   ```USE keyspace_name (db name)```
4. 查询所有表
   ```DESCRIBE TABLES```
5. 查询一个表中的数据
   ```SELECT * from <table_name>```