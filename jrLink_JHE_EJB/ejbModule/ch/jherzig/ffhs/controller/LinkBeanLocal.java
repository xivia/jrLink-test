package ch.jherzig.ffhs.controller;

import javax.ejb.Local;

import ch.jherzig.ffhs.model.Link;



@Local
public interface LinkBeanLocal {
	public Link getByKey(Long key);

}
