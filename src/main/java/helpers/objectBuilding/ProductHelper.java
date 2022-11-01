package helpers.objectBuilding;

import com.github.javafaker.Faker;
import model.Address;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductHelper {

    private static Faker faker = new Faker();

    public static Product createProduct() {
        return Product.builder()
                .name(faker.commerce().productName())
                .availableQuantity(faker.number().randomDigitNotZero())
                .type(faker.commerce().productName())
                .priceWithoutVat(Double.parseDouble(faker.commerce().price()))
                .isProductInStock(faker.bool().bool())
                .warehouse(faker.address().country())
                .build();
    }

    public static List<Product> createProducts(int numberOfProducts) {

        List<Product> products = new ArrayList<>();

        while (numberOfProducts > 0) {
            products.add(createProduct());
            numberOfProducts--;
        }
        return products;
    }
}
