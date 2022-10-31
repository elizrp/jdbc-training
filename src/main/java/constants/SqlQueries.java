package constants;

public interface SqlQueries {

    // customers table queries
    String GET_ALL_CUSTOMERS = "select * from customers";
    String INSERT_CUSTOMER = "insert into customers " +
            "values (default, '%s', '%s', '%s', %s, %s, %s, '%s', '%s', '%s', '%s');";
    String INSERT_ADDRESS = "insert into customers_addresses " +
            "values (default, '%s', '%s', '%s', %s, %s, '%s');";


    String UPDATE_CUSTOMER = "update customers SET name = '%s', email = '%s', phone = '%s', age = %s, gdpr_consent_status = %s, customer_profile_status = %s, profile_created_date = '%s', profile_deactivated_date = '%s', deactivation_reason = '%s', notes = '%s' where id = %s;";
    String UPDATE_ADDRESS = "update customers_addresses SET address = '%s', city = '%s', province = '%s', state = '%s', postal_code = %s, country = '%s' where id = %s;";


    String DELETE_BY_ID = "delete from %s where id = %s;";
    String DELETE_ALL = "truncate table %s;";
    String COUNT_RECORDS = "select count(*) from %s;";
    String GET_RANDOM_ID = "select id from %s order by random() limit 1;";
    String GET_RECORD_BY_ID = "select * from %s where id = %s";
    String GET_RECORDS_BY_IDS = "select * from %s where id in (%s)";
    String GET_CUSTOMER_BY_ID = "select * from customers where id = %s";
    String GET_CUSTOMERS_BY_IDS = "select * from customers where id in (%s)";

    // extract the customer’s address and all of the customer’s orders with the ordered products.
    String CUSTOMER_ORDERED_PRODUCTS = "select o.customer, ca.address, o.id as order_id, pi2.product_name from orders o join customers c on o.customer_id = c.id join customers_addresses ca on ca.customer_id = c.id join orders_products op on op.order_id = o.id join products_inventory pi2 on pi2.id = op.product_id order by customer;";

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

    // database table names
    String CUSTOMERS_TABLE = "customers";
    String CUSTOMERS_ADDRESSES_TABLE = "customers_addresses";
}
