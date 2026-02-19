package com.example;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

}