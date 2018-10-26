package fr.cpe.models;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String login;
    private String pwd;
    private String lastName;
    private String surName;
    private String role;

    public UserModel() {}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserModel ["
                + "login: "
                + this.login
                + ", lastName: "
                + this.lastName
                + ", surName: "
                + this.surName
                + ", role: "
                + this.role
                + "]";
    }
}
