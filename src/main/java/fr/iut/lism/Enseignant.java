package fr.iut.lism;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="enseignant")
public class Enseignant {

	@Id
	private int idEnseignant;

	@Column(name="prenom_enseignant")
	private String prenomEnseignant;
	
	@Column(name="nom_enseignant")
	private String nomEnseignant;
	
	@Column(name="login")
	private String login;
	
	@Column(name="mdp")
	private String mdp;
	
	@OneToMany(mappedBy="enseignant")
	@OrderBy(value="date")
	private List<CoursSessionItem> lesCoursSessionItem;

	public Enseignant(int idEnseignant, String prenomEnseignant, String nomEnseignant, String login, String mdp) {
		this.idEnseignant = idEnseignant;
		this.prenomEnseignant = prenomEnseignant;
		this.nomEnseignant = nomEnseignant;
		this.login = login;
		this.mdp = mdp;
	}
	
	public Enseignant(String prenomEnseignant, String nomEnseignant, String login, String mdp) {
		this.prenomEnseignant = prenomEnseignant;
		this.nomEnseignant = nomEnseignant;
		this.login = login;
		this.mdp = mdp;
	}
	
	public Enseignant() {
		
	}

	/**
	 * @return the idEnseignant
	 */
	public int getIdEnseignant() {
		return idEnseignant;
	}

	/**
	 * @param idEnseignant the idEnseignant to set
	 */
	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	/**
	 * @return the prenomEnseignant
	 */
	public String getPrenomEnseignant() {
		return prenomEnseignant;
	}

	/**
	 * @param prenomEnseignant the prenomEnseignant to set
	 */
	public void setPrenomEnseignant(String prenomEnseignant) {
		this.prenomEnseignant = prenomEnseignant;
	}

	/**
	 * @return the nomEnseignant
	 */
	public String getNomEnseignant() {
		return nomEnseignant;
	}

	/**
	 * @param nomEnseignant the nomEnseignant to set
	 */
	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
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
	 * @return the lesCoursSessionItem
	 */
	public List<CoursSessionItem> getLesCoursSessionItem() {
		return lesCoursSessionItem;
	}

	/**
	 * @param lesCoursSessionItem the lesCoursSessionItem to set
	 */
	public void setLesCoursSessionItem(List<CoursSessionItem> lesCoursSessionItem) {
		this.lesCoursSessionItem = lesCoursSessionItem;
	}

}
