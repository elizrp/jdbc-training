package model;

import lombok.*;

import javax.persistence.Column;
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
    private @NonNull int postalCode;
    @Column(name = "country")
    private @NonNull String country;

    @Override
    public String toString() {
        return "Address info: {" +
                "id = \'" + id + "\',\n" +
                "customer_id = \'" + customerId + "\',\n" +
                "address = \'" + address + "\',\n" +
                "city = \'" + city + "\',\n" +
                "province = \'" + province + "\',\n" +
                "state = \'" + state + "\',\n" +
                "postal_code = \'" + postalCode + "\',\n" +
                "country = \'" + country + "\'\n}";
    }
}
