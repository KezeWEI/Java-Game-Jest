package Controleur;
import Modele.Accueuil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Vue.CreerJoueur;;

/**
 * Cette classe est pour controleur l'action sur l'interface de SetNbJP
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */
public class ControleurCreerJP3 {
	private JFrame unFrame;
	private JButton unBouton11;
	private JButton unBouton22;
	private JButton unBouton33;
	private JButton unBouton44;
	private int nbp;
	
	/**
	 * 
	 * Contructeur par default
	 * @param bouton11
	 * une bouton
	 * @param bouton22
	 * une bouton
	 * @param bouton33
	 * une bouton
	 * @param bouton44
	 * une bouton
	 */
	public ControleurCreerJP3 (JFrame frame,JButton bouton11,JButton bouton22,JButton bouton33,JButton bouton44){
		unBouton11=bouton11;
		unBouton22=bouton22;
		unBouton33=bouton33;
		unBouton44=bouton44;
		unFrame=frame;
		Accueuil a=Accueuil.getInstance();
		
		unBouton11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					unFrame.setVisible(false);
					CreerJoueur window = new CreerJoueur();
					window.frame.setVisible(true);
					a.setJoueurPhysique(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		unBouton22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					unFrame.setVisible(false);
					CreerJoueur window = new CreerJoueur();
					window.frame.setVisible(true);
					a.setJoueurPhysique(2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			
		unBouton33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {						
					unFrame.setVisible(false);
					CreerJoueur window = new CreerJoueur();
					window.frame.setVisible(true);
					a.setJoueurPhysique(3);
				} catch (Exception e) {
						e.printStackTrace();
				}
			}
		});
			
		unBouton44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					unFrame.setVisible(false);
					CreerJoueur window = new CreerJoueur();
					window.frame.setVisible(true);
					a.setJoueurPhysique(4);
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
		});
	}
		
}
