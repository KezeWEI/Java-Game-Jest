package Vue;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Controleur.ControleurCreerJP3;

/**
 * 
 * L'interface graphique pour choisir le nombre de joueurs physiques
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 *
 */
public class SetNbJP {

	public JFrame frame;
	private JButton button_1 = new JButton("1");
	private JButton button_2 = new JButton("2");
	private JButton button_3 = new JButton("3");
	private JButton button_4 = new JButton("4");

	/**
	 * Creer l'application.
	 * @param nb
	 * le nombre du joueur
	 */
	public SetNbJP(int nb) {
		if(nb==3) {
			initialize();}
		else {
			initialize1();
		}
	}

	/**
	 * Initialiser les contents de la frame
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCombienDeJoueurs = new JLabel("Combien de joueurs physique voulez-vous definir?");
		lblCombienDeJoueurs.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblCombienDeJoueurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblCombienDeJoueurs.setBounds(6, 120, 588, 77);
		frame.getContentPane().add(lblCombienDeJoueurs);
		
		button_1.setBounds(27, 270, 136, 47);
		frame.getContentPane().add(button_1);
		
		button_2.setBounds(232, 270, 136, 47);
		frame.getContentPane().add(button_2);
		
		button_3.setBounds(437, 270, 136, 47);
		frame.getContentPane().add(button_3);
		
		ControleurCreerJP3 cjp=new ControleurCreerJP3(frame,button_1,button_2,button_3,button_4); 
	}
	
	/**
	 * Initialiser l'interface
	 */
	private void initialize1() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCombienDeJoueurs = new JLabel("Combien de joueurs physique voulez-vous definir?");
		lblCombienDeJoueurs.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblCombienDeJoueurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblCombienDeJoueurs.setBounds(6, 120, 588, 77);
		frame.getContentPane().add(lblCombienDeJoueurs);
		
		button_1.setBounds(25, 270, 100, 47);
		frame.getContentPane().add(button_1);
		
		button_2.setBounds(175, 270, 100, 47);
		frame.getContentPane().add(button_2);
		

		button_3.setBounds(325, 270, 100, 47);
		frame.getContentPane().add(button_3);


		button_4.setBounds(475, 270, 100, 47);
		frame.getContentPane().add(button_4);
		
		ControleurCreerJP3 cjp=new ControleurCreerJP3(frame,button_1,button_2,button_3,button_4);
		ConsoleListener cs = new ConsoleListener(new Scanner(System.in), new ConsoleListener.Action() {

            public void act(String msg) {
            }
        });
		cs.listenInNewThread();
		cs.addAction("1 joueur physique", new ConsoleListener.Action() {

            public void act(String msg) {
            	button_1.doClick();
            	//cs.cancel();
            }
      });
		cs.addAction("2 joueurs physiques", new ConsoleListener.Action() {

            public void act(String msg) {
            	button_2.doClick();
            	//cs.cancel();
            }
      });
		 cs.addAction("3 joueurs physiques", new ConsoleListener.Action() {

	            public void act(String msg) {
	            	button_3.doClick();
	            	//cs.cancel();
	            }
	      });
		 cs.addAction("4 joueurs physiques", new ConsoleListener.Action() {

	            public void act(String msg) {
	            	button_4.doClick();
	            	//cs.cancel();
	            }
	      });
	}

}
