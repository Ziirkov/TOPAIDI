package fr.epsi.servlet;

import java.io.IOException;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.entite.Idee;
import fr.epsi.entite.Utilisateur;
import fr.epsi.service.IUtilisateurService;
import fr.epsi.service.IVoteService;

@WebServlet("/utilisateur")
public class UtilisateurServlet extends HttpServlet{

	@EJB
	private IUtilisateurService service;
	

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
        {
		
			if(req.getParameter("action").equals("list"))
			{
				
				req.setAttribute("utilisateurs", service.getUtilisateur());
		
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/utilisateur.jsp").forward(req, resp);
			}
			else if(req.getParameter("action").equals("creer"))
			{
				req.setAttribute("utilisateurs", service.getUtilisateur());
		
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/createUtilisateur.jsp").forward(req, resp);
			}
        }
	
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException
	        {
		 		
				if(req.getParameter("action").equals("list"))
				{
					
					String email = req.getParameter("email");
					int pass = req.getParameter("password").hashCode();
					
					if(service.compareUtilisateur(email, pass).isEmpty() == false)
					{
						Utilisateur u = service.getUserFromEmail(email);
						
						HttpSession session = req.getSession();
						
						session.setAttribute("nom", u.getNom());
						session.setAttribute("email", email);
						session.setAttribute("password", pass);
						
						resp.sendRedirect("http://localhost:8080/Topaidi-0.0.1-SNAPSHOT/idee?action=list");
					}else
					{
						resp.sendRedirect("http://localhost:8080/Topaidi-0.0.1-SNAPSHOT/utilisateur?action=creer");
					}
	
				}
				else if(req.getParameter("action").equals("creer"))
				{
					Utilisateur u = new Utilisateur();
					u.setNom(req.getParameter("nom"));
					u.setEmail(req.getParameter("email"));
					u.setPassword(req.getParameter("password"));
					
					service.createUtilisateur(u);
					
					resp.sendRedirect("http://localhost:8080/Topaidi-0.0.1-SNAPSHOT/utilisateur?action=list");
				}
	        }
	
	
}
