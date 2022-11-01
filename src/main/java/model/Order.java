package model;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Column(name = "id")
    private @NonNull int id;
    @Column(name = "customer_id")
    private @NonNull int customerId;
    @Column(name = "customer")
    private @NonNull String customer;
    @Column(name = "is_order_completed")
    private @NonNull boolean isOrderCompleted;
    @Column(name = "is_order_paid")
    private @NonNull boolean isOrderPaid;
    @Column(name = "date_of_order")
    private @NonNull Date dateOfOrder;
    @Column(name = "date_of_order_completed")
    private Date dateOfOrderCompleted;

    private List<Product> products;

    @Override
    public String toString() {
        return "Order info: {" +
                "id = \'" + id + "\',\n" +
                "customer_id = \'" + customerId + "\',\n" +
                "customer = \'" + customer + "\',\n" +
                "is_order_completed = \'" + isOrderCompleted + "\',\n" +
                "is_order_paid = \'" + isOrderPaid + "\',\n" +
                "date_of_order = \'" + dateOfOrder + "\',\n" +
                "date_of_order_completed = \'" + dateOfOrderCompleted + "\',\n" +
                "products = \'" + products + "\'\n}";
    }
}
