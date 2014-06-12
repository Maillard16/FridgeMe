package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import bo.Aliment;
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
	      if(rs.next())
	        return new TypeRecette(
	          id,
	          rs.getString("nom")
	        );         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return null;
	}
	
	@Override
	public Vector<TypeRecette> getListAllItems() {
		Vector<TypeRecette> list = new Vector<TypeRecette>();
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM type_recette");
	      rs = s.executeQuery();
	      while(rs.next())
	    	  
	    	  list.add(new TypeRecette(
	    	          rs.getInt("id_type_recette"),
	    	          rs.getString("nom")
	    	        ));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return list;
	}
	
	
	
}
