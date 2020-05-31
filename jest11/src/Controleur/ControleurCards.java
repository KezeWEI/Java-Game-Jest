package Controleur;
import Modele.*;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Vue.AccueilInterface;
import Vue.CreerJoueur;


/**
 * Cette classe est pour controleur l'action sur l'interface de cartes
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */
public class ControleurCards {
	
	private ImageIcon cluba;
	private ImageIcon club4;
	private ImageIcon club2;
	private ImageIcon club3;
	private ImageIcon coeur2;
	private ImageIcon coeura;
	private ImageIcon coeur3;
	private ImageIcon coeur4;
	private ImageIcon diamond2;
	private ImageIcon diamonda;
	private ImageIcon diamond3;
	private ImageIcon diamond4;
	private ImageIcon spade2;
	private ImageIcon spadea;
	private ImageIcon spade3;
	private ImageIcon spade4;
	private ImageIcon joker;
	
	/**
	 * Contructeur par default
	 */ 
	public ControleurCards(){
	cluba = new ImageIcon(AccueilInterface.class.getResource("/Vue/cluba.jpg"));
	club2 = new ImageIcon(AccueilInterface.class.getResource("/Vue/club2.jpg"));
	club3 = new ImageIcon(AccueilInterface.class.getResource("/Vue/club3.jpg"));
	club4 = new ImageIcon(AccueilInterface.class.getResource("/Vue/club4.jpg"));
	coeura = new ImageIcon(AccueilInterface.class.getResource("/Vue/coeura.jpg"));
	coeur2 = new ImageIcon(AccueilInterface.class.getResource("/Vue/coeur2.jpg"));
	coeur3 = new ImageIcon(AccueilInterface.class.getResource("/Vue/coeur3.jpg"));
	coeur4 = new ImageIcon(AccueilInterface.class.getResource("/Vue/coeur4.jpg"));
	diamonda = new ImageIcon(AccueilInterface.class.getResource("/Vue/diamonda.jpg"));
	diamond2 = new ImageIcon(AccueilInterface.class.getResource("/Vue/diamond2.jpg"));
	diamond3 = new ImageIcon(AccueilInterface.class.getResource("/Vue/diamond3.jpg"));
	diamond4 = new ImageIcon(AccueilInterface.class.getResource("/Vue/diamond4.jpg"));
	spadea = new ImageIcon(AccueilInterface.class.getResource("/Vue/spadea.jpg"));
	spade2 = new ImageIcon(AccueilInterface.class.getResource("/Vue/spade2.jpg"));
	spade3 = new ImageIcon(AccueilInterface.class.getResource("/Vue/spade3.jpg"));
	spade4 = new ImageIcon(AccueilInterface.class.getResource("/Vue/spade4.jpg"));
	joker = new ImageIcon(AccueilInterface.class.getResource("/Vue/joker.jpg"));
	}
	
	/**
	 * transmettre la carte a une image
	 * @param c
	 * une carte
	 * @return
	 * l'image de la carte
	 */
	public ImageIcon textToPicture(Cards c) {
		if (c.getValue()==5) {
		return spadea;
		}
		else if (c.getValue()==6) {
			return cluba;
			}
		else if (c.getValue()==7) {
			return diamonda;
			}
		else if (c.getValue()==8) {
			return coeura;
			}
		else if (c.getValue()==9) {
			return spade2;
			}
		else if (c.getValue()==10) {
			return club2;
			}
		else if (c.getValue()==11) {
			return diamond2;
			}
		else if (c.getValue()==12) {
			return coeur2;
			}
		else if (c.getValue()==13) {
			return spade3;
			}
		else if (c.getValue()==14) {
			return club3;
			}
		else if (c.getValue()==15) {
			return diamond3;
			}
		else if (c.getValue()==16) {
			return coeur3;
			}
		else if (c.getValue()==17) {
			return spade4;
			}
		else if (c.getValue()==18) {
			return club4;
			}
		else if (c.getValue()==19) {
			return diamond4;
			}
		else if (c.getValue()==20) {
			return coeur4;
			}
		else {
			return joker;
			}
		
	}
}