package ch.jherzig.ffhs.controller;

import javax.ejb.Local;

import ch.jherzig.ffhs.model.Tlink;

@Local
public interface LinkBeanLocal {
	public Tlink getByKey(Long key);

}
