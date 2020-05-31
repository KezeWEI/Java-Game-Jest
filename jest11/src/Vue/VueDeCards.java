package Vue;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Modele.Accueuil;
import Modele.Actuel;
import Modele.DifficultComputer;
import Modele.EasyComputer;
import Modele.MediumComputer;
import Controleur.ControleurCards;
import Vue.Jeu3;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;

/**
 * 
 * Cette classe est pour ecouter les actions de cartes
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 *
 */
public class VueDeCards implements ActionListener{
	private Accueuil a = Accueuil.getInstance();
	private Jeu3 j3=Jeu3.getInstance();
	private Jeu4 j4=Jeu4.getInstance();
	public JFrame frame;
	private JLabel lblCard2 = new JLabel("Card2");
	private JLabel lblCard1 = new JLabel("Card1");
	private JButton b = new JButton("Continuer");
	private int j;
	
	/**
	 * Creer l'application.
	 * @param nb
	 * le nombre du joueur
	 */
	public VueDeCards(int nb) {
		int a =nb;
		initialize(a);
	}

	/**
	 * Initialiser les contents de la frame
	 */
	private void initialize(int nb) {
		j=nb;
		ControleurCards c=new ControleurCards();
		
		frame = new JFrame("Cards de Joueur "+ a.getJoueurs().get(j).getNom());
		frame.setBounds(150, 150, 300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(lblCard1, BorderLayout.WEST);
		
		frame.getContentPane().add(lblCard2, BorderLayout.EAST);
		
		
		ImageIcon bg3=null;
		bg3 = c.textToPicture(a.getJoueurs().get(j).getCard1());
		//bg3 = new ImageIcon(AccueilInterface.class.getResource("/Vue/regle.jpg"));
		Image im3=bg3.getImage();
		
		im3=im3.getScaledInstance(96,146,100);
		bg3.setImage(im3);
		frame.getContentPane().setLayout(null);
		
		ImageIcon bg4=null;
		bg4 = c.textToPicture(a.getJoueurs().get(j).getCard2());
		Image im4=bg4.getImage();
		im4=im4.getScaledInstance(96,146,100);
		bg4.setImage(im4);
		frame.getContentPane().setLayout(null);
		
		lblCard1.setIcon(bg3);
		lblCard1.setBounds(34, 10, 96, 146);
		frame.getContentPane().add(lblCard1);
		lblCard1.setVisible(true);
		
		
		
		lblCard2.setIcon(bg4);
		lblCard2.setBounds(170, 10, 96, 146);
		frame.getContentPane().add(lblCard2);
		lblCard2.setVisible(true);
		
		lblCard1.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				lblCard2.setVisible(false);
				ImageIcon bg=null;
				bg = new ImageIcon(AccueilInterface.class.getResource("/Vue/carteback.jpg"));
				Image im=bg.getImage();
				im=im.getScaledInstance(96,146,100);
				bg.setImage(im);
				frame.getContentPane().setLayout(null);
				
				
				lblCard2.setIcon(bg);
				lblCard2.setVisible(true);
						if(a.getJoueurs().get(j) instanceof Actuel) {
							Actuel act =(Actuel)a.getJoueurs().get(j);
							act.chooseCardUp(1);
				
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		lblCard2.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				//
				lblCard1.setVisible(false);
				ImageIcon bg=null;
				bg = new ImageIcon(AccueilInterface.class.getResource("/Vue/carteback.jpg"));
				Image im=bg.getImage();
				im=im.getScaledInstance(96,146,100);
				bg.setImage(im);
				frame.getContentPane().setLayout(null);
				
				lblCard1.setIcon(bg);
				lblCard1.setVisible(true);
						if(a.getJoueurs().get(j) instanceof Actuel) {
							Actuel act =(Actuel)a.getJoueurs().get(j);
							act.chooseCardUp(2);
						
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		b.setBounds(100, 180, 100, 20);
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
			int b=0;
			for(int i=0;i<a.getNbJoueurPhysique();i++) {
				if(a.getJoueurs().get(i).getCard1()==null||a.getJoueurs().get(i).getCard2()==null) {
					b++;
				}
			}
			if(b==a.getNbJoueurPhysique()&&a.getNbJoeur()==3) {
				j3.button_3.doClick();
			}
			else if(b==a.getNbJoueurPhysique()&&a.getNbJoeur()==4) {
				j4.button_3.doClick();
			}

		}
	}

}
