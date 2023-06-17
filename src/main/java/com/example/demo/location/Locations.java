package com.example.demo.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Locations {

    @Id
    private Integer locationId;
    @Column
    private String streetAddress;
    @Column
    private String postalCode;
    @Column
    private String city;
    @Column
    private String stateProvince;
    @Column
    private String countryId;

}
