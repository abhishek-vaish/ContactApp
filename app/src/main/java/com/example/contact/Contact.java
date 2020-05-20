package com.example.contact;

public class Contact {
    String name;
    String email;
    String number;
    String title;

    public Contact() {
    }

    public Contact(String name, String email, String number, String title) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
