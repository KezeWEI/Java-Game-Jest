package Modele;
import java.awt.EventQueue;
import java.util.*;

import javax.swing.JLabel;

import Vue.*;

/**
 * Cette classe est pour le methode main
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */

public class Game {
	
	/**
	 * C'est le main method
	 * @param args
	 * par default
	 */
	public static void main(String []args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccueilInterface window = new AccueilInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Accueuil a=Accueuil.getInstance();	
		
		Calcul c1=new Calcul();
		Calcul c2=new Calcul();
		Calcul c3=new Calcul();
		Calcul c4=new Calcul();
		LinkedList<Calcul> c=new LinkedList<Calcul>();
		
		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(c4);
		a.setnbJoueur();
		a.setJoueurPhysique();
		a.setJoueurVirtuel();
		while(a.partiEncours()) {
			a.getTrophies();
			while (!a.isEmpty()) {
				a.takeCardsBack();
				System.out.println(a.size());
				a.dealer();
				System.out.println(a.size());
				a.chooseCardUp();
				System.out.println(a.size());
				if(a.getNbJoeur()==3) {
					a.compare(a.getJoueurs().get(0).cardUp,a.getJoueurs().get(1).cardUp,a.getJoueurs().get(2).cardUp);
				}
				else {
					a.compare(a.getJoueurs().get(0).cardUp,a.getJoueurs().get(1).cardUp,a.getJoueurs().get(2).cardUp,a.getJoueurs().get(3).cardUp);
				}
				a.takeCards();
				System.out.println("-----------------------------------------------------------");
			}
			a.takeLastCard();
			for (int i=0;i<a.getNbJoeur();i++) {
				a.getJoueurs().get(i).accept(c.get(i));
			}
			for (int i=0;i<a.getNbJoeur();i++) {
				c.get(i).inti();
			}
			a.distrubuerTrophies();
			for (int i=0;i<a.getNbJoeur();i++) {
				a.getJoueurs().get(i).accept(c.get(i));
			}
			int winner=0;
			int note=0;
			for(int i=0;i<a.getNbJoeur();i++) {
				if(note<a.getJoueurs().get(i).value()) {
					note=a.getJoueurs().get(i).value();
					winner=i;
				}
			}
			System.out.println("Le gagnant est: "+a.getJoueurs().get(winner).getNom());
			a=a.restart();
		}
	}
}
