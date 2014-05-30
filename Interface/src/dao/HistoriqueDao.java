package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bo.Historique;

public class HistoriqueDao extends Dao<Historique> {

	@Override
	public boolean create(Historique obj) {
		PreparedStatement pst;
		try {
			pst = connect.prepareStatement("INSERT INTO historique ("+obj.getDate_heure()+","+obj.getIdRecette()+")");
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
			pst = connect.prepareStatement("DELETE * FROM historique");
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
	
	public Historique findByDate(Date dateHeure) {
		PreparedStatement pst;
		ResultSet rs;
		
		
		try {
			pst = connect.prepareStatement("SELECT * FROM historique WHERE date_heure ="+ dateHeure);
			rs = pst.executeQuery();
			
			if(rs.first()){
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

}
