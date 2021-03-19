package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Utilisateur;

public interface IUtilisateurDao {

	void create(Utilisateur u);
	
	List<Utilisateur> getUtilisateur();
	
	List<Utilisateur> compareUtilisateur(String email, int pass);
	
	Utilisateur getUserFromEmail(String email);
}
