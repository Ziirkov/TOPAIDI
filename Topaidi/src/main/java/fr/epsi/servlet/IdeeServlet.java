package fr.epsi.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Idee;
import fr.epsi.entite.Utilisateur;
import fr.epsi.entite.Vote;
import fr.epsi.service.IIdeeService;
import fr.epsi.service.IUtilisateurService;
import fr.epsi.service.IVoteService;

@WebServlet("/idee")
public class IdeeServlet extends HttpServlet {

	@EJB
	private IIdeeService service;

	@EJB
	private IVoteService serviceVote;
	
	@EJB
	private IUtilisateurService serviceUser;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
        {
		
			if(req.getParameter("action").equals("list"))
			{
				req.setAttribute("idees", service.getIdee());
		
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/idee.jsp").forward(req, resp);
			}
			else if(req.getParameter("action").equals("creer"))
			{
				req.setAttribute("idees", service.getIdee());
		
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/createIdee.jsp").forward(req, resp);
			}
			else if(req.getParameter("action").equals("classement"))
			{
				req.setAttribute("classementTop", service.getClassementTop());
				req.setAttribute("classementBrainsStat", service.getClassementBrainsStat());
				req.setAttribute("classementBrainsNom", service.getClassementBrainsNom());
				req.setAttribute("classementVoteTitre", service.getClassementVoteTitre());
				req.setAttribute("classementVoteNum", service.getClassementVoteNum());
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/classementIdee.jsp").forward(req, resp);
			}
        }
	
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException
	        {
		 		
				Long id = Long.parseLong(req.getParameter("idIdee"));
				String email = req.getParameter("email");
				Utilisateur u = serviceUser.getUserFromEmail(email);
				
				Vote v = new Vote();
				v.setIdIdee(id);
				v.setIdUtilisateur(u.getId());
				
				 if(req.getParameter("action").equals("creer"))
					{
			    		Idee i = new Idee();
						i.setTitre(req.getParameter("titre"));
						i.setDescription(req.getParameter("description"));
						i.setUrlImage(req.getParameter("url"));
						i.setCategorie(req.getParameter("cat"));
						i.setUtilisateur(req.getParameter("utilisateur"));
						i.setNomUtil(req.getParameter("nomUtil"));
						i.SetDate();
						service.createIdee(i);
						
						resp.sendRedirect("http://localhost:8080/Topaidi-0.0.1-SNAPSHOT/idee?action=list");
					}
				 else if(req.getParameter("action").equals("top"))
					{						
						if(serviceVote.checkVote(v.getIdIdee(), v.getIdUtilisateur()).isEmpty() != true)
						{				
							resp.sendRedirect("http://localhost:8080/Topaidi-0.0.1-SNAPSHOT/idee?action=list");
						}
						else
						{ 
							serviceVote.createVote(v);					
							service.updateNoteTop(id);
							service.updateMoyenne(id );
							resp.sendRedirect("http://localhost:8080/Topaidi-0.0.1-SNAPSHOT/idee?action=list");
						}
					}
				 else if(req.getParameter("action").equals("flop"))
					{

						if(serviceVote.checkVote(v.getIdIdee(), v.getIdUtilisateur()).isEmpty() != true)
						{				
							resp.sendRedirect("http://localhost:8080/Topaidi-0.0.1-SNAPSHOT/idee?action=list");
						}else {
							
							serviceVote.createVote(v);
							service.updateNoteFlop(id);
							service.updateMoyenne(id);
							resp.sendRedirect("http://localhost:8080/Topaidi-0.0.1-SNAPSHOT/idee?action=list");
						}

					}
	        }
}
