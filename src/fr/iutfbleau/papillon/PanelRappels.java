package fr.iutfbleau.papillon;
import fr.iutfbleau.papillon.ControleurRappel;


import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;

/**
 * La classe <code>PanelRappels</code> est utilisée l'affichage et la gestion des rappels.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class PanelRappels extends JPanel{
    /**
     * Contraintes pour GridBadLayout.
     */
    private GridBagConstraints contraintes;
    private List<Rappel> listRappels;
    private ArrayList<Rappel> listRappelsModif;
    
    /**
     * Le constructeur de la classe <code>PanelRappels</code> initialise tous les composants nécessaire à son affichage 
     */
    public PanelRappels(){
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        contraintes = new GridBagConstraints();
        listRappels=new ArrayList<Rappel>();
        listRappelsModif=new ArrayList<Rappel>();
        listRappels.clear();
        listRappels = Requete.getAllRappels();
        refreshAllRappels();
    }

    public void refreshAllRappels(){
        this.removeAll();
        this.revalidate();
        this.repaint();
        
        int rank = 1;
        for(Iterator<Rappel> iter = listRappels.iterator() ; iter.hasNext() ; rank++){
            Rappel rap = iter.next();
            this.addRappel(rap);
        }
    }

    public void addRappel(Rappel rap){
        contraintes.gridy = rap.getRank();
        contraintes.insets = new Insets(10, 10, 0, 10);
        rap.addMouseListener(new ControleurRappel(rap, this));
        this.add(rap, contraintes); 
    }

    public void deleteRappel(){
    }

    public void updateRappel(){

    }
    /**
     * cette méthode permet de changer la couleur des tous les rappels en fonction du boolean donné. Et met change le staut de tous les rappels 
     * @param statut
     */
    public void setModeModif(boolean statut){
        if (statut){
            for (Rappel r : listRappels){
                r.setModeModif(true); // indique qu'on passe en mode modifier
                r.setColorModif(true);
            }
        }if (!statut){
            for (Rappel r : listRappels){
                r.setModeModif(false);
                r.setColorModif(false);
                r.setSelectedModif(false);
            }
            listRappelsModif.clear();
        }
    }

    // ici c'est la méthode qui stock les deux rappels qu'on veut échanger
    public void addTabRappelModif(Rappel rappel){
        if (listRappelsModif.contains(rappel)){
            return;
        }
        // si on dépasse 2, on enleve le plus ancien
        if (listRappelsModif.size() == 2){
            Rappel supprRappel = listRappelsModif.remove(0);
            supprRappel.setColorModifHover(false);
            supprRappel.setSelectedModif(false);
        }

        // on ajoute la nouvelle sélection
        listRappelsModif.add(rappel);
    }
    public void deleteTabRappelModif(Rappel rappel){
        if (listRappelsModif.contains(rappel)){
            int indexRappel = listRappelsModif.indexOf(rappel);
            if (indexRappel==1){
                listRappelsModif.remove(indexRappel);
            }
            else{ // pour mettre le rappel 1 en position 0
                Rappel rappel1 = listRappelsModif.get(1);
                listRappelsModif.clear();
                listRappelsModif.add(rappel1);

            }
            
        }
    }

    //methode qui va échanger l'ordre des rappels grace listRappelsModif de la méthode addTabRappelModif()
    public void updateTabRappelModif(){
        if (listRappelsModif.size() != 2){
            JOptionPane.showMessageDialog(this, "Vous devez sélectionner exactement 2 rappels pour les échanger.");
            return;
        }
        
    }
}
