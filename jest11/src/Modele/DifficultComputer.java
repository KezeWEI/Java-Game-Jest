package Modele;
import java.util.*;

/**
 * Cette classe est pour les joueurs virtuels et la difficulte est difficult
 * elle herite la classe Joueur et realise l'interface Strategy
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */

public class DifficultComputer extends Joueur implements Strategy {
	
	/**
	 * constructeur
	 * @param n
	 * le nom entre par l'utilisateur
	 * @param s
	 * la strategie est toujours new DifficultComputer()
	 */
	public DifficultComputer(String n,Strategy s) {
		super(n,s);
	}
	
	/**
	 * constructeur par default
	 */
	public DifficultComputer() {
		super();
	}
	
	/**
	 * choisir la carte qui est visible pour les autres joueurs
	 * comparer les deux cartes et quand lequel est ajoute dans son jest est plus grand on cache cette carte
	 */
	public void chooseCardUp() {
		int choose=this.plusGrande(this.card1,this.card2);
		if (choose==1) {
			this.cardDown=card1;
			this.cardUp=card2;
			System.out.println(this.getNom() + " a choisi la carte "+ this.card2.toString() +"  Up");
		}
		else {
			this.cardDown=card2;
			this.cardUp=card1;
			System.out.println(this.getNom() + " a choisi la carte "+ this.card1.toString() +"  Up");
		}		
		
	}
	
	/**
	 * obtenir le nombre de la carte visible(1 ou 2)
	 * @return
	 * retourner le nombre de la carte visible(1 ou 2)
	 */
	public int chooseCardUpReturn() {
		int choose=this.plusGrande(this.card1,this.card2);
		if (choose==1) {
			this.cardDown=card1;
			this.cardUp=card2;
			System.out.println(this.getNom() + " a choisi la carte "+ this.card2.toString() +"  Up");
			return 2;
		}
		else {
			this.cardDown=card2;
			this.cardUp=card1;
			System.out.println(this.getNom() + " a choisi la carte "+ this.card1.toString() +"  Up");
			return 1;
		}		
		
	}
	
	/**
	 * pour comparer quand laquelle carte est ajoute, son jest est plus grand
	 * @param c1
	 * une carte
	 * @param c2
	 * une carte
	 * @return
	 * retourner le numero du nombre de la carte qui est plus grande
	 */
	public int plusGrande(Cards c1,Cards c2) {
		LinkedList<Cards> jestT1=(LinkedList)jest.clone();
		LinkedList<Cards> jestT2=(LinkedList)jest.clone();
		jestT1.add(c1);
		jestT2.add(c2);
		Calcul jestV=new Calcul();
		jestV.visit(jestT1);
		int valeurC1=jestV.value();
		jestV.visit(jestT2);
		int valeurC2=jestV.value();
		if(valeurC1>valeurC2) {
			return 1;
		}
		else {
			return 2;
		}
	}
	
	/**
	 * decider quelle carte est plus grande entre les quatre cartes des autre deux joueurs
	 * @param c1
	 * une carte
	 * @param c2
	 * une carte
	 * @param c3
	 * une carte
	 * @param c4
	 * une carte
	 * @return
	 * retourner le numero du nombre de la carte qui est plus grande
	 */
	public int plusGrande(Cards c1,Cards c2,Cards c3,Cards c4) {
		LinkedList<Cards> jestT1=(LinkedList)jest.clone();
		LinkedList<Cards> jestT2=(LinkedList)jest.clone();
		LinkedList<Cards> jestT3=(LinkedList)jest.clone();
		LinkedList<Cards> jestT4=(LinkedList)jest.clone();
		jestT1.add(c1);
		jestT2.add(c2);
		jestT3.add(c3);
		jestT4.add(c4);
		Calcul jestV=new Calcul();
		jestV.visit(jestT1);
		int valeurC1=jestV.value();
		jestV.visit(jestT2);
		int valeurC2=jestV.value();
		jestV.visit(jestT3);
		int valeurC3=jestV.value();
		jestV.visit(jestT4);
		int valeurC4=jestV.value();
		if(valeurC1>valeurC2 & valeurC1>valeurC3 & valeurC1>valeurC4) {
			return 0;
		}
		else if(valeurC2>valeurC1 & valeurC2>valeurC3 & valeurC2>valeurC4) {
			return 1;
		}
		else if(valeurC3>valeurC1 & valeurC3>valeurC2 & valeurC3>valeurC4) {
			return 2;
		}
		else {
			return 3;
		}
	}

	/**
	 * decider quelle carte est plus grande entre les six cartes des autre trois joueurs
	 * @param c1
	 * une carte
	 * @param c2
	 * une carte
	 * @param c3
	 * une carte
	 * @param c4
	 * une carte
	 * @param c5
	 * une carte
	 * @param c6
	 * une carte
	 * @return
	 * retourner le numero du nombre de la carte qui est plus grande
	 */
	public int plusGrande(Cards c1,Cards c2,Cards c3,Cards c4,Cards c5,Cards c6) {
		LinkedList<Cards> jestT1=(LinkedList)jest.clone();
		LinkedList<Cards> jestT2=(LinkedList)jest.clone();
		LinkedList<Cards> jestT3=(LinkedList)jest.clone();
		LinkedList<Cards> jestT4=(LinkedList)jest.clone();
		LinkedList<Cards> jestT5=(LinkedList)jest.clone();
		LinkedList<Cards> jestT6=(LinkedList)jest.clone();
		jestT1.add(c1);
		jestT2.add(c2);
		jestT3.add(c3);
		jestT4.add(c4);
		jestT5.add(c5);
		jestT6.add(c6);
		Calcul jestV=new Calcul();
		jestV.visit(jestT1);
		int valeurC1=jestV.value();
		jestV.visit(jestT2);
		int valeurC2=jestV.value();
		jestV.visit(jestT3);
		int valeurC3=jestV.value();
		jestV.visit(jestT4);
		int valeurC4=jestV.value();
		jestV.visit(jestT5);
		int valeurC5=jestV.value();
		jestV.visit(jestT6);
		int valeurC6=jestV.value();
		if(valeurC1>valeurC2 & valeurC1>valeurC3 & valeurC1>valeurC4 & valeurC1>valeurC5 & valeurC1>valeurC6) {
			return 0;
		}
		else if(valeurC2>valeurC1 & valeurC2>valeurC3 & valeurC2>valeurC4 &valeurC2>valeurC5 & valeurC2>valeurC6) {
			return 1;
		}
		else if(valeurC3>valeurC1 & valeurC3>valeurC2 & valeurC3>valeurC4 & valeurC3>valeurC5 & valeurC3>valeurC6) {
			return 2;
		}
		else if(valeurC4>valeurC1 & valeurC4>valeurC2 & valeurC4>valeurC3 & valeurC4>valeurC5 & valeurC4>valeurC6){
			return 3;
		}
		else if(valeurC5>valeurC1 & valeurC5>valeurC2 & valeurC5>valeurC3 & valeurC5>valeurC4 & valeurC5>valeurC6){
			return 4;
		}
		else {
			return 5;
		}
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
		if(n!=0) {
			int flag=0;
			if(nbJ==3) {
				int[] available= {0,0};
				for(int j=0;j<nbJ;j++) {
					if (l.get(j).marque==true && l.get(j)!=l.get(ordre[i])) {
						available[flag]=j;
						flag++;
					}
				}
				if(flag==1) {
					int j=plusGrande(l.get(available[0]).cardUp,l.get(available[0]).cardDown);
					if (j==1) {
						this.jest.add(l.get(available[0]).getCardUP());
					}
					else {
						this.jest.add(l.get(available[0]).getCardDown());
					}
					l.get(available[0]).marque=false;
					return available[0]+1;
				}
				else{
					int j=plusGrande(l.get(available[0]).cardUp,l.get(available[0]).cardDown,l.get(available[1]).cardUp,l.get(available[1]).cardDown);
					if(j%2==0) {
						this.jest.add(l.get(available[j/2]).getCardUP());
						l.get(available[j/2]).marque=false;
					}
					else {
						this.jest.add(l.get(available[j/2]).getCardDown());
						l.get(available[j/2]).marque=false;
					}
					return available[j/2]+1;
				}
			}
			else {
				int[] available= {0,0,0};
				for(int j=0;j<nbJ;j++) {
					if (l.get(j).marque==true && l.get(j)!=l.get(ordre[i])) {
						available[flag]=j;
						flag++;
					}
				}
				if(flag==1) {
					int j=plusGrande(l.get(available[0]).cardUp,l.get(available[0]).cardDown);
					if (j==1) {
						this.jest.add(l.get(available[0]).getCardUP());
					}
					else {
						this.jest.add(l.get(available[0]).getCardDown());
					}
					l.get(available[0]).marque=false;
					return available[0]+1;
				}
				else if(flag==2){
					int j=plusGrande(l.get(available[0]).cardUp,l.get(available[0]).cardDown,l.get(available[1]).cardUp,l.get(available[1]).cardDown);
					if(j%2==0) {
						this.jest.add(l.get(available[j/2]).getCardUP());
						l.get(available[j/2]).marque=false;
					}
					else {
						this.jest.add(l.get(available[j/2]).getCardDown());
						l.get(available[j/2]).marque=false;
					}
					return available[j/2]+1;
				}
				else {
					int j=plusGrande(l.get(available[0]).cardUp,l.get(available[0]).cardDown,l.get(available[1]).cardUp,l.get(available[1]).cardDown,l.get(available[2]).cardUp,l.get(available[2]).cardDown);
					if(j%2==0) {
						this.jest.add(l.get(available[j/2]).getCardUP());
						l.get(available[j/2]).marque=false;
					}
					else {
						this.jest.add(l.get(available[j/2]).getCardDown());
						l.get(available[j/2]).marque=false;
					}
					return available[j/2]+1;
				}
			}
		}
		else {
			Cards a=this.cardUp;
			Cards b=this.cardDown;
			int choose=this.plusGrande(a,b);
			if (choose==1) {
				this.jest.add(l.get(ordre[i]).getCardUP());
			}
			else {
				this.jest.add(l.get(ordre[i]).getCardDown());
			}
			return ordre[i]+1;
		}
	}

	/**
	 * choisir la carte de l'autre joueur pour l'interface graphique
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
		if(n!=0) {
			int flag=0;
			if(nbJ==3) {
				int[] available= {0,0};
				for(int j=0;j<nbJ;j++) {
					if (l.get(j).marque==true && l.get(j)!=l.get(i)) {
						available[flag]=j;
						flag++;
					}
				}
				if(flag==1) {
					int j=plusGrande(l.get(available[0]).cardUp,l.get(available[0]).cardDown);
					if (j==1) {
						this.jest.add(l.get(available[0]).getCardUP());
						l.get(available[0]).marque=false;
						return available[0]*2;
					}
					else {
						this.jest.add(l.get(available[0]).getCardDown());
						l.get(available[0]).marque=false;
						return available[0]*2+1;
					}
					
				}
				else if(flag==2){
					int j=plusGrande(l.get(available[0]).cardUp,l.get(available[0]).cardDown,l.get(available[1]).cardUp,l.get(available[1]).cardDown);
					if(j%2==0) {
						this.jest.add(l.get(available[j/2]).getCardUP());
						l.get(available[j/2]).marque=false;
						return available[j/2]*2;
					}
					else {
						this.jest.add(l.get(available[j/2]).getCardDown());
						l.get(available[j/2]).marque=false;
						return available[j/2]*2+1;
					}
				
				}
				else {
					return 0;
				}
			}
			else {
				int[] available= {0,0,0};
				for(int j=0;j<nbJ;j++) {
					if (l.get(j).marque==true && l.get(j)!=l.get(i)) {
						available[flag]=j;
						flag++;
					}
				}
				if(flag==1) {
					int j=plusGrande(l.get(available[0]).cardUp,l.get(available[0]).cardDown);
					if (j==1) {
						this.jest.add(l.get(available[0]).getCardUP());
						l.get(available[0]).marque=false;
						return available[0]*2;
					}
					else {
						this.jest.add(l.get(available[0]).getCardDown());
						l.get(available[0]).marque=false;
						return available[0]*2+1;
					}
				}
				else if(flag==2){
					int j=plusGrande(l.get(available[0]).cardUp,l.get(available[0]).cardDown,l.get(available[1]).cardUp,l.get(available[1]).cardDown);
					if(j%2==0) {
						this.jest.add(l.get(available[j/2]).getCardUP());
						l.get(available[j/2]).marque=false;
						return available[j/2]*2;
					}
					else {
						this.jest.add(l.get(available[j/2]).getCardDown());
						l.get(available[j/2]).marque=false;
						return available[j/2]*2+1;
					}
				}
				else if(flag==3){
					int j=plusGrande(l.get(available[0]).cardUp,l.get(available[0]).cardDown,l.get(available[1]).cardUp,l.get(available[1]).cardDown,l.get(available[2]).cardUp,l.get(available[2]).cardDown);
					if(j%2==0) {
						this.jest.add(l.get(available[j/2]).getCardUP());
						l.get(available[j/2]).marque=false;
						return available[j/2]*2;
					}
					else {
						this.jest.add(l.get(available[j/2]).getCardDown());
						l.get(available[j/2]).marque=false;
						return available[j/2]*2+1;
					}
				
				}
				else {
					return 0;
				}
			}
		}
		else {
			Cards a=this.cardUp;
			Cards b=this.cardDown;
			int choose=this.plusGrande(a,b);
			if (choose==1) {
				this.jest.add(l.get(i).getCardUP());
				return i*2;
			}
			else {
				this.jest.add(l.get(i).getCardDown());
				return i*2+1;
			}
			
		}
	}
}