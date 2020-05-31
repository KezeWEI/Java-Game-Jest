package Modele;
import java.util.*;

/**
 * Cette classe est pour realiser les functions de la pile de cartes
 * il contient des cartes
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 */
public class CardPile {
	public static int nomcards=17;
	private LinkedList<Cards> cardpile;	
	
	/**
	 * constructeur par default
	 */
	public CardPile() {
		this.cardpile= new LinkedList<Cards>();
		this.cardCreat();
	}
	
	/**
	 * retour la pile de cartes
	 * @return cardpile
	 * retour la pile de cartes
	 */
	public LinkedList<Cards> getCardPile(){
		return cardpile;
	}

	/**
	 * creer la pile de cartes initiale
	 * mettre tous les cartes dans la pile de cartes
	 */
	public void cardCreat() {
		this.cardpile= new LinkedList<Cards>(); 
		for (Suit s:Suit.values()) {
			for (Valeur v:Valeur.values()) {
				if (s!=Suit.JOKER&v!=Valeur.JOKER) {
					Cards card=new Cards(s,v);
					this.cardpile.add(card);
				}
			}
		}
		Cards card= new Cards(Suit.JOKER,Valeur.JOKER);
		this.cardpile.add(card);
	}
	
	/**
	 * melanger les cartes dans la pile
	 */
	public void melanger() {
		Collections.shuffle(cardpile);
	}
			
	/**
	 * ajouter une carte dans la pile
	 * @param a
	 *  ajouter la carte a dans la pile
	 */
	public void addCard(Cards a) {
		cardpile.add(a);
	}
	
	/**
	 * mettre une carte dans la pile
	 * @param a
	 * mettre la carte a dans la pile
	 */
	public void putCardsBack(Cards a) {
		cardpile.add(a);
	}
		
	/**
	 * retour si la pile est vide
	 * @return cardpile.isEmpty()
	 * retour si la pile est vide
	 */
	public boolean isEmpty() {
		System.out.println("Le nombre de Pile est  " + this.cardpile.size());
		return cardpile.isEmpty();
	}
	
	/**
	 * choisir une carte et la supprime
	 * @return c
	 * retour la carte choisite et supprimee
	 */
	public Cards tirerCard() {
		Cards c= new Cards();			
		c=cardpile.poll();	
		return c;
	}

	/**
	 * supprimer la premiere carte dans la pile
	 * @return cardpile.poll();
	 * supprimer la premiere carte dans la pile
	 */
	public Cards poll() {
		return cardpile.poll();
	}
		
	/**
	 * afficher les cartes
	 */
	public String toString() {
		return cardpile.toString();
	}
	
	/**
	 * @return this.cardpile.size()
	 * retour le nombre de cartes dans la pile
	 */
	public int size() {
		return this.cardpile.size();
	}
}
