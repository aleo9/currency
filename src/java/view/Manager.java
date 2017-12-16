
package view;

import javax.inject.Named;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import controller.Controller;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
@Named(value = "manager")
@SessionScoped
public class Manager implements Serializable{

    private float amount;
    private float convertedAmount;
    
    @EJB
    private Controller controller;
    
    private String selectedItem; 
    private String selectedItem2; 
    private List<SelectItem> availableItems;

    @PostConstruct
    public void init() {
    availableItems = new ArrayList<SelectItem>();
    
    String[] list = controller.findCurrencyList();
    //add all currencies from db
    for(int i = 0; i < list.length; i++){
        availableItems.add(new SelectItem(list[i]));
    }
    
    }

    public void select(){
        
        float val = controller.convert(selectedItem, selectedItem2);
        val*=amount;
        convertedAmount = val;
    }
    
    public List getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(List items){
        this.availableItems = items;
    }     
    
    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String item){
        this.selectedItem = item;
    } 
    
    public String getSelectedItem2() {
        return selectedItem2;
    }

    public void setSelectedItem2(String item){
        this.selectedItem2 = item;
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
    
    
}
