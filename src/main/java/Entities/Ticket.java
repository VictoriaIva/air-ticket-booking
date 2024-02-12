package Entities;

import jakarta.persistence.*;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Ticket {
    private int id;
    private Flight flight;
    private Passenger passenger;
    private String seatNumber;
    private Timestamp saleDate;

    public Ticket(){}

    public Ticket(Passenger passenger,Flight flight,String seatNumber) {;
        this.passenger = passenger;
        this.flight=flight;
        this.seatNumber = seatNumber;
        this.saleDate= Timestamp.valueOf(LocalDateTime.now());
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
    @JoinColumn(name = "flightID", nullable = false)
    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "passengerID", nullable = false)
    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Column(name = "seatNumber", nullable = false, length = 3)
    public String getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Timestamp getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "Ticket:" + "id=" + id + ", flight=" + flight.getDestination() + ", passenger=" + passenger.getId() +
                ", seatNumber='" + seatNumber + '\'' +
                ", saleDate=" + saleDate ;
    }
}
