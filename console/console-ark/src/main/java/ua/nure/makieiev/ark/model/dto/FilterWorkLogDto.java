package ua.nure.makieiev.ark.model.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class FilterWorkLogDto {

    private String token;
    private long unitId;
    private String temperature;
    private BigDecimal filterContamination;

    public FilterWorkLogDto(long unitId) {
        this.unitId = unitId;
    }

    public FilterWorkLogDto(String token, long unitId, String temperature, BigDecimal filterContamination) {
        this.token = token;
        this.unitId = unitId;
        this.temperature = temperature;
        this.filterContamination = filterContamination;
    }

    public long getUnitId() {
        return unitId;
    }

    public String getTemperature() {
        return temperature;
    }

    public BigDecimal getFilterContamination() {
        return filterContamination;
    }

    public void setUnitId(long unitId) {
        this.unitId = unitId;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setFilterContamination(BigDecimal filterContamination) {
        this.filterContamination = filterContamination;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilterWorkLogDto that = (FilterWorkLogDto) o;
        return getUnitId() == that.getUnitId() &&
                Objects.equals(getToken(), that.getToken()) &&
                Objects.equals(getTemperature(), that.getTemperature()) &&
                Objects.equals(getFilterContamination(), that.getFilterContamination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getToken(), getUnitId(), getTemperature(), getFilterContamination());
    }

}