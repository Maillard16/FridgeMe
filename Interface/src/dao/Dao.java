/*
 -------------------------------------------------------------------------------
 Laboratoire : Projet PRO
 Fichier     : Dao.java
 Auteur(s)   : Julien Bignens, Stéphane Maillard, Anthony Roubaty, Yannick Widmer
 			   et Amine Tayaa
 Date        : 05.2014

 But         : Super classe pour la couche DAO.
 -------------------------------------------------------------------------------
 */

package dao;

import java.sql.Connection;
import java.util.Vector;

import bo.Unite;

public abstract class Dao<Element> {
	protected Connection connect = null;

	public Dao() {
		connect = SqlConnexion.getConnection();
	}

	/**
	 * M�thode de cr�ation
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean create(Element obj);

	/**
	 * M�thode pour effacer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean delete(Element obj);

	/**
	 * M�thode de mise � jour
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean update(Element obj);

	/**
	 * M�thode de recherche des informations
	 * 
	 * @param id
	 * @return T
	 */
	public abstract Element find(int id);
	
	
	public abstract Vector<Element> getListAllItems();

}
