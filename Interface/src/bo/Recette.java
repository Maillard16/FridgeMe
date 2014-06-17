/*
 -------------------------------------------------------------------------------
 Laboratoire : Projet PRO
 Fichier     : Recette.java
 Auteur(s)   : Julien Bignens, Stéphane Maillard, Anthony Roubaty, Yannick Widmer
 			   et Amine Tayaa
 Date        : 05.2014

 But         : Modèle de Recette
 -------------------------------------------------------------------------------
 */

package bo;

import java.util.Vector;

import ctrl.AlimentCtrl;

public class Recette {
	private int idRecette;
	private String nom;
	private String description;
	private int tempsCuisson;
	private int tempsPreparation;
	private boolean favoris;
	private String image;
	private int nombrePersonne;
	private boolean nombrePersonneFlexible;
	private int idTypeRecette;
	
	private Vector<Aliment> alimentsRecette;
	
	public Recette(){
		super();
	}
	
	public Recette(int idRecette, String nom, String description,
			int tempsCuisson, int tempsPreparation, boolean favoris,
			String image, int nombrePersonne, boolean nombrePersonneFlexible,
			int idTypeRecette) {
		super();
		this.idRecette = idRecette;
		this.nom = nom;
		this.description = description;
		this.tempsCuisson = tempsCuisson;
		this.tempsPreparation = tempsPreparation;
		this.favoris = favoris;
		this.image = image;
		this.nombrePersonne = nombrePersonne;
		this.nombrePersonneFlexible = nombrePersonneFlexible;
		this.idTypeRecette = idTypeRecette;
	}

	public int getIdRecette() {
		return idRecette;
	}

	public void setIdRecette(int idRecette) {
		this.idRecette = idRecette;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTempsCuisson() {
		return tempsCuisson;
	}

	public void setTempsCuisson(int tempsCuisson) {
		this.tempsCuisson = tempsCuisson;
	}

	public int getTempsPreparation() {
		return tempsPreparation;
	}

	public void setTempsPreparation(int tempsPreparation) {
		this.tempsPreparation = tempsPreparation;
	}

	public boolean isFavoris() {
		return favoris;
	}

	public void setFavoris(boolean favoris) {
		this.favoris = favoris;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNombrePersonne() {
		return nombrePersonne;
	}

	public void setNombrePersonne(int nombrePersonne) {
		this.nombrePersonne = nombrePersonne;
	}

	public boolean getNombrePersonneFlexible() {
		return nombrePersonneFlexible;
	}

	public void setNombrePersonneFlexible(boolean nombrePersonneFlexible) {
		this.nombrePersonneFlexible = nombrePersonneFlexible;
	}

	public int getIdTypeRecette() {
		return idTypeRecette;
	}

	public void setIdTypeRecette(int idTypeRecette) {
		this.idTypeRecette = idTypeRecette;
	}

	@Override
	public String toString() {
		return "Recette [idRecette=" + idRecette + ", nom=" + nom
				+ ", description=" + description + ", tempsCuisson="
				+ tempsCuisson + ", tempsPreparation=" + tempsPreparation
				+ ", favoris=" + favoris + ", image=" + image
				+ ", nombrePersonne=" + nombrePersonne
				+ ", nombrePersonneFlexible=" + nombrePersonneFlexible
				+ ", idTypeRecette=" + idTypeRecette + "]";
	}
	
	
	public void setAlimentsRecette(Vector<Aliment> recetteAliments) {
		this.alimentsRecette = recetteAliments;
	}
	
	public Vector<Aliment> getAlimentsRecette() {
		return alimentsRecette;
	}
}
