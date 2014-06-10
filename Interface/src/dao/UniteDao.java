package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import bo.Unite;

public class UniteDao extends Dao<Unite> {

	@Override
	public boolean create(Unite obj) {
		return false;
	}

	@Override
	public boolean delete(Unite obj) {
		return false;
	}

	@Override
	public boolean update(Unite obj) {
		return false;
	}

	@Override
	public Unite find(int id) {
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM unite WHERE id_unite = " + id);
	      rs = s.executeQuery();
	      if(rs.next())
	        return new Unite(
	          id,
	          rs.getString("abreviation"),
	          rs.getString("nom")
	        );         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return null;
	}
	
	public Vector<Unite> getListAllItems() {
		Vector<Unite> listUnite = new Vector<Unite>();
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM unite");
	      rs = s.executeQuery();
	      while(rs.next())
	        listUnite.add(new Unite(
	          rs.getInt("id_unite"),
	          rs.getString("abreviation"),
	          rs.getString("nom")
	        ));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return listUnite;
	}
	
}
