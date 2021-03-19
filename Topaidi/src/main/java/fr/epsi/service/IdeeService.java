package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.IIdeeDao;
import fr.epsi.dao.IdeeDao;
import fr.epsi.entite.Idee;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class IdeeService implements IIdeeService {
	

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;

	public List<Idee> getIdee() {
		IIdeeDao dao = new IdeeDao(em, utx);
		return dao.getIdee();
		
	}

	public void createIdee(Idee i) {
		
		IIdeeDao dao = new IdeeDao(em, utx);
		dao.create(i);
		
	}

	public void updateNoteTop(Long id) {
		IIdeeDao dao = new IdeeDao(em, utx);
		dao.updateNoteTop(id);
	}
	
	public void updateNoteFlop(Long id) {
		IIdeeDao dao = new IdeeDao(em, utx);
		dao.updateNoteFlop(id);
	}

	public List<Idee> getClassementTop() {
		IIdeeDao dao = new IdeeDao(em, utx);
		return dao.getClassementTop();
	}

	public void updateMoyenne( Long id) {
		IIdeeDao dao = new IdeeDao(em, utx);
		dao.updateMoyenne( id);
		
	}

	public Idee getIdeeFromId(Long id) {
		IIdeeDao dao = new IdeeDao(em, utx);
		return dao.getIdeeFromId(id);
	}

	public List<Long> getClassementBrainsStat() {
		IIdeeDao dao = new IdeeDao(em, utx);
		return dao.getClassementBrainsStat();
	}

	public List<String> getClassementBrainsNom() {
		IIdeeDao dao = new IdeeDao(em, utx);
		return dao.getClassementBrainsNom();
	}

	public List<Idee> getClassementVoteTitre() {
		IIdeeDao dao = new IdeeDao(em, utx);
		return dao.getClassementVoteTitre();
	}

	public List<Integer> getClassementVoteNum() {
		IIdeeDao dao = new IdeeDao(em, utx);
		return dao.getClassementVoteNum();
	}

}
