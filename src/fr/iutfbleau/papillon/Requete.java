package fr.iutfbleau.papillon;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Requete{

  private static Connection cnx;

  // On charge 
  static{
    try {
      cnx = DriverManager.getConnection(
          "jdbc:mariadb://dwarves.iut-fbleau.fr/bissonr", 
          "bissonr", 
          "ananas");

    } catch (SQLException e3) {
      JOptionPane.showMessageDialog(
        null,
        "Impossible de se connecter à la BDD : " + e3.getMessage(),
        "Erreur",
        JOptionPane.ERROR_MESSAGE
      );
      // System.err.println("Impossible de se connecter à la BDD" + e3.getMessage());
    }
  }

  public static List<Rappel> getAllRappels(){
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      try (PreparedStatement pst = cnx.prepareStatement(
            "SELECT * FROM DEV31");
            // "ORDER BY rang ASC"); A rajouter après
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
        JOptionPane.showMessageDialog(
          null,
          "Problème lié à la BD : " + e2.getMessage(),
          "Erreur",
          JOptionPane.ERROR_MESSAGE
        );
        // System.err.println("Problème lié à la BD : " + e2.getMessage());
        return new ArrayList<>();
      }
    } catch (ClassNotFoundException e) {
      JOptionPane.showMessageDialog(
          null,
          "Classe pas trouvée : " + e.getMessage(),
          "Erreur",
          JOptionPane.ERROR_MESSAGE
      );
      // System.err.println("Classe pas trouvée : " + e.getMessage());
      return new ArrayList<>();
    }
  }
  // Ne pas oublier de faire la vérification des variables au préalable
  /* 
     public static int insert(int id, String titre, String contenu, int theme, int rang){

     }

     public static int swap(int ida, int idb){

     }

     public static int delete(int ida, int idb){

     }
     */
}
