package fr.epsi.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Utilisateur;

public class UtilisateurDao implements IUtilisateurDao {

	EntityManager em;
	UserTransaction utx;
	
	public UtilisateurDao(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}
	
	public void create(Utilisateur u) {
		try {
			utx.begin();
			em.persist(u);
			utx.commit();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (RollbackException e) {
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			e.printStackTrace();
		} catch (NotSupportedException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	
	public List<Utilisateur> getUtilisateur() {
		
		return em.createQuery("select u from Utilisateur u", Utilisateur.class).getResultList();
	}

	public List<Utilisateur> compareUtilisateur(String email, int pass) {
		return em.createQuery("select u from Utilisateur u where u.email = :email and u.password = :pass", Utilisateur.class).setParameter("email", email).setParameter("pass", pass).getResultList();
	}

	public Utilisateur getUserFromEmail(String email) {
		return em.createQuery("select u from Utilisateur u where u.email = :email", Utilisateur.class).setParameter("email", email).getSingleResult();
	}
}
