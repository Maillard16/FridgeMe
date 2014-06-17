package ctrl;

import dao.RepasDao;
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

}
