package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.IUtilisateurDao;
import fr.epsi.dao.UtilisateurDao;
import fr.epsi.entite.Utilisateur;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UtilisateurService implements IUtilisateurService {
	

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;


	public List<Utilisateur> getUtilisateur() {
		IUtilisateurDao dao = new UtilisateurDao(em, utx);
		return dao.getUtilisateur();
	}
	
	public void createUtilisateur(Utilisateur u) {
		IUtilisateurDao dao = new UtilisateurDao(em, utx);
		dao.create(u);
		
		
	}

	public List<Utilisateur> compareUtilisateur(String email, int pass) {
		IUtilisateurDao dao = new UtilisateurDao(em, utx);
		return dao.compareUtilisateur( email, pass);
	}

	public Utilisateur getUserFromEmail(String email) {
		IUtilisateurDao dao = new UtilisateurDao(em, utx);
		return dao.getUserFromEmail(email);
	}




	
}
