/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp.dao;

import com.mycompany.librarymanagementapp.model.Teacher;
import com.mycompany.librarymanagementapp.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
/**
 *
 * @author ddd
 */
public class TeacherDAO {

    // them giang vien moi
    public void saveTeacher(Teacher teacher) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(teacher);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Cap nhat thong tin giang vien
    public void updateTeacher(Teacher teacher) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(teacher);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // xoa giang vien
    public void deleteTeacher(int teacherId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Teacher teacher = session.get(Teacher.class, teacherId);
            if (teacher != null) {
                session.delete(teacher);
                System.out.println("Teacher is deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // tim giang vien theo id
    public Teacher getTeacherById(int teacherId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Teacher.class, teacherId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // lay tat ca giang vien
    public List<Teacher> getAllTeachers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Teacher", Teacher.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // tim giang vien theo ma
    public Teacher getTeacherByCode(String teacherCode) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Teacher where teacherCode = :teacherCode";
            return session.createQuery(hql, Teacher.class)
                          .setParameter("teacherCode", teacherCode)
                          .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // tim giang vien theo khoa
    public List<Teacher> getTeachersByDepartment(String department) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Teacher where department = :department";
            return session.createQuery(hql, Teacher.class)
                          .setParameter("department", department)
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
