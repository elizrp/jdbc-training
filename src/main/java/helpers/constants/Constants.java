package helpers.constants;

public interface Constants {

    // DB connection
    String PATH_TO_PROPERTIES_FILE = "./src/main/resources/config.properties";
    String DATABASE_URL = "jdbc.postgres.url";
    String DATABASE_USERNAME = "jdbc.postgres.username";
    String DATABASE_PASSWORD = "jdbc.postgres.password";

    // SQL queries
    String GET_ALL_CUSTOMERS = "select * from customers";
    String CUSTOMERS_NAME_COLUMN = "name";
}
