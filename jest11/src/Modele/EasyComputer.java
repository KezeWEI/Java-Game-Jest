package Modele;

import java.util.ArrayList;

/**
 * Cette classe est pour les joueurs virtuels et la difficulte est facile
 * elle herite la classe Joueur et realise l'interface Strategy
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */

public class EasyComputer extends Joueur implements Strategy{
	
	/**
	 * constructeur
	 * @param n
	 * le nom entre par l'utilisateur
	 * @param s
	 * la strategie est toujours new EasyComputer()
	 */
	public EasyComputer(String n,Strategy s) {
		super(n,s);
	}
	
	/**
	 * constructeur par default
	 */
	public EasyComputer() {
		super();
	}

	/**
	 * choisir la carte qui est visible pour les autres joueurs
	 * la premier carte est visible
	 */
	public void chooseCardUp() {
		this.cardUp=card1;
		this.cardDown=card2;
		System.out.println(this.getNom() + " a choisi la carte "+ this.card1.toString());
	}
	
	/**
	 * obtenir le nombre de la carte visible(1 ou 2)
	 * @return
	 * retourner le nombre de la carte visible(1 ou 2)
	 */
	public int chooseCardUpReturn() {
		this.cardUp=card1;
		this.cardDown=card2;
		System.out.println(this.getNom() + " a choisi la carte "+ this.card1.toString());
		return 1;
	}
	
	/**
	 * choisir la carte de l'autre joueur
	 * toujour choisir la carte visible plus grande
	 * @param l
	 * l pour obtenir la liste de joueurs
	 * @param ordre
	 * ordre pour savoir l'ordre de joueurs de choisit
	 * @param i
	 * c'est le ieme joueur de choisir
	 * @param n
	 * n pour marquer si le joueur peut choisir lui-meme
	 *  si !n=0 le joueur chosit une carte d'un autre joueur qui n'a pas ete choisit
	 *  si n=0 le joueur doit choisir ses cartes
	 *
	 * @return a
	 * retourner le numero du joueur suivant qui est choisit par le joueur maintenant
	 */
	public int takeCards(ArrayList<Joueur> l,int []ordre,int i,int n) {
		int nbJ=l.size();
		if(nbJ==3) {
			if(l.get(0).marque==true&&ordre[i]!=0) {
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(0).getNom());
				this.jest.add(l.get(0).getCardUP());
				l.get(0).marque=false;
				return 1;
			}
			else if(l.get(1).marque==true&&ordre[i]!=1){
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(1).getNom());
				this.jest.add(l.get(1).getCardUP());
				l.get(1).marque=false;
				return 2;
			}
			else {
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(2).getNom());
				this.jest.add(l.get(2).getCardUP());
				l.get(2).marque=false;
				return 3;
			}
			
		}
		else{
			if(l.get(0).marque==true&&ordre[i]!=0) {
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(0).getNom());
				this.jest.add(l.get(0).getCardUP());
				l.get(0).marque=false;
				return 1;
			}
			else if (l.get(1).marque==true&&ordre[i]!=1) {
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(1).getNom());
					this.jest.add(l.get(1).getCardUP());
					l.get(1).marque=false;
					return 2;
				}
			else if(l.get(2).marque==true&&ordre[i]!=2){
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(2).getNom());
					this.jest.add(l.get(2).getCardUP());
					l.get(2).marque=false;
					return 3;
				}	
			else {
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(3).getNom());
					this.jest.add(l.get(3).getCardUP());
					l.get(3).marque=false;
					return 4;
				}
			}
			
		}
	
	/**
	 * choisir la carte de l'autre joueur pour l'interface graphique
	 * toujour choisir la carte visible plus grande
	 * @param l
	 * l pour obtenir la liste de joueurs
	 * @param ordre
	 * ordre pour savoir l'ordre de joueurs de choisit
	 * @param i
	 * c'est le ieme joueur de choisir
	 * @param n
	 * n pour marquer si le joueur peut choisir lui-meme
	 *  si !n=0 le joueur chosit une carte d'un autre joueur qui n'a pas ete choisit
	 *  si n=0 le joueur doit choisir ses cartes
	 *
	 * @return a
	 * retourner le numero du joueur suivant qui est choisit par le joueur maintenant
	 */
	//for GUI
	public int takeCardsV(ArrayList<Joueur> l,int []ordre,int i,int n) {
		try {
			Thread.sleep(300);
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		int nbJ=l.size();
		if(nbJ==3) {
			if(l.get(0).marque==true&&i!=0) {
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(0).getNom());
				this.jest.add(l.get(0).getCardUP());
				l.get(0).marque=false;
				return 0;
			}
			else if(l.get(1).marque==true&&i!=1){
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(1).getNom());
				this.jest.add(l.get(1).getCardUP());
				l.get(1).marque=false;
				return 2;
			}
			else {
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(2).getNom());
				this.jest.add(l.get(2).getCardUP());
				l.get(2).marque=false;
				return 4;
			}
			
		}
		else{
			if(l.get(0).marque==true&&i!=0) {
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(0).getNom());
				this.jest.add(l.get(0).getCardUP());
				l.get(0).marque=false;
				return 1;
			}
			else if (l.get(1).marque==true&&i!=1) {
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(1).getNom());
					this.jest.add(l.get(1).getCardUP());
					l.get(1).marque=false;
					return 3;
				}
			else if(l.get(2).marque==true&&i!=2){
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(2).getNom());
					this.jest.add(l.get(2).getCardUP());
					l.get(2).marque=false;
					return 3;
				}	
			else {
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(3).getNom());
					this.jest.add(l.get(3).getCardUP());
					l.get(3).marque=false;
					return 5;
				}
			}
		
			
		}

	@Override
	public void getCards(Cards c1, Cards c2) {
		// TODO Auto-generated method stub
		super.getCards(c1, c2);
	}

	@Override
	public String getJest() {
		// TODO Auto-generated method stub
		return super.getJest();
	}

	@Override
	public Cards getCardUP() {
		// TODO Auto-generated method stub
		return super.getCardUP();
	}

	@Override
	public Cards getCardDown() {
		// TODO Auto-generated method stub
		return super.getCardDown();
	}

	@Override
	public void takeCard(Cards c) {
		// TODO Auto-generated method stub
		super.takeCard(c);
	}

	@Override
	public void printJest() {
		// TODO Auto-generated method stub
		super.printJest();
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return super.getNom();
	}

	@Override
	public void setNom(String s) {
		// TODO Auto-generated method stub
		super.setNom(s);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		super.accept(v);
	}

	@Override
	public int value() {
		// TODO Auto-generated method stub
		return super.value();
	}

	@Override
	public int maxCarreau() {
		// TODO Auto-generated method stub
		return super.maxCarreau();
	}

	@Override
	public int minCarreau() {
		// TODO Auto-generated method stub
		return super.minCarreau();
	}

	@Override
	public int maxCoeur() {
		// TODO Auto-generated method stub
		return super.maxCoeur();
	}

	@Override
	public int minCoeur() {
		// TODO Auto-generated method stub
		return super.minCoeur();
	}

	@Override
	public int maxPique() {
		// TODO Auto-generated method stub
		return super.maxPique();
	}

	@Override
	public int minPique() {
		// TODO Auto-generated method stub
		return super.minPique();
	}

	@Override
	public int maxTrefle() {
		// TODO Auto-generated method stub
		return super.maxTrefle();
	}

	@Override
	public int minTrefle() {
		// TODO Auto-generated method stub
		return super.minTrefle();
	}

	@Override
	public int nbDeux() {
		// TODO Auto-generated method stub
		return super.nbDeux();
	}

	@Override
	public int nbTrois() {
		// TODO Auto-generated method stub
		return super.nbTrois();
	}

	@Override
	public int nbQuatre() {
		// TODO Auto-generated method stub
		return super.nbQuatre();
	}

	@Override
	public boolean avoirJoker() {
		// TODO Auto-generated method stub
		return super.avoirJoker();
	}

	@Override
	public int maxQuatre() {
		// TODO Auto-generated method stub
		return super.maxQuatre();
	}

	@Override
	public int maxTrois() {
		// TODO Auto-generated method stub
		return super.maxTrois();
	}

	@Override
	public int maxDeux() {
		// TODO Auto-generated method stub
		return super.maxDeux();
	}

	@Override
	public int maxCard() {
		// TODO Auto-generated method stub
		return super.maxCard();
	}
	}
	