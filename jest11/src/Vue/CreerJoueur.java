package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import Controleur.*;

import java.awt.Font;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextField;
import Modele.*;

/**
 * Cette classe present une fenetre de choisir le nombre de joueurs sur le ecran
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 */
public class CreerJoueur {
	public JFrame frame;
	public JButton button = new JButton("Contiuer");
	private JTextField []texts = new JTextField[4];
	private JLabel lblNewLabel = new JLabel("Le nom de premier joueur?");
	private JLabel lblNewLabe2 = new JLabel("Le nom de deuxieme joueur?");
	private JLabel lblNewLabe3 = new JLabel("Le nom de troisieme joueur?");
	private JLabel lblNewLabe4 = new JLabel("Le nom de quatrieme joueur?");
	private Accueuil a=Accueuil.getInstance();
	private int index=0;
	
	/**
	 * Creer l'application.
	 */
	public CreerJoueur() {
		initialize();
	}

	/**
	 * Initialiser les contents de la frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		button.setBounds(232, 308, 128, 45);
		frame.getContentPane().add(button);
	
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);			
		lblNewLabel.setBounds(45, 68, 366, 22);
		frame.getContentPane().add(lblNewLabel);
	
		for(int i=0;i<4;i++) {
			texts[i]=new JTextField();
		}
		texts[0].setBounds(423, 71, 140, 20);
		texts[0].setColumns(10);
		frame.getContentPane().add(texts[0]);
	
		lblNewLabe2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabe2.setHorizontalAlignment(SwingConstants.LEFT);			
		lblNewLabe2.setBounds(45, 127, 366, 22);
		frame.getContentPane().add(lblNewLabe2);
	
		texts[1].setBounds(423, 130, 140, 20);
		texts[1].setColumns(10);
		frame.getContentPane().add(texts[1]);
	
		lblNewLabe3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabe3.setHorizontalAlignment(SwingConstants.LEFT);			
		lblNewLabe3.setBounds(45, 184, 366, 22);
		frame.getContentPane().add(lblNewLabe3);
	
		texts[2].setBounds(423, 187, 140, 20);	
		texts[2].setColumns(10);
		frame.getContentPane().add(texts[2]);
	
		lblNewLabe4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabe4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabe4.setBounds(45, 239, 366, 22);
		frame.getContentPane().add(lblNewLabe4);
	
		texts[3].setBounds(423, 242, 140, 20);
		texts[3].setColumns(10);
		frame.getContentPane().add(texts[3]);

		ControleurJeu4 cj=new ControleurJeu4(frame,texts[0],texts[1],texts[2],texts[3],button);

		ConsoleListener cs = new ConsoleListener(new Scanner(System.in), new ConsoleListener.Action() {
			public void act(String msg) {
        	if(index<4) {
        		texts[index]=new JTextField(msg);
        	}
        	index++;
			}
		});
		cs.listenInNewThread();
	}
}
