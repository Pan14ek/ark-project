package ua.nure.makieiev.ark.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserInfo implements Serializable {

    private static final long serialVersionUID = 7307220895621788916L;

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
        if (!(o instanceof UserInfo)) return false;
        UserInfo userInfo = (UserInfo) o;
        return getUnitId() == userInfo.getUnitId() &&
                Objects.equals(getToken(), userInfo.getToken()) &&
                Objects.equals(getLogin(), userInfo.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getToken(), getLogin(), getUnitId());
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "token='" + token + '\'' +
                ", login='" + login + '\'' +
                ", unitId=" + unitId +
                '}';
    }

}