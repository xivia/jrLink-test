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
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long rolkey;

	private Integer rolactiveyn;

	private Timestamp rolchdt;

	private String rolchn;

	private Timestamp rolcrdt;

	private String rolcrn;

	private String rolname;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="trole")
	private List<User> tusers;

	public Role() {
	}

	public Long getKey() {
		return this.rolkey;
	}

	public void setKey(Long rolkey) {
		this.rolkey = rolkey;
	}

	public Integer getActiveyn() {
		return this.rolactiveyn;
	}

	public void setRolactiveyn(Integer rolactiveyn) {
		this.rolactiveyn = rolactiveyn;
	}

	public Timestamp getChdt() {
		return this.rolchdt;
	}

	public void setChdt(Timestamp rolchdt) {
		this.rolchdt = rolchdt;
	}

	public String getChn() {
		return this.rolchn;
	}

	public void setChn(String rolchn) {
		this.rolchn = rolchn;
	}

	public Timestamp getCrdt() {
		return this.rolcrdt;
	}

	public void setCrdt(Timestamp rolcrdt) {
		this.rolcrdt = rolcrdt;
	}

	public String getCrn() {
		return this.rolcrn;
	}

	public void setCrn(String rolcrn) {
		this.rolcrn = rolcrn;
	}

	public String getName() {
		return this.rolname;
	}

	public void setName(String rolname) {
		this.rolname = rolname;
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