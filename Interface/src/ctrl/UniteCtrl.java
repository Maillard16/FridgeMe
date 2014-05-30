package ctrl;

import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.event.ListDataListener;

import dao.UniteDao;

import bo.Unite;

public class UniteCtrl {
	
	
	public void setUniteList(JComboBox comboUnite){
		UniteDao uniteDao = new UniteDao();
		comboUnite.setModel(new DefaultComboBoxModel(uniteDao.getListUnit()));
		
		
	}
	
}
