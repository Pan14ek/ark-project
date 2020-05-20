package ua.nure.makieiev.factory.intermediate.iot.model;

import java.util.Objects;

public class UserInfo {

    private String token;
    private String login;
    private long unitId;

    public UserInfo() {
    }

    public UserInfo(String token, String login, long unitId) {
        this.token = token;
        this.login = login;
        this.unitId = unitId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getUnitId() {
        return unitId;
    }

    public void setUnitId(long unitId) {
        this.unitId = unitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return unitId == userInfo.unitId &&
                Objects.equals(token, userInfo.token) &&
                Objects.equals(login, userInfo.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, login, unitId);
    }

}