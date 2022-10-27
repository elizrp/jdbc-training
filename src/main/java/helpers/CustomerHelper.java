package helpers;

import com.github.javafaker.Faker;
import model.Customer;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class CustomerHelper contains methods for creating one or more Customer objects,
 * sample data is generated using JavaFaker
 */
public class CustomerHelper {

    private static Faker faker = new Faker();

    public static Customer createCustomer() {
        return Customer.builder()
                .name(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .phone(faker.phoneNumber().cellPhone())
                .age(faker.number().numberBetween(18, 100))
                .gdprConsentStatus(faker.bool().bool())
                .customerProfileStatus(faker.bool().bool())
                .profileCreatedDate(Date.valueOf(LocalDate.now()))
                .profileDeactivatedDate(Date.valueOf(LocalDate.now()))
                .deactivationReason(faker.lorem().characters())
                .notes(faker.lorem().characters())
                .build();
    }

    public static List<Customer> createCustomers(int numberOfCustomers) {
        List<Customer> customers = new ArrayList<>();
        while (numberOfCustomers > 0) {
            customers.add(createCustomer());
            numberOfCustomers--;
        }
        return customers;
    }
}
