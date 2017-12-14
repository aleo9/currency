
package controller;

import integration.DbHandler;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import model.Currency;

@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class Controller {
    @EJB DbHandler dbHandler;

    public float convert(String fromCurrency, String toCurrency){
        //Currency currency = new Currency("krw", 1000);
        //Currency currency2 = new Currency("sek", 10);
        
        //float fromRate = currency.getRate();
        //float toRate = currency2.getRate();
        
        Currency currency = dbHandler.findCurrency(fromCurrency);
        float fromRate = currency.getRate();
        System.out.println("from rate" +fromRate);
        Currency currency2 = dbHandler.findCurrency(toCurrency);
        float toRate = currency2.getRate();

        float finalRate = toRate/fromRate;
        
        
        return finalRate;
    }
    
}