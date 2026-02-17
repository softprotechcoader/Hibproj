package org.softprotechcoder;

public class Laptop {

    private int SrId;
    private String brand;
    private String ram;
    private String os;

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

    @Override
    public String toString() {
        return "Laptop{" +
                "SrId=" + SrId +
                ", brand='" + brand + '\'' +
                ", ram='" + ram + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
