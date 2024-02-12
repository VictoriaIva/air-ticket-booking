package Entities;

import jakarta.persistence.*;

import jakarta.persistence.JoinColumn;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Flight {

    private int id;
    private String flightNumber;
    private Plane plane;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private Double flightPrice;
   // private transient Set<Passenger> passengers=new HashSet<>();
    private  Set<Ticket> tickets =new HashSet<Ticket>();
    private  Set<Service> services = new HashSet<Service>();

    public Flight() {}

    public Flight(String flightNumber, Plane plane, String destination, Date departureDate, Date arrivalDate, Double flightPrice) {
        this.flightNumber = flightNumber;
        this.plane = plane;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightPrice = flightPrice;
    }

    @OneToMany(mappedBy = "flight",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    public Set<Service> getServices() {return services;}
    public void setServices(Set<Service> services) {this.services = services;}

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "flightNumber", length = 30)
    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "planeID", nullable = false)
    public Plane getPlane() {return plane;}
    public void setPlane(Plane plane) {this.plane = plane;}

    @Column(name = "destination", length = 30)
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Column(name = "departureDate")
    public Date getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @Column(name = "arrivalDate")
    public Date getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Column(name = "price", precision = 2)
    public Double getFlightPrice() {
        return flightPrice;
    }
    public void setFlightPrice(Double flightPrice) {
        this.flightPrice = flightPrice;
    }

   /* @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Ticket",
            joinColumns = {@JoinColumn(name = "flightID")},
            inverseJoinColumns = {@JoinColumn(name = "passengerID")}
    )
    public Set<Passenger> getPassengers() {
        return passengers;
    }
    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }
    */

    @Transactional
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight", cascade = CascadeType.ALL)
    public Set<Ticket> getTickets() {return tickets;}
    public void setTickets(Set<Ticket> tickets) {this.tickets = tickets;}

    @Override
    public String toString() {
        return "Flight:" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", plane=" + plane.getId() +
                ", destination='" + destination + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", flightPrice=" + flightPrice ;
    }
}