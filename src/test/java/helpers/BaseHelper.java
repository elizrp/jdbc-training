package helpers;

import dao.baseDaos.AddressDao;
import dao.baseDaos.CustomerDao;
import dao.daoMappers.CustomerDaoResultSet;
import helpers.objectBuilding.AddressHelper;
import helpers.objectBuilding.CustomerHelper;
import model.Address;

import static org.junit.Assert.assertEquals;

public class BaseHelper {

    private static CustomerDao customerDaoResultSet = new CustomerDaoResultSet();

    public static void prepareData(CustomerDao customerDao, AddressDao addressDao, int numberOfRecords) {

        // clean up the tables
        addressDao.deleteAll();
        customerDao.deleteAll();

        // create new customers
        for (int i = 0; i < numberOfRecords; i++) {
            customerDao.save(CustomerHelper.createCustomer());
        }
        // verify customers table is populated
        assertEquals("Incorrect number of records in customers table!", numberOfRecords, customerDao.getRecordsCount());

        // create an address for each customer
        for (int id : customerDaoResultSet.getCustomerIds()) {
            Address address = AddressHelper.createAddress();
            address.setCustomerId(id);
            addressDao.save(address);
        }
        // verify customers_addresses table is populated
        assertEquals("Incorrect number of records in customers_addresses table!", numberOfRecords, addressDao.getRecordsCount());
    }
}
