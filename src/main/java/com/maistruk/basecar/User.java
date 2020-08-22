package com.maistruk.basecar;

import java.io.Serializable;
import java.util.Random;

public class User implements Serializable{

    private static final long serialVersionUID = -4493819073762514610L;
    private String id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String date;
    private String email;
    
    
    public User(){
        Random rand = new Random();
        int num = rand.nextInt(1000);
        id = Integer.toString(num);
    }
    
    
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", login=" + login + ", password=" + password + ", name=" + name + ", surname="
                + surname + ", date=" + date + ", email=" + email + "]";
    }

}
