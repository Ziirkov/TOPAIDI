package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Idee;

public interface IIdeeService {

	void createIdee(Idee i);
	
	List<Idee> getIdee();
	
	void updateNoteTop(Long id);
	
	void updateNoteFlop(Long id);
	
	void updateMoyenne(Long id);
	
	Idee getIdeeFromId(Long id);
	
	List<Idee> getClassementTop();
	
	List<Long> getClassementBrainsStat();
	
	List<String> getClassementBrainsNom();
	
	List<Idee> getClassementVoteTitre();
	
	List<Integer> getClassementVoteNum();
}
