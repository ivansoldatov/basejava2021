package com.ocp.webapp.model;

public enum ContactType {
    PHONE("Телефон"),
    MAIL("Почта"),
    GITHUB("GitHub"),
    SKYPE("Skype"),
    LINKEDIN("LinkedIn"),
    HOMEPAGE("Домашняя страница");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
