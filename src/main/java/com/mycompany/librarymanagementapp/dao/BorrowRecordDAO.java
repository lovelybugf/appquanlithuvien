/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp.dao;

import com.mycompany.librarymanagementapp.model.BorrowRecord;
import com.mycompany.librarymanagementapp.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;
/**
 *
 * @author ddd
 */
public class BorrowRecordDAO {

    // them ban ghi muon
    public void saveBorrowRecord(BorrowRecord borrowRecord) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(borrowRecord);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // cap nhat ban ghi muon
    public void updateBorrowRecord(BorrowRecord borrowRecord) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(borrowRecord);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // lay ban ghi muon theo id
    public BorrowRecord getBorrowRecordById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(BorrowRecord.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // lay tat ca ban ghi muon
    public List<BorrowRecord> getAllBorrowRecords() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<BorrowRecord> query = session.createQuery("from BorrowRecord", BorrowRecord.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // xoa ban ghi muon theo id
    public void deleteBorrowRecord(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            BorrowRecord borrowRecord = session.get(BorrowRecord.class, id);
            if (borrowRecord != null) {
                session.delete(borrowRecord);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // lay danh sach ban ghi muon theo id nguoi muon
    public List<BorrowRecord> getBorrowRecordsByBorrower(int borrowerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<BorrowRecord> query = session.createQuery("from BorrowRecord where borrower.borrowerId = :borrowerId", BorrowRecord.class);
            query.setParameter("borrowerId", borrowerId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // lay tat ca phieu muon theo id nguoi muon
    public List<BorrowRecord> getBorrowRecordsByBook(int bookId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<BorrowRecord> query = session.createQuery("from BorrowRecord where book.bookId = :bookId", BorrowRecord.class);
            query.setParameter("bookId", bookId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // lay tat ca ban ghi muon qua han tra
    public List<BorrowRecord> getOverdueBorrowRecords() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<BorrowRecord> query = session.createQuery("from BorrowRecord where dueDate < :currentDate and status = 0", BorrowRecord.class);
            query.setParameter("currentDate", new Date());
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
