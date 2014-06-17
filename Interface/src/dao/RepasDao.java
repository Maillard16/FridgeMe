package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import bo.Aliment;
import bo.Repas;

public class RepasDao extends Dao<Repas> {

	@Override
	public boolean create(Repas obj) {
		PreparedStatement pst;
		try {
			pst = connect.prepareStatement("INSERT INTO repas (id_repas, jour, nombre_personne, id_recette, id_heure_repas)" +
										   "VALUES (" + obj.getIdRepas() + ", " + obj.getJour() + ", " + obj.getNombrePersonne() +
										   			", " + obj.getIdRecette() + ", " + obj.getIdHeureRepas() + ");");
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Repas obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Repas obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Repas find(int id) {
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM repas WHERE id_repas = " + id);
	      rs = s.executeQuery();
	      if(rs.next())
	        return new Repas(
	          id,
	          rs.getInt("jour"),
	          rs.getInt("nombre_personne"),
	          rs.getInt("id_recette"),
	          rs.getInt("id_heure_repas"
	        ));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    
	    return null;
	}
	
	@Override
	public Vector<Repas> getListAllItems() {
		Vector<Repas> list = new Vector<Repas>();
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM repas");
	      rs = s.executeQuery();
	      while(rs.next())
	    	  
	    	  list.add(new Repas(
	    	          rs.getInt("id_repas"),
	    	          rs.getInt("jour"),
	    	          rs.getInt("nombre_personne"),
	    	          rs.getInt("id_recette"),
	    	          rs.getInt("id_heure_repas")
	    	        ));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return list;
	}

	public boolean dropPlanning() {
		PreparedStatement s;
	    int row = 0;
	    
	    try {
	      s = connect.prepareStatement("DELETE FROM repas;");
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
