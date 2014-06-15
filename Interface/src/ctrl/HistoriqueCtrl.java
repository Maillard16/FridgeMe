package ctrl;

import java.util.Vector;
import java.sql.Timestamp;

import dao.HistoriqueDao;
import bo.Historique;
import bo.Recette;

public class HistoriqueCtrl {
	static private HistoriqueDao historiqueDao = new HistoriqueDao();

	public static String[] getRecetteHistoriqueNames() {
		Vector<Historique> historique =  historiqueDao.getListAllItems();
		String[] nomRecette = new String[historique.size()];
		int i = 0;
		for (Historique h : historique) {
			nomRecette[i++] = RecetteCtrl.getRecetteById(h.getIdRecette()).getNom();
		}
		return nomRecette;
	}

	public static void addConsommation(Recette recette) {
		historiqueDao.create(new Historique(new Timestamp(System.currentTimeMillis()), recette.getIdRecette()));
	}

	public static void supprimerDeHistorique(int selectedIndex) {
		Vector<Historique> historique = historiqueDao.getListAllItems();
		Historique h = historique.elementAt(selectedIndex);
		historiqueDao.delete(h);
	}

	public static void effacerHistorique() {
		Vector<Historique> historique = historiqueDao.getListAllItems();
		for (Historique h : historique) {
			historiqueDao.delete(h);
		}
	}
}
