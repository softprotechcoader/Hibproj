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
        s1.setName("Mira V.");
        s1.setAge(29);
        s1.setRollno(7);


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.softprotechcoder.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();


//        ***************************Update Statement***********
//        session.merge(s1); // for any data change we need to use Transaction that's why it didn't worked.
        Transaction transaction = session.beginTransaction();
        session.merge(s1); // for merge even we provide new data which is not existing in case it will insert it.
        transaction.commit();
        // now it should work

        session.close(); // closing session
        sf.close(); // closing SessionFactory

        System.out.println(s1);




    }
}