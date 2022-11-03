@Address
Feature: CRUD operations with 'customers_addresses' table

  Background:
    Given prepare data for address tests

  #get X random customers by getting X random customer IDs and verify they have an address
  @Customer-Address
  Scenario Outline: Verify customers have addresses
    When user gets <numberOfCustomers> random customers
    Then verify customers have corresponding addresses

    Examples:
      | numberOfCustomers |
      | 2                 |

  #get X random addresses by getting X random IDs and verify that they have all mandatory fields with data
  @AddressMandatoryFields
  Scenario Outline: Verify customers_addresses mandatory fields are populated
    When user retrieves <numberOfAddresses> random addresses
    Then verify addresses mandatory fields are with data

    Examples:
      | numberOfAddresses |
      | 2                 |