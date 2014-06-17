/*
 -------------------------------------------------------------------------------
 Laboratoire : Projet PRO
 Fichier     : Parametre.java
 Auteur(s)   : Julien Bignens, Stéphane Maillard, Anthony Roubaty, Yannick Widmer
 			   et Amine Tayaa
 Date        : 05.2014

 But         : Contrôleur de Parametre.
 -------------------------------------------------------------------------------
 */

package ctrl;

import javax.swing.JOptionPane;

import bo.Parametre;
import dao.ParametreDao;

public class ParametreCtrl {
	static private ParametreDao parametreDao = new ParametreDao();
	
	public static String getNbPersonne(int id_parametre) {
		Parametre parametre = parametreDao.find(id_parametre);
		return "" + parametre.getNbPersonne();
	}

	public static void updateNbPersonne(String nbPersonne) {
		if (!isPositiveInteger(nbPersonne)) {
			JOptionPane.showMessageDialog(null, "Entrée non valide");
		} else {
			Parametre parametre = new Parametre(1, Integer.parseInt(nbPersonne));
			if (!parametreDao.updateNbPersonne(parametre)) {
				JOptionPane.showMessageDialog(null, "Erreur de mise à jour");
			} else {
				JOptionPane.showMessageDialog(null, "Valeur mise à jour");
			}
		}
	}
	
	public static boolean isPositiveInteger(String str)  
	{  
		  try  
		  {  
		    int i = Integer.parseInt(str);
		    if (i <= 0) {
		    	return false;
		    }
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    return false;  
		  } 
		  return true;  
	}
}
