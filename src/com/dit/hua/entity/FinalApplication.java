package com.dit.hua.entity;
import javax.persistence.*;

@Entity
@Table(name="FINAL_APPLICATION")
public class FinalApplication{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="army_office_username")
    private String ArmyOfficerUsername;

    @Column(name="citizen_username")
    private String citizenUsername;

    @Column(name="citizen_firstName")
    private String citizenFirstName;

    @Column(name="citizen_lastName")
    private String lastName;

    @Column(name="citizen_email")
    private String citizenEmail;

    @Column(name="citizen_amka")
    private int citizenAmka;

    @Column(name="citizen_STRAT_NUMBER")
    private int citizenStratNumber;

    @Column(name="citizen_present_age")
    private String citizenPresentAge;

    public FinalApplication(){}
    public FinalApplication(String ArmyOfficerUsername,String citizenUsername,String citizenFirstName,
                                String lastName,String citizenEmail,int citizenAmka,
                                int citizenStratNumber,String citizenPresentAge){
        this.ArmyOfficerUsername=ArmyOfficerUsername;
        this.citizenUsername=citizenUsername;
        this.citizenFirstName=citizenFirstName;
        this.lastName=lastName;
        this.citizenEmail=citizenEmail;
        this.citizenAmka=citizenAmka;
        this.citizenStratNumber=citizenStratNumber;
        this.citizenPresentAge=citizenPresentAge;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getCitizenUsername(){
        return citizenUsername;
    }
    public void setCitizenUsername(String citizenUsername){
        this.citizenUsername=citizenUsername;
    }
    public String getArmyOfficeUsername(){
        return ArmyOfficerUsername;
    }
    public void setArmyOfficeUsername(String armyOfficeUsername){
        ArmyOfficerUsername=armyOfficeUsername;
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
        this.citizenEmail=citizenEmail;
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
    public String getCitizenPresentAge() {
        return citizenPresentAge;
    }
    public void setCitizenPresentAge(String citizenPresentAge){
        this.citizenPresentAge=citizenPresentAge;
    }
    @Override
    public String toString() {
        return "FinalApplication{"+
                "id="+id+
                ", ArmyOfficeUsername='"+ArmyOfficerUsername+'\''+
                ", citizenUsername='"+citizenUsername+'\''+
                ", citizenFirstName='"+citizenFirstName+'\''+
                ", lastName='"+lastName+'\''+
                ", citizenEmail='"+citizenEmail+'\''+
                ", citizenAmka="+citizenAmka+
                ", citizenStratNumber="+citizenStratNumber+
                ", citizenPresentAge='"+citizenPresentAge+'\''+'}';
    }
}