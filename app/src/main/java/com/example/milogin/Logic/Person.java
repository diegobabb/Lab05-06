package com.example.milogin.Logic;

import java.io.Serializable;

public class Person implements Serializable
{
    private String firstname;
    private String lastname;
    private String street_address;
    private String street_address_2;
    private String city;
    private String state;
    private int zip;
    private String country;
    private String email;
    private int area_code;
    private int phone;

    public Person(String firstname, String lastname, String street_address, String street_address_2, String city, String state, int zip, String country, String email, int area_code, int phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.street_address = street_address;
        this.street_address_2 = street_address_2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.email = email;
        this.area_code = area_code;
        this.phone = phone;
    }

    public Person(){
        this("","","","","","",0,"","",0,0);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getStreet_address_2() {
        return street_address_2;
    }

    public void setStreet_address_2(String street_address_2) {
        this.street_address_2 = street_address_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getArea_code() {
        return area_code;
    }

    public void setArea_code(int area_code) {
        this.area_code = area_code;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", street_address='" + street_address + '\'' +
                ", street_address_2='" + street_address_2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", area_code=" + area_code +
                ", phone=" + phone +
                '}';
    }
}
