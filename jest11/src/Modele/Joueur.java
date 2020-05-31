package Modele;
import java.util.*;

/**
 * Cette classe est gerer chaque joueur
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */


public class Joueur {
	protected String nom;
	public boolean marque;
	
	public Strategy strategy;
	
	protected LinkedList<Cards> jest;
	protected Cards card1;
	protected Cards card2;
	public  Cards cardUp;
	protected Cards cardDown;
	
	//Ces variables sont pour l'attribution facile des Trophies
	private int nbrDeux;
	private int nbrTrois;
	private int nbrQuatre;
	private int nbrJoker;
	private int maxCoeur;
	private int minCoeur;
	private int maxTrefle;
	private int minTrefle;
	private int maxCarreau;
	private int minCarreau;
	private int maxPique;
	private int minPique;
	private int maxQuatre;
	private int maxTrois;
	private int maxDeux;
	private int maxCard;
	private int value;
	
	/**
	 * constructeur par default
	 */
	public Joueur() {
		this.jest=new LinkedList();
		this.marque=true;
	};
	
	/**
	 * constructeur
	 * creer le joueur par le nom et la strategie
	 * @param n
	 * le nom entre par l'utilisateur
	 * @param st
	 * la strategie depend du type de joueur
	 */
	public Joueur (String n,Strategy st) {
		this.nom=n;
		this.jest=new LinkedList();
		this.marque=true;
		this.strategy=st;
	}
	
	/**
	 * recu deux cartes, on les met sur C1 C2 pour le moment 
	 * @param c1
	 * la premiere carte
	 * @param c2
	 * la deuxieme carte
	 * 
	 */
	public void getCards(Cards c1,Cards c2) {
		this.card1=c1;
		this.card2=c2;
		System.out.println(card1 +"      " + card2);
	}
	
	/**
	 * obtenir la premier carte
	 * @return this.card1
	 * retourner la premier carte
	 */
	public Cards getCard1() {
		return this.card1;
	}
	
	/**
	 * obtenir la deuxieme carte
	 * @return this.card2
	 * retourner la deuxieme carte
	 */
	public Cards getCard2() {
		return this.card2;
	}
	
	/**
	 * choisir la carte qui est visible pour les autres joueurs
	 */
	public void chooseCardUp() {
		strategy.chooseCardUp();
	}
	
	/**
	 * cette methode est pour les joueurs virtuels
	 * @return 0
	 * retour 0
	 */
	public int chooseCardUpReturn() {
		return 0;
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
	 * @return strategy.takeCards(l, ordre, i, n)
	 */
	public int takeCards(ArrayList<Joueur> l,int []ordre,int i,int n) {
		return strategy.takeCards(l, ordre, i, n);
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
		return 0;
	}
	
	/**
	 * afficher le jest
	 * @return this.jest.toString()
	 * afficher le jest
	 */
	public String getJest() {
		return this.jest.toString();
	}
	
	/**
	 * afficher le jest pour l'interface graphique
	 * @return
	 * retourner le jest
	 */
	public LinkedList<Cards> getJestGUI() {
		return this.jest;
	}
	
	/**
	 * retourner la carte visible et la supprimer 
	 * mettre la marque a false: la carte ne peut pas etre choisit
	 * @return a
	 * retourner la carte visible
	 */
	public Cards getCardUP() {
		Cards a=this.cardUp;
		this.cardUp=null;
		this.marque=false;
		return a;
	}
	
	/**
	 * retourner la carte non visible et la supprimer 
	 * mettre la marque a false: la carte ne peut pas etre choisit
	 * @return
	 * retourner la carte non visible
	 */
	public Cards getCardDown() {
		Cards a=this.cardDown;
		this.cardDown=null;
		this.marque=false;
		return a;
	}
	
	/**
	 * retourner si la carte non visible est null
	 * @return
	 * retourner si la carte non visible est null
	 */
	public boolean cardDownIsNull() {
		return (this.cardDown==null);
	}
	
	/**
	 * ajouter la carte dans la pile
	 * @param c
	 * une card pour ajouter dans le jest
	 */
	public void takeCard(Cards c) {
		this.jest.add(c);
	}
	
	/**
	 * afficher la carte
	 */
	public void printJest() {
		for (Cards c:jest) {
		System.out.println(c);
		}
	}
	
	/**
	 * retourner le nom du joueur
	 * @return this.nom
	 * retourner le nom du joueur
	 */
	public String getNom() {
		//System.out.println(this.nom);
		return this.nom;
	}
	
	/**
	 * setter le nom du joueur
	 * @param s
	 * entre par l'utilisateur
	 */
	public void setNom(String s) {
		this.nom=s;	
	}
	
	/**
	 * pour realiser le pattern Visitor
	 * pour faciliter de distribuer les trophies
	 * @param v
	 * visitor
	 */
	public void accept(Visitor v)
    {
        v.visit(this.jest,this.nom);
        if(v instanceof Calcul)
        {
        	Calcul c=(Calcul)v;
        	//ces methodes sont pour faciliter de distribuer les trophies
        	this.value=c.value();
        	this.maxCard=c.maxCard();
        	this.maxCarreau=c.maxCarreau();
        	this.minCarreau=c.minCarreau();
        	this.maxCoeur=c.maxCoeur();
        	this.minCoeur=c.minCoeur();
        	this.maxPique=c.maxPique();
        	this.minPique=c.minPique();
        	this.maxTrefle=c.maxTrefle();
        	this.minTrefle=c.minTrefle();
        	this.nbrDeux=c.nbDeux();
        	this.nbrTrois=c.nbTrois();
        	this.nbrQuatre=c.nbQuatre();
        	this.maxDeux=c.maxDeux();
        	this.maxTrois=c.maxTrois();
        	this.maxQuatre=c.maxQuatre();
        	if(c.avoirJoker()) {
        		this.nbrJoker=1;
        	}
        	else {
        		this.nbrJoker=0;
        	}
        }
    }
	
	/**
	 * retourner la note du jest
	 * @return this.value
	 * retour la note du jest
	 */
	public int value() {
		return this.value;
	}
	
	/**
	 * retourner le note de la carte Carreau maximale
	 * @return this.maxCarreau
	 * retour le note de la carte Carreau maximale
	 */
	public int maxCarreau() {
		return this.maxCarreau;
	}
	
	/**
	 * retourner le note de la carte Carreau minimale 
	 * @return this.maxCarreau
	 * retour le note de la carte Carreau minimale
	 */
	public int minCarreau() {
		return this.minCarreau;
	}
	
	/**
	 * retourner le note de la carte Coeur maximale 
	 * @return this.maxCoeur
	 * retourner le note de la carte Coeur maximale
	 */
	public int maxCoeur() {
		return this.maxCoeur;
	}
	
	/**
	 * retourner la note de la carte Coeur minimale 
	 * @return this.minCoeur
	 * retour la note de la carte Coeur minimale
	 */
	public int minCoeur() {
		return this.minCoeur;
	}
	
	/**
	 * retourner la note de la carte Pique maximale
	 * @return this.maxiPique
	 * retour la note de la carte Pique maximale
	 */
	public int maxPique() {
		return this.maxPique;
	}
	
	/**
	 * retourner la note de la carte Pique minmale
	 * @return this.minPique
	 * retour la note de la carte Pique minmale
	 */
	public int minPique() {
		return this.minPique;
	}
	
	/**
	 * retourner la note de la carte Trefle maximale
	 *@return this.maxiTrefle
	 * retour la note de la carte Trefle maximale
	 */
	public int maxTrefle() {
		return this.maxTrefle;
	}
	
	/**
	 * retourner la note de la carte Trefle minimale
	 * @return this.miniTrefle
	 * retour la note de la carte Trefle minimale
	 */
	public int minTrefle() {
		return this.minTrefle;
	}
	
	/**
	 * retourner le nombre des cartes valeur de deux
	 * @return this.nbrDeux
	 * retour le nombre des cartes valeur de deux
	 */
	public int nbDeux() {
		return this.nbrDeux;
	}
	
	/**
	 * retourner le nombre des cartes valeur de Trois
	 * @return this.nbrTrois
	 * retour le nombre des cartes valeur de Trois
	 */
	public int nbTrois() {
		return this.nbrTrois;
	}
	
	/**
	 * retourner le nombre des cartes valeur de Quatre
	 * @return this.nbrQuatre
	 * retour le nombre des cartes valeur de Quatre
	 */
	public int nbQuatre() {
		return this.nbrQuatre;
	}
	
	/**
	 * 
	 * @return (this.nbrJoker==1)
	 * s'il y a de Joker
	 */
	public boolean avoirJoker() {
		return (this.nbrJoker==1);
	}
	
	/**
	 * retourner la note de la carte maximale de valeur de Quatre
	 * @return this.maxQuatre
	 * retour la note de la carte maximale de valeur de Quatre
	 */
	public int maxQuatre() {
		return this.maxQuatre;
	}
	
	/**
	 * retourner la note de la carte maximale de valeur de Trois
	 *  @return this.maxTrois
	 * retour la note de la carte maximale de valeur de Trois
	 */
	public int maxTrois() {
		return this.maxTrois;
	}
	
	/**
	 * retourner la note de la carte maximale de valeur de Deux
	 *  @return this.maxDeux
	 * retour la note de la carte maximale de valeur de Deux
	 */
	public int maxDeux() {
		return this.maxDeux;
	}
	
	/**
	 * retourner la note de la carte maximale
	 *  @return this.maxQCard
	 * retour la note de la carte maximale
	 */
	public int maxCard() {
		return this.maxCard;
	}
	
}
