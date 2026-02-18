package org.softprotechcoder;

import jakarta.persistence.*;
// if its required to keep the class name as it is and change the Entity name as bydefault entity name = table name.
//@Entity(name = "alean_table")

@Entity
@Table(name= "alean_table")
public class Aliean {

    @Id
    private int aid;

    /*
     * In case we need to change column name we can use @Column(name = "alean_name")
     * */
    @Column(name = "alean_name")
    private String aname;
    /*
     * In case we want to skip any column name we can use @Transient annotation. sometime while building
     * application, this type of thing might be needed for processing.
     * */
    @Transient
    private String atech;

    /*
     * In case we don't want to create a separate table we can use this complex type defined in Laptop class.
     * With annotation  @Embedded so column will extend the same Aliean Table.
     *  */
    @OneToOne    // used to create one-to-one relationship in db
    private Laptop laptop;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAtech() {
        return atech;
    }

    public void setAtech(String atech) {
        this.atech = atech;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Aliean{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", atech='" + atech + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}
