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
	      if(rs.next())
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

	public int findIdByName(String chaine) {
		PreparedStatement pst;
		ResultSet rs;
		
		// On formate la chaîne si il y a des '
		
		chaine = format(chaine);
	      
	    try {
	      pst = connect.prepareStatement("SELECT * FROM recette WHERE nom = '" + chaine + "';");
	      rs = pst.executeQuery();
	      if(rs.next()) {
	        return rs.getInt("id_recette");
	                
	      	}
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return 0;
	}
	
	private String format(String chaine) {
		String chaineFormatee = new String();
		for (int i = 0; i < chaine.length(); i++) {
			if (chaine.charAt(i) == '\'') {
				chaineFormatee += "\'";
			}
			chaineFormatee += chaine.charAt(i);
		}
		return chaineFormatee;
		
	}

	public Vector<Recette> getListAllFavoris() {
		Vector<Recette> list = new Vector<Recette>();
		PreparedStatement s;
		ResultSet rs;
	      
	    try {
	      s = connect.prepareStatement("SELECT * FROM recette WHERE favoris = 1");
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

	public boolean updateFavori(Recette recette) {
		PreparedStatement s;
	    int row = 0;
	    
	    try {
	      s = connect.prepareStatement("UPDATE recette SET favoris = " + (recette.isFavoris() ? "1" : "0") + " WHERE id_recette = " + recette.getIdRecette() + ";");
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

	public Vector<Recette> findByNomIncomplet(String nom) {
		nom = format(nom);
		PreparedStatement s;
		ResultSet rs;
		Vector<Recette> listRecette = new Vector<Recette>();
	    try {
	      s = connect.prepareStatement("SELECT * FROM recette WHERE nom LIKE '%" + nom + "%';");
	      rs = s.executeQuery();
	      while(rs.next()) {
	    	  Recette r = new Recette(
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
	          );    
	    	  
	    	  listRecette.add(r);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return listRecette;
	}

	public Vector<Recette> findByNomIncompletFavoris(String nom) {
		nom = format(nom);
		PreparedStatement s;
		ResultSet rs;
		Vector<Recette> listRecette = new Vector<Recette>();
	    try {
	      s = connect.prepareStatement("SELECT * FROM recette WHERE nom LIKE '%" + nom + "%' AND favoris = 1;");
	      rs = s.executeQuery();
	      while(rs.next()) {
	    	  Recette r = new Recette(
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
	          );    
	    	  
	    	  listRecette.add(r);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return listRecette;
	}
}
