package Vue;
import Modele.Observer;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import Controleur.ControleurCards;
import Modele.Accueuil;
import Modele.Actuel;
import Modele.Calcul;
import Modele.Cards;
import Vue.ConsoleListener;
import Modele.DifficultComputer;
import Modele.EasyComputer;
import Modele.MediumComputer;
import Modele.Observable;
import Modele.Suit;
import Modele.Valeur;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * 
 *l'interface graphique pour le jeu de 4 joueurs
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 *
 */
public class Jeu4 implements ActionListener,Observable,Runnable{
	private Observer[] observers=new Observer[1];
	private static Jeu4 instance=null;
	public JFrame frame;
	private JLabel[] lbls = new JLabel[8];
	private int index;
	private int nb=0;
	private int[] mark= {0,0,0,0};
	private LinkedList<Calcul> calcul=new LinkedList<Calcul>();
	private JLabel lblNewLabel_1 = new JLabel("1");
	private JLabel lblNewLabel_2 = new JLabel("2");
	private JLabel lblNewLabel_3 = new JLabel("3");
	private JLabel lblNewLabel_4 = new JLabel("4");
	private JLabel lblNewLabel_pile = new JLabel("pile");
	private JLabel lblNewLabel_regle = new JLabel("regle");
	private JLabel lblNewLabel_trophie1 = new JLabel("trophie1");
	private JLabel lblNewLabel_pile1 = new JLabel("pile1");
	private JLabel lblNewLabel_pile2 = new JLabel("pile2");
	private JButton button_1 = new JButton("Generate trophies");
	private JButton button_2 = new JButton("Deal");
	public JButton button_3 = new JButton("Choose an up card");
	private JButton button_4 = new JButton("Show the Jest");
	private JButton button_5 = new JButton("Distribute trophie");
	

	/**
	 * Creer l'application.
	 */
	private Jeu4() {
		Accueuil a=Accueuil.getInstance();
		addObserver(a);	
		initialize();
		try
		{
			Robot myRobot = new Robot();
		} catch (AWTException e)
		{
			e.printStackTrace();
		}
	}
	public static Jeu4 getInstance(){
		synchronized (Jeu3.class) {                
            if (instance == null) {                    
             	instance = new Jeu4();                
            } }  
        return instance;
    }
	
	/**
	 * Initialiser les contents de la frame
	 */
	private void initialize() {
		ConsoleListener cs = new ConsoleListener(new Scanner(System.in), new ConsoleListener.Action() {

            public void act(String msg) {
                System.out.println("Console: " + msg);
            }
        });
		cs.listenInNewThread();
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
		
		button_1.setBounds(230, 10, 140, 20);
		frame.getContentPane().add(button_1);
		button_1.setActionCommand("Generate Trophies");
		button_1.addActionListener(this);
		
		
		button_2.setBounds(230, 35, 140, 20);
		frame.getContentPane().add(button_2);
		button_2.setActionCommand("Deal");
		button_2.addActionListener(this);
		
		button_3.setBounds(230, 60, 140, 20);
		frame.getContentPane().add(button_3);
		button_3.setActionCommand("Choose an up card");
		button_3.addActionListener(this);
		button_3.setVisible(false);
		
		button_4.setBounds(230, 60, 140, 20);
		frame.getContentPane().add(button_4);
		button_4.setActionCommand("Show the Jest");
		button_4.addActionListener(this);
		
		button_5.setBounds(230, 85, 140, 20);
		frame.getContentPane().add(button_5);
		button_5.setActionCommand("Distribute trophie");
		button_5.addActionListener(this);
		this.lbls[0]=new JLabel(bg1);
		lbls[0].setBounds(6, 6, 48, 73);
		frame.getContentPane().add(lbls[0]);
		
		this.lbls[1]=new JLabel(bg1);
		lbls[1].setBounds(66, 6, 48, 73);
		frame.getContentPane().add(lbls[1]);
		
		this.lbls[2]=new JLabel(bg1);
		lbls[2].setBounds(6, 349, 48, 73);
		frame.getContentPane().add(lbls[2]);
		
		this.lbls[3]=new JLabel(bg1);
		lbls[3].setBounds(66, 349, 48, 73);
		frame.getContentPane().add(lbls[3]);
		
		this.lbls[4]=new JLabel(bg1);
		lbls[4].setBounds(475, 349, 48, 73);
		frame.getContentPane().add(lbls[4]);
		
		this.lbls[5]=new JLabel(bg1);
		lbls[5].setBounds(535, 349, 48, 73);
		frame.getContentPane().add(lbls[5]);
		
		this.lbls[6]=new JLabel(bg1);
		lbls[6].setBounds(475, 6, 48, 73);
		frame.getContentPane().add(lbls[6]);
		
		this.lbls[7]=new JLabel(bg1);
		lbls[7].setBounds(535, 6, 48, 73);
		frame.getContentPane().add(lbls[7]);
		
		for(int i = 0 ; i<8 ;i++) {
			lbls[i].setVisible(false);
		}
		
			lbls[0].addMouseListener(new MouseListener(){
				public void mouseClicked(MouseEvent e) {
					lbls[0].setVisible(false);
					notifyObserver(a.getOrdreIndex(nb), 0);
					a.getJoueurs().get(a.getOrdreIndex(nb)).takeCard(a.getJoueurs().get(0).getCardUP());
					if(nb==0) {
						int c1=0;
						if(3==a.getOrdreIndex(2)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(2, c1);
						}
						else if(3==a.getOrdreIndex(3)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(3,a.getOrdreIndex(2));
							a.changerOrdre(2,c1);}
						}
					else if(nb==1&&3==a.getOrdreIndex(3)){
						int c1=0;
						c1=a.getOrdreIndex(3);
						a.changerOrdre(3,a.getOrdreIndex(2));
						a.changerOrdre(2,c1);
						}
					nb++;
					if(nb<4) {
						System.out.println(a.getJoueurs().get(index).getNom() + "  Vous pouvez choisir");
						while(nb<4&&!(a.getJoueurs().get(a.getOrdreIndex(nb)) instanceof Actuel)){
							int num=a.takeCardsV(a.getOrdreIndex(nb));
							notifyObserver(a.getOrdreIndex(nb), num);
							lbls[num].setVisible(false);
							if(nb==0) {
								int c1=0;
								if(num/2==a.getOrdreIndex(2)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(2, c1);
								}
								else if(num/2==a.getOrdreIndex(3)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(3,a.getOrdreIndex(2));
									a.changerOrdre(2,c1);}
								}
							else if(nb==1&&num/2==a.getOrdreIndex(3)){
								int c1=0;
								c1=a.getOrdreIndex(3);
								a.changerOrdre(3,a.getOrdreIndex(2));
								a.changerOrdre(2,c1);
								}
							nb++;
							}
					}
					if(nb==4) {
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
			lbls[1].addMouseListener(new MouseListener(){
				public void mouseClicked(MouseEvent e) {
					lbls[1].setVisible(false);
					notifyObserver(a.getOrdreIndex(nb), 1);
					a.getJoueurs().get(a.getOrdreIndex(nb)).takeCard(a.getJoueurs().get(0).getCardDown());
					if(nb==0) {
						int c1=0;
						if(3==a.getOrdreIndex(2)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(2, c1);
						}
						else if(3==a.getOrdreIndex(3)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(3,a.getOrdreIndex(2));
							a.changerOrdre(2,c1);}
						}
					else if(nb==1&&3==a.getOrdreIndex(3)){
						int c1=0;
						c1=a.getOrdreIndex(3);
						a.changerOrdre(3,a.getOrdreIndex(2));
						a.changerOrdre(2,c1);
						}nb++;
					if(nb<4) {
						System.out.println(a.getJoueurs().get(index).getNom() + "  Vous pouvez choisir");
						while(nb<4&&!(a.getJoueurs().get(a.getOrdreIndex(nb)) instanceof Actuel)){
							int num=a.takeCardsV(a.getOrdreIndex(nb));
							notifyObserver(a.getOrdreIndex(nb), num);
							lbls[num].setVisible(false);
							if(nb==0) {
								int c1=0;
								if(num/2==a.getOrdreIndex(2)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(2, c1);
								}
								else if(num/2==a.getOrdreIndex(3)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(3,a.getOrdreIndex(2));
									a.changerOrdre(2,c1);}
								}
							else if(nb==1&&num/2==a.getOrdreIndex(3)){
								int c1=0;
								c1=a.getOrdreIndex(3);
								a.changerOrdre(3,a.getOrdreIndex(2));
								a.changerOrdre(2,c1);
								}
							nb++;
							}
					}
					if(nb==4) {
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
			lbls[2].addMouseListener(new MouseListener(){
				public void mouseClicked(MouseEvent e) {
					lbls[2].setVisible(false);
					notifyObserver(a.getOrdreIndex(nb), 2);
					a.getJoueurs().get(a.getOrdreIndex(nb)).takeCard(a.getJoueurs().get(1).getCardUP());
					if(nb==0) {
						int c1=0;
						if(3==a.getOrdreIndex(2)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(2, c1);
						}
						else if(3==a.getOrdreIndex(3)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(3,a.getOrdreIndex(2));
							a.changerOrdre(2,c1);}
						}
					else if(nb==1&&3==a.getOrdreIndex(3)){
						int c1=0;
						c1=a.getOrdreIndex(3);
						a.changerOrdre(3,a.getOrdreIndex(2));
						a.changerOrdre(2,c1);
						}
					nb++;
					if(nb<4) {
						System.out.println(a.getJoueurs().get(index).getNom() + "  Vous pouvez choisir");
						while(nb<4&&!(a.getJoueurs().get(a.getOrdreIndex(nb)) instanceof Actuel)){
							int num=a.takeCardsV(a.getOrdreIndex(nb));
							notifyObserver(a.getOrdreIndex(nb), num);
							lbls[num].setVisible(false);
							if(nb==0) {
								int c1=0;
								if(num/2==a.getOrdreIndex(2)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(2, c1);
								}
								else if(num/2==a.getOrdreIndex(3)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(3,a.getOrdreIndex(2));
									a.changerOrdre(2,c1);}
								}
							else if(nb==1&&num/2==a.getOrdreIndex(3)){
								int c1=0;
								c1=a.getOrdreIndex(3);
								a.changerOrdre(3,a.getOrdreIndex(2));
								a.changerOrdre(2,c1);
								}
							nb++;
							}
					}
					if(nb==4) {
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
			lbls[3].addMouseListener(new MouseListener(){
				public void mouseClicked(MouseEvent e) {
					lbls[3].setVisible(false);
					notifyObserver(a.getOrdreIndex(nb), 3);
					a.getJoueurs().get(a.getOrdreIndex(nb)).takeCard(a.getJoueurs().get(1).getCardDown());
					if(nb==0) {
						int c1=0;
						if(3==a.getOrdreIndex(2)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(2, c1);
						}
						else if(3==a.getOrdreIndex(3)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(3,a.getOrdreIndex(2));
							a.changerOrdre(2,c1);}
						}
					else if(nb==1&&3==a.getOrdreIndex(3)){
						int c1=0;
						c1=a.getOrdreIndex(3);
						a.changerOrdre(3,a.getOrdreIndex(2));
						a.changerOrdre(2,c1);
						}nb++;
					if(nb<4) {
						System.out.println(a.getJoueurs().get(index).getNom() + "  Vous pouvez choisir");
						while(nb<4&&!(a.getJoueurs().get(a.getOrdreIndex(nb)) instanceof Actuel)){
							int num=a.takeCardsV(a.getOrdreIndex(nb));
							notifyObserver(a.getOrdreIndex(nb), num);
							lbls[num].setVisible(false);
							if(nb==0) {
								int c1=0;
								if(num/2==a.getOrdreIndex(2)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(2, c1);
								}
								else if(num/2==a.getOrdreIndex(3)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(3,a.getOrdreIndex(2));
									a.changerOrdre(2,c1);}
								}
							else if(nb==1&&num/2==a.getOrdreIndex(3)){
								int c1=0;
								c1=a.getOrdreIndex(3);
								a.changerOrdre(3,a.getOrdreIndex(2));
								a.changerOrdre(2,c1);
								}
							nb++;
							}
					}
					if(nb==4) {
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
			lbls[4].addMouseListener(new MouseListener(){
				public void mouseClicked(MouseEvent e) {
					lbls[4].setVisible(false);
					notifyObserver(a.getOrdreIndex(nb), 4);
					a.getJoueurs().get(a.getOrdreIndex(nb)).takeCard(a.getJoueurs().get(2).getCardUP());
					if(nb==0) {
						int c1=0;
						if(3==a.getOrdreIndex(2)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(2, c1);
						}
						else if(3==a.getOrdreIndex(3)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(3,a.getOrdreIndex(2));
							a.changerOrdre(2,c1);}
						}
					else if(nb==1&&3==a.getOrdreIndex(3)){
						int c1=0;
						c1=a.getOrdreIndex(3);
						a.changerOrdre(3,a.getOrdreIndex(2));
						a.changerOrdre(2,c1);
						}
					nb++;
					if(nb<4) {
						System.out.println(a.getJoueurs().get(index).getNom() + "  Vous pouvez choisir");
						while(nb<4&&!(a.getJoueurs().get(a.getOrdreIndex(nb)) instanceof Actuel)){
							int num=a.takeCardsV(a.getOrdreIndex(nb));
							notifyObserver(a.getOrdreIndex(nb), num);
							lbls[num].setVisible(false);
							if(nb==0) {
								int c1=0;
								if(num/2==a.getOrdreIndex(2)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(2, c1);
								}
								else if(num/2==a.getOrdreIndex(3)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(3,a.getOrdreIndex(2));
									a.changerOrdre(2,c1);}
								}
							else if(nb==1&&num/2==a.getOrdreIndex(3)){
								int c1=0;
								c1=a.getOrdreIndex(3);
								a.changerOrdre(3,a.getOrdreIndex(2));
								a.changerOrdre(2,c1);
								}
							nb++;
							}
					}
					if(nb==4) {
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
			lbls[5].addMouseListener(new MouseListener(){
				public void mouseClicked(MouseEvent e) {
					lbls[5].setVisible(false);
					notifyObserver(a.getOrdreIndex(nb), 5);
					a.getJoueurs().get(a.getOrdreIndex(nb)).takeCard(a.getJoueurs().get(2).getCardDown());
					if(nb==0) {
						int c1=0;
						if(3==a.getOrdreIndex(2)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(2, c1);
						}
						else if(3==a.getOrdreIndex(3)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(3,a.getOrdreIndex(2));
							a.changerOrdre(2,c1);}
						}
					else if(nb==1&&3==a.getOrdreIndex(3)){
						int c1=0;
						c1=a.getOrdreIndex(3);
						a.changerOrdre(3,a.getOrdreIndex(2));
						a.changerOrdre(2,c1);
						}
					nb++;
					if(nb<4) {
						System.out.println(a.getJoueurs().get(index).getNom() + "  Vous pouvez choisir");
						while(nb<4&&!(a.getJoueurs().get(a.getOrdreIndex(nb)) instanceof Actuel)){
							int num=a.takeCardsV(a.getOrdreIndex(nb));
							notifyObserver(a.getOrdreIndex(nb), num);
							lbls[num].setVisible(false);
							if(nb==0) {
								int c1=0;
								if(num/2==a.getOrdreIndex(2)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(2, c1);
								}
								else if(num/2==a.getOrdreIndex(3)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(3,a.getOrdreIndex(2));
									a.changerOrdre(2,c1);}
								}
							else if(nb==1&&num/2==a.getOrdreIndex(3)){
								int c1=0;
								c1=a.getOrdreIndex(3);
								a.changerOrdre(3,a.getOrdreIndex(2));
								a.changerOrdre(2,c1);
								}
							nb++;
							}
					}
					if(nb==4) {
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
			lbls[6].addMouseListener(new MouseListener(){
				public void mouseClicked(MouseEvent e) {
					lbls[6].setVisible(false);
					notifyObserver(a.getOrdreIndex(nb), 6);
					a.getJoueurs().get(a.getOrdreIndex(nb)).takeCard(a.getJoueurs().get(3).getCardUP());
					if(nb==0) {
						int c1=0;
						if(3==a.getOrdreIndex(2)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(2, c1);
						}
						else if(3==a.getOrdreIndex(3)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(3,a.getOrdreIndex(2));
							a.changerOrdre(2,c1);}
						}
					else if(nb==1&&3==a.getOrdreIndex(3)){
						int c1=0;
						c1=a.getOrdreIndex(3);
						a.changerOrdre(3,a.getOrdreIndex(2));
						a.changerOrdre(2,c1);
						}
					nb++;
					if(nb<4) {
						System.out.println(a.getJoueurs().get(index).getNom() + "  Vous pouvez choisir");
						while(nb<4&&!(a.getJoueurs().get(a.getOrdreIndex(nb)) instanceof Actuel)){
							int num=a.takeCardsV(a.getOrdreIndex(nb));
							notifyObserver(a.getOrdreIndex(nb), num);
							lbls[num].setVisible(false);
							if(nb==0) {
								int c1=0;
								if(num/2==a.getOrdreIndex(2)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(2, c1);
								}
								else if(num/2==a.getOrdreIndex(3)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(3,a.getOrdreIndex(2));
									a.changerOrdre(2,c1);}
								}
							else if(nb==1&&num/2==a.getOrdreIndex(3)){
								int c1=0;
								c1=a.getOrdreIndex(3);
								a.changerOrdre(3,a.getOrdreIndex(2));
								a.changerOrdre(2,c1);
								}
							nb++;
							}
					}
					if(nb==4) {
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
			lbls[7].addMouseListener(new MouseListener(){
				public void mouseClicked(MouseEvent e) {
					lbls[7].setVisible(false);
					notifyObserver(a.getOrdreIndex(nb), 7);
					a.getJoueurs().get(a.getOrdreIndex(nb)).takeCard(a.getJoueurs().get(3).getCardDown());
					if(nb==0) {
						int c1=0;
						if(3==a.getOrdreIndex(2)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(2, c1);
						}
						else if(3==a.getOrdreIndex(3)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,3);
							a.changerOrdre(3,a.getOrdreIndex(2));
							a.changerOrdre(2,c1);}
						}
					else if(nb==1&&3==a.getOrdreIndex(3)){
						int c1=0;
						c1=a.getOrdreIndex(3);
						a.changerOrdre(3,a.getOrdreIndex(2));
						a.changerOrdre(2,c1);
						}
					nb++;
					if(nb<4) {
						System.out.println(a.getJoueurs().get(index).getNom() + "  Vous pouvez choisir");
						while(nb<4&&!(a.getJoueurs().get(a.getOrdreIndex(nb)) instanceof Actuel)){
							int num=a.takeCardsV(a.getOrdreIndex(nb));
							notifyObserver(a.getOrdreIndex(nb), num);
							lbls[num].setVisible(false);
							if(nb==0) {
								int c1=0;
								if(num/2==a.getOrdreIndex(2)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(2, c1);
								}
								else if(num/2==a.getOrdreIndex(3)) {
									c1=a.getOrdreIndex(1);
									a.changerOrdre(1,num/2);
									a.changerOrdre(3,a.getOrdreIndex(2));
									a.changerOrdre(2,c1);}
								}
							else if(nb==1&&num/2==a.getOrdreIndex(3)){
								int c1=0;
								c1=a.getOrdreIndex(3);
								a.changerOrdre(3,a.getOrdreIndex(2));
								a.changerOrdre(2,c1);
								}
							nb++;
							}
					}
					if(nb==4) {
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
		ImageIcon bg2=null;
		bg2 = new ImageIcon(AccueilInterface.class.getResource("/Vue/carteback.jpg"));
		Image im2=bg1.getImage();
		im2=im2.getScaledInstance(25,30,10);
		bg2.setImage(im2);
		frame.getContentPane().setLayout(null);
		
		this.lblNewLabel_1=new JLabel(bg2);
		lblNewLabel_1.setBounds(126, 6, 23, 28);
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
		lblNewLabel_2.setBounds(126, 394, 23, 28);
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
		lblNewLabel_3.setBounds(440, 394, 23, 28);
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
		this.lblNewLabel_4=new JLabel(bg2);
		lblNewLabel_4.setBounds(440, 6, 23, 28);
		frame.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				VueDeJest window = new VueDeJest(3);
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
		
		
		this.lblNewLabel_pile=new JLabel(bg1);
		lblNewLabel_pile.setBounds(6, 182, 48, 73);
		frame.getContentPane().add(lblNewLabel_pile);
		this.lblNewLabel_pile1=new JLabel(bg1);
		lblNewLabel_pile1.setBounds(6, 186, 48, 74);
		frame.getContentPane().add(lblNewLabel_pile1);
		this.lblNewLabel_pile2=new JLabel(bg1);
		lblNewLabel_pile2.setBounds(6, 190, 48, 73);
		frame.getContentPane().add(lblNewLabel_pile2);
		
		ImageIcon bg3=null;
		
		bg3 = new ImageIcon(AccueilInterface.class.getResource("/Vue/regle.jpg"));
		Image im3=bg3.getImage();
		im3=im3.getScaledInstance(140,190,100);
		bg3.setImage(im3);
		frame.getContentPane().setLayout(null);
		
		this.lblNewLabel_regle=new JLabel(bg3);
		lblNewLabel_regle.setBounds(230, 130, 140, 183);
		frame.getContentPane().add(lblNewLabel_regle);
		
		this.lblNewLabel_trophie1=new JLabel(bg1);
		lblNewLabel_trophie1.setBounds(535, 182, 48, 73);
		frame.getContentPane().add(lblNewLabel_trophie1);
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
		for (int i=0;i<8;i++) {
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
			
			ImageIcon bg3=null;
			bg3 = c.textToPicture(a.getTrophie1());
			Image im3=bg3.getImage();
			im3=im3.getScaledInstance(48,73,100);
			bg3.setImage(im3);
			frame.getContentPane().setLayout(null);
			
			this.lblNewLabel_trophie1=new JLabel(bg3);
			lblNewLabel_trophie1.setBounds(535, 182, 48, 73);
			frame.getContentPane().add(lblNewLabel_trophie1);
			lblNewLabel_trophie1.setVisible(true);
		}
		if(e.getActionCommand().equals("Deal")){
			Accueuil a=Accueuil.getInstance();
			ControleurCards c=new ControleurCards();
			this.initialize2();
			if(a.size()>0){	
				for(int i = 0; i<8 ;i++) {
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
		
		if(e.getActionCommand().equals("Show the Jest")){
			Accueuil a=Accueuil.getInstance();
				for(int j = 0;j<a.getNbJoeur();j++) {
					VueDeJest window = new VueDeJest(j);
					window.frame.setVisible(true);
				}
			
			
			}
		if(e.getActionCommand().equals("Distribute trophie")){
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
		if(e.getActionCommand().equals("Choose an up card")){
			Accueuil a=Accueuil.getInstance();
			ControleurCards c=new ControleurCards();
			try {
				Thread.sleep(500);
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
				else{
					
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
			
			a.compare(a.getJoueurs().get(0).cardUp,a.getJoueurs().get(1).cardUp,a.getJoueurs().get(2).cardUp,a.getJoueurs().get(3).cardUp);
			while(nb<4&&!(a.getJoueurs().get(a.getOrdreIndex(nb)) instanceof Actuel)){
					int num=a.takeCardsV(a.getOrdreIndex(nb));
					notifyObserver(a.getOrdreIndex(nb), num);
					lbls[num].setVisible(false);
					//the situation that we need to changer the order
					if(nb==0) {
						int c1=0;
						if(num/2==a.getOrdreIndex(2)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,num/2);
							a.changerOrdre(2, c1);
						}
						else if(num/2==a.getOrdreIndex(3)) {
							c1=a.getOrdreIndex(1);
							a.changerOrdre(1,num/2);
							a.changerOrdre(3,a.getOrdreIndex(2));
							a.changerOrdre(2,c1);}
						}
					else if(nb==1&&num/2==a.getOrdreIndex(3)){
						int c1=0;
						c1=a.getOrdreIndex(3);
						a.changerOrdre(3,a.getOrdreIndex(2));
						a.changerOrdre(2,c1);
						}
					nb++;
					}
					
			if(nb==4) {
						nb=0;
						System.out.println("This round is over now");
						if(a.size()>0) {
							a.takeCardsBack();
							System.out.println("The number of the pile is : "+a.getNbPile());
							initialize2();
						}
			}
			}catch (InterruptedException e1) {
	           e1.printStackTrace(); 
	       }
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
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}