package com.dit.hua.entity;
import javax.persistence.*;

@Entity
@Table(name="VALIDATED_APPLICATION")
public class ValidatedApplication{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="office_username")
    private String officeUsername;

    @Column(name="citizen_username")
    private String citizenUsername;

    @Column(name="citizen_firstName")
    private String citizenFirstName;

    @Column(name="citizen_lastname")
    private String lastName;

    @Column(name="citizen_email")
    private String citizenEmail;

    @Column(name="citizen_amka")
    private int citizenAmka;

    @Column(name="citizen_STRAT_NUMBER")
    private int citizenStratNumber;

    @Column(name="REASON_TIME_DELAY")
    private String reasonDelay;
    public ValidatedApplication(){}
    public ValidatedApplication(String officeUsername,String citizenUsername,String citizenFirstName,
                                String lastName,String citizenEmail,int citizenAmka,
                                int citizenStratNumber,String reasonDelay){
        this.officeUsername=officeUsername;
        this.citizenUsername=citizenUsername;
        this.citizenFirstName=citizenFirstName;
        this.lastName=lastName;
        this.citizenEmail=citizenEmail;
        this.citizenAmka=citizenAmka;
        this.citizenStratNumber=citizenStratNumber;
        this.reasonDelay=reasonDelay;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getOfficeUsername(){
        return officeUsername;
    }
    public void setOfficeUsername(String officeUsername){
        this.officeUsername=officeUsername;
    }
    public String getCitizenUsername(){
        return citizenUsername;
    }
    public void setCitizenUsername(String citizenUsername){
        this.citizenUsername=citizenUsername;
    }
    public String getCitizenFirstName(){
        return citizenFirstName;
    }
    public void setCitizenFirstName(String citizenFirstName){
        this.citizenFirstName=citizenFirstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public String getCitizenEmail(){
        return citizenEmail;
    }
    public void setCitizenEmail(String citizenEmail){
        this.citizenEmail = citizenEmail;
    }
    public int getCitizenAmka(){
        return citizenAmka;
    }
    public void setCitizenAmka(int citizenAmka){
        this.citizenAmka=citizenAmka;
    }
    public int getCitizenStratNumber(){
        return citizenStratNumber;
    }
    public void setCitizenStratNumber(int citizenStratNumber){
        this.citizenStratNumber=citizenStratNumber;
    }
    public String getReasonDelay(){
        return reasonDelay;
    }
    public void setReasonDelay(String reasonDelay){
        this.reasonDelay=reasonDelay;
    }
    @Override
    public String toString(){
        return "ValidatedApplication{"+
                "id=" + id +
                ", officeUsername='"+officeUsername+'\''+
                ", citizenUsername='"+citizenUsername+'\''+
                ", citizenFirstName='"+citizenFirstName+'\''+
                ", lastName='"+lastName+'\''+
                ", citizenEmail='"+citizenEmail+'\''+
                ", citizenAmka="+citizenAmka+
                ", citizenStratNumber="+citizenStratNumber+
                ", reasonDelay='"+reasonDelay+'\''+'}';
    }
}