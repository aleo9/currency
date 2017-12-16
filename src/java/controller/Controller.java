
package controller;

import integration.DbHandler;
//import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
//import model.Currency;

@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class Controller {
    @EJB DbHandler dbHandler;

    public float convert(String fromCurrency, String toCurrency){
        
        
        float fromRate = dbHandler.findCurrency(fromCurrency);
        float toRate = dbHandler.findCurrency(toCurrency);
        
        return toRate/fromRate;
    }
    
    public String[] findCurrencyList(){
        String[] list = dbHandler.findCurrencyList();
     
    return list;
    
    }
    
    
}