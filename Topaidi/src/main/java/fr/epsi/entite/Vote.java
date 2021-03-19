package fr.epsi.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idIdee;
	
	private Long idUtilisateur;
	
	public Long getIdIdee() {
		return this.idIdee;
	}
	
	public void setIdIdee(Long idIdee) {
		this.idIdee = idIdee;
	}
	
	public Long getIdUtilisateur() {
		return this.idUtilisateur;
	}
	
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
}
