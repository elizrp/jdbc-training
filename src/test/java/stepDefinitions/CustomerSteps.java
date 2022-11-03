package stepDefinitions;

import dao.baseDaos.AddressDao;
import dao.baseDaos.CustomerDao;
import dao.daoMappers.AddressDaoDBUtils;
import dao.daoMappers.CustomerDaoDBUtils;
import helpers.BaseHelper;
import helpers.objectBuilding.CustomerHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Customer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerSteps {

    private static CustomerDao customerDaoDBUtils = new CustomerDaoDBUtils();
    private static AddressDao addressDao = new AddressDaoDBUtils();
    private static Customer customer;
    private static List<Customer> randomCustomers = new ArrayList<>();
    private static int numberOfRecords = 5;
    private static int customerId;
    private static int totalCount;

    @Given("prepare data for customer tests")
    public static void prepareData() {
        BaseHelper.prepareData(customerDaoDBUtils, addressDao, numberOfRecords);
    }

    // Create a new record, save it and verify that it was saved successfully, verify there are more entries in the table
    @When("user creates a new customer")
    public Customer createCustomer() {
        return customer = CustomerHelper.createCustomer();
    }

    @When("user saves customer in the database")
    public void saveCustomerInDatabase() {
        customerDaoDBUtils.save(customer);
    }

    @Then("there are more entries in the table")
    public void verifyNumberOfRecordsAfterInsert() {
        assertEquals("Incorrect number of records in table!", ++numberOfRecords, customerDaoDBUtils.getRecordsCount());
    }

    // Delete a record, and verify that it does not exist in the database and there are fewer entries in the table
    @When("user deletes a customer")
    public void deleteCustomer() {
        customerDaoDBUtils.delete(customerId = customerDaoDBUtils.getRandomId());
    }

    @Then("user does not exist in the database")
    public void verifyCustomerNotExist() {
        try {
            assertNull(String.format("Customer with id %d still exists in the database!", customerId), customerDaoDBUtils.getById(customerId));
        } catch (NullPointerException e) {
        }
    }

    @Then("there are fewer entries in the table")
    public void verifyNumberOfRecordsAfterDelete() {
        assertEquals("Incorrect number of records in table!", --numberOfRecords, customerDaoDBUtils.getRecordsCount());
    }

    // Get X random customers by getting X random customer IDs and verify that their mandatory fields are with data
    @When("user retrieves {int} random customers")
    public void getCustomersByRandomId(int numberOfRecords) {
        randomCustomers = customerDaoDBUtils.getByIds(customerDaoDBUtils.getRandomIds(numberOfRecords));
    }

    // Mandatory fields: id, name, email, phone, gdpr_consent_status, customer_profile_status, profile_created_date
    // id (primary key) and boolean type fields are never null, thus there is no verification for those
    @Then("verify mandatory fields are with data")
    public void verifyMandatoryFieldsNotEmpty() {
        for (Customer customer : randomCustomers) {
            assertNotNull("Customer name must not be null!", customer.getName());
            assertNotNull("Customer email must not be null!", customer.getEmail());
            assertNotNull("Customer phone must not be null!", customer.getPhone());
            assertNotNull("Customer profile_created_date must not be null!", customer.getProfileCreatedDate());
        }
    }

    // Verify the data count for the customers table
    @When("user retrieves the total count of records in the table")
    public void getTotalCountOfRecords() {
        totalCount = customerDaoDBUtils.getRecordsCount();
    }

    @Then("verify the result equals {int}")
    public void verifyRecordsCount(int numberOfRecords) {
        assertEquals("Incorrect number of records in table!", numberOfRecords, totalCount);
    }
}
