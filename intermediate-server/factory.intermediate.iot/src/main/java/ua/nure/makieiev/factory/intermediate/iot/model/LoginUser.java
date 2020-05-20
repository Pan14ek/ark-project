package ua.nure.makieiev.factory.intermediate.iot.model;

import java.util.Objects;

public class LoginUser {

    private String login;
    private String password;

    public LoginUser() {
    }

    public LoginUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginUser loginUser = (LoginUser) o;
        return Objects.equals(login, loginUser.login) &&
                Objects.equals(password, loginUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

}