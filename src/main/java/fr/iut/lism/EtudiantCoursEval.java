package fr.iut.lism;

import java.io.Serializable;

public class EtudiantCoursEval implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Etudiant etudiant;
	private EvalSession evalSession;
	private float note;
	private String status;
	
	public EtudiantCoursEval(Etudiant etudiant, EvalSession evalSession, float note, String status) {
		this.setEtudiant(etudiant);
		this.setEvalSession(evalSession);
		this.setNote(note);
		this.setStatus(status);
	}
	
	public EtudiantCoursEval() {
		
	}
	
	/**
	 * @return the etudiant
	 */
	public Etudiant getEtudiant() {
		return etudiant;
	}

	/**
	 * @param etudiant the etudiant to set
	 */
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	/**
	 * @return the evalSession
	 */
	public EvalSession getEvalSession() {
		return evalSession;
	}

	/**
	 * @param evalSession the evalSession to set
	 */
	public void setEvalSession(EvalSession evalSession) {
		this.evalSession = evalSession;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((etudiant == null) ? 0 : etudiant.hashCode());
		result = prime * result
				+ ((evalSession == null) ? 0 : evalSession.hashCode());
		result = prime * result + Float.floatToIntBits(note);
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EtudiantCoursEval other = (EtudiantCoursEval) obj;
		if (etudiant == null) {
			if (other.etudiant != null)
				return false;
		} else if (!etudiant.equals(other.etudiant))
			return false;
		if (evalSession == null) {
			if (other.evalSession != null)
				return false;
		} else if (!evalSession.equals(other.evalSession))
			return false;
		if (Float.floatToIntBits(note) != Float.floatToIntBits(other.note))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
}


