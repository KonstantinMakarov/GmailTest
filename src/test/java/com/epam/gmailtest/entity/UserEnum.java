package com.epam.gmailtest.entity;

/**
 * Created by Kanstantsin_Makarau on 12/1/2014.
 */
public enum UserEnum {
    User1("epamlab.user1@gmail.com","labuser1"),
    User2("epamlab.user2@gmail.com","labuser2"),
    User3("epamlab.user3@gmail.com","labuser3");

    private String email;
    private String password;

    UserEnum(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
