package Entities;
import Entities.Employee;
import Entities.Flight;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="service")
public abstract class Service {
    private int id;
    private Employee employee;
    private Flight flight;

    public Service(){}

    public Service(Employee employee, Flight flight) {
        this.employee = employee;
        this.flight = flight;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeID", nullable = false)
    public Employee getEmployee() {return employee;}
    public void setEmployee(Employee employee) {this.employee = employee;}


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flightID", nullable = false)
    public Flight getFlight() {return flight;}

    public void setFlight(Flight flight) {this.flight = flight;}


}
