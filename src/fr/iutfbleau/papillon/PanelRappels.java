package fr.iutfbleau.papillon;

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
    private ArrayList<Rappel> tabRappels;
    
    /**
     * Le constructeur de la classe <code>PanelRappels</code> initialise tous les composants nécessaire à son affichage 
     */
    public PanelRappels(){
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        contraintes = new GridBagConstraints();
        listRappels=new ArrayList<Rappel>();
        tabRappels=new ArrayList<Rappel>();
        refreshAllRappels();
    }

    public void refreshAllRappels(){
        this.removeAll();
        this.revalidate();
        this.repaint();
        listRappels.clear();
        listRappels = Requete.getAllRappels();
        int rank = 1;
        for(Iterator<Rappel> iter = listRappels.iterator() ; iter.hasNext() ; rank++){
            Rappel rap = iter.next();
            this.addRappel(rap.getTitle(), rap.getContent(), rap.getTheme(), rank, rap.getId());
        }
    }

    public void addRappel(String titre, String contexte, int theme, int rang, int id){
        // contraintes.gridx = 0;
        // contraintes.gridy = rang;
        // contraintes.weightx = 1.0;
        // contraintes.insets = new Insets(10, 10, 0, 10); 
        // this.add(new Rappel(titre,contexte,theme,rang,id),contraintes);

        tabRappels.add(new Rappel(titre,contexte,theme,tabRappels.size()+1, 1));
        contraintes.gridy = tabRappels.size()-1;
        contraintes.insets = new Insets(10, 10, 0, 10);
        this.add(tabRappels.get(tabRappels.size()-1), contraintes); 
    }

    public void deleteRappel(){
    }

    public void updateRappel(){

    }

    public void changeColorAllRappels(boolean statut){
        if (statut){
            for (Rappel r : tabRappels){
                r.setColorModify(statut);
            }
        }else{
            for (Rappel r : tabRappels){
                r.setColorModify(statut);
            }
        }
    }
}
