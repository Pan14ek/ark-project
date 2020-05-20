package ua.nure.makieiev.factory.intermediate.iot.model;

import java.util.Objects;

public class Role {

    private long id;
    private String title;
    private String symbol;
    private String description;

    public Role() {
    }

    public Role(long id, String title, String symbol, String description) {
        this.id = id;
        this.title = title;
        this.symbol = symbol;
        this.description = description;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(title, role.title) &&
                Objects.equals(symbol, role.symbol) &&
                Objects.equals(description, role.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, symbol, description);
    }

}