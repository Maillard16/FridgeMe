/*
 -------------------------------------------------------------------------------
 Laboratoire : Projet PRO
 Fichier     : Historique.java
 Auteur(s)   : Julien Bignens, Stéphane Maillard, Anthony Roubaty, Yannick Widmer
 			   et Amine Tayaa
 Date        : 05.2014

 But         : Modèle d'Historique.
 -------------------------------------------------------------------------------
 */

package bo;

import java.sql.Timestamp;

public class Historique {
	private String date_heure;
	private int idRecette;
	
	
	public Historique() {
		super();
	}

	public Historique(Timestamp date_heure, int idRecette) {
		super();
		this.date_heure = "" + date_heure;
		this.idRecette = idRecette;
	}
	
	public Historique(String date_heure, int idRecette) {
		super();
		this.date_heure = date_heure;
		this.idRecette = idRecette;
	}

	public String getDate_heure() {
		return date_heure;
	}
	
	public void setDate_heure(Timestamp date_heure) {
		this.date_heure = "" + date_heure;
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
