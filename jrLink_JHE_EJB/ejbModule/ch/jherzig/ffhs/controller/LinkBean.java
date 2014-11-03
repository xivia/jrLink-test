package ch.jherzig.ffhs.controller;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.jherzig.ffhs.model.Link;


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
        
    }
    
    @PersistenceContext
    private EntityManager em;

	@Override
	public Link getByKey(Long key) {
		Link table;
		table = em.find(Link.class, key);
		return table;
	}

}
