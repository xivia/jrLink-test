package ch.jherzig.ffhs.controller;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.jherzig.ffhs.model.Tlink;

/**
 * Session Bean implementation class LinkBean
 */
@Stateless
@LocalBean
public class LinkBean implements LinkBeanLocal {

    /**
     * Default constructor. 
     */
    public LinkBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    private EntityManager em;

	@Override
	public Tlink getByKey(Long key) {
		Tlink table;
		table = em.find(Tlink.class, key);
		return table;
	}

}
