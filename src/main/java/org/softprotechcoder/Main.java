package org.softprotechcoder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ast.tree.expression.JsonObjectAggUniqueKeysBehavior;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*How to set Laptop complex type data and configure*/
        Laptop l1 = new Laptop();
               l1.setSrId(1001);
               l1.setBrand("HP");
               l1.setRam("8GB");
               l1.setOs("Windows 10");

        Laptop l2 = new Laptop();
                l2.setSrId(1002);
                l2.setBrand("Dell");
                l2.setRam("6GB");
                l2.setOs("Windows 8");

        Laptop l3 = new Laptop();
                l3.setSrId(1003);
                l3.setBrand("Apple");
                l3.setRam("16GB");
                l3.setOs("Mac");


        Aliean a1 = new Aliean();
                a1.setAid(700);
                a1.setAname("Ayush");
                a1.setAtech("Java");
                a1.setLaptops(Arrays.asList(l1,l2)); // as it is list type we have to use Arrays.asList.

        Aliean a2 = new Aliean();
                a2.setAid(701);
                a2.setAname("Ashutosh");
                a2.setAtech("Cloud");
                a2.setLaptops(Arrays.asList(l2,l3));

         Aliean a3 = new Aliean();
                a3.setAid(702);
                a3.setAname("Subhash");
                a3.setAtech("React");
                a3.setLaptops(List.of(l3));
/*
* When do not want additional table for referring alean and laptop table as in this case
* both the laptop belongs same alean.
* in the previous case it was creating another table with composite key's
* */
//        l1.setAlieans(a1);
//        l2.setAlieans(a1);
//        l2.setAlieans(a2);
//        l3.setAlieans(a3);
        l1.setAlieans(List.of(a1));
        l2.setAlieans(Arrays.asList(a1,a2));
        l3.setAlieans(List.of(a3));


        a1.setLaptops(Arrays.asList(l1,l2));
        a2.setLaptops(Arrays.asList(l2,l3));
        a3.setLaptops(List.of(l3));


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.softprotechcoder.Aliean.class)
                .addAnnotatedClass(org.softprotechcoder.Laptop.class) // need to add this class also.
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);
        transaction.commit();
/*Fetching all details*/
        Aliean alean = session.find(Aliean.class,700);
        System.out.println(alean);


        session.close(); // closing session
        sf.close(); // closing SessionFactory

/* Observation : Its firing insert query instead of select needs to be figured out */

    }
}