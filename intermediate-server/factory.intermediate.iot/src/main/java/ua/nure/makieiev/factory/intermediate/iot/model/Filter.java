package ua.nure.makieiev.factory.intermediate.iot.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Filter {

    private long id;
    private String title;
    private BigDecimal diameter;
    private String filterType;

    public Filter() {
    }

    public Filter(long id, String title, BigDecimal diameter, String filterType) {
        this.id = id;
        this.title = title;
        this.diameter = diameter;
        this.filterType = filterType;
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

    public BigDecimal getDiameter() {
        return diameter;
    }

    public void setDiameter(BigDecimal diameter) {
        this.diameter = diameter;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filter filter = (Filter) o;
        return id == filter.id &&
                Objects.equals(title, filter.title) &&
                Objects.equals(diameter, filter.diameter) &&
                Objects.equals(filterType, filter.filterType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, diameter, filterType);
    }

}