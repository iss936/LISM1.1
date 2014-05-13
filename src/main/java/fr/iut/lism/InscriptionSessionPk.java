package fr.iut.lism;

import java.io.Serializable;

public class InscriptionSessionPk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Etudiant etudiant;
	protected CoursSession coursSession;
	
	public InscriptionSessionPk() {
		
	}
	
	public InscriptionSessionPk(Etudiant etudiant, CoursSession coursSession) {
		this.etudiant = etudiant;
		this.coursSession = coursSession;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coursSession == null) ? 0 : coursSession.hashCode());
		result = prime * result
				+ ((etudiant == null) ? 0 : etudiant.hashCode());
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
		InscriptionSessionPk other = (InscriptionSessionPk) obj;
		if (coursSession == null) {
			if (other.coursSession != null)
				return false;
		} else if (!coursSession.equals(other.coursSession))
			return false;
		if (etudiant == null) {
			if (other.etudiant != null)
				return false;
		} else if (!etudiant.equals(other.etudiant))
			return false;
		return true;
	}
	
}
