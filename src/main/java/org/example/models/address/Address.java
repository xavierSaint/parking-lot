package org.example.models.address;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {
    String city;
    String state;
    String country;
}
