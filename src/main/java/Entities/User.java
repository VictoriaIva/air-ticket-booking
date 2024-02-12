package Entities;

import jakarta.persistence.*;

import jakarta.persistence.CascadeType;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    private int id;
    private String login;
    private String password;
    private String role;
    private String avatarPath;


    private Byte isBlocked;
    private transient Set<Passenger> passengerSet=new HashSet<>();

    public User(){}
    public User(String login,String password){
        this.login=login;
        this.password=password;
        this.avatarPath="";
    }
    public User(String login,String password,String role,Byte isBlocked){
        this.login=login;
        this.password=password;
        this.role=role;
        this.avatarPath="";
        this.isBlocked=isBlocked;
    }
    public User(String login,String password,String role){
        this.login=login;
        this.password=password;
        this.role=role;
        this.avatarPath=avatarPath;
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

    @Column(name = "login",length = 30)
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password",length = 10)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "role",  length = 30)
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "avatarPath")
    public String getAvatarPath() {
        return avatarPath;
    }
    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Passenger> getPassengerSet() {
        return passengerSet;
    }
    public void setPassengerSet(Set<Passenger> passengerSet) {
        this.passengerSet = passengerSet;
    }
    @Column(name = "isBlocked")
    public Byte getIsBlocked() {return isBlocked;}
    public void setIsBlocked(Byte isBlocked) {this.isBlocked = isBlocked;}


}
