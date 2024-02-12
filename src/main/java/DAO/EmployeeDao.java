package DAO;

import Factory.OwnSessionFactory;
import Entities.Employee ;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;

import java.util.List;

public class EmployeeDao implements DAO{
    @Override
    public boolean save(Object employee) {
        boolean isAdded = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.save(employee);
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
    public boolean update(Object employee) {
        boolean isUpdated = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.update(employee);
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
    public boolean delete(Object employee) {
        boolean isDeleted = false;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.delete(employee);
            trans.commit();
            session.close();
            isDeleted = true;
        }
        catch (EntityNotFoundException e){
            System.out.println("Employee not found!");
        }
        return isDeleted;
    }

    @Override
    public List findAll() {
        Session session=OwnSessionFactory.getSessionFactory().openSession();
        List<Object> employees = (List<Object>) session.createQuery("FROM Employee ").list();
        session.close();
        return employees;
    }

    @Override
    public Object findById(int id) {
        Employee employee = null;
        try {
            Session session = OwnSessionFactory.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            employee =session.find(Employee.class,id);
            trans.commit();
            session.close();
        }
        catch (NoResultException e) {
            System.out.println("Employee not found!");
        }
        return employee;
    }
}
