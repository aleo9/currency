
package integration;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import model.Currency;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class DbHandler {
    @PersistenceContext(unitName = "currencyPU")
    private EntityManager em;
    
    public Currency findCurrency(String name){
        Currency c = em.find(Currency.class, name);
        if (c == null) {
            throw new EntityNotFoundException("No currency " + name);
        }
        return c;
    }
    
    public double getRate(String fromCurrency, String toCurrency){
        double rate = 1;
        
        return rate;
    }
    
}
