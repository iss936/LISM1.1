package fr.iut.lism;
public class Cours {

	private int idCours;
	private String libelleCours;
	
	public Cours(int idCours, String libelle) {
		this.setIdCours(idCours);
		this.setLibelleCours(libelle);
	}
	
	public Cours(String libelle) {
		this.setLibelleCours(libelle);
	}
	
	public Cours() {
		
	}

	/**
	 * @return the idCours
	 */
	public int getIdCours() {
		return idCours;
	}

	/**
	 * @param idCours the idCours to set
	 */
	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelleCours() {
		return libelleCours;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelleCours(String libelle) {
		this.libelleCours = libelle;
	}
	

}
