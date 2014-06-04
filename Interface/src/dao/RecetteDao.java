package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import bo.Aliment;
import bo.Recette;

public class RecetteDao extends Dao<Recette> {

	@Override
	public boolean create(Recette obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Recette obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Recette obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Recette find(int id) {
		PreparedStatement pst;
		ResultSet rs;
	      
	    try {
	      pst = connect.prepareStatement("SELECT * FROM recette WHERE id_recette = " + id);
	      rs = pst.executeQuery();
	      if(rs.first())
	        return new Recette(
	          id,
	          rs.getString("nom"),
	          rs.getString("description"),
	          rs.getInt("temps_cuisson"),
	          rs.getInt("temps_preparation"),
	          rs.getBoolean("favoris"),
	          rs.getString("image"),
	          rs.getInt("nombre_personne"),
	          rs.getBoolean("nb_personne_flexible"),
	          rs.getInt("id_type_recette")
	        );         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return null;
	}
	
	@Override
	public Vector<Recette> getListAllItems() {
		Vector<Recette> list = new Vector<Recette>();
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM recette");
	      rs = s.executeQuery();
	      while(rs.next())
	    	  
	    	  list.add(new Recette(
	    	          rs.getInt("id_recette"),
	    	          rs.getString("nom"),
	    	          rs.getString("description"),
	    	          rs.getInt("temps_cuisson"),
	    	          rs.getInt("temps_preparation"),
	    	          rs.getBoolean("favoris"),
	    	          rs.getString("image"),
	    	          rs.getInt("nombre_personne"),
	    	          rs.getBoolean("nb_personne_flexible"),
	    	          rs.getInt("id_type_recette")
	    	        ));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return list;
	}
	
}
