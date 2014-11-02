package ch.jherzig.ffhs.controller;

import javax.ejb.Local;

import ch.jherzig.ffhs.model.Role;

@Local
public interface RoleBeanLocal {
	
	public Role getByKey(Long key);

}
