package Entities;

import jakarta.persistence.*;

import jakarta.persistence.Column;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    private int id;
    private User user;
    private String name;
    private String surname;

    private Set<Service> services = new HashSet<Service>();


    @OneToMany(mappedBy = "employee",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    public Set<Service> getServices() {return services;}

    public void setServices(Set<Service> services) {this.services = services;}

    public Employee(){}
    public Employee(User user,String name,String surname){
        this.user=user;
        this.name=name;
        this.surname=surname;
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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", nullable = false)
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "name", length = 30)
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

}
