/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp.dao;

import com.mycompany.librarymanagementapp.model.Student;
import com.mycompany.librarymanagementapp.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
/**
 *
 * @author ddd
 */
public class StudentDAO {

    // them sinh vien moi
    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // cap nhat thog tin sinh vien
    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // lay tat ca sinh vien
    public List<Student> getAllStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Student";
            return session.createQuery(hql, Student.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // lay sinh vien theo msv
    public Student getStudentByCode(String studentCode) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Student where studentCode = :studentCode";
            return session.createQuery(hql, Student.class)
                          .setParameter("studentCode", studentCode)
                          .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // xoa sinh vien
    public void deleteStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
