package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bo.Categorie;

public class CategorieDao extends Dao<Categorie> {

	@Override
	public boolean create(Categorie obj) {
		return false;
	}

	@Override
	public boolean delete(Categorie obj) {
		return false;
	}

	@Override
	public boolean update(Categorie obj) {
		return false;
	}

	@Override
	public Categorie find(int id) {
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM categorie WHERE id_categorie = " + id);
	      rs = s.executeQuery();
	      if(rs.first())
	        return new Categorie(
	          id,
	          rs.getString("nom"
	        ));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    
	    return null;
	}

}
