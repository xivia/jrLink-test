package ch.jherzig.ffhs.controller;

import java.util.Collection;

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
    }
    
       
    @PersistenceContext
    private EntityManager em;

	@Override
	public Role getByKey(Long key) {
		
		Role role;
		role = em.find(Role.class, key);
		
		return role;
	}

	@Override
	public Collection<Role> getRoleList() {
		return em.createNamedQuery("Role.findAll",Role.class).getResultList();
	}

	@Override
	public void update(Role role) {
		if (getByKey(role.getKey()) != null) {
			em.merge(role);
			em.flush();
		}			
	}

	@Override
	public void create(Role role) {
		
		em.persist(role);
		em.flush();		
	}

	@Override
	public void delete(Role role) {
		Role roleDelete = getByKey(role.getKey());
		if (roleDelete != null) {
			em.remove(roleDelete);
			em.flush();
		}
		
	}

}
