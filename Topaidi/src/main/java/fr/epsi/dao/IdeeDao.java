package fr.epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;


import fr.epsi.entite.Idee;

public class IdeeDao implements IIdeeDao{


	EntityManager em;
	UserTransaction utx;
	
	public IdeeDao(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}
	
	public void create(Idee i) {
		try {
			utx.begin();
			em.persist(i);
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
	
	public List<Idee> getIdee() {
		
		return em.createQuery("select i from Idee i", Idee.class).getResultList();
	}

	public void updateNoteTop(Long id) {
		
		try {
			utx.begin();
			Query query = em.createQuery("UPDATE Idee i SET i.top = i.top + 1 WHERE i.id = :id").setParameter("id", id);
			query.executeUpdate();
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

	public void updateNoteFlop(Long id) {
		
		try {
			utx.begin();
			Query query = em.createQuery("UPDATE Idee i SET i.flop = i.flop + 1 WHERE i.id = :id").setParameter("id", id);
			query.executeUpdate();
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

	public List<Idee> getClassementTop() {
		
		return em.createQuery("select i from Idee i order by i.moyenne desc", Idee.class).setMaxResults(3).getResultList();
	}

	public List<Long> getClassementBrainsStat() {
		return em.createQuery("select count(i.utilisateur) from Idee i group by i.utilisateur order by count(i.utilisateur) desc", Long.class).setMaxResults(3).getResultList();
	}
	
	public List<String> getClassementBrainsNom() {
		return em.createQuery("select i.nomUtil from Idee i group by i.utilisateur order by count(i.utilisateur) desc", String.class).setMaxResults(3).getResultList();
	}
	
	public List<Idee> getClassementVoteTitre() {
		return em.createQuery("select i from Idee i order by top+flop desc", Idee.class).setMaxResults(3).getResultList();
	}
	
	public List<Integer> getClassementVoteNum() {
		return em.createQuery("select top+flop from Idee i order by top+flop desc", Integer.class).setMaxResults(3).getResultList();
	}
	
	public void updateMoyenne(Long id) {
	
		try {
			utx.begin();
			Query query = em.createQuery("UPDATE Idee i SET i.moyenne = (i.top/(i.top+i.flop) * 100) WHERE i.id = :id").setParameter("id", id);
			query.executeUpdate();
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

	public Idee getIdeeFromId(Long id) {
		
		return em.createQuery("select i from Idee i where i.id = :id", Idee.class).setParameter("id", id).getSingleResult();
	}








}
