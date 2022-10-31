package helpers.objectBuilding;

import com.github.javafaker.Faker;
import model.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Class AddressHelper contains methods for creating one or more Address objects,
 * sample data is generated using JavaFaker
 */
public class AddressHelper {

    private static Faker faker = new Faker();

    public static Address createAddress() {
        return Address.builder()
                .address(faker.address().fullAddress())
                .city(faker.address().cityName())
                .province(faker.address().cityName())
                .state(faker.address().state())
                .postalCode(Integer.parseInt(faker.address().countryCode()))
                .country(faker.address().country())
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
