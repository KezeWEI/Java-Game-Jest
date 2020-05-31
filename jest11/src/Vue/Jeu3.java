package Vue;

import java.awt.EventQueue;
import Modele.*;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;


import Controleur.ControleurCards;

/**
 *l'interface graphique pour le jeu de 3 joueurs
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 *
 */

public class Jeu3 implements ActionListener,Observable{
	private Observer[] observers=new Observer[1];
	private static Jeu3 instance=null;
	public JFrame frame;
	private JLabel[] lbls = new JLabel[8];
	private int index;
	private int nb=0;
	private int[] mark= {0,0,0};
	LinkedList<Calcul> calcul=new LinkedList<Calcul>();
	private JLabel lblNewLabel_1 = new JLabel("1");
	private JLabel lblNewLabel_2 = new JLabel("2");
	private JLabel lblNewLabel_3 = new JLabel("3");
	private JLabel lblNewLabel_4 = new JLabel("4");
	private JLabel lblNewLabel_regle = new JLabel("regle");
	private JLabel lblNewLabel_trophie1 = new JLabel("trophie1");
	private JLabel lblNewLabel_trophie2 = new JLabel("trophie2");
	//private JLabel lblNewLabel_message = new JLabel("message");
	private JLabel lblNewLabel_pile = new JLabel("pile");
	private JLabel lblNewLabel_pile1 = new JLabel("pile1");
	private JLabel lblNewLabel_pile2 = new JLabel("pile2");
	private JButton button_1 = new JButton("Generate trophies");
	private JButton button_2 = new JButton("Deal");
	public JButton button_3 = new JButton("Choose an up card");
	private JButton button_4 = new JButton("Show the Jest");
	private JButton button_5 = new JButton("Distribute the trophies");
	

	/**
	 * Creer l'application.
	 */ 
	private Jeu3() {
		Accueuil a=Accueuil.getInstance();
		addObserver(a);	
		initialize();
		
	}
	
	/**
	 * pour realiser le pattern Singleton
	 * @return instance
	 * l'instance d'acceuille singleton
	 */
	public static Jeu3 getInstance(){
		synchronized (Jeu3.class) {                
            if (instance == null) {                    
             	instance = new Jeu3();                
            } 
        }  
        return instance;
    }
	
	/**
	 * Initialiser les contents de la frame.
	 */
	private void initialize() {
		Accueuil a=Accueuil.getInstance();
		Calcul c1=new Calcul();
		Calcul c2=new Calcul();
		Calcul c3=new Calcul();
		Calcul c4=new Calcul();
		calcul.add(c1);
		calcul.add(c2);
		calcul.add(c3);
		calcul.add(c4);
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon bg1=null;
		bg1 = new ImageIcon(AccueilInterface.class.getResource("/Vue/carteback.jpg"));
		Image im=bg1.getImage();
		im=im.getScaledInstance(70,80,100);
		bg1.setImage(im);
		frame.getContentPane().setLayout(null);
		//J1
		this.lbls[0]=new JLabel(bg1);
		lbls[0].setBounds(6, 187, 48, 73);
		frame.getContentPane().add(lbls[0]);
		
		
		lbls[0].addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				notifyObserver(index, 0);
				lbls[0].setVisible(false);
				if(nb==2) {
					index=0;
				}
				a.getJoueurs().get(index).takeCard(a.getJoueurs().get(0).getCardUP());
				nb++;
				if(nb<3) {
					System.out.println(a.getJoueurs().get(index).getNom() + "  Vous pouvez choisir");
					while((a.getJoueurs().get(index) instanceof EasyComputer ||a.getJoueurs().get(index) instanceof MediumComputer||a.getJoueurs().get(index) instanceof DifficultComputer)&&nb<3&&mark[index]<1){
						if(index>=0&&index<a.getNbJoeur()) {
							int num=a.takeCardsV(index);
							notifyObserver(index, num);
							lbls[num].setVisible(false);
							mark[index]++;
							nb++;
							index=num/2;
						}
						if(nb==3) {
							nb=0;
							System.out.println("This round is over now");
							if(a.size()>0) {
							a.takeCardsBack();
							System.out.println("The number of the pile is : "+a.getNbPile());
							initialize2();
							break;
						}
						}
					}
					if(nb==2) {
						for(int i=0;i<a.getNbJoeur();i++) {
							if(mark[i]==0&& !(a.getJoueurs().get(i) instanceof Actuel)) {
								int num=a.takeCardsV(i);
								notifyObserver(i, num);
								lbls[num].setVisible(false);
								mark[i]++;
								nb=0;
								System.out.println("This round is over now");
								if(a.size()>0) {
								a.takeCardsBack();
								System.out.println("The number of the pile is : "+a.getNbPile());
								initialize2();}
							}
						}
					}
				}
				else {
					nb=0;
					System.out.println("This round is over now");
					if(a.size()>0) {
						a.takeCardsBack();
						System.out.println("The number of the pile is : "+a.getNbPile());
						initialize2();
						}
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
		this.lbls[1]=new JLabel(bg1);
		lbls[1].setBounds(66, 187, 48, 73);
		this.frame.getContentPane().add(lbls[1]);
		
		lbls[1].addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				notifyObserver(index, 1);
				lbls[1].setVisible(false);
				if(nb==2) {
					index=0;
				}
				a.getJoueurs().get(index).takeCard(a.getJoueurs().get(0).getCardDown());
				index=0;
				nb++;
				if(nb<3) {
					System.out.println(a.getJoueurs().get(index).getNom() + "  Vous pouvez choisir");
					while((a.getJoueurs().get(index) instanceof EasyComputer ||a.getJoueurs().get(index) instanceof MediumComputer||a.getJoueurs().get(index) instanceof DifficultComputer)&&nb<3&&mark[index]<1){
						if(index>=0&&index<a.getNbJoeur()) {
							int num=a.takeCardsV(index);
							notifyObserver(index, num);
							lbls[num].setVisible(false);
							mark[index]++;
							nb++;
							index=num/2;
						}
						if(nb==3) {
							nb=0;
							System.out.println("This round is over now");
							if(a.size()>0) {
							a.takeCardsBack();
							System.out.println("The number of the pile is : "+a.getNbPile());
							initialize2();
							break;
						}
						}
					}
					if(nb==2) {
						for(int i=0;i<a.getNbJoeur();i++) {
							if(mark[i]==0&& !(a.getJoueurs().get(i) instanceof Actuel)) {
								int num=a.takeCardsV(i);
								notifyObserver(i, num);
								lbls[num].setVisible(false);
								nb=0;
								System.out.println("This round is over now");
								if(a.size()>0) {
								a.takeCardsBack();
								System.out.println("The number of the pile is : "+a.getNbPile());
								initialize2();}
							}
						}
					}
				}
				else {
					nb=0;
					System.out.println("This round is over now");
					if(a.size()>0) {
						a.takeCardsBack();
						System.out.println("The number of the pile is : "+a.getNbPile());
						initialize2();
						}
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
		//J2
		this.lbls[2]=new JLabel(bg1);
		lbls[2].setBounds(240, 349, 48, 73);
		frame.getContentPane().add(lbls[2]);
		
		lbls[2].addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				lbls[2].setVisible(false);
				notifyObserver(index, 2);
				a.getJoueurs().get(index).takeCard(a.getJoueurs().get(1).getCardUP());
				index=1;
				nb++;				
				if(nb<3) {
					System.out.println(a.getJoueurs().get(index).getNom() + "  Vous pouvez choisir");
					while((a.getJoueurs().get(index) instanceof EasyComputer ||a.getJoueurs().get(index) instanceof MediumComputer||a.getJoueurs().get(index) instanceof DifficultComputer)&&nb<3&&mark[index]<1){
						if(index>=0&&index<a.getNbJoeur()) {
							int num=a.takeCardsV(index);
							notifyObserver(index, num);
							lbls[num].setVisible(false);
							mark[index]++;
							nb++;
							index=num/2;
						}
						if(nb==3) {
							nb=0;
							System.out.println("This round is over now");
							if(a.size()>0) {
							a.takeCardsBack();
							System.out.println("The number of the pile is : "+a.getNbPile());
							initialize2();
							break;
						}
						}
					}
					if(nb==2) {
						for(int i=0;i<a.getNbJoeur();i++) {
							if(mark[i]==0&& !(a.getJoueurs().get(i) instanceof Actuel)) {
								int num=a.takeCardsV(i);
								notifyObserver(i, num);
								lbls[num].setVisible(false);
								nb=0;
								System.out.println("This round is over now");
								if(a.size()>0) {
								a.takeCardsBack();
								System.out.println("The number of the pile is : "+a.getNbPile());
								initialize2();
								}
							}
						}
					}
				}
				else {
					nb=0;
					System.out.println("This round is over now");
					if(a.size()>0) {
						a.takeCardsBack();
						System.out.println("The number of the pile is : "+a.getNbPile());
						initialize2();
						}
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
		
		this.lbls[3]=new JLabel(bg1);
		lbls[3].setBounds(303, 349, 48, 73);
		frame.getContentPane().add(lbls[3]);
		
		lbls[3].addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				notifyObserver(index, 3);
				lbls[3].setVisible(false);
				a.getJoueurs().get(index).takeCard(a.getJoueurs().get(1).getCardDown());
				index=1;
				nb++;
				//
				if(nb<3) {
						System.out.println(a.getJoueurs().get(index).getNom() + "  Vous pouvez choisir");
						while((a.getJoueurs().get(index) instanceof EasyComputer ||a.getJoueurs().get(index) instanceof MediumComputer||a.getJoueurs().get(index) instanceof DifficultComputer)&&nb<3&&mark[index]<1){
							if(index>=0&&index<a.getNbJoeur()) {
								int num=a.takeCardsV(index);
								notifyObserver(index, num);
								lbls[num].setVisible(false);
								mark[index]++;
								nb++;
								index=num/2;
							}
							if(nb==3) {
								nb=0;
								System.out.println("This round is over now");
								if(a.size()>0) {
								a.takeCardsBack();
								System.out.println("The number of the pile is : "+a.getNbPile());
								initialize2();
								break;
							}
							}
						}
						if(nb==2) {
							for(int i=0;i<a.getNbJoeur();i++) {
								if(mark[i]==0&& !(a.getJoueurs().get(i) instanceof Actuel)) {
									int num=a.takeCardsV(i);
									notifyObserver(i, num);
									lbls[num].setVisible(false);
									nb=0;
									System.out.println("This round is over now");
									if(a.size()>0) {
										a.takeCardsBack();
										System.out.println("The number of the pile is : "+a.getNbPile());
										initialize2();
										}
								}
							}
						}
					}
					else {
						nb=0;
						System.out.println("This round is over now");
						if(a.size()>0) {
							a.takeCardsBack();
							System.out.println("The number of the pile is : "+a.getNbPile());
							initialize2();
							
							}
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
		//J3
		this.lbls[4]=new JLabel(bg1);
		lbls[4].setBounds(475, 187, 48, 73);
		frame.getContentPane().add(lbls[4]);
		
		lbls[4].addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				lbls[4].setVisible(false);
				notifyObserver(index, 4);
				a.getJoueurs().get(index).takeCard(a.getJoueurs().get(2).getCardUP());
				index=2;
				nb++;
				
				if(nb<3) {
						System.out.println(a.getJoueurs().get(index).getNom() + "  Vous pouvez choisir");
						while((a.getJoueurs().get(index) instanceof EasyComputer ||a.getJoueurs().get(index) instanceof MediumComputer||a.getJoueurs().get(index) instanceof DifficultComputer)&&nb<3&&mark[index]<1){
							if(index>=0&&index<a.getNbJoeur()) {
								int num=a.takeCardsV(index);
								notifyObserver(index, num);
								lbls[num].setVisible(false);
								mark[index]++;
								nb++;
								index=num/2;
							}
							if(nb==3) {
								nb=0;
								System.out.println("This round is over now");
								if(a.size()>0) {
								a.takeCardsBack();
								System.out.println("The number of the pile is : "+a.getNbPile());
								initialize2();
								break;
							}
							}
						}
						if(nb==2) {
							for(int i=0;i<a.getNbJoeur();i++) {
								if(mark[i]==0&& !(a.getJoueurs().get(i) instanceof Actuel)) {
									int num=a.takeCardsV(i);
									lbls[num].setVisible(false);
									notifyObserver(i, num);
									nb=0;
									System.out.println("This round is over now");
									if(a.size()>0) {
									a.takeCardsBack();
									System.out.println("The number of the pile is : "+a.getNbPile());
									initialize2();}
								}
							}
						}
					}
					else {
						nb=0;
						System.out.println("This round is over now");
						if(a.size()>0) {
							a.takeCardsBack();
							System.out.println("The number of the pile is : "+a.getNbPile());
							initialize2();
							}
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
		this.lbls[5]=new JLabel(bg1);
		lbls[5].setBounds(535, 187, 48, 73);
		frame.getContentPane().add(lbls[5]);
		lbls[5].addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				notifyObserver(index, 5);
				lbls[5].setVisible(false);
				a.getJoueurs().get(index).takeCard(a.getJoueurs().get(2).getCardDown());
				index=2;
				nb++;
			
				if(nb<3) {
						System.out.println(a.getJoueurs().get(index).getNom() + "  Vous pouvez choisir");
						while((a.getJoueurs().get(index) instanceof EasyComputer ||a.getJoueurs().get(index) instanceof MediumComputer||a.getJoueurs().get(index) instanceof DifficultComputer)&&nb<3&&mark[index]<1){
							if(index>=0&&index<a.getNbJoeur()) {
								int num=a.takeCardsV(index);
								notifyObserver(index, num);
								lbls[num].setVisible(false);
								mark[index]++;
								nb++;
								index=num/2;
							}
							if(nb==3) {
								nb=0;
								System.out.println("This round is over now");
							if(a.size()>0) {
								a.takeCardsBack();
								System.out.println("The number of the pile is : "+a.getNbPile());
								initialize2();
								break;
							}
							}
						}
						if(nb==2) {
							for(int i=0;i<a.getNbJoeur();i++) {
								if(mark[i]==0&& !(a.getJoueurs().get(i) instanceof Actuel)) {
									int num=a.takeCardsV(i);
									notifyObserver(i, num);
									lbls[num].setVisible(false);
									nb=0;
									System.out.println("This round is over now");
									if(a.size()>0) {
									a.takeCardsBack();
									System.out.println("The number of the pile is : "+a.getNbPile());
									initialize2();}
								}
							}
						}
					}
				else {
						nb=0;
						System.out.println("This round is over now");
						if(a.size()>0) {
						a.takeCardsBack();
						System.out.println("The number of the pile is : "+a.getNbPile());
						initialize2();
						}
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
		
		for(int i = 0 ; i<6 ;i++) {
			lbls[i].setVisible(false);
		}
		button_1.setBounds(10, 10, 140, 20);
		frame.getContentPane().add(button_1);
		button_1.setActionCommand("Generate Trophies");
		button_1.addActionListener(this);
		
		button_2.setBounds(10, 35, 140, 20);
		frame.getContentPane().add(button_2);
		button_2.setActionCommand("Deal");
		button_2.addActionListener(this);
		
		button_3.setBounds(10, 60, 140, 20);
		frame.getContentPane().add(button_3);
		button_3.setActionCommand("Choose an up card");
		button_3.addActionListener(this);
		button_3.setVisible(false);
		
		button_4.setBounds(10, 60, 140, 20);
		frame.getContentPane().add(button_4);
		button_4.setActionCommand("Show the Jest");
		button_4.addActionListener(this);
		
		button_5.setBounds(10, 85, 140, 20);
		frame.getContentPane().add(button_5);
		button_5.setActionCommand("Distribute the trophies");
		button_5.addActionListener(this);
		
		ImageIcon bg2=null;
		bg2 = new ImageIcon(AccueilInterface.class.getResource("/Vue/carteback.jpg"));
		Image im2=bg2.getImage();
		im2=im2.getScaledInstance(25,30,10);
		bg2.setImage(im2);
		frame.getContentPane().setLayout(null);
		
		this.lblNewLabel_1=new JLabel(bg2);
		lblNewLabel_1.setBounds(6, 147, 23, 28);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				VueDeJest window = new VueDeJest(0);
				window.frame.setVisible(true);
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
		
		this.lblNewLabel_2=new JLabel(bg2);
		lblNewLabel_2.setBounds(205, 380, 23, 28);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				VueDeJest window = new VueDeJest(1);
				window.frame.setVisible(true);
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
		this.lblNewLabel_3=new JLabel(bg2);
		lblNewLabel_3.setBounds(560, 272, 23, 28);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				VueDeJest window = new VueDeJest(2);
				window.frame.setVisible(true);
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
		ImageIcon bg4=null;
		bg4 = new ImageIcon(AccueilInterface.class.getResource("/Vue/carteback.jpg"));
		Image im4=bg4.getImage();
		im4=im4.getScaledInstance(120,120,100);
		bg4.setImage(im4);
		frame.getContentPane().setLayout(null);
		this.lblNewLabel_pile=new JLabel(bg4);
		lblNewLabel_pile.setBounds(480, 23, 72, 112);
		frame.getContentPane().add(lblNewLabel_pile);
		this.lblNewLabel_pile1=new JLabel(bg4);
		lblNewLabel_pile1.setBounds(480, 20, 72, 112);
		frame.getContentPane().add(lblNewLabel_pile1);
		this.lblNewLabel_pile2=new JLabel(bg4);
		lblNewLabel_pile2.setBounds(480, 17, 72, 112);
		frame.getContentPane().add(lblNewLabel_pile2);
		
		ImageIcon bg3=null;
		bg3 = new ImageIcon(AccueilInterface.class.getResource("/Vue/regle.jpg"));
		Image im3=bg3.getImage();
		im3=im3.getScaledInstance(110,160,120);
		bg3.setImage(im3);
		frame.getContentPane().setLayout(null);
		
		this.lblNewLabel_regle=new JLabel(bg3);
		lblNewLabel_regle.setBounds(240, 23, 108, 152);
		frame.getContentPane().add(lblNewLabel_regle);
		
		this.lblNewLabel_trophie1=new JLabel(bg4);
		this.lblNewLabel_trophie2=new JLabel(bg4);
		lblNewLabel_trophie1.setBounds(19, 335, 48, 73);
		frame.getContentPane().add(lblNewLabel_trophie1);
		
		lblNewLabel_trophie2.setBounds(534, 335, 48, 73);
		frame.getContentPane().add(lblNewLabel_trophie2);
		
	}
	
	/**
	 * Initialiser l'interface
	 */
	private void initialize2() {
		nb=0;
		ImageIcon bg1=null;
		bg1 = new ImageIcon(AccueilInterface.class.getResource("/Vue/carteback.jpg"));
		Image im=bg1.getImage();
		im=im.getScaledInstance(70,80,100);
		bg1.setImage(im);
		frame.getContentPane().setLayout(null);
		for (int i=0;i<6;i++) {
		lbls[i].setIcon(bg1);
		lbls[i].setVisible(false);
		}
		for(int j=0;j<3;j++) {
			mark[j]=0;
		}
		
	}
	
	/**
	 * Realiser les functions selon l'action
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Generate Trophies")){
			Accueuil a=Accueuil.getInstance();
			a.getTrophies();
			ControleurCards c=new ControleurCards();						
			lblNewLabel_trophie1.setVisible(false);
			lblNewLabel_trophie2.setVisible(false);
			
			ImageIcon bg3=null;
			bg3 = c.textToPicture(a.getTrophie1());
			Image im3=bg3.getImage();
			im3=im3.getScaledInstance(48,73,100);
			bg3.setImage(im3);
			frame.getContentPane().setLayout(null);
			
			lblNewLabel_trophie1.setIcon(bg3);
			lblNewLabel_trophie1.setVisible(true);
			
			ImageIcon bg4=null;
			bg4 = c.textToPicture(a.getTrophie2());
			Image im4=bg4.getImage();
			im4=im4.getScaledInstance(48,73,100);
			bg4.setImage(im4);
			frame.getContentPane().setLayout(null);
			
			lblNewLabel_trophie2.setIcon(bg4);
			lblNewLabel_trophie2.setVisible(true);
		}
		if(e.getActionCommand().equals("Deal")){
			Accueuil a=Accueuil.getInstance();
			ControleurCards c=new ControleurCards();
			this.initialize2();
			if(a.size()>0){	
				for(int i = 0; i<6 ;i++) {
				lbls[i].setVisible(true);
				}
				a.dealer();
			
				for(int j = 0;j<a.getNbJoueurPhysique();j++) {
						VueDeCards window = new VueDeCards(j);
						window.frame.setVisible(true);	
				}
			}
			else {
				System.out.println("fini");
				a.takeLastCard();
				for (int i=0;i<a.getNbJoeur();i++) {
					if(calcul!=null) {
						a.getJoueurs().get(i).accept(calcul.get(i));
					}
				}
				for (int i=0;i<a.getNbJoeur();i++) {
					if(calcul!=null) {
						calcul.get(i).inti();
					}
					
				}
				
			}
		}
		
		if(e.getActionCommand().equals("Choose an up card")){
			Accueuil a=Accueuil.getInstance();
			ControleurCards c=new ControleurCards();
			try {
				Thread.sleep(800);
			for(int i=0;i<a.getNbJoueurPhysique();i++) {
				if(a.getJoueurs().get(i) instanceof Actuel) {
						Actuel act =(Actuel)a.getJoueurs().get(i);
						if(act.getCard1()==null) {
							lbls[i*2].setVisible(false);
						
							ImageIcon bg3=null;
							bg3 = c.textToPicture(a.getJoueurs().get(i).cardUp);
							Image im3=bg3.getImage();
							im3=im3.getScaledInstance(48,73,100);
							bg3.setImage(im3);
							frame.getContentPane().setLayout(null);
						
							this.lbls[i*2].setIcon(bg3);
							lbls[i*2].setVisible(true);
							}
						else if(act.getCard2()==null){  
							
							lbls[i*2+1].setVisible(false);
						
							ImageIcon bg3=null;
							bg3 = c.textToPicture(a.getJoueurs().get(i).cardUp);
							Image im3=bg3.getImage();
							im3=im3.getScaledInstance(48,73,100);
							bg3.setImage(im3);
							frame.getContentPane().setLayout(null);
						
							this.lbls[i*2+1].setIcon(bg3);
							lbls[i*2+1].setVisible(true);
							}
					
						
					
					}
				}
			for (int i=a.getNbJoueurPhysique();i<a.getNbJoeur();i++) {
				if(a.getJoueurs().get(i).chooseCardUpReturn()==1) {
					
						lbls[i*2].setVisible(false);
					
						ImageIcon bg3=null;
						bg3 = c.textToPicture(a.getJoueurs().get(i).cardUp);
						Image im3=bg3.getImage();
						im3=im3.getScaledInstance(48,73,100);
						bg3.setImage(im3);
						frame.getContentPane().setLayout(null);
					
						this.lbls[i*2].setIcon(bg3);
						lbls[i*2].setVisible(true);
	
				}
				else if(a.getJoueurs().get(i).chooseCardUpReturn()==2) {
					
						lbls[i*2+1].setVisible(false);
					
						ImageIcon bg3=null;
						bg3 = c.textToPicture(a.getJoueurs().get(i).cardUp);
						Image im3=bg3.getImage();
						im3=im3.getScaledInstance(48,73,100);
						bg3.setImage(im3);
						frame.getContentPane().setLayout(null);
					
						this.lbls[i*2+1].setIcon(bg3);
						lbls[i*2+1].setVisible(true);

				}
				
			}
			
			a.compare(a.getJoueurs().get(0).cardUp,a.getJoueurs().get(1).cardUp,a.getJoueurs().get(2).cardUp);
			index=a.getOrdre0();
			while((a.getJoueurs().get(index) instanceof EasyComputer ||a.getJoueurs().get(index) instanceof MediumComputer||a.getJoueurs().get(index) instanceof DifficultComputer)&&nb<3&&mark[index]<1){
				if(index>=0&&index<a.getNbJoeur()) {
					int num=a.takeCardsV(index);
					notifyObserver(index, num);
					lbls[num].setVisible(false);
					mark[index]++;
					nb++;
					index=num/2;
				}
			}
			if(nb==2) {
				for(int i=0;i<a.getNbJoeur();i++) {
					if(mark[i]==0&& !(a.getJoueurs().get(i) instanceof Actuel)) {
						int num=a.takeCardsV(i);
						notifyObserver(i, num);
						lbls[num].setVisible(false);
						nb=0;
						System.out.println("This round is over now");
						if(a.size()>0) {
						a.takeCardsBack();
						System.out.println("The number of the pile is : "+a.getNbPile());
						initialize2();}
					}
				}
			}
		}catch (InterruptedException e1) {
	           e1.printStackTrace(); 
	       }
		}
			
		
		
		if(e.getActionCommand().equals("Show the Jest")){
			Accueuil a=Accueuil.getInstance();
				for(int j = 0;j<a.getNbJoeur();j++) {
					VueDeJest window = new VueDeJest(j);
					window.frame.setVisible(true);
				}
			
			
			}
		if(e.getActionCommand().equals("Distribute the trophies")){
			Accueuil a=Accueuil.getInstance();
			a.distrubuerTrophies();
			for (int i=0;i<a.getNbJoeur();i++) {
				a.getJoueurs().get(i).accept(calcul.get(i));
			}
				for(int j = 0;j<a.getNbJoeur();j++) {
					VueDeJest window = new VueDeJest(j);
					window.frame.setVisible(true);
				}
				Fin window = new Fin();
				window.frame.setVisible(true);
			
			}
	}
	
	/**
	 * ajouter un observeur
	 */
	public void addObserver(Observer o) {
		this.observers[0]=o;
	}
	
	/**
	 * notifier l'observeur
	 */
	public void notifyObserver(Object o1,Object o2) {
			this.observers[0].update(o1, o2);
	}
}
