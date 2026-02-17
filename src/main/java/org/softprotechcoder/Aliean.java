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

    @Override
    public String toString() {
        return "Aliean{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", atech='" + atech + '\'' +
                '}';
    }
}
