package ch.jherzig.ffhs.test;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ttest database table.
 * 
 */
@Entity
@Table(name="tTest")
@NamedQuery(name="Ttest.findAll", query="SELECT t FROM Ttest t ORDER BY t.key")
public class Ttest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="tstkey")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_tstKey")
    @SequenceGenerator(name="seq_tstKey", sequenceName="seq_tstKey", allocationSize=1)
	private Long key;

	private String tstvalue;

	public Ttest() {
	}

	public Long getKey() {
		return this.key;
	}

	public void setKey(Long tstkey) {
		this.key = tstkey;
	}

	public String getValue() {
		return this.tstvalue;
	}

	public void setValue(String tstvalue) {
		this.tstvalue = tstvalue;
	}

}