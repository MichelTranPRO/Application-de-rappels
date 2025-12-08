package fr.iutfbleau.papillon;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Requete{

  private static Connection cnx;

  // On charge la connection
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
            "SELECT * FROM DEV31" +
            "ORDER BY rang ASC"); A rajouter après
          ResultSet rs = pst.executeQuery()) {

        List<Rappel> results = new ArrayList<>();
        while (rs.next()) {
          Rappel rap = new Rappel(rs.getString("titre"), rs.getString("contenu"), rs.getInt("theme"), rs.getInt("rang"), rs.getInt("id"));
          results.add(rap);
        }

        return results;
      } catch (SQLException e2) {
        JOptionPane.showMessageDialog(
            null,
            "Problème lié à la BD : " + e2.getMessage(),
            "Erreur",
            JOptionPane.ERROR_MESSAGE
            );
        return new ArrayList<>();
      }
    } catch (ClassNotFoundException e) {
      JOptionPane.showMessageDialog(
          null,
          "Classe pas trouvée : " + e.getMessage(),
          "Erreur",
          JOptionPane.ERROR_MESSAGE
          );
      return new ArrayList<>();
    }
  }

  // Ne pas oublier de faire la vérification des variables au préalable


  public static int insert(int id, String titre, String contenu, int theme) {
    try (PreparedStatement pst1 = cnx.prepareStatement(
          "SELECT MAX(rang) FROM DEV31");
        ResultSet rs1 = pst1.executeQuery()) {

      int nextRang = 1;
      if (rs1.next()) {
        nextRang = rs1.getInt(1) + 1;
      }

      try (PreparedStatement pst2 = cnx.prepareStatement(
            "INSERT INTO DEV31 VALUES(?, ?, ?, ?, ?)")) {

        pst2.setInt(1, id);
        pst2.setString(2, titre);
        pst2.setString(3, contenu);
        pst2.setInt(4, theme);
        pst2.setInt(5, nextRang);

        pst2.executeUpdate();
        return 1;

      } catch (SQLException e2) {
        JOptionPane.showMessageDialog(
            null,
            "Problème lié à la BD : " + e2.getMessage(),
            "Erreur",
            JOptionPane.ERROR_MESSAGE
            );
        return 0;
      }

    } catch (SQLException e3) {
      JOptionPane.showMessageDialog(
          null,
          "Problème lié à la BD : " + e3.getMessage(),
          "Erreur",
          JOptionPane.ERROR_MESSAGE
          );
      return 0;
    }
  }

  public static int swap(int ida, int idb){
    
  }

  public static int delete(int ida, int idb){

  }

}
