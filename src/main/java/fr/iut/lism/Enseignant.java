package fr.iut.lism;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class Enseignant {

	private int idEnseignant;
	private String prenomEnseignant;
	private String nomEnseignant;
	private String login;
	private String mdp;
	private Set<CoursSessionItem> lesCoursSessionItem;

	public Enseignant(int idEnseignant, String prenomEnseignant, String nomEnseignant, String login, String mdp) {
		this.setIdEnseignant(idEnseignant);
		this.setPrenomEnseignant(prenomEnseignant);
		this.setNomEnseignant(nomEnseignant);
		this.setLogin(login);
		this.setMdp(mdp);
	}
	
	public Enseignant(String prenomEnseignant, String nomEnseignant, String login, String mdp) {
		this.setPrenomEnseignant(prenomEnseignant);
		this.setNomEnseignant(nomEnseignant);
		this.setLogin(login);
		this.setMdp(mdp);
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
	public Set<CoursSessionItem> getLesCoursSessionItem() {
		return lesCoursSessionItem;
	}

	/**
	 * @param lesCoursSessionItem the lesCoursSessionItem to set
	 */
	public void setLesCoursSessionItem(Set<CoursSessionItem> lesCoursSessionItem) {
		this.lesCoursSessionItem = lesCoursSessionItem;
	}

}
