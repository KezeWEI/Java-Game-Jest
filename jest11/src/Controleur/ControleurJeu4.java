package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Modele.Accueuil;
import Vue.CreerJoueur;
import Vue.ChoisirDifficulte;

/**
 * Cette classe est pour controleur l'action sur l'interface de CreerJoueur
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */
public class ControleurJeu4 {
	private JFrame unFrame;
	private JTextField unText1;
	private JTextField unText2;
	private JTextField unText3;
	private JTextField unText4;
	private String [] t=new String[4];
	private JButton button;
	
	/**
	 * Contructeur par default
	 * @param text1
	 * une ligne de texte espace
	 * @param text2
	 * une ligne de texte espace
	 * @param text3
	 * une ligne de texte espace
	 * @param text4
	 * une ligne de texte espace
	 * @param bu
	 * un button
	 */
	public ControleurJeu4 (JFrame frame,JTextField text1,JTextField text2,JTextField text3,JTextField text4,JButton bu){
		unText1=text1;
		unText2=text2;
		unText3=text3;
		unText4=text4;
		button=bu;
		unFrame=frame;
		Accueuil a=Accueuil.getInstance();
		unText1.addActionListener(new ActionListener(){ 
		      public void actionPerformed(ActionEvent ae){ 
		    	 t[0] = unText1.getText();
		      } 
		     }); 
		unText2.addActionListener(new ActionListener(){ 
		      public void actionPerformed(ActionEvent ae){ 
		    	  t[1] = unText2.getText(); 
		      } 
		     }); 
		unText3.addActionListener(new ActionListener(){ 
		      public void actionPerformed(ActionEvent ae){ 
		    	  t[2] = unText3.getText(); 
		      } 
		     }); 
		unText4.addActionListener(new ActionListener(){ 
		      public void actionPerformed(ActionEvent ae){ 
		    	  t[3] = unText4.getText(); 
		      } 
		     });
		// L'appuie sur le bouton
		bu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					unFrame.setVisible(false);
					ChoisirDifficulte window = new ChoisirDifficulte();
					window.frame.setVisible(true);
					for(int i=0;i<a.getNbJoueurPhysique();i++) {
						if(t[i]!=null) {
							a.setNomDeJoueur(t[i]);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
