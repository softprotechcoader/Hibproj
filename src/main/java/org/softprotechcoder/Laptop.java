package org.softprotechcoder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Laptop {
    @Id
    private int SrId;
    private String brand;
    private String ram;
    private String os;
//    @ManyToOne // many laptops can be assigned to one alean.
    @ManyToMany(mappedBy = "laptops")//MappedBy -> on giving this reference laptops will be responsible for mapping.
    // many laptops can be assigned to many alean.
    private List<Aliean> alieans;

    public int getSrId() {
        return SrId;
    }

    public void setSrId(int srId) {
        SrId = srId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public List<Aliean> getAlieans() {
        return alieans;
    }

    public void setAlieans(List<Aliean> alieans) {
        this.alieans = alieans;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "SrId=" + SrId +
                ", brand='" + brand + '\'' +
                ", ram='" + ram + '\'' +
                ", os='" + os + '\'' +
                '}';
//        / its better to avoid relationship in toStrings
    }
}
