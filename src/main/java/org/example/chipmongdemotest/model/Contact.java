package org.example.chipmongdemotest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private Long id;
    private String address1;
    private String district;
    private String amphur;
    private String province;
    private String postalCode1;
    private String telephone;
    private String fax;

    private String address2;
    private String city;
    private String stateProvince;
    private String postalCode2;
    private String country;
    private String contactPerson;
    private String email;
}
