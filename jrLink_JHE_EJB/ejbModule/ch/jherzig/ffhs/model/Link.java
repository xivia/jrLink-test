package ch.jherzig.ffhs.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the tlink database table.
 * 
 */
@Entity
@Table(name="tlink")
@NamedQuery(name="Link.findAll", query="SELECT l FROM Link l ORDER BY l.key")
public class Link implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "linkey")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_linkKey")
	@SequenceGenerator(name = "seq_linkKey", sequenceName = "seq_linkKey", allocationSize = 0)
	private Long key;

	@Column(name = "linname")
	private String name;

	@Column(name = "linvalue")
	private String value;

	public Link() {
	}

	public Long getKey() {
		return this.key;
	}

	public void setKey(Long linkey) {
		this.key = linkey;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String linname) {
		this.name = linname;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String linvalue) {
		this.value = linvalue;
	}

}