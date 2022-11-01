package dao;

import constants.SqlQueries;
import helpers.DaoHelper;
import model.Address;

import java.util.List;
import java.util.logging.Logger;

public abstract class AddressDao implements DAO<Address>, SqlQueries {

    public static final Logger logger = Logger.getLogger(AddressDao.class.getName());
    private static DaoHelper daoHelper = new DaoHelper();

    /**
     * Inserts/Saves a new address in the table.
     *
     * @param address address to be inserted/saved
     */
    @Override
    public void save(Address address) {
        daoHelper.save(String.format(INSERT_ADDRESS, 8, address.getAddress(), address.getCity(),
                address.getProvince(), address.getState(), address.getPostalCode(), address.getCountry()));
    }

    /**
     * Updates data of an address.
     *
     * @param address   address object with properties to be used for the update
     * @param addressId id of the address to be updated
     */
    @Override
    public void update(Address address, int addressId) {
        daoHelper.update(String.format(UPDATE_ADDRESS, address.getAddress(), address.getCity(),
                address.getProvince(), address.getState(), address.getPostalCode(), address.getCountry(), addressId));
    }

    /**
     * Deletes an address from the table.
     *
     * @param addressId id of the address to be deleted
     */
    @Override
    public void delete(int addressId) {
        daoHelper.delete(addressId, CUSTOMERS_ADDRESSES_TABLE);
    }

    /**
     * Deletes all data from customers_addresses table.
     */
    @Override
    public void deleteAll() {
        daoHelper.deleteAll(CUSTOMERS_ADDRESSES_TABLE);
    }

    /**
     * Retrieves a random id from customers_addresses table.
     *
     * @return random id of address
     */
    @Override
    public int getRandomId() {
        return daoHelper.getRandomId(CUSTOMERS_ADDRESSES_TABLE);
    }

    /**
     * Retrieves a list of random ids from customers_addresses table.
     *
     * @param numberOfIds number of ids to be retrieved
     * @return a list of random ids
     */
    @Override
    public List<Integer> getRandomIds(int numberOfIds) {
        return daoHelper.getRandomIds(numberOfIds, CUSTOMERS_ADDRESSES_TABLE);
    }

    /**
     * Finds the total count of records in customers_addresses table.
     *
     * @return count of all records in customers_addresses table
     */
    @Override
    public int getRecordsCount() {
        return daoHelper.getRecordsCount(CUSTOMERS_ADDRESSES_TABLE);
    }

    /**
     * Retrieves an Address object by given customerId
     *
     * @param customerId the id of the customer which corresponds to this address
     * @return Address object
     */
    public abstract Address getByCustomerId(int customerId);
}
