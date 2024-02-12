package DAO;

import Factory.OwnSessionFactory;
import Entities.Passenger ;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import java.util.List;

public class PassengerDao implements DAO{



    @Override
    public boolean save(Object passenger) {
        boolean isAdded = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.save(passenger);
            trans.commit();
            session.close();
            isAdded = true;
            System.out.println("save");
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public boolean update(Object passenger) {
        boolean isUpdated = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.update(passenger);
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
    public boolean delete(Object passenger) {
        boolean isDeleted = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.delete(passenger);
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
        Transaction trans = session.beginTransaction();
        List<Object> passengers= (List<Object>) session.createQuery("FROM Passenger ").list();
        trans.commit();
        session.close();
        return passengers;
    }

    @Override
    public Object findById(int id) {
        Passenger passenger = null;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            passenger=session.find(Passenger.class,id);
            trans.commit();
            session.close();
        }
        catch (NoResultException e) {
            System.out.println("User not found!");
        }
        return passenger;
    }



    public List findbyuserid( Integer id){

        Session session = OwnSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Object> passengers = session.createQuery("FROM Passenger where userId=:id").setParameter("id",id).list();
        trans.commit();
        session.close();
        return passengers;
    }

    public List findbypasport( String pasport){

        Session session = OwnSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Object> passengers = session.createQuery("FROM Passenger where passport=:pasport").setParameter("pasport",pasport).list();
        trans.commit();
        session.close();
        return passengers;
    }

    public List passengerByUser(Integer id){

        Session session = OwnSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Object> passengers =  session.createQuery("FROM Passenger where user.id=:id ")
                .setParameter("id",id)
                .list();
        trans.commit();
        session.close();
        return passengers;
    }

}

