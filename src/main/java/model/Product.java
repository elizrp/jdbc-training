package model;

import lombok.*;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Column(name = "id")
    private @NonNull int id;
    @Column(name = "supplier_id")
    private @NonNull int supplierId;
    @Column(name = "product_name")
    private @NonNull String name;
    @Column(name = "available_quantity")
    private @NonNull int availableQuantity;
    @Column(name = "product_type")
    private @NonNull String type;
    @Column(name = "price_without_VAT")
    private @NonNull double priceWithoutVat;
    @Column(name = "price_with_VAT")
    private @NonNull double priceWithVat;
    @Column(name = "is_product_in_stock")
    private @NonNull boolean isProductInStock;
    @Column(name = "warehouse")
    private @NonNull String warehouse;

    @Override
    public String toString() {
        return "Product info: {" +
                "id = \'" + id + "\',\n" +
                "supplier_id = \'" + supplierId + "\',\n" +
                "product_name = \'" + name + "\',\n" +
                "available_quantity = \'" + availableQuantity + "\',\n" +
                "product_type = \'" + type + "\',\n" +
                "price_without_VAT = \'" + priceWithoutVat + "\',\n" +
                "price_with_VAT = \'" + priceWithVat + "\',\n" +
                "is_product_in_stock = \'" + isProductInStock + "\'\n" +
                "warehouse = \'" + warehouse + "\'\n}";
    }
}
