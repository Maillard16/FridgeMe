package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bo.RecetteAliment;

public class RecetteAlimentDao extends Dao<RecetteAliment> {

	@Override
	public boolean create(RecetteAliment obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(RecetteAliment obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(RecetteAliment obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RecetteAliment find(int id) {
		
		return null;
	}
	
	public RecetteAliment findByKey(int idRecette,int idAliment) {
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = connect.prepareStatement("SELECT * FROM recette_aliment WHERE id_recette = "+
						idRecette +" AND id_aliment = "+ idAliment);
			rs = pst.executeQuery();
			if(rs.first()){
				return new RecetteAliment(
						idAliment,
						idRecette,
						rs.getInt("quantite"),
						rs.getInt("priorite"),
						rs.getString("nom_complet")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}
