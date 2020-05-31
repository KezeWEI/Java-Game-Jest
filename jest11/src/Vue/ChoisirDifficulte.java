package Vue;

import java.awt.EventQueue;
import Controleur.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import Controleur.ControleurDifficulte5;

import java.awt.Font;
import javax.swing.JButton;


/**
 * Cette classe present une fenetre de choisir la difficulte sur l'ecran
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */
public class ChoisirDifficulte {

	public JFrame frame;
	private JLabel lblQuelleDifficulte = new JLabel("Quelle difficulte voulez-vous choisir?");
	private JButton btnEasy = new JButton("EASY");
	private JButton btnMedian = new JButton("MEDIAN");
	private JButton btnDifficult = new JButton("DIFFICULT");

	/**
	 * Create the application.
	 */
	public ChoisirDifficulte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblQuelleDifficulte = new JLabel("Quelle difficulte?");
		lblQuelleDifficulte.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblQuelleDifficulte.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuelleDifficulte.setBounds(77, 137, 438, 57);
		frame.getContentPane().add(lblQuelleDifficulte);
		
		JButton btnEasy = new JButton("EASY");
		btnEasy.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnEasy.setBounds(27, 270, 139, 45);
		frame.getContentPane().add(btnEasy);
		
		JButton btnMedian = new JButton("MEDIAN");
		btnMedian.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnMedian.setBounds(232, 270, 139, 45);
		frame.getContentPane().add(btnMedian);
		
		JButton btnDifficult = new JButton("DIFFICULT");
		btnDifficult.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnDifficult.setBounds(437, 270, 139, 45);
		frame.getContentPane().add(btnDifficult);
		
		ControleurDifficulte5 cd=new ControleurDifficulte5(frame,btnEasy,btnMedian,btnDifficult);
	}
}
