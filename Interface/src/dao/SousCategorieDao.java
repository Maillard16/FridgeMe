package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import bo.Aliment;
import bo.SousCategorie;


public class SousCategorieDao extends Dao<SousCategorie> {

	@Override
	public boolean create(SousCategorie obj) {
		return false;
	}

	@Override
	public boolean delete(SousCategorie obj) {
		return false;
	}
	
	@Override
	public boolean update(SousCategorie obj) {
		return false;
	}

	@Override
	public SousCategorie find(int id) {
		PreparedStatement pst;
		ResultSet rs;
	      
	    try {
	      pst = connect.prepareStatement("SELECT * FROM sous_categorie WHERE id_sous_categorie = " + id);
	      rs = pst.executeQuery();
	      if(rs.next())
	        return new SousCategorie(
	          id,
	          rs.getString("nom"),
	          rs.getBoolean("interdit"),
	          rs.getInt("id_categorie"));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return null;
	}
	
	@Override
	public Vector<SousCategorie> getListAllItems() {
		Vector<SousCategorie> list = new Vector<SousCategorie>();
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM sous_categorie");
	      rs = s.executeQuery();
	      while(rs.next())
	    	  
	    	  list.add(new SousCategorie(
	    	          rs.getInt("id_sous_categorie"),
	    	          rs.getString("nom"),
	    	          rs.getBoolean("interdit"),
	    	          rs.getInt("id_categorie")));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return list;
	}

	public Vector<SousCategorie> getListAllItemsAutorisee() {
		Vector<SousCategorie> list = new Vector<SousCategorie>();
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM sous_categorie WHERE interdit = 0");
	      rs = s.executeQuery();
	      while(rs.next())
	    	  
	    	  list.add(new SousCategorie(
	    	          rs.getInt("id_sous_categorie"),
	    	          rs.getString("nom"),
	    	          rs.getBoolean("interdit"),
	    	          rs.getInt("id_categorie")));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return list;
	}

	public Vector<SousCategorie> getListAllItemsInterdite() {
		Vector<SousCategorie> list = new Vector<SousCategorie>();
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM sous_categorie WHERE interdit = 1");
	      rs = s.executeQuery();
	      while(rs.next())
	    	  
	    	  list.add(new SousCategorie(
	    	          rs.getInt("id_sous_categorie"),
	    	          rs.getString("nom"),
	    	          rs.getBoolean("interdit"),
	    	          rs.getInt("id_categorie")));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return list;
	}

	public SousCategorie findByName(String sCName) {
		PreparedStatement pst;
		ResultSet rs;
	      
	    try {
	      pst = connect.prepareStatement("SELECT * FROM sous_categorie WHERE nom = '" + sCName + "';");
	      rs = pst.executeQuery();
	      if(rs.next())
	        return new SousCategorie(
	          rs.getInt("id_sous_categorie"),
	          rs.getString("nom"),
	          rs.getBoolean("interdit"),
	          rs.getInt("id_categorie"));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return null;
	}

	public boolean updateInterdit(SousCategorie sC) {
		PreparedStatement s;
	    int row = 0;
	    
		int interdit = sC.getInterdit() ? 1 : 0;
		try {
			s = connect
					.prepareStatement("UPDATE sous_categorie SET interdit = " + interdit 
							+" WHERE id_sous_categorie = " + sC.getIdSousCategorie() + ";");

			s.executeUpdate();
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
