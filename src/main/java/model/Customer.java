package model;

import lombok.*;

import java.util.Date;
import java.io.Serializable;

/**
 * Class Customer constructed as JavaBean,
 * class variables have the same data types as columns in the database,
 * uses lombok annotations for code optimization,
 * annotation @AllArgsConstructor is necessary for the @Builder annotation
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Customer implements Serializable {

    private @NonNull int id;
    private @NonNull String name;
    private @NonNull String email;
    private @NonNull String phone;
    private @Builder.Default int age = 99;
    private @NonNull boolean gdprConsentStatus;
    private @NonNull boolean customerProfileStatus;
    private @NonNull Date profileCreatedDate;
    private Date profileDeactivatedDate;
    private String deactivationReason;
    private String notes;

    // Modify toString() method to make the output more readable
    @Override
    public String toString() {
        return "Customer info: {\n" +
                "id = " + id + ",\n" +
                "name = " + name + ",\n" +
                "email = " + email + ",\n" +
                "phone = " + phone + ",\n" +
                "age = " + age + ",\n" +
                "gdprConsentStatus = " + gdprConsentStatus + ",\n" +
                "customerProfileStatus = " + customerProfileStatus + ",\n" +
                "profileCreatedDate = " + profileCreatedDate + ",\n" +
                "profileDeactivatedDate = " + profileDeactivatedDate + ",\n" +
                "deactivationReason = " + deactivationReason + ",\n" +
                "notes = " + notes + "\n" +
                "}";
    }
}
