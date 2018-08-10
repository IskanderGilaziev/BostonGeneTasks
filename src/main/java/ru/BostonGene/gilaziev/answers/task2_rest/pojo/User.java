package ru.BostonGene.gilaziev.answers.task2_rest.pojo;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;



@XmlRootElement()
public class User {

    private  Long id;
    private  String name;
    private  String lastName;
    private  String date;
    private  String email;
    private  String password;

    public User() {
    }


    public User(Long id, String name, String lastName, String date, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.date = date;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date=" + date +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
