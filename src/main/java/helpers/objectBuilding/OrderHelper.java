package helpers.objectBuilding;

import com.github.javafaker.Faker;
import model.Address;
import model.Order;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderHelper {

    private static Faker faker = new Faker();

    public static Order createOrder() {
        return Order.builder()
                .customer(faker.name().fullName())
                .isOrderCompleted(faker.bool().bool())
                .isOrderPaid(faker.bool().bool())
                .dateOfOrder(Date.valueOf(LocalDate.now()))
                .dateOfOrderCompleted(Date.valueOf(LocalDate.now()))
                .build();
    }

    public static List<Order> createOrders(int numberOfOrders) {

        List<Order> orders = new ArrayList<>();

        while (numberOfOrders > 0) {
            orders.add(createOrder());
            numberOfOrders--;
        }
        return orders;
    }
}
