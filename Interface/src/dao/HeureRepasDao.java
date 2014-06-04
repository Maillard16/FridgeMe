package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import bo.Aliment;
import bo.HeureRepas;

public class HeureRepasDao extends Dao<HeureRepas> {

	@Override
	public boolean create(HeureRepas obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(HeureRepas obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(HeureRepas obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HeureRepas find(int id) {
		PreparedStatement pst;
		ResultSet rs;

		try {
			pst = connect
					.prepareStatement("SELECT * FROM heure_repas WHERE id_heure_repas = "
							+ id);
			rs = pst.executeQuery();

			if (rs.first()) {
				return new HeureRepas(id, rs.getString("nom"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Vector<HeureRepas> getListAllItems() {
		Vector<HeureRepas> list = new Vector<HeureRepas>();
		PreparedStatement s;
		ResultSet rs;

		try {
			s = connect.prepareStatement("SELECT * FROM heure_repas");
			rs = s.executeQuery();
			while (rs.next())

				list.add(new HeureRepas(rs.getInt("id_heure_repas"), rs
						.getString("nom")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
