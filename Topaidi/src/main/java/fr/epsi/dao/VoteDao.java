package fr.epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Vote;


public class VoteDao implements IVoteDao{
	

	EntityManager em;
	UserTransaction utx;
	
	public VoteDao(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public void createVote(Vote v) {
		try {
			utx.begin();
			em.persist(v);
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

	public List<Vote> checkVote(Long idIdee, Long idUtil) {
		
		return em.createQuery("select v from Vote v where v.idIdee = :idIdee and v.idUtilisateur = :idUtil", Vote.class).setParameter("idIdee", idIdee).setParameter("idUtil", idUtil).getResultList();
	}

}
