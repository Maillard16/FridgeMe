package ctrl;

import java.util.Vector;

import dao.TypeRecetteDao;
import bo.Aliment;
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

}
