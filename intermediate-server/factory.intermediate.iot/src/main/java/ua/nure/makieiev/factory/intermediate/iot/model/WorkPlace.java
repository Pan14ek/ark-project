package ua.nure.makieiev.factory.intermediate.iot.model;

import java.util.Objects;

public class WorkPlace {

    private long id;
    private String title;
    private int size;
    private Unit unit;

    public WorkPlace() {
    }

    public WorkPlace(long id, String title, int size, Unit unit) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.unit = unit;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkPlace workPlace = (WorkPlace) o;
        return id == workPlace.id &&
                size == workPlace.size &&
                Objects.equals(title, workPlace.title) &&
                Objects.equals(unit, workPlace.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, size, unit);
    }

}