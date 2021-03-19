package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Vote;


public interface IVoteDao {

	void createVote(Vote v);
	
	List<Vote> checkVote(Long idIdee, Long idUtil);
}
