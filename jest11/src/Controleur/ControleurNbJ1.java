package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import Vue.*;


/**
 * Cette classe est pour controleur l'action sur l'interface de AccueilInterface
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */
public class ControleurNbJ1 {
	
	private JButton unBouton;
	private JFrame unFrame;
	
	/**
	 *  constructeur
	 * @param bouton
	 * un button
	 */
	public ControleurNbJ1 (JFrame frame,JButton bouton){
		unBouton=bouton;
		unFrame=frame;
		// L'appuie sur le bouton
		unBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					unFrame.setVisible(false);
					SetNbJoueur window = new SetNbJoueur();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

}