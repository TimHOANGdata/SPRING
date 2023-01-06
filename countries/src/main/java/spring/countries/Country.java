package spring.countries;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="countries")

public class Country {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @JsonIgnore
    private Integer id;
    private String name;
    private String capital;
    
    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }
    public Country(){

    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    @Override
    public String toString() {
        return "Country [id=" + id + ", name=" + name + ", capital=" + capital + "]";
    }

    
    
    

}
