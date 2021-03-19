package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Idee;

public interface IIdeeDao {

	void create(Idee a);
	
	List<Idee> getIdee();
	
	void updateNoteTop(Long id);
	
	void updateNoteFlop(Long id);
	
	List<Idee> getClassementTop();
	
	void updateMoyenne(Long id);
	
	Idee getIdeeFromId(Long id);
	
	List<Long> getClassementBrainsStat();
	
	List<String> getClassementBrainsNom();
	
	List<Idee> getClassementVoteTitre();
	
	List<Integer> getClassementVoteNum();
}
