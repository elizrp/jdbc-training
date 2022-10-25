package constants;

public interface SqlQueries {

    // customers table
    String GET_ALL_CUSTOMERS = "select * from customers";
    String CUSTOMERS_NAME_COLUMN = "name";
    String INSERT_CUSTOMER = "insert into customers " +
            "values (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s);";
    String UPDATE_CUSTOMER = "update customers SET name = %s, email = %s, phone = %s, age = %s, gdpr_consent_status = %s, customer_profile_status = %s, profile_created_date = %s, profile_deactivated_date = %s, deactivation_reason = %s, notes = %s where id = %s;";
    String DELETE_BY_ID = "delete from customers where id = %s;";
    String DELETE_ALL = "truncate table customers;";
    String COUNT_RECORDS = "select count(*) from customers;";
    String GET_RANDOM_ID = "select id from customers order by random() limit 1;";
    String GET_RANDOM_IDS = "select id from customers order by random() limit %s;";
}
