package bo;

import java.sql.Date;

public class Historique {
	private Date date_heure;
	private Recette recette;
	
	
	
	public Historique() {
		super();
	}

	public Historique(Date date_heure, Recette recette) {
		super();
		this.date_heure = date_heure;
		this.recette = recette;
	}



	public Date getDate_heure() {
		return date_heure;
	}
	
	public void setDate_heure(Date date_heure) {
		this.date_heure = date_heure;
	}
	
	public Recette getRecette() {
		return recette;
	}
	
	public void setRecette(Recette recette) {
		this.recette = recette;
	}
	
	
}
