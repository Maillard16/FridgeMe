package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bo.SousCategorie;
import bo.Unite;

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
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM sous_categorie WHERE id_sous_categorie = " + id);
	      rs = s.executeQuery();
	      if(rs.first())
	        return new SousCategorie(
	          id,
	          rs.getString("nom"),
	          rs.getBoolean("interdit"),
	          rs.getInt("id_categories"
	        ));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return null;
	}

}
