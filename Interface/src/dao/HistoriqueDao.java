package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import bo.Aliment;
import bo.Historique;

public class HistoriqueDao extends Dao<Historique> {

	@Override
	public boolean create(Historique obj) {
		PreparedStatement pst;
		try {
			pst = connect.prepareStatement("INSERT INTO historique (id_recette, date_heure) VALUES (" + obj.getIdRecette() + ", '" + obj.getDate_heure() + "');");
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Historique obj) {
		PreparedStatement pst;
		try {
			pst = connect.prepareStatement("DELETE FROM historique WHERE date_heure = '" + obj.getDate_heure() + "';");
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Historique obj) {
		
		return false;
	}

	@Override
	public Historique find(int id) {
		
		
		return null;
	}
	
	public Historique findByDate(Timestamp dateHeure) {
		PreparedStatement pst;
		ResultSet rs;
		
		
		try {
			pst = connect.prepareStatement("SELECT * FROM historique WHERE date_heure = " + dateHeure);
			rs = pst.executeQuery();
			
			if(rs.next()){
				return new Historique(
						dateHeure,
						rs.getInt("id_recette")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Vector<Historique> getListAllItems() {
		Vector<Historique> list = new Vector<Historique>();
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM historique ORDER BY date_heure");
	      rs = s.executeQuery();
	      while(rs.next())
	    	  
	    	  list.add(new Historique(
						rs.getString("date_heure"),
						rs.getInt("id_recette")
						));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    
	    return list;
	}

}
