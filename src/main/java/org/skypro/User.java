package org.skypro;

import java.util.Objects;

public class User {

    private String login;
    private String email;
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+$";

    public User() {

    }

    public User(String login, String email) {
        setLogin(login);
        setEmail(email);
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        if (login == null || login.isEmpty() || login.isBlank() || login.equals(this.email)) {
            throw new IllegalArgumentException();
        }
        this.login = login;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty() || email.isBlank() || !email.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException();
        }
        this.email = email;
    }

}