package Entities;
import Entities.Flight;
import jakarta.persistence.*;

import jakarta.persistence.*;

import jakarta.persistence.CascadeType;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="plane")
public class Plane {
    private int id;
    private String sideNumber;
    private int seatsNumber;
    private String airline;
    private String planeModel;

    private Set<Flight> flightSet = new HashSet<Flight>();
@OneToMany(mappedBy = "plane",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    public Set<Flight> getFlightSet() {return flightSet;}
    public void setFlightSet(Set<Flight> flightSet) {this.flightSet = flightSet;}

    public Plane(){}
    public Plane(String sideNumber,int seatsNumber,String airline,String planeModel){
        this.sideNumber=sideNumber;
        this.seatsNumber=seatsNumber;
        this.airline=airline;
        this.planeModel=planeModel;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "sideNumber", length = 30)
    public String getSideNumber() {
        return sideNumber;
    }
    public void setSideNumber(String sideNumber) {
        this.sideNumber = sideNumber;
    }

    @Column(name = "seatsNumber", length = 3)
    public int getSeatsNumber() {
        return seatsNumber;
    }
    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    @Column(name = "airline",  length = 30)
    public String getAirline() {
        return airline;
    }
    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Column(name = "planeModel",  length = 30)
    public String getPlaneModel() {
        return planeModel;
    }
    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

}