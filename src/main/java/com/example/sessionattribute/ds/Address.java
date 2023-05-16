package com.example.sessionattribute.ds;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {

    private String streetName;
    private String streetNumber;
    private String country;
    private String zipCode;
}
