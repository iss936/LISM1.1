package fr.iut.lism;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class Etudiant {

	private int idEtudiant;
	private String prenomEtudiant;
	private String nomEtudiant;
	private String login;
	private String mdp;
	private Set<EtudiantCoursEval> lesEtudiantCoursEval;
	private Set<InscriptionSession> lesInscriptionSession;
	
	public Etudiant(int idEtudiant, String prenomEtudiant, String nomEtudiant, String login, String mdp) {
		this.setIdEtudiant(idEtudiant);
		this.setPrenomEtudiant(prenomEtudiant);
		this.setNomEtudiant(nomEtudiant);
	}
	
	public Etudiant(String prenomEtudiant, String nomEtudiant, String login, String mdp){
		this.setPrenomEtudiant(prenomEtudiant);
		this.setNomEtudiant(nomEtudiant);
		this.setLogin(login);
		this.setMdp(mdp);
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
	 * @return the lesEtudiantCoursEval
	 */
	public Set<EtudiantCoursEval> getLesEtudiantCoursEval() {
		return lesEtudiantCoursEval;
	}

	/**
	 * @param lesEtudiantCoursEval the lesEtudiantCoursEval to set
	 */
	public void setLesEtudiantCoursEval(Set<EtudiantCoursEval> lesEtudiantCoursEval) {
		this.lesEtudiantCoursEval = lesEtudiantCoursEval;
	}

	/**
	 * @return the lesInscriptionSession
	 */
	public Set<InscriptionSession> getLesInscriptionSession() {
		return lesInscriptionSession;
	}

	/**
	 * @param lesInscriptionSession the lesInscriptionSession to set
	 */
	public void setLesInscriptionSession(Set<InscriptionSession> lesInscriptionSession) {
		this.lesInscriptionSession = lesInscriptionSession;
	}
	
	
}
