/*
 -------------------------------------------------------------------------------
 Laboratoire : Projet PRO
 Fichier     : SqlConnexion.java
 Auteur(s)   : Julien Bignens, Stéphane Maillard, Anthony Roubaty, Yannick Widmer
 			   et Amine Tayaa
 Date        : 05.2014

 But         : Connexion à la base de données.
 -------------------------------------------------------------------------------
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class SqlConnexion {
	private static SqlConnexion instance = null;
	private static Connection connect;

	private SqlConnexion() {
		try {
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:sqlite:database/FridgeMe.db");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Echec de la connexion à la base de données");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	/*
	 * private Connection connect(){ Connection connect = null;
	 * 
	 * try { Class.forName("org.sqlite.JDBC"); connect =
	 * DriverManager.getConnection("jdbc:sqlite:fridgeMe.db"); } catch (
	 * Exception e ) { System.err.println( e.getClass().getName() + ": " +
	 * e.getMessage() ); }
	 * 
	 * System.out.println("Connection to database: successfull");
	 * 
	 * return connect; }
	 */

	public static Connection getConnection() {
		if (instance == null)
			instance = new SqlConnexion();

		return connect;
	}
}
