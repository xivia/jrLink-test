package ch.jherzig.ffhs.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the tuser database table.
 * 
 */
@Entity
@Table(name="tuser")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long usekey;

	private Integer useactiveyn;

	private Timestamp usechdt;

	private String usechn;

	private Timestamp usecrdt;

	private String usecrn;

	private String usemail;

	private String usename;

	private String usenick;

	private String usepasswort;

	private String usevorname;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="useroleid")
	private Role trole;

	public User() {
	}

	public Long getKey() {
		return this.usekey;
	}

	public void setKey(Long usekey) {
		this.usekey = usekey;
	}

	public Integer getActiveyn() {
		return this.useactiveyn;
	}

	public void setActiveyn(Integer useactiveyn) {
		this.useactiveyn = useactiveyn;
	}

	public Timestamp getChdt() {
		return this.usechdt;
	}

	public void setChdt(Timestamp usechdt) {
		this.usechdt = usechdt;
	}

	public String getChn() {
		return this.usechn;
	}

	public void setChn(String usechn) {
		this.usechn = usechn;
	}

	public Timestamp getCrdt() {
		return this.usecrdt;
	}

	public void setCrdt(Timestamp usecrdt) {
		this.usecrdt = usecrdt;
	}

	public String getCrn() {
		return this.usecrn;
	}

	public void setCrn(String usecrn) {
		this.usecrn = usecrn;
	}

	public String getMail() {
		return this.usemail;
	}

	public void setMail(String usemail) {
		this.usemail = usemail;
	}

	public String getName() {
		return this.usename;
	}

	public void setName(String usename) {
		this.usename = usename;
	}

	public String getNick() {
		return this.usenick;
	}

	public void setNick(String usenick) {
		this.usenick = usenick;
	}

	public String getPasswort() {
		return this.usepasswort;
	}

	public void setPasswort(String usepasswort) {
		this.usepasswort = usepasswort;
	}

	public String getVorname() {
		return this.usevorname;
	}

	public void setVorname(String usevorname) {
		this.usevorname = usevorname;
	}
	
	public Role getRole() {
		return this.trole;
	}

	public void setRole(Role trole) {
		this.trole = trole;
	}


}