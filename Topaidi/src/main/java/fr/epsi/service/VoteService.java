package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.IVoteDao;
import fr.epsi.dao.VoteDao;
import fr.epsi.entite.Vote;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class VoteService implements IVoteService {
	
	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;

	public void createVote(Vote v) {
		
		IVoteDao dao = new VoteDao(em, utx);
		dao.createVote(v);
		
	}

	public List<Vote> checkVote(Long idIdee, Long idUtil) {
		IVoteDao dao = new VoteDao(em, utx);
		
		return dao.checkVote(idIdee, idUtil);
	}

}
