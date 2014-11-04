package ch.jherzig.ffhs.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the trole database table.
 * 
 */
@Entity
@Table(name="trole")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r ORDER BY r.key")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "rolkey")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rolKey")
	@SequenceGenerator(name = "seq_rolKey", sequenceName = "seq_rolKey", allocationSize = 0)
	private Long key;

	@Column(name = "rolactiveyn")
	private Integer activeyn;

	@Column(name = "rolchdt")
	private Timestamp chdt;

	@Column(name = "rolchn")
	private String chn;
	
	@Column(name = "rolcrdt")
	private Timestamp crdt;

	@Column(name = "rolcrn")
	private String crn;

	@Column(name = "rolname")
	private String name;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="trole")
	private List<User> tusers;

	public Role() {
	}

	public Long getKey() {
		return this.key;
	}

	public void setKey(Long rolkey) {
		this.key = rolkey;
	}

	public Integer getActiveyn() {
		return this.activeyn;
	}

	public void setRolactiveyn(Integer rolactiveyn) {
		this.activeyn = rolactiveyn;
	}

	public Timestamp getChdt() {
		return this.chdt;
	}

	public void setChdt(Timestamp rolchdt) {
		this.chdt = rolchdt;
	}

	public String getChn() {
		return this.chn;
	}

	public void setChn(String rolchn) {
		this.chn = rolchn;
	}

	public Timestamp getCrdt() {
		return this.crdt;
	}

	public void setCrdt(Timestamp rolcrdt) {
		this.crdt = rolcrdt;
	}

	public String getCrn() {
		return this.crn;
	}

	public void setCrn(String rolcrn) {
		this.crn = rolcrn;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String rolname) {
		this.name = rolname;
	}

	public List<User> getTusers() {
		return this.tusers;
	}

	public void setTusers(List<User> tusers) {
		this.tusers = tusers;
	}

	public User addTuser(User tuser) {
		getTusers().add(tuser);
		tuser.setRole(this);

		return tuser;
	}

	public User removeTuser(User tuser) {
		getTusers().remove(tuser);
		tuser.setRole(null);

		return tuser;
	}

}