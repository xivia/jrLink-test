package ch.ffhs.jhe.bean;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.ffhs.jhe.model.TestTable;

/**
 * Session Bean implementation class BeanTestTable
 */
@Stateless
@LocalBean
public class BeanTestTable implements BeanTestTableRemote {

	/**
	 * Default constructor.
	 */
	public BeanTestTable() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	private EntityManager em;

	private TestTable tt;

	@Override
	public String getName(int id) {

		tt = (TestTable) em.find(TestTable.class, new Long(id));

		if (tt != null) {
			return tt.getValue();
		} else {
			return "kein Ergebnis gefunden!";

		}

	}

	@Override
	public TestTable setName(String name) {
		
		TestTable table = new TestTable();
		// TODO ID Automatisch erzeugen
		table.setValue(name);
		em.persist(table);
		
		return table;
	}

	@Override
	public Collection<TestTable> getAllTestTable() {
		Query query = em.createQuery("SELECT t FROM TestTable t");
	    return (Collection<TestTable>) query.getResultList();
	}

}
