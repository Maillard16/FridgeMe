package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import bo.Aliment;
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
			s = connect
					.prepareStatement("SELECT * FROM categorie WHERE id_categorie = "
							+ id);
			rs = s.executeQuery();
			if (rs.next())
				return new Categorie(id, rs.getString("nom"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Vector<Categorie> getListAllItems() {
		Vector<Categorie> list = new Vector<Categorie>();
		PreparedStatement s;
		ResultSet rs;

		try {
			s = connect.prepareStatement("SELECT * FROM categorie");
			rs = s.executeQuery();
			while (rs.next())

				list.add(new Categorie(rs.getInt("id_categorie"), rs
						.getString("nom")));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
