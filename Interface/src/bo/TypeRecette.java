/*
 -------------------------------------------------------------------------------
 Laboratoire : Projet PRO
 Fichier     : TypeRecette.java
 Auteur(s)   : Julien Bignens, Stéphane Maillard, Anthony Roubaty, Yannick Widmer
 			   et Amine Tayaa
 Date        : 05.2014

 But         : Modèle de TypeRecette.
 -------------------------------------------------------------------------------
 */

package bo;

public class TypeRecette {
	private int idTypeRecette;
	private String nom;
	
	public TypeRecette(){
		super();
	}
	
	public TypeRecette(int idTypeRecette, String nom) {
		super();
		this.idTypeRecette = idTypeRecette;
		this.nom = nom;
	}

	public int getIdTypeRecette() {
		return idTypeRecette;
	}

	public void setIdTypeRecette(int idTypeRecette) {
		this.idTypeRecette = idTypeRecette;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "TypeRecette [idTypeRecette=" + idTypeRecette + ", nom=" + nom
				+ "]";
	}
	
	
	
}
