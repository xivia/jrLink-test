package ch.ffhs.jhe.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.ffhs.jhe.model.TestTable;

/**
 * Session Bean implementation class HalloBeanDB
 */
@Stateless
@LocalBean
public class HalloBeanDB implements HalloBeanDBRemote {

	/**
	 * Default constructor.
	 */
	public HalloBeanDB() {
		// TODO Auto-generated constructor stub
	}
	
	@PersistenceContext
	private EntityManager em;
	
	private TestTable tt;

	public String sayHello(String msg, int id) {
		// TODO Gibt die msg mit einer ergänzung zurück
		
		tt = (TestTable) em.find(TestTable.class, new Long(id));
		
		return "Hallo in der Welt von DB-" + tt.getValue() + ": " + msg + "!!";

	}

}
