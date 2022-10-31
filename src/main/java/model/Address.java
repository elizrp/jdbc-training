package model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address implements Serializable {

    @Column(name = "id")
    private @NonNull int id;
    @Column(name = "customer_id")
    private @NonNull int customerId;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private @NonNull String city;
    @Column(name = "province")
    private String province;
    @Column(name = "state")
    private String state;
    @Column(name = "postal_code")
    private @NonNull Integer postalCode;
    @Column(name = "country")
    private @NonNull String country;
}
