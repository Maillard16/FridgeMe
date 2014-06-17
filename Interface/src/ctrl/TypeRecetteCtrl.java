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
		// On inverse dessert et plat principale
		nomTypeRecette[0] = typeRecettes.get(2).getNom();
		nomTypeRecette[2] = typeRecettes.get(0).getNom();
		
		return nomTypeRecette;		
	}

	public static int getIndexByRecette(Recette recette) {
		int index = recette.getIdTypeRecette() - 1;
		// On inverse dessert et plat principale
		if (index == 0) {
			index = 2;
		} else if (index == 2) {
			index = 0;
		}
		return index;
	}

}
