package ua.nure.makieiev.factory.intermediate.iot.model;

import java.util.Objects;

public class Unit {

    private long id;
    private String title;
    private String description;
    private String status;

    public Unit() {
    }

    public Unit(long id, String title, String description, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return id == unit.id &&
                Objects.equals(title, unit.title) &&
                Objects.equals(description, unit.description) &&
                Objects.equals(status, unit.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, status);
    }

}