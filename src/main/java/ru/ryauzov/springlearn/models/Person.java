package ru.ryauzov.springlearn.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty(message = "Name should be not empty")
    @Size(min = 2, max = 30, message = "Name length must be greater than 2 and less than 30 characters")
    private String name;
    @Min(value = 0, message = "Invalid age value: age should be greater than 0")
    private int age;
    @NotEmpty(message = "Invalid input email: email should be not empty")
    @Email(message = "email should be a valid")
    private String email;

    public Person() {}

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
