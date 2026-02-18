package org.softprotechcoder;

import jakarta.persistence.*;

import java.util.List;
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
    @OneToMany    // used to create one-to-many relationship in db
    // as one Alean can have many laptop so its one-to-many relationship so used list of laptops.
    private List<Laptop> laptops;

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

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Aliean{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", atech='" + atech + '\'' +
                ", laptops=" + laptops +
                '}';
    }
}
