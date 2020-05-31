package Modele;

/**
 * Cette classe est pour gerer chaque carte
 * chaque carte a deux attributs:valeur et suit
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */

public class Cards {
	private Suit suit;
	private Valeur valeur;
	
	/**
	 * constructeur par default
	 */
	public Cards() {
		this.suit=null;
		this.valeur=null;
	}
	
	/**
	 * constructeur
	 * @param a
	 * le suit
	 * @param b
	 * le valeur
	 */
	public Cards (Suit a, Valeur b ) {
		this.suit=a;
		this.valeur=b;
	}
	
	/**
	 * obtenir le valeur de la carte
	 * @return this.valeur
	 * retourner le valeur de la carte
	 */
	public Valeur getValeur() {
		return this.valeur;
	}
	
	/**
	 * obtenir le suit de la carte
	 * @return this.suit
	 * retourner le suit de la carte
	 */
	public Suit getSuit() {
		return this.suit;
	}
	
	/**
	 * setter le valeur de la carte
	 * @param v
	 * valeur
	 */
	public void setValeur(Valeur v) {
		this.valeur=v;
	}
	
	/**
	 * setter le suit de la carte	
	 * @param s
	 * suit
	 */
	public void setSuit(Suit s) {
		this.suit=s;
	}
	
	/**
	 * afficher le valeur et le suit de la carte
	 */
	public String toString() {
		StringBuffer s= new StringBuffer();
		s.append(this.valeur);
		s.append("  de  ");
		s.append(this.suit.toString());
		return s.toString();
	}
	
	/**
	 * obtenir retourner le note de la carte
	 * @return b
	 * retourner le note de la carte
	 */
	public int getValue() {
		int b=4;
		if(this.valeur==Valeur.AS) {
			b=4;
		}
		else if(this.valeur==Valeur.DEUX) {
			b=8;
		}
		else if(this.valeur==Valeur.TROIS) {
			b=12;
		}
		else if(this.valeur==Valeur.QUATRE) {
			b=16;
		}
		
		if (this.suit==Suit.PIQUE) {
			b++;
		}
		else if(this.suit==Suit.TREFLE){
			b=b+2;
		}
		else if(this.suit==Suit.CARREAU) {
			b=b+3;
		}
		else if(this.suit==Suit.COEUR){
			b=b+4;
		}

		return b;
	}
	

}
