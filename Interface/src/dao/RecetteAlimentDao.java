/*
 -------------------------------------------------------------------------------
 Laboratoire : Projet PRO
 Fichier     : RecetteAlimentDao.java
 Auteur(s)   : Julien Bignens, Stéphane Maillard, Anthony Roubaty, Yannick Widmer
 			   et Amine Tayaa
 Date        : 05.2014

 But         : DAO de RecetteAliment.
 -------------------------------------------------------------------------------
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import bo.Aliment;
import bo.RecetteAliment;

public class RecetteAlimentDao extends Dao<RecetteAliment> {

	@Override
	public boolean create(RecetteAliment obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(RecetteAliment obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(RecetteAliment obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RecetteAliment find(int id) {
		
		return null;
	}
	
	public RecetteAliment findByKey(int idRecette, int idAliment, int priorite) {
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = connect.prepareStatement("SELECT * FROM recette_aliment WHERE id_recette = "+
						idRecette +" AND id_aliment = "+ idAliment + " AND priorite = " + priorite + ";");
			rs = pst.executeQuery();
			if(rs.next()){
				return new RecetteAliment(
						idAliment,
						idRecette,
						rs.getInt("quantite"),
						priorite,
						rs.getString("nom_complet")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Vector<RecetteAliment> getListAllItems() {
		Vector<RecetteAliment> list = new Vector<RecetteAliment>();
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM recette_aliment");
	      rs = s.executeQuery();
	      while(rs.next()) {
	    	  list.add(new RecetteAliment(
	    			  	rs.getInt("id_aliment"),
	    			  	rs.getInt("id_recette"),
						rs.getInt("quantite"),
						rs.getInt("priorite"),
						rs.getString("nom_complet")
						));
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return list;
	}

	public Vector<RecetteAliment> getListAllItemsRecette(int idRecette) {
		Vector<RecetteAliment> list = new Vector<RecetteAliment>();
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM recette_aliment WHERE id_recette = " + idRecette + ";");
	      rs = s.executeQuery();
	      while(rs.next()) {
	    	  list.add(new RecetteAliment(
	    			  	rs.getInt("id_aliment"),
	    			  	rs.getInt("id_recette"),
						rs.getInt("quantite"),
						rs.getInt("priorite"),
						rs.getString("nom_complet")
						));
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return list;
	}
}
