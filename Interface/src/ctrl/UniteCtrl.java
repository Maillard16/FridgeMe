package ctrl;

import java.util.Vector;

import javax.swing.JComboBox;

import dao.UniteDao;
import bo.Aliment;
import bo.Unite;

public class UniteCtrl {
	static UniteDao uniteDao = new UniteDao();
	
	static public void setUniteList(JComboBox<String> comboUnite){
		Vector<Unite> unites = uniteDao.getListAllItems();
		comboUnite.removeAllItems();
		for (Unite unite : unites) {
			comboUnite.addItem(unite.getNom());
		}
	}

	public static Unite getUnitebyAlimentName(String nomAliment) {
		Aliment aliment = AlimentCtrl.getAlimentbyName(nomAliment);
		return uniteDao.find(aliment.getIdUnite());
	}
	
}
