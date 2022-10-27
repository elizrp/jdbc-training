package constants;

public interface SqlQueries {

    // customers table queries
    String GET_ALL_CUSTOMERS = "select * from customers";
    String INSERT_CUSTOMER = "insert into customers " +
            "values (default, '%s', '%s', '%s', %s, %s, %s, '%s', '%s', '%s', '%s');";
    String UPDATE_CUSTOMER = "update customers SET name = '%s', email = '%s', phone = '%s', age = %s, gdpr_consent_status = %s, customer_profile_status = %s, profile_created_date = '%s', profile_deactivated_date = '%s', deactivation_reason = '%s', notes = '%s' where id = %s;";
    String DELETE_BY_ID = "delete from customers where id = %s;";
    String DELETE_ALL = "truncate table customers;";
    String COUNT_RECORDS = "select count(*) from customers;";
    String GET_RANDOM_ID = "select id from customers order by random() limit 1;";
    String GET_RANDOM_IDS = "select id from customers order by random() limit %s;";
    String GET_CUSTOMER_BY_ID = "select * from customers where id = %s";
    String GET_CUSTOMERS_BY_IDS = "select * from customers where id in (%s)";

    // customers table columns
    String CUSTOMERS_ID_COLUMN = "id";
    String CUSTOMERS_NAME_COLUMN = "name";
    String CUSTOMERS_EMAIL_COLUMN = "email";
    String CUSTOMERS_PHONE_COLUMN = "phone";
    String CUSTOMERS_AGE_COLUMN = "age";
    String CUSTOMERS_GDPR_CONSENT_STATUS_COLUMN = "gdpr_consent_status";
    String CUSTOMERS_CUSTOMER_PROFILE_STATUS_COLUMN = "customer_profile_status";
    String CUSTOMERS_PROFILE_CREATED_DATE_COLUMN = "profile_created_date";
    String CUSTOMERS_PROFILE_DEACTIVATED_DATE_COLUMN = "profile_deactivated_date";
    String CUSTOMERS_DEACTIVATION_REASON_COLUMN = "deactivation_reason";
    String CUSTOMERS_NOTES_COLUMN = "notes";
}
