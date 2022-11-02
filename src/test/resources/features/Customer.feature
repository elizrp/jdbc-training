@Customer
Feature: CRUD operations with 'customers' table

  #create a new record, save it and verify that it was saved successfully, verify there are more entries in the table
  @CreateCustomer
  Scenario: Verify new record is created successfully
    When user creates a new customer
    And user saves customer in the database
    Then there are more entries in the table

  #delete a record, and verify that it doesn’t exist in the database and there are fewer entries in the table.
  @DeleteCustomer
  Scenario: Verify record is successfully deleted
    When user deletes a customer
    Then user does not exist in the database
    And there are fewer entries in the table

  #get X random customers by getting X random customer IDs and verify that their mandatory fields are with data
  #random fields: id, name, email, phone, gdpr_consent_status, customer_profile_status, profile_created_date
  @CustomerMandatoryFields
  Scenario Outline: Verify customers mandatory fields are populated
    When user retrieves <numberOfCustomers> random customers
    Then verify mandatory fields are with data

    Examples:
      | numberOfCustomers |
      | 2                 |

  #verify the data count for the customers table
  @TotalCountCustomer
  Scenario Outline: Verify total count of records
    When user retrieves the total count of records in the table
    Then verify the result equals <count>

    Examples:
      | count |
      | 5     |