package ua.nure.makieiev.factory.intermediate.iot.model;

import java.util.Objects;

public class UserPlace {

    private long id;
    private WorkPlace workPlace;
    private User user;

    public UserPlace() {
    }

    public UserPlace(long id, WorkPlace workPlace, User user) {
        this.id = id;
        this.workPlace = workPlace;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WorkPlace getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(WorkPlace workPlace) {
        this.workPlace = workPlace;
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
        UserPlace userPlace = (UserPlace) o;
        return id == userPlace.id &&
                Objects.equals(workPlace, userPlace.workPlace) &&
                Objects.equals(user, userPlace.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workPlace, user);
    }

}