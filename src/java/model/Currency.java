
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private float rate;
    
    public Currency() {
    }
    
    public Currency(String name, float rate){
        this.name = name;
        this.rate = rate;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setRate(float rate) {
        this.rate = rate;
    }
    
    public float getRate() {
        return rate;
    }
}
