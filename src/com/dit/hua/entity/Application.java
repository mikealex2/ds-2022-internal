package com.dit.hua.entity;
import javax.persistence.*;

@Entity
@Table(name="application")
public class Application{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="user")
    private String username;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="amka")
    private int amka;

    @Column(name="stratNumber")
    private int stratNumber;

    @Column(name="reasonOfDelay")
    private String reasonDelay;
    public Application(){}
    public Application(String username,String firstName,String lastName,
                       String email,int amka,int stratNumber,String reasonDelay){
        this.username=username;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.amka=amka;
        this.stratNumber=stratNumber;
        this.reasonDelay=reasonDelay;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public int getAmka(){
        return amka;
    }
    public void setAmka(int amka){
        this.amka=amka;
    }
    public int getStratNumber(){
        return stratNumber;
    }
    public void setStratNumber(int stratNumber){
        this.stratNumber=stratNumber;
    }
    public String getReasonDelay(){
        return reasonDelay;
    }
    public void setReasonDelay(String reasonDelay){
        this.reasonDelay=reasonDelay;
    }
    @Override
    public String toString(){
        return "Application{"+
                "id="+id+
                ", username='"+username+'\''+
                ", firstName='"+firstName+'\''+
                ", lastName='"+lastName+'\''+
                ", email='"+email+'\''+
                ", amka="+amka+
                ", stratNumber="+stratNumber+
                ", reasonDelay='"+reasonDelay+'\''+'}';
    }
}