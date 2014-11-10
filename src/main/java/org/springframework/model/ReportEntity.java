package org.springframework.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Администратор on 10.11.2014.
 */
@Entity
@Table(name = "report", schema = "", catalog = "kazgidro")
public class ReportEntity {
    private int reportid;
    private int temperature;
    private String wind;
    private Timestamp datetime;

    @Id
    @Column(name = "reportid", nullable = false, insertable = true, updatable = true)
    public int getReportid() {
        return reportid;
    }

    public void setReportid(int reportid) {
        this.reportid = reportid;
    }

    @Basic
    @Column(name = "temperature", nullable = false, insertable = true, updatable = true)
    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Basic
    @Column(name = "wind", nullable = false, insertable = true, updatable = true, length = 45)
    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    @Basic
    @Column(name = "datetime", nullable = false, insertable = true, updatable = true)
    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReportEntity that = (ReportEntity) o;

        if (reportid != that.reportid) return false;
        if (temperature != that.temperature) return false;
        if (datetime != null ? !datetime.equals(that.datetime) : that.datetime != null) return false;
        if (wind != null ? !wind.equals(that.wind) : that.wind != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reportid;
        result = 31 * result + temperature;
        result = 31 * result + (wind != null ? wind.hashCode() : 0);
        result = 31 * result + (datetime != null ? datetime.hashCode() : 0);
        return result;
    }
}
