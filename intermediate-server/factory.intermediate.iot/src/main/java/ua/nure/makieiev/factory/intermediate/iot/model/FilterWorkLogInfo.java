package ua.nure.makieiev.factory.intermediate.iot.model;

import java.math.BigDecimal;
import java.util.Objects;

public class FilterWorkLogInfo {

    private long filterUnitId;
    private String scanDateTime;
    private String temperature;
    private BigDecimal filterContamination;

    public FilterWorkLogInfo() {
    }

    public FilterWorkLogInfo(long filterUnitId, String scanDateTime, String temperature, BigDecimal filterContamination) {
        this.filterUnitId = filterUnitId;
        this.scanDateTime = scanDateTime;
        this.temperature = temperature;
        this.filterContamination = filterContamination;
    }

    public long getFilterUnitId() {
        return filterUnitId;
    }

    public void setFilterUnitId(long filterUnitId) {
        this.filterUnitId = filterUnitId;
    }

    public String getScanDateTime() {
        return scanDateTime;
    }

    public void setScanDateTime(String scanDateTime) {
        this.scanDateTime = scanDateTime;
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
        FilterWorkLogInfo that = (FilterWorkLogInfo) o;
        return filterUnitId == that.filterUnitId &&
                Objects.equals(scanDateTime, that.scanDateTime) &&
                Objects.equals(temperature, that.temperature) &&
                Objects.equals(filterContamination, that.filterContamination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filterUnitId, scanDateTime, temperature, filterContamination);
    }

}
