package fr.iutfbleau.papillon;

import java.sql.*;
import org.mariadb.jdbc.*;
import java.util.List;
import java.util.ArrayList;

public class Requete{
  public static List<Rappel> getAllRappels(){
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      try (Connection cnx = DriverManager.getConnection(
            "jdbc:mariadb://dwarves.iut-fbleau.fr/bissonr", "bissonr", "ananas");
          PreparedStatement pst = cnx.prepareStatement(
            "SELECT titre FROM DEV31");
          ResultSet rs = pst.executeQuery()) {

        int rang = 1;
        List<Rappel> results = new ArrayList<>();
        while (rs.next()) {
          Rappel rap = new Rappel(rs.getString("titre"), rs.getString("contenu"), rs.getString("theme"), rang, rs.getInt("id"));
          results.add(rap);
          rang++; // Suivi du rang pour l'emplacement des rappels dans le layout
        }
        return results;

      } catch (SQLException e2) {
        System.err.println("Problème lié à la BD. " + e2.getMessage());
        return new ArrayList<>();
      }
    } catch (ClassNotFoundException e) {
      System.out.println("Classe pas trouvée : " + e.getMessage());
      return new ArrayList<>();
    }
  }

}
