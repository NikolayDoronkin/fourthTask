package com.epam.task.fourth.entitity;

import java.util.Objects;

public class Address {
    private String country;
    private String city;
    private String street;
    private int numberOfBuild;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (numberOfBuild != address.numberOfBuild) return false;
        if (!Objects.equals(country, address.country)) return false;
        if (!Objects.equals(city, address.city)) return false;
        return Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        int result = country != null ? country.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + numberOfBuild;
        return result;
    }

    public Address() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Address(String country, String city, String street, int number) {
        this.country = country;
        this.city = city;
        this.street = street;
        numberOfBuild = number;
    }

    public int getNumberOfBuild() {
        return numberOfBuild;
    }

    public void setNumberOfBuild(int numberOfBuild) {
        this.numberOfBuild = numberOfBuild;
    }
}
