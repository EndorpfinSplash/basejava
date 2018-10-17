package ru.javawebinar.basejava.model;

public enum ContactType {
    phoneHome("Home phone"),
    phoneWork("Work phone"),
    skype("skype"),
    email("email");

    final String type;

    ContactType(String type) {
        this.type = type;
    }
}
