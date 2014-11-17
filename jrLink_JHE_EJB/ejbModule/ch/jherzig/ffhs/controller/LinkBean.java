package ch.jherzig.ffhs.controller;

import java.util.Collection;
import java.util.List;

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

	@Override
	public Collection<Link> getLinkList() {
		List<Link> list = em.createNamedQuery("Link.findAll", Link.class).getResultList();
		return list;
	}

	@Override
	public void update(Link link) {
		if (getByKey(link.getKey()) != null) {
			em.merge(link);
			em.flush();
		}
		
	}

	@Override
	public void create(Link link) {
		em.persist(link);
		em.flush();
		
	}

	@Override
	public void delete(Link link) {
		Link linkDelete = getByKey(link.getKey());
		if (linkDelete != null) {
			em.remove(linkDelete);
			em.flush();
		}
		
	}

}
