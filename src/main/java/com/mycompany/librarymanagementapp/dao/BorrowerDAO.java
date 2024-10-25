/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp.dao;

import com.mycompany.librarymanagementapp.model.Borrower;
import com.mycompany.librarymanagementapp.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author ddd
 */
public class BorrowerDAO {

    // them moi nguoi muon
    public void saveBorrower(Borrower borrower) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(borrower);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // cap nhat thog tin nguoi muon
    public void updateBorrower(Borrower borrower) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(borrower);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // lay nguoi muon theo id
    public Borrower getBorrowerById(Integer borrowerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Borrower.class, borrowerId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // lay tat ca ngươi muon
    public List<Borrower> getAllBorrowers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Borrower";
            return session.createQuery(hql, Borrower.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // tim nguoi muon theo kieu nguoi muon
    public List<Borrower> getBorrowersByType(String borrowerType) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Borrower where borrowerType = :borrowerType";
            return session.createQuery(hql, Borrower.class)
                          .setParameter("borrowerType", borrowerType)
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // xoa nguoi muon
    public void deleteBorrower(Borrower borrower) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(borrower);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    // tim nguoi muon theo ten
    public List<Borrower> getBorrowerByName(String fullName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Borrower where student.fullName = :fullName or teacher.fullName = :fullName";
            return session.createQuery(hql, Borrower.class)
                          .setParameter("fullName", fullName)
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // tim nguoi muon theo 1 phan ten
    public List<Borrower> searchBorrowerByPartialName(String partialName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Borrower where student.fullName like :partialName or teacher.fullName like :partialName";
            return session.createQuery(hql, Borrower.class)
                          .setParameter("partialName", "%" + partialName + "%")
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // tim nguoi muon theo lop cua sinh vien
    public List<Borrower> findBorrowerByStudentClass(String studentClass) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Borrower b where b.student.studentClass = :studentClass";
            return session.createQuery(hql, Borrower.class)
                          .setParameter("studentClass", studentClass)
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // tim nguoi muon theo 1 phan lop cua sinh vien
    public List<Borrower> findBorrowerByPartialStudentClass(String studentClass) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Borrower b where b.student.studentClass like :studentClass";
            return session.createQuery(hql, Borrower.class)
                          .setParameter("studentClass", "%" + studentClass + "%")
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // tim nguoi muon theo msv
    public List<Borrower> findBorrowerByStudentCode(String studentCode) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Borrower b where b.student.studentCode = :studentCode";
            return session.createQuery(hql, Borrower.class)
                          .setParameter("studentCode", studentCode)
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // tim nguoi muon theo 1 phan ma sinh vien
    public List<Borrower> findBorrowerByPartialStudentCode(String studentCode) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Borrower b where b.student.studentCode like :studentCode";
            return session.createQuery(hql, Borrower.class)
                          .setParameter("studentCode", "%" + studentCode + "%")
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // tim nguoi muon theo khoa cua giang vien
    public List<Borrower> findBorrowerByTeacherDepartment(String teacherDepartment) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Borrower b where b.teacher.teacherDepartment = :teacherDepartment";
            return session.createQuery(hql, Borrower.class)
                          .setParameter("teacherDepartment", teacherDepartment)
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // tim nguoi muon theo 1 phan khoa cua giang vien
    public List<Borrower> findBorrowerByPartialTeacherDepartment(String teacherDepartment) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Borrower b where b.teacher.teacherDepartment like :teacherDepartment";
            return session.createQuery(hql, Borrower.class)
                          .setParameter("teacherDepartment", "%" + teacherDepartment + "%")
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // tim nguoi muon theo ma giang vien
    public List<Borrower> findBorrowerByTeacherCode(String teacherCode) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Borrower b where b.teacher.teacherCode = :teacherCode";
            return session.createQuery(hql, Borrower.class)
                          .setParameter("teacherCode", teacherCode)
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // tim nguoi muon theo 1 phan ma giang vien
    public List<Borrower> findBorrowerByPartialTeacherCode(String teacherCode) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Borrower b where b.teacher.teacherCode like :teacherCode";
            return session.createQuery(hql, Borrower.class)
                          .setParameter("teacherCode", "%" + teacherCode + "%")
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
