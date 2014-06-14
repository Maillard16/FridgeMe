package ctrl;

import java.util.Vector;

import view.RecetteFrame;
import dao.RecetteAlimentDao;
import dao.RecetteDao;
import bo.Aliment;
import bo.Recette;
import bo.RecetteAliment;

public class RecetteCtrl {
	static private RecetteDao recetteDao = new RecetteDao();
	static private RecetteAlimentDao recetteAlimentDao = new RecetteAlimentDao();
	
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
		
		//System.out.println(r.getNom() + " " + score);
		
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

	public static int getRecetteIdByName(String recetteName) {
		int idRecette = recetteDao.findIdByName(recetteName);
		return idRecette;
	}

	public static String[] getRecettesFavorisNames() {
		Vector<Recette> recettes = recetteDao.getListAllFavoris();
		String[] valeurs = new String[recettes.size()];
		int i = 0;
		for (Recette r : recettes) {
			valeurs[i++] = r.getNom();
		}
		return valeurs;
	}

	public static Recette getRecetteById(int idRecette) {
		return recetteDao.find(idRecette);
	}

	public static void AfficherRecetteByName(String nomRecette) {
		Recette recette = recetteDao.find(recetteDao.findIdByName(nomRecette));
		RecetteFrame recetteFrame = new RecetteFrame(recette);
		recetteFrame.setVisible(true);
	}
	
	public static Vector<Recette> getRecetteRapide(int nbRecette) {
		Vector<Recette> allRecettes = recetteDao.getListAllItems();
		Vector<Aliment> aliments = AlimentCtrl.getAlimentFrigo();
		Vector<Recette> recettesSelectionnees = new Vector<Recette>();
		
		for (Recette r : allRecettes) {
			RecetteCtrl.setAlimentsRecette(r);
		}
		
		for (int i = 0; i < nbRecette; i++) {
			if (allRecettes.size() == 0) {
				break;
			}
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

	public static Vector<Recette> getRecetteRapideFavoris(int nbRecette) {
		Vector<Recette> allRecettes = recetteDao.getListAllFavoris();
		Vector<Aliment> aliments = AlimentCtrl.getAlimentFrigo();
		Vector<Recette> recettesSelectionnees = new Vector<Recette>();
		
		for (Recette r : allRecettes) {
			RecetteCtrl.setAlimentsRecette(r);
		}
		
		for (int i = 0; i < nbRecette; i++) {
			if (allRecettes.size() == 0) {
				break;
			}
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

	public static void setFavori(Recette recette, boolean b) {
		recette.setFavoris(b);
		recetteDao.updateFavori(recette);
	}
}
