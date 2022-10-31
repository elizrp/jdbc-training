package dao;

import constants.SqlQueries;
import helpers.DBUtilsMapperHelper;
import model.Address;

import java.util.List;

public class AddressDaoDBUtils extends AddressDao implements SqlQueries {

    private static DBUtilsMapperHelper<Address> dbUtilsHelper = new DBUtilsMapperHelper<>();

    /**
     * Extracts a single customer from the database by ID.
     * Uses Apache DBUtils ResultSetHandler for mapping db data to pojo.
     *
     * @param id the id of the address
     * @return Address object
     */
    @Override
    public Address getById(int id) {
        return dbUtilsHelper.getById(id, CUSTOMERS_ADDRESSES_TABLE, Address.class);
    }

    /**
     * Extracts a list of objects from the database by a List of IDs.
     * Uses Apache DBUtils ResultSetHandler for mapping db data to pojo.
     *
     * @param ids a list of address ids
     * @return a list of Address objects
     */
    @Override
    public List<Address> getByIds(List<Integer> ids) {
        return dbUtilsHelper.getByIds(ids, CUSTOMERS_ADDRESSES_TABLE, Address.class);
    }
}
