package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Vote;

public interface IVoteService {

	void createVote(Vote v);
	
	List<Vote> checkVote(Long idIdee, Long idUtil);
}
