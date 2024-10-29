/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp.dao;

import com.mycompany.librarymanagementapp.model.BorrowerRule;
import com.mycompany.librarymanagementapp.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
/**
 *
 * @author ddd
 */
public class BorrowerRuleDAO {

    // them moi quy dinh cho nguoi muon
    public void saveBorrowerRule(BorrowerRule borrowerRule) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(borrowerRule);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // cap nhat quy dinh
    public void updateBorrowerRule(BorrowerRule borrowerRule) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(borrowerRule);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // lay ra quy dinh theo id
    public BorrowerRule getBorrowerRuleById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(BorrowerRule.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // lay tat ca quy dinh
    public List<BorrowerRule> getAllBorrowerRules() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<BorrowerRule> query = session.createQuery("from BorrowerRule", BorrowerRule.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // xoa quy dinh theo id
    public void deleteBorrowerRule(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            BorrowerRule borrowerRule = session.get(BorrowerRule.class, id);
            if (borrowerRule != null) {
                session.delete(borrowerRule);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    // tim quy dinh theo loai quy dinh danh cho giang vien hoac sinh vien
    public BorrowerRule getBorrowerRuleByType(String borrowerType) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<BorrowerRule> query = session.createQuery("from BorrowerRule where borrowerType = :borrowerType", BorrowerRule.class);
            query.setParameter("borrowerType", borrowerType);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
