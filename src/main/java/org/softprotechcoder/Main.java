package org.softprotechcoder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ast.tree.expression.JsonObjectAggUniqueKeysBehavior;

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

        Aliean a1 = new Aliean();
                a1.setAid(700);
                a1.setAname("Ayush");
                a1.setAtech("Java");
                a1.setLaptop(l1);


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.softprotechcoder.Aliean.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(a1);
        transaction.commit();
/*Fetching all details*/
        Aliean a2 = session.find(Aliean.class,700);
        System.out.println(a2);


        session.close(); // closing session
        sf.close(); // closing SessionFactory

/* Observation : Its firing insert query instead of select needs to be feagured out */

    }
}