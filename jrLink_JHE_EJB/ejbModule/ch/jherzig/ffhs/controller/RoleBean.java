package ch.jherzig.ffhs.controller;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.jherzig.ffhs.model.Role;

/**
 * Session Bean implementation class RoleBean
 */
@Stateless
@LocalBean
public class RoleBean implements RoleBeanLocal {

    /**
     * Default constructor. 
     */
    public RoleBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    private EntityManager em;

	@Override
	public Role getByKey(Long key) {
		
		Role role;
		role = em.find(Role.class, key);
		
		return role;
	}

}
