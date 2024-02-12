package DAO;

import Factory.OwnSessionFactory;
import Entities.Service ;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import java.util.List;

public class ServiceDao implements DAO{
    @Override
    public boolean save(Object service) {
        boolean isAdded = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.save(service);
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
    public boolean update(Object service) {
        boolean isUpdated = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.update(service);
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
    public boolean delete(Object service) {
        boolean isDeleted = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.delete(service);
            trans.commit();
            session.close();
            isDeleted = true;
        }
        catch (EntityNotFoundException e){
            System.out.println("Service not found!");
        }
        return isDeleted;
    }

    @Override
    public List findAll() {
        Session session= OwnSessionFactory.getSessionFactory().
                openSession();
        List<Object> services= (List<Object>) session.createQuery("FROM Service ").list();
        session.close();
        return services;
    }

    @Override
    public Object findById(int id) {
        Service service=null;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            service=session.find(Service.class,id);
            trans.commit();
            session.close();
        }
        catch (NoResultException e) {
            System.out.println("Service not found!");
        }
        return service;
    }

    public List servicesbyflID(Integer id){

        Session session = OwnSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Object> tickets =  session.createQuery("FROM Service where flight.id=:id ")
                .setParameter("id",id)
                .list();
        trans.commit();
        session.close();
        return tickets;
    }
}
