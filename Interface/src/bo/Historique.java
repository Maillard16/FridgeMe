package bo;

import java.sql.Date;

public class Historique {
	private Date date_heure;
	private int idRecette;
	
	
	public Historique() {
		super();
	}

	public Historique(Date date_heure, int idRecette) {
		super();
		this.date_heure = date_heure;
		this.idRecette = idRecette;
	}

	public Date getDate_heure() {
		return date_heure;
	}
	
	public void setDate_heure(Date date_heure) {
		this.date_heure = date_heure;
	}
	
	public int getIdRecette() {
		return idRecette;
	}
	
	public void setIdRecette(int idRecette) {
		this.idRecette = idRecette;
	}

	@Override
	public String toString() {
		return "Historique [date_heure=" + date_heure + ", idRecette="
				+ idRecette + "]";
	}
	
	
	
	
}
