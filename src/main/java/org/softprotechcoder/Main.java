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
    Student s1 = new Student();
        s1.setName("Vishal");
        s1.setAge(29);
        s1.setRollno(30);

//        For Fetching Data of Student
        Student s2 = null;   // s2 Object

//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(org.softprotechcoder.Student.class);
//        cfg.configure();   // all above 3 line can we merged into one line
//        SessionFactory sf = null;
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.softprotechcoder.Student.class)
                .configure()
                .buildSessionFactory();
//        SessionFactory sf = cfg.buildSessionFactory(); // this will give object of SessionFactory.
//        Session session = null ;      // Session is an interface. we can't create an object of it.
        Session session = sf.openSession();
        /* here as we can't create direct obj of Session so SessionFactory is required  but SessionFactory is
        * also an interface for this case we have to create and obj of Configuration from hibernate. */

//        Transaction tx = session.beginTransaction();  // not required for fetching data from db
//        session.persist(s1);
//        tx.commit();                         // not require as performing get operation which do not have dependency on it .


// Fetching Operation from DB

           s2 = session.find(Student.class,25);

        session.close(); // closing session
        sf.close(); // closing SessionFactory
//        System.out.println(s1);
//        System.out.println("Data Updated in Sql.");

        System.out.println("Fetching Date from SQL");
        System.out.println(s2);


    }
}