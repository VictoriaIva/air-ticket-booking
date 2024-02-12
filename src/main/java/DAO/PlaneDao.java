package DAO;

import Factory.OwnSessionFactory;
import Entities.Plane ;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import java.util.List;

public class PlaneDao implements DAO {
    @Override
    public boolean save(Object plane) {
        boolean isAdded = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.save(plane);
            trans.commit();
            session.close();
            isAdded = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public boolean update(Object plane) {
        boolean isUpdated = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.update(plane);
            trans.commit();
            session.close();
            isUpdated = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return isUpdated;

    }

    @Override
    public boolean delete(Object plane) {
        boolean isDeleted = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.delete(plane);
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
    public List<Object> findAll() {
        Session session=OwnSessionFactory.getSessionFactory().
                openSession();
        List<Object> planes= (List<Object>) session.createQuery("FROM Plane ").list();
        session.close();

        return planes;
    }


    @Override
    public Object findById(int id) {
        Plane plane=null;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            plane=session.find(Plane.class,id);
            trans.commit();
            session.close();
        }
        catch (NoResultException e) {
            System.out.println("User not found!");
        }
        return plane;
    }


}
