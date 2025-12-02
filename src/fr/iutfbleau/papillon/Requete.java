package fr.iutfbleau.papillon;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JDialog;

public class Requete{
	public static List<Rappel> getAllRappels(){
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			try (Connection cnx = DriverManager.getConnection(
						"jdbc:mariadb://dwarves.iut-fbleau.fr/bissonr", "bissonr", "ananas");
					PreparedStatement pst = cnx.prepareStatement(
						"SELECT * FROM DEV31");
						//"ORDER BY rang ASC");
					ResultSet rs = pst.executeQuery()) {

				int rang = 1;
				List<Rappel> results = new ArrayList<>();
				while (rs.next()) {
					Rappel rap = new Rappel(rs.getString("titre"), rs.getString("contenu"), rs.getInt("theme"), rang, rs.getInt("id"));
					results.add(rap);
					rang++; // Suivi du rang pour l'emplacement des rappels dans le layout
				}
				return results;
			} catch (SQLException e2) {
				System.err.println("Problème lié à la BD : " + e2.getMessage());
				return new ArrayList<>();
			}
		} catch (ClassNotFoundException e) {
			System.err.println("Classe pas trouvée : " + e.getMessage());
			return new ArrayList<>();
		}
	}

}
