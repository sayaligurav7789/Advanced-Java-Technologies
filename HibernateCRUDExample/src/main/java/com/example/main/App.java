package com.example.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.entity.Student;
import com.example.util.HibernateUtil;

public class App {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // CREATE
            Transaction tx = session.beginTransaction();
            Student s1 = new Student("Sayali", "Sayali@gmail.com", 21);
            session.persist(s1); // ✅ Replaces save()
            tx.commit();
            System.out.println("Student added: " + s1);

            
            // READ
            Student s2 = session.get(Student.class, s1.getId());
            System.out.println("Fetched Student: " + s2);

            // UPDATE
            tx = session.beginTransaction();
            s2.setEmail("Sayali@gmail.com");
            session.merge(s2); // ✅ Replaces update()
            tx.commit();
            System.out.println("Student updated: " + s2);

          // DELETE (Optional)
         
          tx = session.beginTransaction();
          session.remove(s2); // ✅ Replaces delete()
          tx.commit();
          System.out.println("Student deleted.");
        

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}