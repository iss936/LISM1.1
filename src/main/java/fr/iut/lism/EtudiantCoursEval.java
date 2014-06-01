package fr.iut.lism;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

@Entity
@Table(name="etudiant_cours_eval")
@AssociationOverrides({
	@AssociationOverride(name = "pk.etudiant", 
		joinColumns = @JoinColumn(name = "id_etudiant")),
	@AssociationOverride(name = "pk.evalSession", 
		joinColumns = @JoinColumn(name = "id_eval_session")) })
public class EtudiantCoursEval implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EtudiantCoursEvalPk pk;
	
	@Column(name="note_eval")
	private float note;
	
	@Column(name="status")
	private String status;
	
	public EtudiantCoursEval(EtudiantCoursEvalPk pk, float note, String status) {
		this.pk = pk;
		this.note = note;
		this.status = status;
	}
	
	public EtudiantCoursEval(EtudiantCoursEvalPk pk) {
		this.pk = pk;
	}
	
	public EtudiantCoursEval() {
		
	}

	/**
	 * @return the pk
	 */
	public EtudiantCoursEvalPk getPk() {
		return pk;
	}

	/**
	 * @param pk the pk to set
	 */
	public void setPk(EtudiantCoursEvalPk pk) {
		this.pk = pk;
	}
	
	@Transient
	public Etudiant getEtudiant() {
		return pk.getEtudiant();
	}
	
	public void setEtudiant(Etudiant e) {
		getPk().setEtudiant(e);
	}
	
	@Transient
	public EvalSession getEvalSession() {
		return pk.getEvalSession();
	}
	
	public void setEvalSession(EvalSession es) {
		getPk().setEvalSession(es);
	}

	/**
	 * @return the note
	 */
	public float getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(float note) {
		this.note = note;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}


