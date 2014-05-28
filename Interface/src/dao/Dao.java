package dao;

import java.sql.Connection;

public abstract class Dao<Element> {
	protected Connection connect = null;

	public Dao() {
		connect = SqlConnexion.getConnection();
	}

	/**
	 * Méthode de création
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean create(Element obj);

	/**
	 * Méthode pour effacer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean delete(Element obj);

	/**
	 * Méthode de mise à jour
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean update(Element obj);

	/**
	 * Méthode de recherche des informations
	 * 
	 * @param id
	 * @return T
	 */
	public abstract Element find(int id);

}
