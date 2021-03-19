package fr.epsi.entite;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Idee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titre;
	
	private String description;
	
	private String urlImage;
	
	private Integer note =0;
	
	private Integer top = 0;
	
	private Integer flop = 0;
	
	private String categorie;
	
	private String utilisateur;

	private String nomUtil;
	
	private String date;
	
	private Double moyenne;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getTitre() {
		return this.titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getUrlImage() {
		return this.urlImage;
	}
	
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
	public Integer getNote() {
		return this.note;
	}
	
	public void setNote(Integer note) {
		this.note = note;
	}
	
	
	public Integer getTop() {
		return this.top;
	}
	
	public void setTop(Integer top) {
		
		this.top = top;
		this.setMoyenne();
	}
	
	public Integer getFlop() {
		return this.flop;
	}
	
	public void setFlop(Integer flop) {
		this.flop = flop;
		this.setMoyenne();
	}
	
	public Double getMoyenne() {
		return this.moyenne;
	}
	
	public void setMoyenne() {
		Integer c = (this.getTop() / (this.getTop() +this.getFlop() ) * 100);
		this.moyenne = Double.valueOf(c);

	}
	
	public String getCategorie() {
		return this.categorie;
	}
	
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public String getUtilisateur() {
		return this.utilisateur;
	}
	
	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public String getNomUtil() {
		return this.nomUtil;
	}
	
	public void setNomUtil(String nomUtil) {
		this.nomUtil = nomUtil;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void SetDate() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		Date bruteDate = new Date(); 
		
		this.date = formatter.format(bruteDate);
	}
	

	
}
