package com.epam.task.fourth.entitity;

import java.util.Objects;

public class OldCards {
    private Address address;
    private String author;

    public OldCards(Address inputAddress, String inputAuthor){
        address = inputAddress;
        author = inputAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OldCards oldCards = (OldCards) o;

        if (!Objects.equals(address, oldCards.address)) return false;
        return Objects.equals(author, oldCards.author);
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    public OldCards() {

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
