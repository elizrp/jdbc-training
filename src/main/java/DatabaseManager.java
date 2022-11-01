import dao.CustomerDao;
import dao.CustomerDaoDBUtils;
import model.Customer;

public class DatabaseManager {

    private static CustomerDao customerDao;

    public static void main(String[] args) {

        customerDao = new CustomerDaoDBUtils();
        Customer customer = customerDao.getById(11);
        System.out.println(customer.toString());

    }
}
