package ch.jherzig.ffhs.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;

/**
 * The persistent class for the tuser database table.
 * 
 */
@Entity
@Table(name = "tuser")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u ORDER BY u.key")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "usekey")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usekey")
	@SequenceGenerator(name = "seq_usekey", sequenceName = "seq_usekey", allocationSize = 0)
	private Long key;

	@Column(name = "useactiveyn")
	private Integer activeyn;

	@Column(name = "usechdt")
	private Timestamp chdt;

	@Column(name = "usechn")
	private String chn;

	@Column(name = "usecrdt")
	private Timestamp crdt;

	@Column(name = "usecrn")
	private String crn;

	@Column(name = "usemail")
	private String mail;

	@Column(name = "usename")
	private String name;

	@Column(name = "usenick")
	private String nick;

	@Column(name = "usepasswort")
	private String passwort;

	@Column(name = "usevorname")
	private String vorname;

	// bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name = "useroleid")
	private Role trole;

	public User() {
	}

	public Long getKey() {
		return this.key;
	}

	public void setKey(Long usekey) {
		this.key = usekey;
	}

	public Integer getActiveyn() {
		return this.activeyn;
	}

	public void setActiveyn(Integer useactiveyn) {
		this.activeyn = useactiveyn;
	}

	public Timestamp getChdt() {
		return this.chdt;
	}

	public void setChdt(Timestamp usechdt) {
		this.chdt = usechdt;
	}

	public String getChn() {
		return this.chn;
	}

	public void setChn(String usechn) {
		this.chn = usechn;
	}

	public Timestamp getCrdt() {
		return this.crdt;
	}

	public void setCrdt(Timestamp usecrdt) {
		this.crdt = usecrdt;
	}

	public String getCrn() {
		return this.crn;
	}

	public void setCrn(String usecrn) {
		this.crn = usecrn;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String usemail) {
		this.mail = usemail;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String usename) {
		this.name = usename;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String usenick) {
		this.nick = usenick;
	}

	public String getPasswort() {
		return this.passwort;
	}

	public void setPasswort(String usepasswort) {
		this.passwort = usepasswort;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String usevorname) {
		this.vorname = usevorname;
	}

	public Role getRole() {
		return this.trole;
	}

	public void setRole(Role trole) {
		this.trole = trole;
	}

}