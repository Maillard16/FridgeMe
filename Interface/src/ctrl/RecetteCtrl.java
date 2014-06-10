package ctrl;

import java.util.Vector;

import dao.RecetteAlimentDao;
import dao.RecetteDao;
import bo.Aliment;
import bo.Recette;
import bo.RecetteAliment;

public class RecetteCtrl {
	static private RecetteDao recetteDao = new RecetteDao();
	static private RecetteAlimentDao recetteAlimentDao = new RecetteAlimentDao();
	
	public static Vector<Recette> getRecetteRapide(int nombreRecette) {
		Vector<Recette> allRecettes = recetteDao.getListAllItems();
		Vector<Aliment> aliments = AlimentCtrl.getAlimentFrigo();
		Vector<Recette> recettesSelectionnees = new Vector<Recette>();
		
		for (Recette r : allRecettes) {
			RecetteCtrl.setAlimentsRecette(r);
		}
		
		for (int i = 0; i < nombreRecette; i++) {
			double ptsMax = -1.0;
			Recette recetteSelectionnee = null;
			
			for (Recette r : allRecettes) {
				double score = RecetteCtrl.getScore(r, aliments);
				if (score > ptsMax) {
					ptsMax = score;
					recetteSelectionnee = r;
				}
			}
			
			recettesSelectionnees.add(recetteSelectionnee);
			allRecettes.remove(recetteSelectionnee);
		}
	
		return recettesSelectionnees;
	}
	
	private static double getScore(Recette r, Vector<Aliment> aliments) {
		Vector<Aliment> alimentsRecette = r.getAlimentsRecette();
		int prioriteMax = 0;
		double score = 0.0;
		for (Aliment alimentRecette : alimentsRecette) {
			if (alimentRecette.getPriorite() > prioriteMax) {
				prioriteMax = alimentRecette.getPriorite();
			}
			for (Aliment alimentFrigo : aliments) {
				if (alimentRecette.getIdAliment() == alimentFrigo.getIdAliment()) {
					if (alimentRecette.getQuantite() <= alimentFrigo.getQuantite()) {
						score += alimentRecette.getPriorite();
					} else {
						score += alimentRecette.getPriorite() / 2;
					}
					continue;
				}
			}
		}
		
		// On pondère
		if (prioriteMax > 0) {
			score = score / (prioriteMax * (prioriteMax + 1) / 2);
		}
		
		return score;
	}

	public static void setAlimentsRecette(Recette recette) {
		Vector<Aliment> alimentsRecette = new Vector<Aliment>();
		Vector<RecetteAliment> recetteAliments = recetteAlimentDao.getListAllItems();
		
		for (RecetteAliment rA : recetteAliments) {
			if (rA.getIdRecette() == recette.getIdRecette()) {
				Aliment aliment = AlimentCtrl.getAlimentbyId(rA.getIdAliment());
				aliment.setQuantite(rA.getQuantite());
				aliment.setPriorite(rA.getPriorite());
				alimentsRecette.add(aliment);
			}
		}
		
		recette.setAlimentsRecette(alimentsRecette);
	}
}
