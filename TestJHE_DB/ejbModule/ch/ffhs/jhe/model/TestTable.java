package ch.ffhs.jhe.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the test_table database table.
 * 
 */
@Entity
@Table(name="test_table")
@NamedQuery(name="TestTable.findAll", query="SELECT t FROM TestTable t")
public class TestTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMP_SEQ")
    @SequenceGenerator(name="EMP_SEQ", sequenceName="EMP_SEQ", allocationSize=0)
	private Long id;

	private String value;

	public TestTable() {
	}

	public Long getId() {
		return this.id;
	}


	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}