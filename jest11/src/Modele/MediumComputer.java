package Modele;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Cette classe est pour les joueurs virtuels et la difficulte est medium
 * elle herite la classe Joueur et realise l'interface Strategy
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */

public class MediumComputer extends Joueur implements Strategy {
	
	/**
	 * constructeur
	 * creer le joueur physique par le nom et la strategie
	 * @param n
	 * le nom entre par l'utilisateur
	 * @param s
	 * la strategie est toujours new MediumComputer()
	 */
	public MediumComputer(String n,Strategy s) {
		super(n,s);
	}
	
	/**
	 * constructeur par default
	 */
	public MediumComputer() {
		super();
	}

	/**
	 * choisir la carte qui est visible pour les autres joueurs
	 * comparer les deux cartes et quand lequel est ajoute son jest est plus grand on cache cette carte
	 */
	public void chooseCardUp() {
		if (this.card1.getValue()<this.card2.getValue()) {
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
	 * retourner le nombre de la carte visible(1 ou 2)
	 * @return
	 * retour le nombre de la carte visible(1 ou 2)
	 */
	public int chooseCardUpReturn() {
		if (this.card1.getValue()<this.card2.getValue()) {
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
	 * pour comparer quand laquelle carte est ajoute, mon jest est plus grand
	 * @param c1
	 * une carte
	 * @param c2
	 * une carte
	 * @return
	 * retourner le numero du nombre de la carte qui est plus grande
	 */
	public int plusGrande(Cards c1,Cards c2) {
		LinkedList<Cards> jestT1=(LinkedList)this.jest.clone();
		LinkedList<Cards> jestT2=(LinkedList)this.jest.clone();
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
	 * decider quelle carte est plus grande entre les trois cartes des autre trois joueurs
	 * @param c1
	 * une carte
	 * @param c2
	 * une carte
	 * @param c3
	 * une carte
	 * @return
	 * retourner le numero du nombre de la carte qui est plus grande
	 */
	public int plusGrande(Cards c1,Cards c2,Cards c3) {
		LinkedList<Cards> jestT1=(LinkedList)jest.clone();
		LinkedList<Cards> jestT2=(LinkedList)jest.clone();
		LinkedList<Cards> jestT3=(LinkedList)jest.clone();
		jestT1.add(c1);
		jestT2.add(c2);
		jestT3.add(c3);
		Calcul jestV=new Calcul();
		jestV.visit(jestT1);
		int valeurC1=jestV.value();
		jestV.visit(jestT2);
		int valeurC2=jestV.value();
		jestV.visit(jestT1);
		int valeurC3=jestV.value();
		if(valeurC1>valeurC2 && valeurC1>valeurC3) {
			return 1;
		}
		else if(valeurC2>valeurC1 && valeurC2>valeurC3){
			return 2;
		}
		else {
			return 3;
		}
	}
	
	/**
	 * apres ajouter la carte si son jest devient passif
	 * @param c1
	 * la carte va ajouter dans le jest
	 * @return iN
	 * si le jest va devenir negatif
	 */
	public boolean isNull(Cards c1) {
		boolean iN=false;
		LinkedList<Cards> jestT1=(LinkedList)jest.clone();
		jestT1.add(c1);
		Calcul jestV=new Calcul();
		jestV.visit(jestT1);
		int valeurC1=jestV.value();
		if(valeurC1<0) {
			iN=true;
		}
		return iN;
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
					if (l.get(j).marque==true && j!=i) {
						available[flag]=j;
						flag++;
					}
				}
				if(flag==1) {
					this.jest.add(l.get(available[0]).getCardUP());
					l.get(available[0]).marque=false;
					return available[0]*2;
				}
				else{
					int k=plusGrande(l.get(available[0]).cardUp,l.get(available[1]).cardUp);
					if(k==1) {
						this.jest.add(l.get(available[0]).getCardUP());
						l.get(available[0]).marque=false;
						return available[0]*2;
					}
					else {
						boolean N=isNull(l.get(available[0]).cardUp);
						if(N==false) {
							this.jest.add(l.get(available[1]).getCardUP());
							l.get(available[1]).marque=false;
							return available[1]*2;
						}
						else {
							this.jest.add(l.get(available[1]).getCardDown());
							l.get(available[1]).marque=false;
							return available[1]*2+1;
						}
					}
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
					System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(available[0]).getNom());
					this.jest.add(l.get(available[0]).getCardUP());
					l.get(available[0]).marque=false;
					return available[0]*2;
				}
				else if(flag==2){
					int k=plusGrande(l.get(available[0]).cardUp,l.get(available[1]).cardUp);
					if(k==1) {
						System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(available[0]).getNom());
						this.jest.add(l.get(available[0]).getCardUP());
						l.get(available[0]).marque=false;
						return available[0]*2;
					}
					else {
						boolean N=isNull(l.get(available[1]).cardUp);
						if(N==false) {
							this.jest.add(l.get(available[1]).getCardUP());
							l.get(available[1]).marque=false;
							return available[1]*2;
						}
						else {
						System.out.println(this.getNom() + " a choisi la Carte FACEDOWN de "+ l.get(available[1]).getNom());
						this.jest.add(l.get(available[1]).getCardDown());
						l.get(available[1]).marque=false;
						return available[1]*2+1;
						}
					}
				}
				else {
					int k=plusGrande(l.get(available[0]).cardUp,l.get(available[1]).cardUp,l.get(available[2]).cardUp);
					if(k==1) {
						System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(available[0]).getNom());
						this.jest.add(l.get(available[0]).getCardUP());
						l.get(available[0]).marque=false;
						return available[0]*2;
					}
					else if(k==2) {
						boolean N=isNull(l.get(available[1]).cardUp);
						if(N==false) {
							this.jest.add(l.get(available[1]).getCardUP());
							l.get(available[1]).marque=false;
							return available[1]*2;
						}
						else {
							System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(available[1]).getNom());
							this.jest.add(l.get(available[1]).getCardDown());
							l.get(available[1]).marque=false;
							System.out.println(l.get(available[1]).getNom()+" up "+l.get(available[1]).cardUp);
							System.out.println(l.get(available[1]).getNom()+" down "+l.get(available[1]).cardDown);
							return available[1]*2+1;
							}
					}
					else {
						boolean N=isNull(l.get(available[2]).cardUp);
						if(N==false) {
							this.jest.add(l.get(available[2]).getCardUP());
							l.get(available[2]).marque=false;
							return available[2]*2;
						}
						else {
							System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(available[2]).getNom());
							this.jest.add(l.get(available[2]).getCardDown());
							l.get(available[2]).marque=false;
							System.out.println(l.get(available[2]).getNom()+" up "+l.get(available[2]).cardUp);
							System.out.println(l.get(available[2]).getNom()+" down "+l.get(available[2]).cardDown);
							return available[2]*2+1;}
					}
				}
			}
		}
		else {
			Cards a=this.cardUp;
			Cards b=this.cardDown;
			int choose=this.plusGrande(a,b);
			if (choose==1) {
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de son propre");
				this.jest.add(l.get(i).getCardUP());
				return i*2;
			}
			else {
				System.out.println(this.getNom() + " a choisi la Carte FACEDOWN de son propre");
				this.jest.add(l.get(i).getCardDown());
				return i*2+1;
			}
			
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
					if (l.get(j).marque==true && j!=ordre[i]) {
						available[flag]=j;
						flag++;
					}
				}
				if(flag==1) {
					this.jest.add(l.get(available[0]).getCardUP());
					l.get(available[0]).marque=false;
					return available[0]+1;
				}
				else{
					int k=plusGrande(l.get(available[0]).cardUp,l.get(available[1]).cardUp);
					if(k==1) {
						this.jest.add(l.get(available[0]).getCardUP());
						l.get(available[0]).marque=false;
						return available[0]+1;
					}
					else {
						boolean N=isNull(l.get(available[0]).cardUp);
						if(N==false) {
							this.jest.add(l.get(available[1]).getCardUP());
							l.get(available[1]).marque=false;
							return available[1]+1;
						}
						else {
							this.jest.add(l.get(available[1]).getCardDown());
							l.get(available[1]).marque=false;
							return available[1]+1;
						}
					}
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
					System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(available[0]).getNom());
					this.jest.add(l.get(available[0]).getCardUP());
					l.get(available[0]).marque=false;
					return available[0]+1;
				}
				else if(flag==2){
					int k=plusGrande(l.get(available[0]).cardUp,l.get(available[1]).cardUp);
					if(k==1) {
						System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(available[0]).getNom());
						this.jest.add(l.get(available[0]).getCardUP());
						l.get(available[0]).marque=false;
						System.out.println(l.get(available[0]).getNom()+" up "+l.get(available[0]).cardUp);
						System.out.println(l.get(available[0]).getNom()+" down "+l.get(available[0]).cardDown);
						return available[0]+1;
					}
					else {
						boolean N=isNull(l.get(available[1]).cardUp);
						if(N==false) {
							this.jest.add(l.get(available[1]).getCardUP());
							l.get(available[1]).marque=false;
							return available[1]+1;
						}
						else {
						System.out.println(this.getNom() + " a choisi la Carte FACEDOWN de "+ l.get(available[1]).getNom());
						this.jest.add(l.get(available[1]).getCardDown());
						l.get(available[1]).marque=false;
						return available[1]+1;
						}
					}
				}
				else {
					int k=plusGrande(l.get(available[0]).cardUp,l.get(available[1]).cardUp,l.get(available[2]).cardUp);
					if(k==1) {
						System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(available[0]).getNom());
						this.jest.add(l.get(available[0]).getCardUP());
						l.get(available[0]).marque=false;
						return available[0]+1;
					}
					else if(k==2) {
						boolean N=isNull(l.get(available[1]).cardUp);
						if(N==false) {
							this.jest.add(l.get(available[1]).getCardUP());
							l.get(available[1]).marque=false;
							return available[1]+1;
						}
						else {
							System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(available[1]).getNom());
							this.jest.add(l.get(available[1]).getCardDown());
							l.get(available[1]).marque=false;
							System.out.println(l.get(available[1]).getNom()+" up "+l.get(available[1]).cardUp);
							System.out.println(l.get(available[1]).getNom()+" down "+l.get(available[1]).cardDown);
							return available[1]+1;}
					}
					else {
						boolean N=isNull(l.get(available[2]).cardUp);
						if(N==false) {
							this.jest.add(l.get(available[2]).getCardUP());
							l.get(available[2]).marque=false;
							return available[2]+1;
						}
						else {
							System.out.println(this.getNom() + " a choisi la Carte FACEUP de "+ l.get(available[2]).getNom());
							this.jest.add(l.get(available[2]).getCardDown());
							l.get(available[2]).marque=false;
							System.out.println(l.get(available[2]).getNom()+" up "+l.get(available[2]).cardUp);
							System.out.println(l.get(available[2]).getNom()+" down "+l.get(available[2]).cardDown);
							return available[2]+1;}
					}
				}
			}
		}
		else {
			Cards a=this.cardUp;
			Cards b=this.cardDown;
			int choose=this.plusGrande(a,b);
			if (choose==1) {
				System.out.println(this.getNom() + " a choisi la Carte FACEUP de son propre");
				this.jest.add(l.get(ordre[i]).getCardUP());
			}
			else {
				System.out.println(this.getNom() + " a choisi la Carte FACEDOWN de son propre");
				this.jest.add(l.get(ordre[i]).getCardDown());
			}
			return ordre[i]+1;
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
	public boolean cardDownIsNull() {
		// TODO Auto-generated method stub
		return super.cardDownIsNull();
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