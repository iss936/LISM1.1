package fr.iut.lism;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="eval_session")
public class EvalSession {

	@Id
	private int idEvalSession;
	
	@Column(name="date_debut")
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Column(name="date_fin")
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cours_session")
	private CoursSession coursSession;
	
	@OneToMany(mappedBy = "pk.evalSession", cascade=CascadeType.ALL)
	private Set<EtudiantCoursEval> lesEtudiantCoursEval;
	
	public EvalSession(int idEvalSession, Date dateDebut, Date dateFin, CoursSession coursSession) {
		this.idEvalSession = idEvalSession;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.coursSession = coursSession;
	}
	
	public EvalSession(Date dateDebut, Date dateFin, CoursSession coursSession) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.coursSession = coursSession;
	}
	
	public EvalSession() {
		
	}
	
	/**
	 * @return the idEvalSession
	 */
	public int getIdEvalSession() {
		return idEvalSession;
	}
	/**
	 * @param idEvalSession the idEvalSession to set
	 */
	public void setIdEvalSession(int idEvalSession) {
		this.idEvalSession = idEvalSession;
	}
	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}
	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}
	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	/**
	 * @return the coursSession
	 */
	public CoursSession getCoursSession() {
		return coursSession;
	}
	/**
	 * @param coursSession the coursSession to set
	 */
	public void setCoursSession(CoursSession coursSession) {
		this.coursSession = coursSession;
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
	
	public void addEtudiantCoursEval(EtudiantCoursEval ece) {
		if(!getLesEtudiantCoursEval().contains(ece)) {
			getLesEtudiantCoursEval().add(ece);
		}
	}
}
