package mateusz;

import java.util.jar.Attributes;

public class User {
    String lastName;
    String name;
    String pesel;
    String phone;
    String mail;
    String adress;


    public User(String name  ,String lastName, String pesel, String phone, String mail,String adress){

        this.lastName = lastName;
        this.name = name;
        this.mail = mail;
        this.pesel = pesel;
        this.phone = phone;
        this.adress = adress;

    }

    @Override
    public String toString() {
        return name+ ";"+ lastName+";"+ mail+";"+phone+";"+pesel+";"+adress;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }



    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;


    }
}

