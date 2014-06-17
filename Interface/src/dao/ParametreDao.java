/*
 -------------------------------------------------------------------------------
 Laboratoire : Projet PRO
 Fichier     : ParametreDao.java
 Auteur(s)   : Julien Bignens, Stéphane Maillard, Anthony Roubaty, Yannick Widmer
 			   et Amine Tayaa
 Date        : 05.2014

 But         : DAO de Parametre.
 -------------------------------------------------------------------------------
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import bo.Aliment;
import bo.Historique;
import bo.Parametre;

public class ParametreDao extends Dao<Parametre> {

	@Override
	public boolean create(Parametre obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Parametre obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Parametre obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Parametre find(int id) {
		PreparedStatement s;
		ResultSet rs;
	    try {
	      s = connect.prepareStatement("SELECT * FROM parametre WHERE id_parametre = " + id);
	      rs = s.executeQuery();
	      if(rs.next())
	        return new Parametre(
	          id,
	          rs.getInt("nb_personne")
	          );         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return null;
	}

	@Override
	public Vector<Parametre> getListAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateNbPersonne(Parametre p) {
		PreparedStatement s;
	    int row = 0;
	    
	    try {
	      s = connect.prepareStatement("UPDATE parametre SET nb_personne = " + p.getNbPersonne() + " WHERE id_parametre = " + p.getIdParametre() + ";");
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
}
