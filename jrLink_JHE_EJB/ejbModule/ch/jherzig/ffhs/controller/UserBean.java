package ch.jherzig.ffhs.controller;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.jherzig.ffhs.model.User;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
@LocalBean
public class UserBean implements UserBeanLocal {

    /**
     * Default constructor. 
     */
    public UserBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    private EntityManager em;

	@Override
	public User getByKey(Long key) {
		User user;
		user = em.find(User.class, key);
		
		return user;
	}

}
