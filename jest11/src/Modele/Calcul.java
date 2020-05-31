package Modele;
import java.util.*;

/**
 * Cette classe est pour calculer des notes de chaque joueur
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */

public class Calcul implements Visitor{
	
	private int value;
	private int nbrAs;
	private int nbrDeux;
	private int nbrTrois;
	private int nbrQuatre;
	
	private int nbrCoeur;
	private int nbrPique;
	private int nbrJoker;
	private int nbrTrefle;
	
	
	private Valeur[] valeurPique;
	private Valeur[] valeurTrefle;
	private LinkedList<Cards> jest;
	private String nomJoueur;
	
	/**
	 * Constructeur par default
	 */
	public Calcul() {
		 value=0;
		 nbrAs=0;
		 nbrDeux=0;
		 nbrTrois=0;
		 nbrQuatre=0;
		 valeurPique=new Valeur[100];
		 valeurTrefle=new Valeur[100];
		 nbrCoeur=0;
		 nbrPique=0;
		 nbrJoker=0;
		 nbrTrefle=0;
		 LinkedList<Cards> jest=new LinkedList<Cards>();
	}
	
	/**
	 * 
	 * initialiser pour calcul
	 */
	public void inti() {
		value=0;
		nbrAs=0;
		nbrDeux=0;
		nbrTrois=0;
		nbrQuatre=0;
		valeurPique=new Valeur[100];
		valeurTrefle=new Valeur[100];
		nbrCoeur=0;
		nbrPique=0;
		nbrJoker=0;
		nbrTrefle=0;
		LinkedList<Cards> jest=new LinkedList<Cards>();
	}
	
	/**
	 * calculer et montrer la note de jest du joueur
	 * utiliser la methode calcul()
	 * @param j
	 * le jest du joueur
	 * @param s
	 * le nom du joueur
	 */
	public void visit(LinkedList<Cards> j,String s) {
		this.jest=j;
		for (Cards c:jest) {
			System.out.println(c);
		}
		this.compteNombre();
		this.calcul();
		this.nomJoueur=s;
		System.out.println("Le valeur de "+this.nomJoueur+ "  est  " +this.value);
	}
	
	/**
	 * calculer la note de jest
	 * utiliser la methode calcul()
	 * @param j
	 * le jest
	 */
	public void visit(LinkedList<Cards> j) {
		this.jest=j;
		this.compteNombre();
		this.calcul();
	}
	
	/**
	 * compter les nombres de chaque type de carte
	 */
	public void compteNombre() {
		for (Iterator<Cards> it=jest.iterator();it.hasNext();) {
			Cards card=it.next();
			if (card.getValeur()==Valeur.AS) {					
				this.nbrAs++;
			}
			else if(card.getValeur()==Valeur.DEUX) {
				this.nbrDeux++;
			}
			else if(card.getValeur()==Valeur.TROIS) {
				this.nbrTrois++;
			}
			else if (card.getValeur()==Valeur.QUATRE) {
				this.nbrQuatre++;
			}
				
			if (card.getSuit()==Suit.COEUR) {
				this.nbrCoeur++;
			}
			else if (card.getSuit()==Suit.JOKER) {
				this.nbrJoker++;
			}
			else if (card.getSuit()==Suit.PIQUE) {
				valeurPique[this.nbrPique]=card.getValeur();
				this.nbrPique++;
			}
			else if (card.getSuit()==Suit.TREFLE) {
				valeurTrefle[this.nbrTrefle]=card.getValeur();
				this.nbrTrefle++;
			}
		}
	}
	
	/**
	 * Obtenir la note de la carte par sa valeur et Suit
	 * @param c
	 * la carte
	 * @return
	 * retourner le note de la carte
	 */
	public int getNomDeValue(Cards c) {
		if(c.getValeur()==Valeur.AS){
			if(this.nbrAs==1) {
				return 5;
			}
			else {
				return 1;
			}
		}
		else if(c.getValeur()==Valeur.DEUX)	{
			return 2;
		}
		else if(c.getValeur()==Valeur.TROIS){
			return 3;
		}
		else if(c.getValeur()==Valeur.QUATRE){
			return 4;
		}
		else{
			if(this.nbrCoeur==0) {
				return 4;
			}
			else {
				return 0;
			}
		}
	}
	
	/**
	 * Obtenir la note de la carte par sa valeur et Suit par differents cas
	 * @param c
	 * la carte c
	 * @return value
	 * la note de la carte
	 */
	public int calculValue(Cards c) {
		Suit suitCal=c.getSuit();
		Valeur valueCal=c.getValeur();
		
		if(suitCal==Suit.PIQUE||suitCal==Suit.TREFLE){
			value+=this.getNomDeValue(c);
			return value;
		}
		else if(suitCal==Suit.CARREAU){
			value-=this.getNomDeValue(c);
			return value;
		}
		else if(suitCal==Suit.COEUR){
			if (this.nbrCoeur<4&&this.nbrJoker==1)
				{value-=this.getNomDeValue(c);}
			else if (this.nbrCoeur==4&&this.nbrJoker==1)
				{value+=this.getNomDeValue(c);}
			return value;
		}
		else {
			value+=this.getNomDeValue(c);
			return value;
		}	
	}
	
	/**
	 * 
	 * calcule la note des cartes
	 * @return this.value
	 * la note des cartes
	 */
	public int calcul() {
		for (int k=0;k<this.nbrPique;k++) {
			for (int l=0;l<this.nbrTrefle;l++) {
				if (this.valeurPique[k]==this.valeurTrefle[l]){
					this.value+=2;
				}
			}
		}
		for (Iterator<Cards> it=this.jest.iterator();it.hasNext();) {
			Cards card=it.next();
			this.value=calculValue(card);
		}
		return this.value;
	}
	
	/**
	 * obtenir la note maximale de la carte Coeur
	 * @return val
	 * la note maximale de la carte Coeur
	 */
	public int maxCoeur() {
		int val=0;
		for (Iterator<Cards> it=this.jest.iterator();it.hasNext();) {
			Cards card=it.next();
			if(card.getSuit()==Suit.COEUR) {
				int i=0;
				i=card.getValue();
				if (i>val) {
					val=i;
				}
			}
			}
		return val;
	}
	
	/**
	 * obtenir la note minimale de la carte Coeur
	 * @return val
	 * la note minimale de la carte Coeur
	 */
	public int minCoeur() {
		int val=100;
		for (Iterator<Cards> it=this.jest.iterator();it.hasNext();) {
			Cards card=it.next();
			if(card.getSuit()==Suit.COEUR) {
				int i=0;
				i=card.getValue();
				if (i<val) {
					val=i;
				}
			}
		}
		return val;
	}
	
	/**
	 * obtenir la note maximale de la carte Pique
	 * @return val
	 * la note maximale de la carte Pique
	 */
	public int maxPique() {
		int val=0;
		for (Iterator<Cards> it=this.jest.iterator();it.hasNext();) {
			Cards card=it.next();
			if(card.getSuit()==Suit.PIQUE) {
				int i=0;
				i=card.getValue();
				if (i>val) {
					val=i;
				}
			}
			}
		return val;
	}
	
	/**
	 * obtenir la note minimale de la carte Pique
	 * @return val
	 * la note minimale de la carte Pique
	 */
	public int minPique() {
		int val=100;
		for (Iterator<Cards> it=this.jest.iterator();it.hasNext();) {
			Cards card=it.next();
			if(card.getSuit()==Suit.PIQUE) {
				int i=0;
				i=card.getValue();
				if (i<val) {
					val=i;
				}
			}
			}
		return val;
	}
	
	/**
	 * obtenir la note maximale de la carte Trefle
	 * @return val
	 * la note maximale de la carte Trefle
	 */
	public int maxTrefle() {
		int val=0;
		for (Iterator<Cards> it=this.jest.iterator();it.hasNext();) {
			Cards card=it.next();
			if(card.getSuit()==Suit.TREFLE) {
				int i=0;
				i=card.getValue();
				if (i>val) {
					val=i;
				}
			}
		}
		return val;
	}
	
	/**
	 * obtenir la note minimale de la carte Trefle
	 * @return val
	 * la note minimale de la carte Trefle
	 */
	public int minTrefle() {
		int val=100;
		for (Iterator<Cards> it=this.jest.iterator();it.hasNext();) {
			Cards card=it.next();
			if(card.getSuit()==Suit.TREFLE) {
				int i=0;
				i=card.getValue();
				if (i<val) {
					val=i;
				}
			}
			}
		return val;
	}
	
	/**
	 * 
	 * @return val
	 * la note maximale de la carte Carreau
	 */
	public int maxCarreau() {
		int val=0;
		for (Iterator<Cards> it=this.jest.iterator();it.hasNext();) {
			Cards card=it.next();
			if(card.getSuit()==Suit.CARREAU) {
				int i=0;
				i=card.getValue();
				if (i>val) {
					val=i;
				}
			}
			}
		return val;
	}
	
	/**
	 * obtenir la note minimale de la carte Carreau
	 * @return val
	 * la note minimale de la carte Carreau
	 */
	public int minCarreau() {
		int val=100;
		for (Iterator<Cards> it=this.jest.iterator();it.hasNext();) {
			Cards card=it.next();
			if(card.getSuit()==Suit.CARREAU) {
				int i=0;
				i=card.getValue();
				if (i<val) {
					val=i;
				}
			}
			}
		return val;
	}
	
	/**
	 * obtenir la note maximale de la carte Quatre
	 * @return val
	 * la note maximale de la carte Quatre
	 */
	public int maxQuatre() {
		int val=0;
		for (Iterator<Cards> it=this.jest.iterator();it.hasNext();) {
			Cards card=it.next();
			if(card.getValeur()==Valeur.QUATRE) {
				int i=0;
				i=card.getValue();
				if (i>val) {
					val=i;
				}
			}
			}
		return val;
	}
	
	/**
	 * obtenir la note maximale de la carte Trois
	 * @return val
	 * la note maximale de la carte Trois
	 */
	public int maxTrois() {
		int val=0;
		for (Iterator<Cards> it=this.jest.iterator();it.hasNext();) {
			Cards card=it.next();
			if(card.getValeur()==Valeur.TROIS) {
				int i=0;
				i=card.getValue();
				if (i>val) {
					val=i;
				}
			}
			}
		return val;
	}
	
	/**
	 * obtenir la note maximale de la carte Deux
	 * @return val
	 * la note maximale de la carte Deux
	 */
	public int maxDeux() {
		int val=0;
		for (Iterator<Cards> it=this.jest.iterator();it.hasNext();) {
			Cards card=it.next();
			if(card.getValeur()==Valeur.DEUX) {
				int i=0;
				i=card.getValue();
				if (i>val) {
					val=i;
				}
			}
			}
		return val;
	}
	
	/**
	 * obtenir la note maximale de la carte
	 * @return val
	 * la note maximale de la carte
	 */
	public int maxCard() {
		int val=0;
		for (Iterator<Cards> it=this.jest.iterator();it.hasNext();) {
			Cards card=it.next();
				int i=0;
				i=card.getValue();
				if (i>val) {
					val=i;
				}
			
			}
		return val;
	}
	
	/**
	 * retourner que s'il y a de Joker
	 * @return this.nbrJoker==1
	 * retourner que s'il y a de Joker
	 */
	public boolean avoirJoker() {
		return (this.nbrJoker==1);
	}
	
	/**
	 * obtenir le nombre de cartes qui valuent 4
	 * @return this.nbrQuatre
	 * retourner le nombre de cartes qui valuent 4
	 */
	public int nbQuatre() {
		return this.nbrQuatre;
	}
	
	/**
	 *obtenir le nombre de cartes qui valuent 2
	 * @return this.nbrDeux
	 * retourner le nombre de cartes qui valuent 2
	 */
	public int nbDeux() {
		return this.nbrDeux;
	}
	
	/**
	 * obtenir le nombre de cartes qui valuent 3
	 * @return this.nbrTrois
	 * retourner le nombre de cartes qui valuent 3
	 */
	public int nbTrois() {
		return this.nbrTrois;
	}
	
	/**
	 * obtenir la note de jest
	 * @return this.value
	 * retourner la note de jest
	 */
	public int value() {
		return this.value;
	}
}

