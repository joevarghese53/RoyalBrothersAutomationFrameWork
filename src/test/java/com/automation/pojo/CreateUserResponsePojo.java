package com.automation.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CreateUserResponsePojo {
    String name;
    String email;
    double salary;
    int age;
    long createdAt;
    String id;
}
