package ru.javawebinar.basejava.model;

public enum ContactType {
    phone("Тел."),
    skype("Skype"),
    email("Почта"),
    linkedin("Профиль LinkedIn"),
    github("Профиль GitHub"),
    stackowerflow("Профиль StackOwerflow"),
    hompage("Домашняя страница");

    final String type;

    ContactType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
