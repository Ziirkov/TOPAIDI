package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Utilisateur;

public interface IUtilisateurService {

	void createUtilisateur(Utilisateur u);
	
	List<Utilisateur> getUtilisateur();
	
	List<Utilisateur> compareUtilisateur(String email, int pass);
	
	Utilisateur getUserFromEmail(String email);
	
}
