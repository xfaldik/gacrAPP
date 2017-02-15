/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.gacr.domain;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 *
 * @author olda
 */
@Entity
public class Enterprise {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Column(nullable = false)
    private String nameEnterprise;
    
   
    
    private String name;
    
   
   
    private String surname;

  

    private String ICO;
    
    
    private String titul;
    

    private String place;

    @NotNull
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String password;

    public int getId() {
        return id;
    }

    public String getNameEnterprise() {
        return nameEnterprise;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameEnterprise(String nameEnterprise) {
        this.nameEnterprise = nameEnterprise;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setICO(String ICO) {
        this.ICO = ICO;
    }

    public void setTitul(String titul) {
        this.titul = titul;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getICO() {
        return ICO;
    }

    public String getTitul() {
        return titul;
    }

    public String getPlace() {
        return place;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Enterprise(String nameEnterprise, String email, String password) {
        this.nameEnterprise = nameEnterprise;
        this.email = email;
        this.password = password;
    }
    
    
    protected Enterprise() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Enterprise other = (Enterprise) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    
}
