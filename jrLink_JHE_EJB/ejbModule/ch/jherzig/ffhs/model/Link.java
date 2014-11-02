package ch.jherzig.ffhs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tlink database table.
 * 
 */
@Entity
@Table(name="tlink")
@NamedQuery(name="Link.findAll", query="SELECT l FROM Link l")
public class Link implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long linkey;

	private String linname;

	private String linvalue;

	public Link() {
	}

	public Long getKey() {
		return this.linkey;
	}

	public void setKey(Long linkey) {
		this.linkey = linkey;
	}

	public String getName() {
		return this.linname;
	}

	public void setName(String linname) {
		this.linname = linname;
	}

	public String getValue() {
		return this.linvalue;
	}

	public void setValue(String linvalue) {
		this.linvalue = linvalue;
	}

}