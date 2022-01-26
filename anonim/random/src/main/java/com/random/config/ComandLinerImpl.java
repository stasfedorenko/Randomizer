package com.random.config;

import com.random.DAO.StudentDAO;
import com.random.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
public class ComandLinerImpl implements CommandLineRunner {
    //
//    EntityManagerFactory entityManagerFactory;
//
//    @Autowired
//    public ComandLinerImpl(EntityManagerFactory entityManagerFactory) {
//        this.entityManagerFactory = entityManagerFactory;
//    }
    StudentDAO studentDAO;

    @Autowired
    public ComandLinerImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            createStudentEntity(new Student());
        }

    }

    private void createStudentEntity(Student student) {
        student.setB_teamId(2);
        student.setC_name("Dmitriy");
        student.setD_surname("Borisov");
        studentDAO.save(student);

//        Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            student.setB_teamId(2);
//            student.setC_name("Dmitriy");
//            student.setD_surname("Borisov");
//            session.save(student);
//            tx.commit();
//        } catch (HibernateException ex) {
//            if (tx != null) {
//                tx.rollback();
//            } else {
//                ex.printStackTrace();
//            }
//        }

    }
}
