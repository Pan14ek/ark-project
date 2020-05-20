package ua.nure.makieiev.factory.intermediate.iot.model;

import java.math.BigDecimal;
import java.util.Objects;

public class FilterWorkLogDto {

    private String token;
    private long unitId;
    private String temperature;
    private BigDecimal filterContamination;

    public FilterWorkLogDto() {
    }

    public FilterWorkLogDto(String token, long unitId, String temperature, BigDecimal filterContamination) {
        this.token = token;
        this.unitId = unitId;
        this.temperature = temperature;
        this.filterContamination = filterContamination;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getUnitId() {
        return unitId;
    }

    public void setUnitId(long unitId) {
        this.unitId = unitId;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getFilterContamination() {
        return filterContamination;
    }

    public void setFilterContamination(BigDecimal filterContamination) {
        this.filterContamination = filterContamination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilterWorkLogDto that = (FilterWorkLogDto) o;
        return unitId == that.unitId &&
                Objects.equals(temperature, that.temperature) &&
                Objects.equals(filterContamination, that.filterContamination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitId, temperature, filterContamination);
    }

}