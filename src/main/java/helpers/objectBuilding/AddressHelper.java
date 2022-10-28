package helpers;

import com.github.javafaker.Faker;
import model.Address;
import model.Customer;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressHelper {

    private static Faker faker = new Faker();

    public static Address createAddress() {
        return Address.builder()
                .address(faker.address().fullAddress())
                .city(faker.address().cityName())
                .province(faker.address().cityName())
                .state(faker.address().state())
                .postalCode(faker.address().bool().bool())
                .customerProfileStatus(faker.bool().bool())
                .profileCreatedDate(Date.valueOf(LocalDate.now()))
                .profileDeactivatedDate(Date.valueOf(LocalDate.now()))
                .deactivationReason(faker.lorem().characters())
                .notes(faker.lorem().characters())
                .build();
    }

    public static List<Address> createAddresses(int numberOfAddresses) {

        List<Address> addresses = new ArrayList<>();

        while (numberOfAddresses > 0) {
            addresses.add(createAddress());
            numberOfAddresses--;
        }
        return addresses;
    }
}
