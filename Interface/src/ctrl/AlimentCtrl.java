package ctrl;
import java.util.Vector;

import javax.swing.table.TableModel;

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

	public static void modifierQuantites(TableModel model) {
		int nombreLignes = model.getRowCount();
		for (int i = 0; i < nombreLignes; i++) {
			int quantite = 0;
			String valueSuppression = (String) model.getValueAt(i, 3);
			if (valueSuppression != null) {
				if (isPositiveInteger(valueSuppression)) {
					quantite -= Integer.valueOf(valueSuppression);
				}
			}
			String valueAjout = (String) model.getValueAt(i, 4);
			if (valueAjout != null) {
				if (isPositiveInteger(valueAjout)) {
					quantite += Integer.valueOf(valueAjout);
				}
			}
			if (quantite != 0) {
				// On modifie la valeur
				Aliment aliment = AlimentCtrl.getAlimentbyName((String) model.getValueAt(i, 0));
				int nouvelleQuantite = aliment.getQuantite() + quantite;
				if (nouvelleQuantite < 0) {
					nouvelleQuantite = 0;
				}
				aliment.setQuantite(nouvelleQuantite);
				alimentDao.updateQuantite(aliment);
			}
		}
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
