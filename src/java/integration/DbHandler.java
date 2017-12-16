
package integration;

import java.util.List;
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
    
    
    //returns list of names of currencies
    public String[] findCurrencyList(){
    List<Currency> list = em.createQuery("Select c from Currency c", Currency.class).getResultList();
    int listSize = list.size();
    String[] currencies = new String[listSize];
    for(int i = 0; i<listSize; i++){
        currencies[i] = list.get(i).getName();
    }
    return currencies;

    }
    
    //returns the rate of currency with the specific name
    public float findCurrency(String name){
        
        Currency c = em.find(Currency.class, name);
        if (c == null) {
            throw new EntityNotFoundException("No currency " + name);
        }
        float fromRate = c.getRate();
        return fromRate;
    }
    
    
}
