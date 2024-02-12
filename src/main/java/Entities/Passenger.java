package Entities;

import jakarta.persistence.*;

import jakarta.persistence.CascadeType;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Passenger")
public class Passenger {

    private int id;
    private String passport;
    private User user;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;

    private transient Set<Ticket> tickets=new HashSet<>();


    public Passenger(){}
    public Passenger(User user,String passportId,String name,String surname,
                     Date dateOfBirth, String phoneNumber,String email){
        this.user=user;
        this.passport =passportId;
        this.name=name;
        this.surname=surname;
        this.dateOfBirth=dateOfBirth;
        this.phoneNumber=phoneNumber;
        this.email=email;
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

    @Column(name = "passport", length = 9)
    public String getPassport() {
        return passport;
    }
    public void setPassport(String passportId) {
        this.passport = passportId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false)
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "name",length = 30)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname", length = 30)
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "dateOfBirth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "phoneNumber",length = 13)
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "email",length = 40)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

   /*@ManyToMany(mappedBy="passengers",fetch = FetchType.LAZY)
    public Set<Flight> getFlights() {
        return flights;
    }
    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }*/

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "passenger", cascade =CascadeType.ALL)
    public Set<Ticket> getTickets() {
        return tickets;
    }
    public void setTickets(Set<Ticket> ticket) {
        this.tickets = ticket;
    }


}