package fr.cpe.models;

import javax.persistence.*;

// User model linked to users table in DB
@Entity
@Table(name="users")
@NamedQuery(name = "Users.list", query = "select u from User u")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "surName")
    private String surName;

    @Column(name = "role")
    private String role;

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
        return "User ["
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
