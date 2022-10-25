package dao;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao<T> {

    public void save(T object);

    public void update(T object, int customerId);

    public void delete(T object, int customerId);

    public void deleteAll();

    public int getRandomId();

    public List<Integer> getRandomIds(int numberOfIds);

    public int getRecordsCount();

    public T getById(int id);

    public List<T> getByIds(List<Integer> ids);
}