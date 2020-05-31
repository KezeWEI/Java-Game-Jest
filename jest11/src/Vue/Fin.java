package Vue;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Modele.Accueuil;

public class Fin {

	public JFrame frame;


	/**
	 * Creer l'application.
	 */
	public Fin() {
		initialize();
	}

	/**
	 * Initialiser les contents de la frame.
	 */
	private void initialize() {
		Accueuil a=Accueuil.getInstance();
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		int winner=0;
		int note=0;
		for(int i=0;i<a.getNbJoeur();i++) {
			if(note<a.getJoueurs().get(i).value()) {
				note=a.getJoueurs().get(i).value();
				winner=i;
			}
		}
		JLabel lblvoulezvousJouerUn = new JLabel("Le gagnant est: "+a.getJoueurs().get(winner).getNom());
		lblvoulezvousJouerUn.setHorizontalAlignment(SwingConstants.CENTER);
		lblvoulezvousJouerUn.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblvoulezvousJouerUn.setToolTipText("Voulez-vous jouer un autre tour? ");
		lblvoulezvousJouerUn.setBounds(78, 200, 421, 53);
		frame.getContentPane().add(lblvoulezvousJouerUn);
		
	}
	
	/**
	 * Marcher l'application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fin window = new Fin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
