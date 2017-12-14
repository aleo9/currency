
package view;

import javax.inject.Named;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import controller.Controller;
import javax.ejb.EJB;
@Named(value = "manager")
@SessionScoped
public class Manager implements Serializable{
    private String fromCurrency;
    private String toCurrency;
    private String name;
    private float value;
    private float amount;
    private float convertedAmount;
    
    @EJB
    private Controller controller;
    
    public void convert(){
        float val = controller.convert(fromCurrency, toCurrency);
        val*=amount;
        convertedAmount = val;
    }
    
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount){
        this.amount = amount;
    }   
    
    public float getConvertedAmount(){
        return convertedAmount;
    } 
    
    public void setConvertedAmount(float amount){
        
    }  
    
    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String currency) {
        this.fromCurrency = currency;
    }  
    
    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String currency) {
        this.toCurrency = currency;
    } 
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  
    
    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
    
    //public Manager() {
    //}
    
}
