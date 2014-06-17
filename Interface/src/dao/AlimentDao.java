/*
 -------------------------------------------------------------------------------
 Laboratoire : Projet PRO
 Fichier     : AlimentDao.java
 Auteur(s)   : Julien Bignens, Stéphane Maillard, Anthony Roubaty, Yannick Widmer
 			   et Amine Tayaa
 Date        : 05.2014

 But         : DAO d'Aliment.
 -------------------------------------------------------------------------------
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import bo.Aliment;
import bo.Unite;

public class AlimentDao extends Dao<Aliment> {

	@Override
	public boolean create(Aliment obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Aliment obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Aliment obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Aliment find(int id) {
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM aliment WHERE id_aliment = " + id);
	      rs = s.executeQuery();
	      if(rs.next())
	        return new Aliment(
	          id,
	          rs.getString("nom"),
	          rs.getInt("quantite"),
	          rs.getInt("id_sous_categorie"),
	          rs.getInt("id_unite")
	          );         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return null;
	}
	
	public Vector<Aliment> findByNomIncomplet(String nom) {
		nom = format(nom);
		PreparedStatement s;
		ResultSet rs;
		Vector<Aliment> listAliment = new Vector<Aliment>();
	    try {
	      s = connect.prepareStatement("SELECT * FROM aliment WHERE nom LIKE '%" + nom + "%';");
	      rs = s.executeQuery();
	      while(rs.next()) {
	    	  Aliment a = new Aliment(
	          rs.getInt("id_aliment"),
	          rs.getString("nom"),
	          rs.getInt("quantite"),
	          rs.getInt("id_sous_categorie"),
	          rs.getInt("id_unite")
	          );    
	    	  
	    	  listAliment.add(a);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return listAliment;
	}
	
	public Vector<Aliment> findByNomExact(String nom) {
		nom = format(nom);
		PreparedStatement s;
		ResultSet rs;
		Vector<Aliment> listAliment = new Vector<Aliment>();
	    try {
	      s = connect.prepareStatement("SELECT * FROM aliment WHERE nom = '" + nom + "';");
	      rs = s.executeQuery();
	      while(rs.next()) {
	    	  Aliment a = new Aliment(
	          rs.getInt("id_aliment"),
	          rs.getString("nom"),
	          rs.getInt("quantite"),
	          rs.getInt("id_sous_categorie"),
	          rs.getInt("id_unite")
	          );    
	    	  
	    	  listAliment.add(a);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return listAliment;
	}

	@Override
	public Vector<Aliment> getListAllItems() {
		Vector<Aliment> list = new Vector<Aliment>();
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM aliment");
	      rs = s.executeQuery();
	      while(rs.next())
	    	  
	    	  list.add(new Aliment(
	    	          rs.getInt("id_aliment"),
	    	          rs.getString("nom"),
	    	          rs.getInt("quantite"),
	    	          rs.getInt("id_sous_categorie"),
	    	          rs.getInt("id_unite")
	    	          ));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return list;
	}

	public boolean updateQuantite(Aliment a) {
		PreparedStatement s;
	    int row = 0;
	    
	    try {
	      s = connect.prepareStatement("UPDATE aliment SET quantite = " + a.getQuantite()+ " WHERE id_aliment = " + a.getIdAliment() + ";");
	      row = s.executeUpdate();   
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    
	    if (row == 1) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	public Vector<Aliment> getListFrigo() {
		Vector<Aliment> list = new Vector<Aliment>();
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM aliment WHERE quantite > 0;");
	      rs = s.executeQuery();
	      while(rs.next())
	    	  
	    	  list.add(new Aliment(
	    	          rs.getInt("id_aliment"),
	    	          rs.getString("nom"),
	    	          rs.getInt("quantite"),
	    	          rs.getInt("id_sous_categorie"),
	    	          rs.getInt("id_unite")
	    	          ));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return list;
	}

	public Aliment getAlimentbyName(String nom) {
		nom = format(nom);
		PreparedStatement s;
		ResultSet rs;
	    try {
	      s = connect.prepareStatement("SELECT * FROM aliment WHERE nom = '" + nom + "';");
	      rs = s.executeQuery();
	      while(rs.next()) {
	    	  return new Aliment(
	          rs.getInt("id_aliment"),
	          rs.getString("nom"),
	          rs.getInt("quantite"),
	          rs.getInt("id_sous_categorie"),
	          rs.getInt("id_unite")
	          );
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return null;
	}
	
	private String format(String chaine) {
		String chaineFormatee = new String();
		for (int i = 0; i < chaine.length(); i++) {
			if (chaine.charAt(i) == '\'') {
				chaineFormatee += "\'";
			}
			chaineFormatee += chaine.charAt(i);
		}
		return chaineFormatee;
		
	}

}
