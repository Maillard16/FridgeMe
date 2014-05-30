package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
	
	//Permet de mettre à jour que le champs interdit
	@Override
	public boolean update(SousCategorie obj) {
		PreparedStatement pst;
		try {
			pst = connect
					.prepareStatement("UPDATE sous_categorie SET interdit = "+ obj.getInterdit() 
							+" WHERE id_sous_categorie = " + obj.getIdCategorie());

			pst.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public SousCategorie find(int id) {
		PreparedStatement pst;
		ResultSet rs;
	      
	    try {
	      pst = connect.prepareStatement("SELECT * FROM sous_categorie WHERE id_sous_categorie = " + id);
	      rs = pst.executeQuery();
	      if(rs.first())
	        return new SousCategorie(
	          id,
	          rs.getString("nom"),
	          rs.getBoolean("interdit"),
	          rs.getInt("id_categories"));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return null;
	}
	
}
