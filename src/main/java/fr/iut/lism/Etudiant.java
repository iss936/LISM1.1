package fr.iut.lism;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "etudiant")
public class Etudiant {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_etudiant")
	private int idEtudiant;
	
	@Column(name="prenom_etudiant")
	private String prenomEtudiant;
	
	@Column(name="nom_etudiant")
	private String nomEtudiant;
	
	@Column(name="login")
	private String login;
	
	@Column(name="mdp")
	private String mdp;

//	private Set<EtudiantCoursEval> lesEtudiantCoursEval;
	
	@ManyToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH}, fetch=FetchType.EAGER)
	@JoinTable(
			name="inscription_session",
			joinColumns=@JoinColumn(name="id_etudiant"),
			inverseJoinColumns=@JoinColumn(name="id_cours_session"))
	private Set<CoursSession> lesCoursSession = new HashSet<CoursSession>();
	
	public Etudiant(int idEtudiant, String prenomEtudiant, String nomEtudiant, String login, String mdp) {
		this.idEtudiant = idEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.nomEtudiant = nomEtudiant;
		this.login = login;
		this.mdp = mdp;
	}
	
	public Etudiant(String prenomEtudiant, String nomEtudiant, String login, String mdp) {
		this.prenomEtudiant = prenomEtudiant;
		this.nomEtudiant = nomEtudiant;
		this.login = login;
		this.mdp = mdp;
	}
	
	public Etudiant() {
		
	}

	/**
	 * @return the idEtudiant
	 */
	public int getIdEtudiant() {
		return idEtudiant;
	}

	/**
	 * @param idEtudiant the idEtudiant to set
	 */
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	/**
	 * @return the prenomEtudiant
	 */
	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}

	/**
	 * @param prenomEtudiant the prenomEtudiant to set
	 */
	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}

	/**
	 * @return the nomEtudiant
	 */
	public String getNomEtudiant() {
		return nomEtudiant;
	}

	/**
	 * @param nomEtudiant the nomEtudiant to set
	 */
	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}
	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @return the lesCoursSession
	 */
	public Set<CoursSession> getLesCoursSession() {
		return lesCoursSession;
	}

	/**
	 * @param lesCoursSession the lesCoursSession to set
	 */
	public void setLesCoursSession(Set<CoursSession> lesCoursSession) {
		this.lesCoursSession = lesCoursSession;
	}

//	/**
//	 * @return the lesEtudiantCoursEval
//	 */
//	public Set<EtudiantCoursEval> getLesEtudiantCoursEval() {
//		return lesEtudiantCoursEval;
//	}
//
//	/**
//	 * @param lesEtudiantCoursEval the lesEtudiantCoursEval to set
//	 */
//	public void setLesEtudiantCoursEval(Set<EtudiantCoursEval> lesEtudiantCoursEval) {
//		this.lesEtudiantCoursEval = lesEtudiantCoursEval;
//	}
	
	public void addCoursSession(CoursSession cs) {
		if(!getLesCoursSession().contains(cs)) {
			getLesCoursSession().add(cs);
		}
		if(!cs.getLesEtudiant().contains(this)) {
			cs.getLesEtudiant().add(this);
		}
	}
}
