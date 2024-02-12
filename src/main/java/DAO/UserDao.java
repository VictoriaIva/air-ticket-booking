package DAO;

import Factory.OwnSessionFactory;
import Entities.User ;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.List;



public class UserDao implements DAO {
    @Override
    public boolean save(Object user) {
        boolean isAdded = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.save(user);
            trans.commit();
            session.close();
            isAdded = true;
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        return isAdded;

    }

    @Override
    public boolean update(Object user) {
        boolean isUpdated = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.update(user);
            trans.commit();
            session.close();
            isUpdated = true;
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        return isUpdated;

    }

    @Override
    public boolean delete(Object user) {
        boolean isDeleted = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.delete(user);
            trans.commit();
            session.close();
            isDeleted = true;
        }
        catch (EntityNotFoundException e){
            System.out.println("User not found!");
        }
        return isDeleted;

    }

    @Override
    public List findAll() {
        Session session=OwnSessionFactory.getSessionFactory().
                openSession();
        List<Object> users =  session.createQuery("FROM User ").list();
        session.close();
        return users;
    }

    @Override
    public User findById(int id) {
        User user=null;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            user=session.find(User.class,id);
            trans.commit();
            session.close();
        }
        catch (NoResultException e) {
            System.out.println("User not found!");
        }
        return user;
    }

    public List userloginpass(String login, String password){

            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            List<Object> users =  session.createQuery("FROM User where login=:log and password=:pass").setParameter("log",login)
                    .setParameter("pass",password).list();

            trans.commit();
            session.close();
        return users;
    }
    public List userlogin( String login){

        Session session = OwnSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Object> users =  session.createQuery("FROM User where login=:log").setParameter("log",login)
                .list();

        trans.commit();
        session.close();
        return users;
    }


    @Override
    public String toString() {
        return "UserDao{}";
    }
}
