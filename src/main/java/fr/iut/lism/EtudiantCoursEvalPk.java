package fr.iut.lism;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class EtudiantCoursEvalPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Etudiant etudiant;
	
	@ManyToOne
	private EvalSession evalSession;
	
	public EtudiantCoursEvalPk() {
		
	}

	public EtudiantCoursEvalPk(Etudiant etudiant, EvalSession evalSession) {
		this.etudiant = etudiant;
		this.evalSession = evalSession;
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
		EtudiantCoursEvalPk other = (EtudiantCoursEvalPk) obj;
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
		return true;
	}
}
