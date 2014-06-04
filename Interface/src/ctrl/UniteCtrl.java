package ctrl;

import java.util.Vector;

import javax.swing.JComboBox;

import dao.UniteDao;
import bo.Unite;

public class UniteCtrl {
	Vector<Unite> unites;
	UniteDao uniteDao = new UniteDao();
	
	public void setUniteList(JComboBox<String> comboUnite){
		unites = uniteDao.getListUnit();
		comboUnite.removeAllItems();
		for (Unite unite : unites) {
			comboUnite.addItem(unite.getNom());
		}
	}
	
}
