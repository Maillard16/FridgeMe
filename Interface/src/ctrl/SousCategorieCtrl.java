/*
 -------------------------------------------------------------------------------
 Laboratoire : Projet PRO
 Fichier     : SousCategorie.java
 Auteur(s)   : Julien Bignens, Stéphane Maillard, Anthony Roubaty, Yannick Widmer
 			   et Amine Tayaa
 Date        : 05.2014

 But         : Contrôleur de SousCategorie.
 -------------------------------------------------------------------------------
 */

package ctrl;

import java.util.Vector;

import dao.SousCategorieDao;
import bo.Aliment;
import bo.SousCategorie;

public class SousCategorieCtrl {
	static private SousCategorieDao sousCategorieDao = new SousCategorieDao();

	public static String[] getAllAutorisee() {
		Vector<SousCategorie> sCs = sousCategorieDao.getListAllItemsAutorisee();
		String[] sousCategories = new String[sCs.size()];
		int i = 0;
		for (SousCategorie sC : sCs) {
			sousCategories[i++] = sC.getNom();
		}
		return sousCategories;
	}

	public static String[] getAllInterdite() {
		Vector<SousCategorie> sCs = sousCategorieDao.getListAllItemsInterdite();
		String[] sousCategories = new String[sCs.size()];
		int i = 0;
		for (SousCategorie sC : sCs) {
			sousCategories[i++] = sC.getNom();
		}
		return sousCategories;
	}

	public static void setInterdit(String sCName) {
		SousCategorie sC = sousCategorieDao.findByName(sCName);
		sC.setInterdit(true);
		sousCategorieDao.updateInterdit(sC);
	}

	public static void setAutorise(String sCName) {
		SousCategorie sC = sousCategorieDao.findByName(sCName);
		sC.setInterdit(false);
		sousCategorieDao.updateInterdit(sC);
	}

}
