/*
 -------------------------------------------------------------------------------
 Laboratoire : Projet PRO
 Fichier     : RepasCtrl.java
 Auteur(s)   : Julien Bignens, Stéphane Maillard, Anthony Roubaty, Yannick Widmer
 			   et Amine Tayaa
 Date        : 05.2014

 But         : Contrôleur de Repas.
 -------------------------------------------------------------------------------
 */

package ctrl;

import java.util.Vector;

import javax.swing.JOptionPane;

import dao.RepasDao;
import bo.Recette;
import bo.Repas;

public class RepasCtrl {
	static private RepasDao repasDao = new RepasDao();
	
	public static boolean isPlanning() {
		if (repasDao.getListAllItems().size() == 0) {
			return false;
		} else {
			return true;
		}
		
	}

	public static Vector<Repas> getPlanning() {
		Vector<Repas> repas = repasDao.getListAllItems();
		return repas;
	}

	public static void dropPlanning() {
		repasDao.dropPlanning();
		
	}

	public static boolean generatePlanning(Vector<Integer> jours,
			Vector<Integer> heures, Vector<String> nbPersonnes,
			Vector<String> types) {
		if (isPlanning()) {
			JOptionPane.showMessageDialog(null, "Il y a déjà un planning");
			return false;
		} else if (jours.size() == 0) {
			JOptionPane.showMessageDialog(null, "Aucune plage selectionnée");
			return false;
		}
		
		for (String nb : nbPersonnes) {
			if (!isPositiveInteger(nb)) {
				JOptionPane.showMessageDialog(null, "Nombre de personne invalide");
				return false;
			}
		}
		Vector<Recette> recette = RecetteCtrl.getRecettePlanning(types);
		
		if (recette.size() != types.size()) {
			JOptionPane.showMessageDialog(null, "Pas assez de recette de ces types");
			return false;
		}
		
		Repas repas;
		for (int i = 0; i < jours.size(); i++) {
			repas = (new Repas(i + 1, jours.get(i), Integer.valueOf(nbPersonnes.get(i)), recette.get(i).getIdRecette(),
					heures.get(i)));
			repasDao.create(repas);
		}
		
		return true;
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
