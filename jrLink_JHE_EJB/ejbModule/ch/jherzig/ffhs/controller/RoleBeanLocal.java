package ch.jherzig.ffhs.controller;

import java.util.Collection;
import javax.ejb.Local;
import ch.jherzig.ffhs.model.Role;

@Local
public interface RoleBeanLocal {
	
	public Role getByKey(Long key);
	public Collection<Role> getRoleList();
	public void update(Role role);
	public void create(Role role);
	public void delete(Role role);

}
