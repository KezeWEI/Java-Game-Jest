package Vue;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Accueuil;
import Modele.Cards;
import Controleur.ControleurCards;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;

/**
 * 
 * Cette classe est pour ecouter les actions de jest
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 *
 */
public class VueDeJest implements ActionListener{

	public JFrame frame;
	private JLabel []cards = new JLabel[7];
	private JButton b = new JButton("Continuer");
	/**
	 * Creer the application.
	 * @param nb
	 * le nombre du joueur
	 */
	public VueDeJest(int nb) {
		int a =nb;
		initialize(a);
	}

	/**
	 * Initialiser les contents de la frame
	 */
	private void initialize(int nb) {
		int j=nb;
		ControleurCards c=new ControleurCards();
		Accueuil a = Accueuil.getInstance();
		frame = new JFrame("Jest de Joueur "+ a.getJoueurs().get(j).getNom());
		//frame = new JFrame();
		frame.setBounds(150, 150, 450, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
		ImageIcon []bg=new ImageIcon[7];
		Image []im = new Image[7];
		
		//i = nb de cards
		int i=0;
		for (Cards card:a.getJoueurs().get(j).getJestGUI()) {
			bg[i] = c.textToPicture(card);
			im[i]=bg[i].getImage();
			im[i]=im[i].getScaledInstance(96,146,100);
			bg[i].setImage(im[i]);
			frame.getContentPane().setLayout(null);
			cards[i]=new JLabel(bg[i]);
			i++;
		}
		
		if(a.getJoueurs().get(j).getJestGUI().size()>=1){
		cards[0].setBounds(34, 50, 96, 146);
		frame.getContentPane().add(cards[0]);
		cards[0].setVisible(true);}
		
		if(a.getJoueurs().get(j).getJestGUI().size()>=2){
		cards[1].setBounds(170, 50, 96, 146);
		frame.getContentPane().add(cards[1]);
		cards[1].setVisible(true);}
		
		if(a.getJoueurs().get(j).getJestGUI().size()>=3){
		cards[2].setBounds(306, 50, 96, 146);
		frame.getContentPane().add(cards[2]);
		cards[2].setVisible(true);}
		
		if(a.getJoueurs().get(j).getJestGUI().size()>=4){
		cards[3].setBounds(34, 250, 96, 146);
		frame.getContentPane().add(cards[3]);
		cards[3].setVisible(true);}
		
		if(a.getJoueurs().get(j).getJestGUI().size()>=5) {
		cards[4].setBounds(170, 250, 96, 146);
		frame.getContentPane().add(cards[4]);
		cards[4].setVisible(true);
		}
		if(a.getJoueurs().get(j).getJestGUI().size()>=6){
		cards[5].setBounds(306, 250, 96, 146);
		frame.getContentPane().add(cards[5]);
		cards[5].setVisible(true);
		}
		if(a.getJoueurs().get(j).getJestGUI().size()>=7){
			cards[6].setBounds(34, 450, 96, 146);
			frame.getContentPane().add(cards[6]);
			cards[6].setVisible(true);
			}
		
		b.setBounds(170,600 , 100, 20);
		frame.getContentPane().add(b);
		b.setActionCommand("Continuer");
		b.addActionListener(this);
		
	}
	
	/**
	 * Realiser les functions selon l'action
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Continuer")){
			this.frame.setVisible(false);
		}
	}

}