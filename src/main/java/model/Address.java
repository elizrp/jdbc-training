package model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public class Address implements Serializable {

    @Column(name = "id")
    private @NonNull int id;

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
}
