package DAO;

import Factory.OwnSessionFactory;
import Entities.Ticket ;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import java.util.List;

public class TicketDao implements DAO{
    @Override
    public boolean save(Object ticket) {
        boolean isAdded = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.save(ticket);
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
    public boolean update(Object ticket) {
        boolean isUpdated = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.update(ticket);
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
    public boolean delete(Object ticket) {
        boolean isDeleted = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.delete(ticket);
            trans.commit();
            session.close();
            isDeleted = true;
        }
        catch (EntityNotFoundException e){
            System.out.println("Ticket not found!");
        }
        return isDeleted;
    }

    @Override
    public List<Object> findAll() {
        Session session= OwnSessionFactory.getSessionFactory().
                openSession();
        List<Object> tickets=  session.createQuery("FROM Ticket ").list();
        session.close();
        return tickets;
    }

    @Override
    public Object findById(int id) {
        Ticket ticket=null;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            ticket=session.find(Ticket.class,id);
            trans.commit();
            session.close();
        }
        catch (NoResultException e) {
            System.out.println("Ticket not found!");
        }
        return ticket;
    }


    public List ticketsbyflID(Integer id){

        Session session = OwnSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Object> tickets =  session.createQuery("FROM Ticket where flight.id=:id ")
                .setParameter("id",id)
                .list();

        trans.commit();
        session.close();
        return tickets;
    }

    public List ticketsbyPasID(Integer id){

        Session session = OwnSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Object> tickets =  session.createQuery("FROM Ticket where passenger.id=:id ")
                .setParameter("id",id)
                .list();
        trans.commit();
        session.close();
        return tickets;
    }
}