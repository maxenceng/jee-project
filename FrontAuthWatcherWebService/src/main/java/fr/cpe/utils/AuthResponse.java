package fr.cpe.utils;

public class AuthResponse {
    private boolean validAuth;
    private String role;
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isValidAuth() {
        return validAuth;
    }

    public void setValidAuth(boolean validAuth) {
        this.validAuth = validAuth;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAll(String login, String role) {
        this.validAuth = true;
        this.role = role;
        this.login = login;
    }
}
