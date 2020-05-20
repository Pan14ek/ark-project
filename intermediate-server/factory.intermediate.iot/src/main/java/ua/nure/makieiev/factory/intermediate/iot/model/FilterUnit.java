package ua.nure.makieiev.factory.intermediate.iot.model;

import java.time.LocalDate;
import java.util.Objects;

public class FilterUnit {

    private long id;
    private Filter filter;
    private Unit unit;
    private LocalDate dateInstall;
    private String status;
    private LocalDate dateRemoval;

    public FilterUnit() {
    }

    public FilterUnit(long id, Filter filter, Unit unit, LocalDate dateInstall, String status, LocalDate dateRemoval) {
        this.id = id;
        this.filter = filter;
        this.unit = unit;
        this.dateInstall = dateInstall;
        this.status = status;
        this.dateRemoval = dateRemoval;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public LocalDate getDateInstall() {
        return dateInstall;
    }

    public void setDateInstall(LocalDate dateInstall) {
        this.dateInstall = dateInstall;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateRemoval() {
        return dateRemoval;
    }

    public void setDateRemoval(LocalDate dateRemoval) {
        this.dateRemoval = dateRemoval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilterUnit that = (FilterUnit) o;
        return id == that.id &&
                Objects.equals(filter, that.filter) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(dateInstall, that.dateInstall) &&
                Objects.equals(status, that.status) &&
                Objects.equals(dateRemoval, that.dateRemoval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filter, unit, dateInstall, status, dateRemoval);
    }

}
