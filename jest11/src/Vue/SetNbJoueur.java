package Vue;

import javax.swing.JFrame;
import Controleur.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Scanner;

import javax.swing.JButton;


/**
 * 
 * L'interface graphique pour choisir le nombre de joueurs
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 *
 */
public class SetNbJoueur {

	public JFrame frame;
	private JButton button3 = new JButton("3");
	private JButton button4 = new JButton("4");
	
	/**
	 * Creer l'application.
	 */
	public SetNbJoueur() {
		initialize();
	}

	/**
	 * Initialiser les contents de la frame
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Combien de joueurs voulez-vous definir?");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 120, 588, 77);
		frame.getContentPane().add(lblNewLabel);
		button3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		button3.setBounds(87, 270, 136, 47);
		frame.getContentPane().add(button3);
		button4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		button4.setBounds(354, 270, 136, 47);
		frame.getContentPane().add(button4);
		
		ControleurNbJP2 cnp=new ControleurNbJP2(frame,button3,button4);
		ConsoleListener cs = new ConsoleListener(new Scanner(System.in), new ConsoleListener.Action() {
            public void act(String msg) {
            }
        });
		cs.listenInNewThread();
		 cs.addAction("3 joueurs", new ConsoleListener.Action() {

	            public void act(String msg) {
	            	button3.doClick();
	            	//cs.cancel();
	            }
	      });
		 cs.addAction("4 joueurs", new ConsoleListener.Action() {

	            public void act(String msg) {
	            	button4.doClick();
	            	//cs.cancel();
	            }
	      });
	
	}

}
