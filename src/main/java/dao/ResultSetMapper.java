package dao;

import org.apache.commons.beanutils.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultSetMapper<T> {

    private static final Logger logger = Logger.getLogger(ResultSetMapper.class.getName());

    /**
     * Maps database returned objects to T objects.
     *
     * @param resultSet   the result from SQL query
     * @param outputClass the class to be mapped to
     * @return a list of T objects
     */
    public List<T> mapResultSetToMultipleObjects(ResultSet resultSet, Class outputClass) {

        List<T> outputList = null;

        try {
            // make sure resultSet is not null
            if (resultSet != null) {
                // make sure outputClass has 'Entity' annotation
                if (outputClass.isAnnotationPresent(Entity.class)) {
                    // get resultSet metadata
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    // get all attributes of outputClass
                    Field[] fields = outputClass.getDeclaredFields();
                    // iterate over the results from the db
                    while (resultSet.next()) {
                        // create new object of type T
                        T bean = (T) outputClass.getConstructor().newInstance();
                        for (int iterator = 0; iterator < metaData.getColumnCount(); iterator++) {
                            // get the SQL column name
                            String columnName = metaData.getColumnName(iterator + 1);
                            // read the value of the SQL column
                            Object columnValue = resultSet.getObject(iterator + 1);
                            // iterate over outputClass attributes to check if any attribute has 'Column' annotation with matching 'name' value
                            for (Field field : fields) {
                                if (field.isAnnotationPresent(Column.class)) {
                                    Column column = field.getAnnotation(Column.class);
                                    if (column.name().equalsIgnoreCase(columnName) && columnValue != null) {
                                        BeanUtils.setProperty(bean, field.getName(), columnValue);
                                        break;
                                    }
                                }
                            }
                        }
                        if (outputList == null) {
                            outputList = new ArrayList<T>();
                        }
                        outputList.add(bean);
                    }

                } else {
                    logger.log(Level.WARNING, "ResultSet is empty. Please check if database table is empty");
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return outputList;
    }

    /**
     * Maps a database returned object to a single T object.
     *
     * @param resultSet   the result from SQL query
     * @param outputClass the class to be mapped to
     * @return a T object
     */
    public T mapResultSetToSingleObject(ResultSet resultSet, Class outputClass) {

        T outputObject = null;

        try {
            // make sure resultSet is not null
            if (resultSet != null) {
                // make sure outputClass has 'Entity' annotation
                if (outputClass.isAnnotationPresent(Entity.class)) {
                    // get resultSet metadata
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    // get all attributes of outputClass
                    Field[] fields = outputClass.getDeclaredFields();
                    if (resultSet.next()) {
                        // create new object of type T
                        outputObject = (T) outputClass.getConstructor().newInstance();
                        for (int iterator = 0; iterator < metaData.getColumnCount(); iterator++) {
                            // get the SQL column name
                            String columnName = metaData.getColumnName(iterator + 1);
                            // read the value of the SQL column
                            Object columnValue = resultSet.getObject(iterator + 1);
                            // iterate over outputClass attributes to check if any attribute has 'Column' annotation with matching 'name' value
                            for (Field field : fields) {
                                if (field.isAnnotationPresent(Column.class)) {
                                    Column column = field.getAnnotation(Column.class);
                                    if (column.name().equalsIgnoreCase(columnName) && columnValue != null) {
                                        BeanUtils.setProperty(outputObject, field.getName(), columnValue);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    logger.log(Level.WARNING, "ResultSet is empty. Please check if database table is empty");
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return outputObject;
    }
}
