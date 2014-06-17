package ctrl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.JOptionPane;

import view.RecetteFrame;
import dao.AlimentDao;
import dao.RecetteAlimentDao;
import dao.RecetteDao;
import dao.UniteDao;
import bo.Aliment;
import bo.Recette;
import bo.RecetteAliment;
import bo.Repas;

public class RecetteCtrl {
	static private RecetteDao recetteDao = new RecetteDao();
	static private RecetteAlimentDao recetteAlimentDao = new RecetteAlimentDao();
	static private AlimentDao alimentDao = new AlimentDao();
	static private UniteDao uniteDao = new UniteDao();
	
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

	public static void setAlimentsRecette(Recette recette, Vector<RecetteAliment> recetteAliments) {
		Vector<Aliment> alimentsRecette = new Vector<Aliment>();
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

	public static void AfficherRecetteByName(String nomRecette, String nbPersonne) {
		if (RecetteCtrl.isPositiveInteger(nbPersonne)) {
			Recette recette = recetteDao.find(recetteDao.findIdByName(nomRecette));
			RecetteFrame recetteFrame = new RecetteFrame(recette, nbPersonne);
			recetteFrame.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Nombre de personne incorrect");
		}
	}
	
	public static Vector<Recette> getRecetteRapide(int nbRecette) {
		Vector<Recette> allRecettes = recetteDao.getListAllItemsFiltered();
		Vector<Aliment> aliments = AlimentCtrl.getAlimentFrigo();
		Vector<Recette> recettesSelectionnees = new Vector<Recette>();
		
		Vector<RecetteAliment> recetteAliments = recetteAlimentDao.getListAllItems();
		for (Recette r : allRecettes) {
			RecetteCtrl.setAlimentsRecette(r, recetteAliments);
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
		
		Vector<RecetteAliment> recetteAliments = recetteAlimentDao.getListAllItems();
		for (Recette r : allRecettes) {
			RecetteCtrl.setAlimentsRecette(r, recetteAliments);
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

	public static String[] getRecettesNames(String nomRecette) {
		Vector<Recette> recettes = recetteDao.findByNomIncompletFiltered(nomRecette);
		String[] nomRecettes = new String[recettes.size()];
		int i = 0;
		for (Recette r : recettes) {
			nomRecettes[i++] = r.getNom();
		}
		return nomRecettes;
	}

	public static String[] getRecettesNamesFavoris(String nomRecette) {
		Vector<Recette> recettes = recetteDao.findByNomIncompletFavoris(nomRecette);
		String[] nomRecettes = new String[recettes.size()];
		int i = 0;
		for (Recette r : recettes) {
			nomRecettes[i++] = r.getNom();
		}
		return nomRecettes;
	}

	public static void consommerRecette(Recette recette, String nbPersonne) {
		if (RecetteCtrl.isPositiveInteger(nbPersonne)) {
			JOptionPane.showMessageDialog(null,
					"Nombre de personne incorrect");
		}
		Vector<RecetteAliment> recetteAliments = recetteAlimentDao.getListAllItemsRecette(recette.getIdRecette());
		String consommation = "";
		for (RecetteAliment rA : recetteAliments) {
			Aliment aliment = alimentDao.find(rA.getIdAliment());
			if (aliment.getQuantite() > 0) {
				int nouvelleQuantite = 0;
				int quantiteConsommee = 0;
				if (aliment.getQuantite() > rA.getQuantite()) {
					nouvelleQuantite = aliment.getQuantite() - rA.getQuantite();
					quantiteConsommee = rA.getQuantite();
				} else {
					quantiteConsommee = aliment.getQuantite();
				}
				aliment.setQuantite(nouvelleQuantite);
				alimentDao.updateQuantite(aliment);
				consommation += "\n- " + aliment.getNom() + " : " + quantiteConsommee + " " + uniteDao.find(aliment.getIdUnite()).getNom(); 
			}
		}
		if (!consommation.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Consommation dans le frigo :" + consommation );
		} else {
			JOptionPane.showMessageDialog(null,
					"Aucun aliment consommé dans le frigo.");
		}
		HistoriqueCtrl.addConsommation(recette);
	}

	public static String getIngredientsText(Recette recette) {
		Vector<RecetteAliment> recetteAlimentsVector = recetteAlimentDao.getListAllItemsRecette(recette.getIdRecette());
		RecetteAliment[] recetteAliments = new RecetteAliment[recetteAlimentsVector.size()];
		int i = 0;
		for (RecetteAliment rA : recetteAlimentsVector) {
			recetteAliments[i++] = rA;
		}
		// On trie par ordre décroissant de prioritéss
		Arrays.sort(recetteAliments, new Comparator<RecetteAliment>() {
			@Override
			public int compare(RecetteAliment rA1, RecetteAliment rA2) {
				if(rA1.getPriorite() > rA2.getPriorite())
			    {
			        return -1;
			    }
			    else
			    {
			        if(rA1.getPriorite() < rA2.getPriorite())
			        {
			            return 1;
			        }
			        else
			        {
			            return 0;
			        }
			    } 
			}
		});
		String text = "";
		for (RecetteAliment rA : recetteAliments) {
			text += rA.getNomComplet() + "\n";
		}
		return text;
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

	public static Vector<Recette> getRecettePlanning(Vector<String> types) {
		int nbRecette = types.size();
		Vector<Recette> allRecettes = recetteDao.getListAllItemsFiltered();
		Vector<Aliment> aliments = AlimentCtrl.getAlimentFrigo();
		Vector<Recette> recettesSelectionnees = new Vector<Recette>();
		
		Vector<RecetteAliment> recetteAliments = recetteAlimentDao.getListAllItems();
		for (Recette r : allRecettes) {
			RecetteCtrl.setAlimentsRecette(r, recetteAliments);
		}
		
		for (int i = 0; i < nbRecette; i++) {
			if (allRecettes.size() == 0) {
				break;
			}
			double ptsMax = -1.0;
			Recette recetteSelectionnee = null;
			
			int idType = TypeRecetteCtrl.getIdByName(types.get(i));
			
			for (Recette r : allRecettes) {
				if (r.getIdTypeRecette() != idType) {
					continue;
				}
				double score = RecetteCtrl.getScore(r, aliments);
				if (score > ptsMax) {
					ptsMax = score;
					recetteSelectionnee = r;
				}
			}
			if (ptsMax == -1.0) {
				return recettesSelectionnees;
			}
			recettesSelectionnees.add(recetteSelectionnee);
			allRecettes.remove(recetteSelectionnee);
		}
	
		return recettesSelectionnees;
	}
}
