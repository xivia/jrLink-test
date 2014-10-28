package ch.jherzig.ffhs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tlink database table.
 * 
 */
@Entity
@NamedQuery(name="Tlink.findAll", query="SELECT t FROM Tlink t")
public class Tlink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long linkey;

	private String linname;

	private String linvalue;

	public Tlink() {
	}

	public Long getLinkey() {
		return this.linkey;
	}

	public void setLinkey(Long linkey) {
		this.linkey = linkey;
	}

	public String getLinname() {
		return this.linname;
	}

	public void setLinname(String linname) {
		this.linname = linname;
	}

	public String getLinvalue() {
		return this.linvalue;
	}

	public void setLinvalue(String linvalue) {
		this.linvalue = linvalue;
	}

}