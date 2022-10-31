package model;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;

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

    private Product product;
}
