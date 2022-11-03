package stepDefinitions;

import dao.baseDaos.AddressDao;
import dao.baseDaos.CustomerDao;
import dao.daoMappers.AddressDaoDBUtils;
import dao.daoMappers.CustomerDaoDBUtils;
import helpers.BaseHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Address;
import model.Customer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class AddressSteps {

    private static CustomerDao customerDaoDBUtils = new CustomerDaoDBUtils();
    private static AddressDao addressDao = new AddressDaoDBUtils();
    private static List<Address> randomAddresses = new ArrayList<>();
    private static List<Customer> randomCustomers = new ArrayList<>();
    private static int numberOfRecords = 5;

    @Given("prepare data for address tests")
    public static void prepareData() {
        BaseHelper.prepareData(customerDaoDBUtils, addressDao, numberOfRecords);
    }

    // Get X random customers by getting X random customer IDs and verify they have an address
    @When("user gets {int} random customers")
    public void getCustomersByRandomId(int numberOfRecords) {
        randomCustomers = customerDaoDBUtils.getByIds(customerDaoDBUtils.getRandomIds(numberOfRecords));
    }

    @Then("verify customers have corresponding addresses")
    public void verifyCustomersHaveAddresses() {
        for (Customer customer : randomCustomers) {
            assertNotNull(String.format("Customer with id % does not have an address!", customer.getId()),
                    addressDao.getByCustomerId(customer.getId()));
        }
    }

    // Get X random addresses by getting X random IDs and verify that they have all mandatory fields with data
    @When("user retrieves {int} random addresses")
    public void getAddressesByRandomId(int numberOfAddresses) {
        randomAddresses = addressDao.getByIds(addressDao.getRandomIds(numberOfAddresses));
    }

    // Mandatory fields: id, city, postal_code, country
    // id (primary key) and postal_code (>0) are never null, thus there is no verification for those
    @Then("verify addresses mandatory fields are with data")
    public void verifyMandatoryFieldsNotEmpty() {
        for (Address address : randomAddresses) {
            assertNotNull("Address city must not be null!", address.getCity());
            assertNotNull("Address country must not be null!", address.getCountry());
        }
    }
}
