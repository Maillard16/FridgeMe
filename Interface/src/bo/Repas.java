/*
 -------------------------------------------------------------------------------
 Laboratoire : Projet PRO
 Fichier     : Repas.java
 Auteur(s)   : Julien Bignens, Stéphane Maillard, Anthony Roubaty, Yannick Widmer
 			   et Amine Tayaa
 Date        : 05.2014

 But         : Modèle de Repas.
 -------------------------------------------------------------------------------
 */

package bo;

public class Repas {
	private int idRepas;
	private int jour;
	private int nombrePersonne;
	private int idRecette;
	private int idHeureRepas;
	
	public Repas(){
		super();
	}
	
	public Repas(int idRepas, int jour, int nombrePersonne, int idRecette,
			int idHeureRepas) {
		super();
		this.idRepas = idRepas;
		this.jour = jour;
		this.nombrePersonne = nombrePersonne;
		this.idRecette = idRecette;
		this.idHeureRepas = idHeureRepas;
	}

	public int getIdRepas() {
		return idRepas;
	}

	public void setIdRepas(int idRepas) {
		this.idRepas = idRepas;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getNombrePersonne() {
		return nombrePersonne;
	}

	public void setNombrePersonne(int nombrePersonne) {
		this.nombrePersonne = nombrePersonne;
	}

	public int getIdRecette() {
		return idRecette;
	}

	public void setIdRecette(int idRecette) {
		this.idRecette = idRecette;
	}

	public int getIdHeureRepas() {
		return idHeureRepas;
	}

	public void setIdHeureRepas(int idHeureRepas) {
		this.idHeureRepas = idHeureRepas;
	}

	@Override
	public String toString() {
		return "Repas [idRepas=" + idRepas + ", jour=" + jour
				+ ", nombrePersonne=" + nombrePersonne + ", idRecette=" + idRecette
				+ ", idHeureRepas=" + idHeureRepas + "]";
	}
	
	
	
}
