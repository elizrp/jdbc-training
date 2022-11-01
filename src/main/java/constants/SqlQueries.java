package constants;

public interface SqlQueries {

    // customers table queries
    // insert queries
    String INSERT_CUSTOMER = "insert into customers " +
            "values (default, '%s', '%s', '%s', %s, %s, %s, '%s', '%s', '%s', '%s');";
    String INSERT_ADDRESS = "insert into customers_addresses " +
            "values (default, %s, '%s', '%s', '%s', '%s', %s, '%s');";
    String INSERT_PRODUCT = "insert into products_inventory " +
            "values (default, %s, '%s', %s, '%s', %s, default, %s, '%s');";
    String INSERT_ORDER = "insert into orders " +
            "values (default, %s, '%s', %s, %s, '%s', '%s');";


    // update queries
    String UPDATE_CUSTOMER = "update customers SET name = '%s', email = '%s', phone = '%s', age = %s, gdpr_consent_status = %s, customer_profile_status = %s, profile_created_date = '%s', profile_deactivated_date = '%s', deactivation_reason = '%s', notes = '%s' where id = %s;";
    String UPDATE_ADDRESS = "update customers_addresses SET address = '%s', city = '%s', province = '%s', state = '%s', postal_code = %s, country = '%s' where id = %s;";
    String UPDATE_PRODUCT = "update products_inventory SET product_name = '%s', available_quantity = %s, product_type = '%s', price_without_VAT = %s, price_with_VAT = %s, is_product_in_stock = %s, warehouse = %s where id = %s;";
    String UPDATE_ORDER = "update orders SET customer = '%s', is_order_completed = %s, is_order_paid = %s, date_of_order = '%s', date_of_order_completed = '%s' where id = %s;";


    // CRUD queries
    String DELETE_BY_ID = "delete from %s where id = %s;";
    String DELETE_ALL = "truncate table %s;";
    String COUNT_RECORDS = "select count(*) from %s;";
    String GET_RANDOM_ID = "select id from %s order by random() limit 1;";
    String GET_CUSTOMER_BY_ID = "select * from customers where id = %s";
    String GET_ADDRESS_BY_ID = "select * from customers_addresses where id = %s";
    String GET_PRODUCT_BY_ID = "select * from products_inventory where id = %s";
    String GET_PRODUCTS_BY_IDS = "select * from products_inventory where id in (%s)";
    String GET_ORDER_BY_ID = "select * from orders where id = %s";
    String GET_ORDERS_BY_IDS = "select * from orders where id in (%s)";
    String GET_ADDRESS_BY_CUSTOMER_ID = "select * from customers_addresses where customer_id = %s";
    String GET_ORDER_BY_CUSTOMER_ID = "select * from orders where customer_id = %s";
    String GET_CUSTOMERS_BY_IDS = "select * from customers where id in (%s)";
    String GET_PRODUCTS_BY_ORDER_ID = "select pi2.id, pi2.supplier_id, pi2.product_name, pi2.available_quantity, pi2.product_type, pi2.price_without_vat, pi2.price_with_vat, pi2.is_product_in_stock, pi2.warehouse\n" +
            "from products_inventory pi2 \n" +
            "join orders_products op on op.product_id = pi2.id \n" +
            "join orders o on o.id = op.order_id \n" +
            "where o.id = %s;";


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
    String PRODUCTS_INVENTORY_TABLE = "products_inventory";
    String ORDERS_TABLE = "orders";
}
