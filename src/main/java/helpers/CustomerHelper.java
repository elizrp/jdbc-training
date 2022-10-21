package helpers;

import com.github.javafaker.Faker;
import model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Class CustomerHelper contains methods for creating one or more Customer objects,
 * sample data is generated using JavaFaker
 */
public class CustomerHelper {

    private static Faker faker = new Faker();

    private static Customer customer;

    public static Customer createSingleCustomer() {

        customer = Customer.builder()
                .id(faker.number().randomDigitNotZero())
                .name(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .phone(faker.phoneNumber().cellPhone())
                .age(faker.number().numberBetween(18, 100))
                .gdprConsentStatus(faker.bool().bool())
                .customerProfileStatus(faker.bool().bool())
                .profileCreatedDate(faker.date().future(1, TimeUnit.DAYS))
                .profileDeactivatedDate(faker.date().future(1, TimeUnit.DAYS))
                .deactivationReason(faker.lorem().characters())
                .notes(faker.lorem().characters())
                .build();

        return customer;
    }

    public static List<Customer> createMultipleCustomers(int numberOfCustomers) {

        List<Customer> customers = new ArrayList<>();

        while (numberOfCustomers > 0) {
            customer = Customer.builder()
                    .id(faker.number().randomDigitNotZero())
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .phone(faker.phoneNumber().cellPhone())
                    .age(faker.number().numberBetween(18, 100))
                    .gdprConsentStatus(faker.bool().bool())
                    .customerProfileStatus(faker.bool().bool())
                    .profileCreatedDate(faker.date().future(1, TimeUnit.DAYS))
                    .profileDeactivatedDate(faker.date().future(1, TimeUnit.DAYS))
                    .deactivationReason(faker.lorem().characters())
                    .notes(faker.lorem().characters())
                    .build();

            customers.add(customer);

            numberOfCustomers--;
        }

        return customers;
    }
}
