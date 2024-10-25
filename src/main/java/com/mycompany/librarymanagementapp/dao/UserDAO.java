/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.librarymanagementapp.utils.HibernateUtil;
import com.mycompany.librarymanagementapp.model.*;
import java.util.List;
import org.hibernate.query.Query;
/**
 *
 * @author ddd
 */
public class UserDAO {

    // luu user moi
    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // lay user theo id
    public User getUserById(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // lay ra tat ca user
    public List<User> getAllUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User", User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // cap nhat thong tin user
    public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // xoa user
    public void deleteUser(int userId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, userId);
            if (user != null) {
                session.delete(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // tim user theo username
    public User getUserByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from User where username = :username";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("username", username);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
