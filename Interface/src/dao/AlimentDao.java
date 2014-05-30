package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import bo.Aliment;

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
	      if(rs.first())
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
	
	public Vector<Aliment> findByNom(String nom) {
		PreparedStatement s;
		ResultSet rs;
		Vector<Aliment> listAliment = new Vector<Aliment>();
	    try {
	      s = connect.prepareStatement("SELECT * FROM aliment WHERE nom = " + nom);
	      rs = s.executeQuery();
	      while(rs.next()) {
	    	  Aliment a = new Aliment(
	          rs.getInt("id"),
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
		return null;
	}

}
