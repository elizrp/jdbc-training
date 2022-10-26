package dao;

import java.sql.Connection;
import java.util.List;

public interface DAO<T> {

    void save(T object);

    void update(T object, int customerId);

    void delete(int customerId);

    void deleteAll();

    int getRandomId();

    List<Integer> getRandomIds(int numberOfIds);

    int getRecordsCount();

    T getById(int id);

    List<T> getByIds(List<Integer> ids);
}