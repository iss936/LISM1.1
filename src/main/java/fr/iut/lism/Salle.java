package fr.iut.lism;

import java.util.Set;


public class Salle {

	private int idSalle;
	private String libelleSalle;
	private Set<CoursSessionItem> lesCoursSessionItem;
	
	public Salle(int idSalle, String libelleSalle) {
		this.setIdSalle(idSalle);
		this.setLibelleSalle(libelleSalle);
	}
	
	public Salle() {
		
	}

	/**
	 * @return the idSalle
	 */
	public int getIdSalle() {
		return idSalle;
	}

	/**
	 * @param idSalle the idSalle to set
	 */
	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	/**
	 * @return the libelleSalle
	 */
	public String getLibelleSalle() {
		return libelleSalle;
	}

	/**
	 * @param libelleSalle the libelleSalle to set
	 */
	public void setLibelleSalle(String libelleSalle) {
		this.libelleSalle = libelleSalle;
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
