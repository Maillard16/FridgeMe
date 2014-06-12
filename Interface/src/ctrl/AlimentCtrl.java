package ctrl;
import java.util.Vector;

import dao.AlimentDao;
import dao.UniteDao;
import bo.Aliment;

public class AlimentCtrl {
	static private AlimentDao alimentDao = new AlimentDao();
	static private UniteDao uniteDao = new UniteDao();
	
	public static void ajouterAliment(String nomAliment, int quantite) {
		Vector<Aliment> aliments = alimentDao.findByNomExact(nomAliment);
		Aliment aliment = aliments.firstElement();
		aliment.setQuantite(aliment.getQuantite() + quantite);
		alimentDao.updateQuantite(aliment);
	}

	public static String getAlimentName(String nomAliment) {
		Vector<Aliment> aliments = alimentDao.findByNomIncomplet(nomAliment);
		if (aliments.size() > 0) {
			return aliments.firstElement().getNom();
		} else {
			return null;
		}
	}

	public static Vector<Object> getTableModelFrigo(Vector<String> titre) {
		Vector<Aliment> aliments = alimentDao.getListFrigo();
		
		Vector<Object> matrice = new Vector<Object>();
		
        for(Aliment a : aliments){
        	Vector<Object> v= new Vector<Object>();
        	v.add(a.getNom());
        	v.add(a.getQuantite());
        	if (a.getIdUnite() > 0) {
        		v.add(uniteDao.find(a.getIdUnite()).getNom());
        	} else {
        		v.add("");
        	}
        	matrice.add(v);
        }
        
        return matrice;
	}
	
	public static Vector<Aliment> getAlimentFrigo() {
		return alimentDao.getListFrigo();
	}

	public static Aliment getAlimentbyId(int idAliment) {
		return alimentDao.find(idAliment);
	}

	public static Aliment getAlimentbyName(String text) {
		return alimentDao.getAlimentbyName(text);
	}

	public static String[] getAlimentsNames(String nomAliment) {
		Vector<Aliment> aliments = alimentDao.findByNomIncomplet(nomAliment);
		String[] nomAliments = new String[aliments.size()];
		int i = 0;
		for (Aliment a : aliments) {
			nomAliments[i++] = a.getNom();
		}
		return nomAliments;
	}

	public static String[] getAlimentsNamesFrigo() {
		Vector<Aliment> aliments = AlimentCtrl.getAlimentFrigo();
		String[] nomAliments = new String[aliments.size()];
		int i = 0;
		for (Aliment a : aliments) {
			nomAliments[i++] = a.getNom();
		}
		return nomAliments;
	}
}
