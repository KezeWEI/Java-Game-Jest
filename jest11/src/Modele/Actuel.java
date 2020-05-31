package Modele;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Cette classe est pour les joueurs physiques
 * elle herite la classe Joueur et realise l'interface Strategy
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */

public class Actuel extends Joueur implements Strategy {
	
	/**
	 * constructeur par default
	 */
	public Actuel() {
		super();
	}
	
	/**
	 * constructeur
	 * @param n
	 * le nom entre par l'utilisateur
	 * @param s
	 * la strategie est toujours new Actuel()
	 */
	public Actuel(String n,Strategy s) {
		super(n,s);
	}
	
	/**
	 * choisir la carte qui est visible pour les autres joueurs
	 */
	public void chooseCardUp() {
		Scanner scan=new Scanner(System.in);
		System.out.println(this.getNom()+" selectionnez une carte tournee vers le haut et entrez C1 ou C2 ,svp.");
		String a=new String();
		a = scan.next();
		while (!a.equals("C1")&&!a.equals("C2")) {
				System.out.println("Entrez C1 ou C2, svp");
				a = scan.next();
				continue;
		}
		if(a.equals("C1")||a.equals("c1")) {
			this.cardUp=card1;
			this.cardDown=card2;
			System.out.println(this.nom + "  a choisi la carte " + this.cardUp.toString() + " Up");
			}
		else if(a.equals("C2")||a.equals("c2")){
			this.cardUp=card2;
			this.cardDown=card1;
			System.out.println(this.nom + "  a choisi la carte " + this.cardDown.toString() + " Up");
		}
		else {
			System.out.println("Vous ne pouvez pas choisir " + a +". Choisissez a nouveau");
		}
	}
	
	//for GUI
	/**
	 * choisir la carte qui est visible pour les autres joueurs pour l'interface graphique
	 * @param b
	 * le nombre de la carte visible(1 ou 2)
	 */
	public void chooseCardUp(int b) {
		int a=b;
		if(a==1) {
			this.cardUp=card1;
			this.card1=null;
			this.cardDown=card2;
			System.out.println(this.nom + "  a choisi la carte " + this.cardUp.toString() + " Up");
			}
		else {
			this.cardUp=card2;
			this.card2=null;
			this.cardDown=card1;
			System.out.println(this.nom + "  a choisi la carte " + this.cardUp.toString() + " Up");
		}
		
	}
	
	/**
	 * choisir la carte de l'autre joueur
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
		int a=0;
		String b;
		Scanner scan=new Scanner(System.in);
		if (scan.hasNextInt()) {
			a=scan.nextInt();
		}
		if(n!=0) {
		//choisit quel joueur
			while (a-1==ordre[i]||l.get(a-1).marque==false) {
				System.out.println("Entrez le bon nombre,svp");
				if(scan.hasNext()) {
					a = scan.nextInt();
				}continue;
			}
			l.get(a-1).marque=false;
			System.out.println("Marque de " + l.get(a-1).getNom()+" est :" +l.get(a-1).marque);
			
		//choisit Up ou Down
			System.out.println("La carte Up ou la carte Down? S'il vous plait entrez Up ou Down");
			b=scan.next();
			while (!b.equals("Up")&&!b.equals("Down")&&!b.equals("up")&&!b.equals("down")) {
				System.out.println("Entrez Up ou Down,svp");
				b = scan.next();
				continue;
			}
			if (b.equals("Up")) {
				
			//ici,quand on utilise la methode getCardUP()
			//CardUp sera defini sur NULL apres envoiye une valeur pour faciliter la recuperation
				l.get(ordre[i]).takeCard(l.get(a-1).getCardUP());
				System.out.println(l.get(a-1).getNom()+" up "+l.get(a-1).cardUp);
				System.out.println(l.get(a-1).getNom()+" down "+l.get(a-1).cardDown);
			}
			else {
				l.get(ordre[i]).takeCard(l.get(a-1).getCardDown());
				System.out.println(l.get(a-1).getNom()+" up "+l.get(a-1).cardUp);
				System.out.println(l.get(a-1).getNom()+" down "+l.get(a-1).cardDown);
			}
		}
		else {
			b=scan.next();
			while (!b.equals("Up")&&!b.equals("Down")&&!b.equals("up")&&!b.equals("down")) {
				System.out.println("Entrez Up ou Down,svp");
				b = scan.next();
				continue;
			}
			if(b.equals("Up")||b.equals("up")) {
				l.get(ordre[l.size()-1]).takeCard(l.get(ordre[l.size()-1]).getCardUP());
			}
			else {
				l.get(ordre[l.size()-1]).takeCard(l.get(ordre[l.size()-1]).getCardDown());
			}
		}
	return a;
	}
	
}
