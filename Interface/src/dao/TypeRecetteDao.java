package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bo.TypeRecette;
import bo.Unite;

public class TypeRecetteDao extends Dao<TypeRecette> {

	@Override
	public boolean create(TypeRecette obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TypeRecette obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TypeRecette obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TypeRecette find(int id) {
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM type_recette WHERE id_type_recette = " + id);
	      rs = s.executeQuery();
	      if(rs.first())
	        return new TypeRecette(
	          id,
	          rs.getString("nom")
	        );         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return null;
	}
	
	
	
}
