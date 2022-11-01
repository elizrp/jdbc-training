package model;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class Customer constructed as JavaBean,
 * class variables have the same data types as columns in the database,
 * uses lombok annotations for code optimization,
 * annotation @AllArgsConstructor is necessary for the @Builder annotation
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer implements Serializable {

    @Column(name = "id")
    private @NonNull int id;
    @Column(name = "name")
    private @NonNull String name;
    @Column(name = "email")
    private @NonNull String email;
    @Column(name = "phone")
    private @NonNull String phone;
    @Column(name = "age")
    private @Builder.Default int age = 99;
    @Column(name = "gdpr_consent_status")
    private @NonNull boolean gdprConsentStatus;
    @Column(name = "customer_profile_status")
    private @NonNull boolean customerProfileStatus;
    @Column(name = "profile_created_date")
    private @NonNull Date profileCreatedDate;
    @Column(name = "profile_deactivated_date")
    private Date profileDeactivatedDate;
    @Column(name = "deactivation_reason")
    private String deactivationReason;
    @Column(name = "notes")
    private String notes;

    private Address address;
    private List<Order> orders;

    @Override
    public String toString() {
        return "Customer info: {" +
                "id = \'" + id + "\',\n" +
                "name = \'" + name + "\',\n" +
                "email = \'" + email + "\',\n" +
                "phone = \'" + phone + "\',\n" +
                "age = \'" + age + "\',\n" +
                "gdprConsentStatus = \'" + gdprConsentStatus + "\',\n" +
                "customerProfileStatus = \'" + customerProfileStatus + "\',\n" +
                "profileCreatedDate = \'" + profileCreatedDate + "\',\n" +
                "profileDeactivatedDate = \'" + profileDeactivatedDate + "\',\n" +
                "deactivationReason = \'" + deactivationReason + "\',\n" +
                "notes = \'" + notes + "\'\n" +
                "address = \'" + address + "\',\n" +
                "orders = \'" + orders + "\'\n}";
    }
}