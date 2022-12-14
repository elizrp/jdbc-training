package dao.daoMappers;

import constants.SqlQueries;
import dao.baseDaos.AddressDao;
import helpers.daoHelpers.DBUtilsMapperHelper;
import model.Address;

import java.util.List;

public class AddressDaoDBUtils extends AddressDao implements SqlQueries {

    private static DBUtilsMapperHelper<Address> dbUtilsHelper = new DBUtilsMapperHelper<>(Address.class);

    /**
     * Extracts a single address from the database by ID.
     * Uses Apache DBUtils ResultSetHandler for mapping db data to pojo.
     *
     * @param id the id of the address
     * @return Address object
     */
    @Override
    public Address getById(int id) {
        return dbUtilsHelper.getById(id, GET_ADDRESS_BY_ID);
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
        return dbUtilsHelper.getByIds(ids, GET_ADDRESSES_BY_IDS);
    }

    /**
     * Retrieves an Address object by given customerId
     *
     * @param customerId the id of the customer which corresponds to this address
     * @return Address object
     */
    public Address getByCustomerId(int customerId) {
        return dbUtilsHelper.getById(customerId, GET_ADDRESS_BY_CUSTOMER_ID);
    }
}
