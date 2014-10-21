package ch.jherzig.ffhs.test;

import javax.ejb.Local;

@Local
public interface TestBeanLocal {
	public String sayHello(String msg);

}
