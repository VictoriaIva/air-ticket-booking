package DAO;

import Factory.OwnSessionFactory;
import Entities.Flight ;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class FlightDao implements DAO{
    @Override
    public boolean save(Object flight) {
        boolean isAdded = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.save(flight);
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
    public boolean update(Object flight) {
        boolean isUpdated = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.update(flight);
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
    public boolean delete(Object flight) {
        boolean isDeleted = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.delete(flight);
            trans.commit();
            session.close();
            isDeleted = true;
        }
        catch (EntityNotFoundException e){
            System.out.println("Flight not found!");
        }
        return isDeleted;
    }

    @Override
    public List<Object> findAll() {
        Session session=OwnSessionFactory.getSessionFactory().openSession();
        List<Object> flights= session.createQuery("FROM Flight ").list();
        session.close();
        return flights;
    }

    public List findAllStudentsWithJpql() {
        Session session=OwnSessionFactory.getSessionFactory().openSession();
        return session.createQuery("SELECT f FROM Flight f", Flight.class).getResultList();
    }


    @Override
    public Object findById(int id) {
        Flight flight = null;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            flight=session.find(Flight.class,id);
            trans.commit();
            session.close();
        }
        catch (NoResultException e) {
            System.out.println("Flight not found!");
        }
        return flight;
    }


    public List flightsByDestination(String destinstion){

        Session session = OwnSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Object> flights =  session.createQuery("FROM Flight where destination=:destinstion ")
                .setParameter("destinstion",destinstion)
                .list();

        trans.commit();
        session.close();
        return flights;
    }

    public List flightsByArrDate(Timestamp arrivalDate){

        Session session = OwnSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Object> flights =  session.createQuery("FROM Flight where arrivalDate=:arrivalDate ")
                .setParameter("arrivalDate",arrivalDate)
                .list();

        trans.commit();
        session.close();
        return flights;
    }

    public List flightsByDepDate(Timestamp departureDate){

        Session session = OwnSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Object> flights =  session.createQuery("FROM Flight where departureDate=:departureDate ")
                .setParameter("departureDate",departureDate)
                .list();

        trans.commit();
        session.close();
        return flights;
    }

    public List flightsByPrice(Double flightPrice1,Double flightPrice2 ){

        Session session = OwnSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Object> flights =  session.createQuery("FROM Flight where  flightPrice>:flightPrice1 and flightPrice<:flightPrice2 ")
                .setParameter("flightPrice1",flightPrice1).setParameter("flightPrice2",flightPrice2)
                .list();

        trans.commit();
        session.close();
        return flights;
    }
    public List FlightsbyPlID(Integer id){

        Session session = OwnSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Object> flights =  session.createQuery("FROM Flight where plane.id=:id ")
                .setParameter("id",id)
                .list();

        trans.commit();
        session.close();
        return flights;
    }


}
