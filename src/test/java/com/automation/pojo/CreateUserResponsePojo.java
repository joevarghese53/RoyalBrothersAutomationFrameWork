package com.automation.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CreateUserResponsePojo{
    long createdAt;
    String name;
    String email;
    double salary;
    int age;
    String id;
}
