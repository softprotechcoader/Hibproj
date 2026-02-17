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
     /*   s1.setName("Mira V.");
        s1.setAge(29);
        s1.setRollno(7);*/


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.softprotechcoder.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
//        ****** Deleting data from Db ****

        s1= session.find(Student.class,1);  // fetching data from db
        Transaction transaction = session.beginTransaction();
        session.remove(s1); // passing it in remove or another option is to provide
        // all details in student obj and pass it in remove.
        transaction.commit();




        session.close(); // closing session
        sf.close(); // closing SessionFactory

        System.out.println(s1);




    }
}