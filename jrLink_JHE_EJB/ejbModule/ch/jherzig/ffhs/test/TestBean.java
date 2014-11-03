package ch.jherzig.ffhs.test;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class TestBean
 */
@Stateless
@LocalBean
public class TestBean implements TestBeanLocal {

    /**
     * Default constructor. 
     */
    public TestBean() {
    }
    
    @PersistenceContext
    private EntityManager em;

    private Ttest tt;
    
	@Override
	public String sayHello(String msg) {
		tt = em.find(Ttest.class, new Long(1));
		return msg + " : Das TestBean sagt Hallo | DB ausgabe: "+ tt.getValue();
	}

}
