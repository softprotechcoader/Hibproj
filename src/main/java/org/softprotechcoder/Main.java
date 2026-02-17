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

        Aliean a1 = new Aliean();
                a1.setAid(700);
                a1.setAname("Ayush");
                a1.setAtech("Java");


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.softprotechcoder.Aliean.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(a1);
        transaction.commit();



        session.close(); // closing session
        sf.close(); // closing SessionFactory



    }
}