package Vue;

import java.awt.EventQueue;

import Controleur.*;
import Vue.ConsoleListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Icon;


/**
 * Cette classe present une fenetre de commencer sur l'ecran
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */
public class AccueilInterface{

	public static JFrame frame;
	private static JLabel lblNewLabel = new JLabel("BIENVENUE");
	private static JButton btnNewButton_1 = new JButton("START");

	/**
	 * Launch the application.
	 * @param args
	 * par default
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the application.
	 */
	public AccueilInterface() {
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
		
		ImageIcon bg=null;
		bg = new ImageIcon(AccueilInterface.class.getResource("/Vue/JEST.jpg"));
		Image im=bg.getImage();
		im=im.getScaledInstance(296,100, 100);
		bg.setImage(im);
		JLabel lblJest = new JLabel(bg);
		lblJest.setBounds(102, 85, 402, 134);
		frame.getContentPane().add(lblJest);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
		lblNewLabel.setToolTipText("Connaissez-vous les regles?");
		lblNewLabel.setBounds(6, 253, 588, 22);
		frame.getContentPane().add(lblNewLabel);
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton_1.setBounds(228, 309, 144, 48);
		frame.getContentPane().add(btnNewButton_1);
		ControleurNbJ1 cg=new ControleurNbJ1(frame,btnNewButton_1);
	}
}
