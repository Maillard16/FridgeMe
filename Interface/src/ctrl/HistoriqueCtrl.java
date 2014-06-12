package ctrl;

import java.util.Vector;

import dao.HistoriqueDao;
import bo.Historique;

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
}
