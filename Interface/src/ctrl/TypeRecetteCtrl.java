/*
 -------------------------------------------------------------------------------
 Laboratoire : Projet PRO
 Fichier     : TypeRecette.java
 Auteur(s)   : Julien Bignens, Stéphane Maillard, Anthony Roubaty, Yannick Widmer
 			   et Amine Tayaa
 Date        : 05.2014

 But         : Contrôleur de TypeRecette.
 -------------------------------------------------------------------------------
 */

package ctrl;

import java.util.Vector;

import dao.TypeRecetteDao;
import bo.Aliment;
import bo.Recette;
import bo.TypeRecette;

public class TypeRecetteCtrl {
	static private TypeRecetteDao typeRecetteDao = new TypeRecetteDao();

	public static String[] getAllTypeRecetteNames() {
		Vector<TypeRecette> typeRecettes = typeRecetteDao.getListAllItems();
		String[] nomTypeRecette = new String[typeRecettes.size()];
		int i = 0;
		for (TypeRecette tR : typeRecettes) {
			nomTypeRecette[i++] = tR.getNom();
		}
		
		return nomTypeRecette;		
	}

	public static int getIndexByRecette(Recette recette) {
		int index = recette.getIdTypeRecette() - 1;
		return index;
	}

	public static int getIdByName(String name) {
		return typeRecetteDao.findByName(name).getIdTypeRecette();
	}

}
