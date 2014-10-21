package ch.jherzig.ffhs.test;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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
        // TODO Auto-generated constructor stub
    }

	@Override
	public String sayHello(String msg) {
		
		return msg + " : Das TestBean sagt Hallo";
	}

}
