package ua.nure.makieiev.factory.intermediate.iot.model;

import java.util.Objects;

public class UserToken {

    private String token;
    private User user;

    public UserToken() {
    }

    public UserToken(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserToken userToken = (UserToken) o;
        return Objects.equals(token, userToken.token) &&
                Objects.equals(user, userToken.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, user);
    }

}