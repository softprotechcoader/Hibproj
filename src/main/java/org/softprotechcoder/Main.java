package org.softprotechcoder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Student s1 = new Student();
        s1.setName("Sarah");
        s1.setAge(23);
        s1.setRollno(11);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.softprotechcoder.Student.class);
        cfg.configure();
//        SessionFactory sf = null;
        SessionFactory sf = cfg.buildSessionFactory(); // this will give object of SessionFactory.
//        Session session = null ;      // Session is an interface. we can't create an object of it.
        Session session = sf.openSession();
        /* here as we can't create direct obj of Session so SessionFactory is required  but SessionFactory is
        * also an interface for this case we have to create and obj of Configurantion from hibernate. */
        Transaction tx = session.beginTransaction();
        session.persist(s1);
        tx.commit();
        System.out.println(s1);
    }
}