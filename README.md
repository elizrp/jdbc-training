### jdbc-training

This is a project which uses JDBC for database management and testing.

### Prerequisites
- Local Postgres database setup
- 'customers', 'customers_addresses', 'orders', 'products_inventory' tables with example data

### Setup
- Java 11
- Maven
- JDBC driver for Postgres database
- Cucumber

### Structure

- Two helper classes that create db connection via different design patterns
- Sample data is generated with the help of JavaFaker -> implemented in CustomerHelper class.
- DAO classes in /dao/baseDaos which implement CRUD operations
- Extended functionalities and different implementations of mapping result data can be found in /dao/daoMappers
- All operations can be tested through the main() method in DatabaseManager class
- Cucumber tests under src/test - tests can be run from TestRunner class using the tags cucumber option
    Note: The implemented tests run on database schema 'customers_data' -> this can be set in the config.properties file
