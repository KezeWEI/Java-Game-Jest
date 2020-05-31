package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Modele.Accueuil;
import Vue.CreerJoueur;
import Vue.Jeu3;
import Vue.Jeu4;

/**
 * Cette classe est pour controleur l'action sur l'interface de ChoisirDifficulte
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */

public class ControleurDifficulte5 {
	
	private JButton buttonE;
	private JButton buttonM;
	private JButton buttonD;
	private JFrame unFrame;
	
	/**
	 * constructeur
	 * @param bu1
	 * un bouton
	 * @param bu2
	 * un bouton
	 * @param bu3
	 * un bouton
	 */
	public ControleurDifficulte5 (JFrame frame,JButton bu1,JButton bu2,JButton bu3){
		unFrame=frame;
		buttonE=bu1;
		buttonM=bu2;
		buttonD=bu3;
		Accueuil a=Accueuil.getInstance();
		
		// L'appuie sur le bouton
		buttonE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					unFrame.setVisible(false);
					a.setJoueurVirtuel(1);
					if(a.getJoueurs().size()==3){
						Jeu3 window = Jeu3.getInstance();
						window.frame.setVisible(true);
						}
					else{
						Jeu4 window = Jeu4.getInstance();
						window.frame.setVisible(true);
						}
					
					}
				 catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		buttonM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					unFrame.setVisible(false);
					a.setJoueurVirtuel(2);
					if(a.getJoueurs().size()==3){
						Jeu3 window = Jeu3.getInstance();
						window.frame.setVisible(true);
						}
					else{
						Jeu4 window = Jeu4.getInstance();
						window.frame.setVisible(true);
						}
					
					}
				 catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		buttonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					unFrame.setVisible(false);
					a.setJoueurVirtuel(3);
					if(a.getJoueurs().size()==3){
						Jeu3 window = Jeu3.getInstance();
						window.frame.setVisible(true);
						}
					else{
						Jeu4 window = Jeu4.getInstance();
						window.frame.setVisible(true);
						}
					
					}
				 catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}

}
