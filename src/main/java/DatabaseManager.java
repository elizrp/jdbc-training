import dao.baseDaos.CustomerDao;
import dao.daoMappers.CustomerDaoDBUtils;

public class DatabaseManager {

    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDaoDBUtils();
        System.out.println(customerDao.getById(11).toString());
    }
}
