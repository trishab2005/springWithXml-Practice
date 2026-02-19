package com.example;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Person {
    private String name;
    private int age;
    private Address address;

}