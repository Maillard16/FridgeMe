/*
 -------------------------------------------------------------------------------
 Laboratoire : Projet PRO
 Fichier     : Parametre.java
 Auteur(s)   : Julien Bignens, Stéphane Maillard, Anthony Roubaty, Yannick Widmer
 			   et Amine Tayaa
 Date        : 05.2014

 But         : Modèle de Parametre.
 -------------------------------------------------------------------------------
 */

package bo;

public class Parametre {
	private int id_parametre;
	private int nb_personne;
	
	public Parametre() {
		super();
	}
	
	public Parametre(int id_parametre, int nb_personne) {
		this.id_parametre = id_parametre;
		this.nb_personne = nb_personne;
	}
	
	public int getIdParametre() {
		return id_parametre;
	}
	
	public int getNbPersonne() {
		return nb_personne;
	}
	
	public void setNbPersonne(int nb_personne) {
		this.nb_personne = nb_personne;
	}
}
