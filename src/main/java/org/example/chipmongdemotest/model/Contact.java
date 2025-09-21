package org.example.chipmongdemotest.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private Long id;

    // --- Primary Address ---
    @NotBlank(message = "Address is required")
    private String address1;

    @NotNull(message = "Province is required")
    private Long provinceId;

    @NotNull(message = "Amphur is required")
    private Long amphurId;

    @NotNull(message = "District is required")
    private Long districtId;

    @NotBlank(message = "Postal Code is required")
    @Pattern(regexp = "\\d{5}", message = "Postal Code must be 5 digits")
    private String postalCode1;

    @NotBlank(message = "Telephone is required")
    @Pattern(regexp = "^[0-9\\-+]{7,15}$", message = "Telephone must be valid")
    private String telephone;

    @NotBlank(message = "Fax is required")
    @Pattern(regexp = "^[0-9\\-+]{7,15}$", message = "Fax must be valid")
    private String fax;

    // --- Secondary Address ---
    @NotBlank(message = "Address is required")
    private String address2;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State/Province is required")
    private String stateProvince;

    @NotBlank(message = "Postal Code is required")
    @Pattern(regexp = "\\d{5}", message = "Postal Code must be 5 digits")
    private String postalCode2;

    @NotBlank(message = "Country is required")
    private String country;

    // --- Contact Person Info ---
    @NotBlank(message = "Contact Person is required")
    private String contactPerson;

    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email address")
    private String email;

    // --- Extra fields for display ---
    private String provinceName;
    private String amphurName;
    private String districtName;
}
