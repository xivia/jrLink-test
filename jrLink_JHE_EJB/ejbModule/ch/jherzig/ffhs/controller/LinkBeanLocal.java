package ch.jherzig.ffhs.controller;

import java.util.Collection;

import javax.ejb.Local;

import ch.jherzig.ffhs.model.Link;



@Local
public interface LinkBeanLocal {
	public Link getByKey(Long key);
	public Collection<Link> getLinkList();
	public void update(Link link);
	public void create(Link link);
	public void delete(Link link);

}
