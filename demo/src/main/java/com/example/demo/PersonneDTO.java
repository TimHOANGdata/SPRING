package com.example.demo;

public class PersonneDTO {
    
    private String firstName;
    private String lastName;


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //dto permet de modifier les datas qu'on veut montrer 
    // ou montrer les datas dans le json mais ils n'existent pas dans le base de donnees.
}
