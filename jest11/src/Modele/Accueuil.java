package Modele;
import java.util.*;

/**
 * Cette classe est utilisee quand un jeu commence
 * Elle realise beaucoup de functions
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 * 
 *
 */
public class Accueuil implements Observer{
	private static Accueuil instance = null;
	private boolean partieEncours;
	private int nbJoueur;
	private int nbPhysique;
	private int nbVirtuel;
	private ArrayList<Joueur> joueurs; 
	private CardPile cards;
	private Cards trophie1;
	private Cards trophie2;
	public int [] ordre;
	
	/**
	 * constructeur par default
	 */
	private Accueuil () {
		this.nbJoueur=0;//   par defaut 
		this.cards=new CardPile();
		this.joueurs=new ArrayList<Joueur>();
		cards.melanger();
		this.trophie1=null;
		this.trophie2=null;
		this.partieEncours=true;
	}
	
	/**
	 * pour le pattern singelton
	 * @return instance
	 */
	public static Accueuil getInstance(){
		
		synchronized (Accueuil.class) {                
            if (instance == null) {                    
             	instance = new Accueuil();                
            } }          
	      return instance;
	   }
	
	/**
	 * melanger les cartes
	 * utiliser la methode melanger() dans la classe CardPile
	 */
	public void melanger(){
		this.cards.melanger();
	}
	
	/**
	 * decider le nombre de joueurs par le numero choisi par l'utilisateur
	 */
	public void setnbJoueur() {
		int a=0;
		int b=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("Combien de joueurs voulez-vous definir?");
		System.out.println("Entrez 3 ou 4, svp");
		if(scan.hasNext()) {
			a = scan.nextInt();
		}
		while (a<3||a>4) {
			
				System.out.println("Entrez 3 ou 4, svp");
				a = scan.nextInt();
				continue;
			
		}
		System.out.println("Combien de joueurs physique voulez-vous definir?");
		System.out.println("Entrez une nombre inferiere que la nombre de joueurs,svp");
		b=scan.nextInt();
		while (b>a||b<0) {
			
	
				System.out.println("Entrez une nombre inferiere que la nombre de joueurs,svp");
				b = scan.nextInt();
				continue;
			
		}
		System.out.println("Vous avez cree le jeu avec succes");
		this.nbJoueur=a;
		this.nbPhysique=b;
		this.nbVirtuel=a-b;
		}
	
	/**
	 * setter le nombre de joueurs
	 * @param a
	 * entrer par l'utilisateur
	 */
	public void setnbJoueur(int a) {
		this.nbJoueur=a;
	}
	
	/**
	 * decider le nombre de joueurs physiques par le numero choisi par l'utilisateur
	 * creer les joueurs physiques
	 */
	public void setJoueurPhysique() {
		if(this.nbPhysique>0) {
			Scanner scan=new Scanner(System.in);
			System.out.println("Le nom de premier joueur?");
			String a = scan.next();
			Actuel a1=new Actuel(a,new Actuel());
			this.addJoueur(a1);
			if(this.nbPhysique>1) {
				System.out.println("Le nom de deuxieme joueur?");
				a = scan.next();
				Actuel a2=new Actuel(a,new Actuel());
				this.addJoueur(a2);
			}
			if(this.nbPhysique>2) {
				System.out.println("Le nom de troisieme joueur?");
				a = scan.next();
				Actuel a3=new Actuel(a,new Actuel());
				this.addJoueur(a3);
			}
			if(this.nbPhysique>3) {
				System.out.println("Le nom de quatrieme joueur?");
				a = scan.next();
				Actuel a4=new Actuel(a,new Actuel());
				this.addJoueur(a4);
			}
		}
	}
	
	/**
	 * setter le nombre de joueurs physiques et calculer le nombre de joueurs virtuels
	 * @param a
	 * entrez par l'utilisateur
	 */
	public void setJoueurPhysique(int a) {
		this.nbPhysique=a;
		this.nbVirtuel=this.nbJoueur-this.nbPhysique;
		System.out.println("Le nombre de joueurs: "+this.nbJoueur);
		System.out.println("Le nombre de joueurs physiques: "+this.nbPhysique);
		System.out.println("Le nombre de joueurs virtuels: "+this.nbVirtuel);
	}
	
	/**
	 * decider les noms de joueur physiques par les noms entres par les utilisateur
	 * @param nom
	 * entrez par l'utilisateur
	 */
	public void setNomDeJoueur(String nom) {
		Actuel a=new Actuel(nom,new Actuel());
		this.addJoueur(a);
	}
	
	/**
	 * decider le difficulte du jeu, il est choisi par l'utilisateur
	 * creer les joueurs virtuels
	 */
	public void setJoueurVirtuel() {
			int a;
			if(nbVirtuel>0) {
			System.out.println("Quel difficulte? 1: EASY 2: MEDIUM 3: DIFFICULT\n Entrez le nombre SVP");
			Scanner scan=new Scanner(System.in);
			a=scan.nextInt();
			while ((a!=1) && (a!=2) && (a!=3)) {
				System.out.println("Il faut etre 1 ou 2 ou 3");
			continue;
			}
			if(this.nbVirtuel==1 && a==1) {
				EasyComputer jVE1=new EasyComputer("E1",new EasyComputer());
				this.addJoueur(jVE1);
			}
			else if(this.nbVirtuel==2 && a==1) {
				EasyComputer jVE1=new EasyComputer("E1",new EasyComputer());
				this.addJoueur(jVE1);
				EasyComputer jVE2=new EasyComputer("E2",new EasyComputer());
				this.addJoueur(jVE2);
			}
			else if(this.nbVirtuel==3 && a==1) {
				EasyComputer jVE1=new EasyComputer("E1",new EasyComputer());
				this.addJoueur(jVE1);
				EasyComputer jVE2=new EasyComputer("E2",new EasyComputer());
				this.addJoueur(jVE2);
				EasyComputer jVE3=new EasyComputer("E3",new EasyComputer());
				this.addJoueur(jVE3);
			}
			else if(this.nbVirtuel==4 && a==1) {
				EasyComputer jVE1=new EasyComputer("E1",new EasyComputer());
				this.addJoueur(jVE1);
				EasyComputer jVE2=new EasyComputer("E2",new EasyComputer());
				this.addJoueur(jVE2);
				EasyComputer jVE3=new EasyComputer("E3",new EasyComputer());
				this.addJoueur(jVE3);
				EasyComputer jVE4=new EasyComputer("E4",new EasyComputer());
				this.addJoueur(jVE4);
			}
			else if(this.nbVirtuel==1 && a==2) {
				MediumComputer jVM1=new MediumComputer("M1",new MediumComputer());
				this.addJoueur(jVM1);
			}
			else if(this.nbVirtuel==2 && a==2) {
				MediumComputer jVM1=new MediumComputer("M1",new MediumComputer());
				this.addJoueur(jVM1);
				MediumComputer jVM2=new MediumComputer("M2",new MediumComputer());
				this.addJoueur(jVM2);
			}
			else if(this.nbVirtuel==3 && a==2) {
				MediumComputer jVM1=new MediumComputer("M1",new MediumComputer());
				this.addJoueur(jVM1);
				MediumComputer jVM2=new MediumComputer("M2",new MediumComputer());
				this.addJoueur(jVM2);
				MediumComputer jVM3=new MediumComputer("M3",new MediumComputer());
				this.addJoueur(jVM3);
			}
			else if(this.nbVirtuel==4 && a==2) {
				MediumComputer jVM1=new MediumComputer("M1",new MediumComputer());
				this.addJoueur(jVM1);
				MediumComputer jVM2=new MediumComputer("M2",new MediumComputer());
				this.addJoueur(jVM2);
				MediumComputer jVM3=new MediumComputer("M3",new MediumComputer());
				this.addJoueur(jVM3);
				MediumComputer jVM4=new MediumComputer("M4",new MediumComputer());
				this.addJoueur(jVM4);
			}
			
			else if(this.nbVirtuel==3 && a==3) {
				DifficultComputer jVM1=new DifficultComputer("D1",new DifficultComputer() );
				this.addJoueur(jVM1);
				DifficultComputer jVM2=new DifficultComputer("D2",new DifficultComputer() );
				this.addJoueur(jVM2);
				DifficultComputer jVM3=new DifficultComputer("D3",new DifficultComputer() );
				this.addJoueur(jVM3);
			}
			else if(this.nbVirtuel==1 && a==3) {
				DifficultComputer jVD1=new DifficultComputer("D1",new DifficultComputer() );
				this.addJoueur(jVD1);
			}
			else if(this.nbVirtuel==2 && a==3) {
				DifficultComputer jVD1=new DifficultComputer("D1",new DifficultComputer() );
				this.addJoueur(jVD1);
				DifficultComputer jVD2=new DifficultComputer("D2",new DifficultComputer() );
				this.addJoueur(jVD2);
			}
			else if (this.nbVirtuel==4 && a==3) {
				DifficultComputer jVM1=new DifficultComputer("D1",new DifficultComputer() );
				this.addJoueur(jVM1);
				DifficultComputer jVM2=new DifficultComputer("D2",new DifficultComputer() );
				this.addJoueur(jVM2);
				DifficultComputer jVM3=new DifficultComputer("D3",new DifficultComputer() );
				this.addJoueur(jVM3);
				DifficultComputer jVD4=new DifficultComputer("D4",new DifficultComputer() );
				this.addJoueur(jVD4);
			}
			}
			System.out.println("Vous avez cree le jeu avec succes");
			
	}
	
	/**
	 * decider le difficulte du jeu, il est choisi par l'utilisateur
	 * creer les joueurs virtuels
	 * @param diffculte
	 * difficulte est le difficulte choisi par l'utilisateur
	 */
	public void setJoueurVirtuel(int diffculte) {
		int a = diffculte;
		if(nbVirtuel>0) {
		if(this.nbVirtuel==1 && a==1) {
			EasyComputer jVE1=new EasyComputer("E1",new EasyComputer());
			this.addJoueur(jVE1);
		}
		else if(this.nbVirtuel==2 && a==1) {
			EasyComputer jVE1=new EasyComputer("E1",new EasyComputer());
			this.addJoueur(jVE1);
			EasyComputer jVE2=new EasyComputer("E2",new EasyComputer());
			this.addJoueur(jVE2);
		}
		else if(this.nbVirtuel==3 && a==1) {
			EasyComputer jVE1=new EasyComputer("E1",new EasyComputer());
			this.addJoueur(jVE1);
			EasyComputer jVE2=new EasyComputer("E2",new EasyComputer());
			this.addJoueur(jVE2);
			EasyComputer jVE3=new EasyComputer("E3",new EasyComputer());
			this.addJoueur(jVE3);
		}
		else if(this.nbVirtuel==4 && a==1) {
			EasyComputer jVE1=new EasyComputer("E1",new EasyComputer());
			this.addJoueur(jVE1);
			EasyComputer jVE2=new EasyComputer("E2",new EasyComputer());
			this.addJoueur(jVE2);
			EasyComputer jVE3=new EasyComputer("E3",new EasyComputer());
			this.addJoueur(jVE3);
			EasyComputer jVE4=new EasyComputer("E4",new EasyComputer());
			this.addJoueur(jVE4);
		}
		else if(this.nbVirtuel==1 && a==2) {
			MediumComputer jVM1=new MediumComputer("M1",new MediumComputer());
			this.addJoueur(jVM1);
		}
		else if(this.nbVirtuel==2 && a==2) {
			MediumComputer jVM1=new MediumComputer("M1",new MediumComputer());
			this.addJoueur(jVM1);
			MediumComputer jVM2=new MediumComputer("M2",new MediumComputer());
			this.addJoueur(jVM2);
		}
		else if(this.nbVirtuel==3 && a==2) {
			MediumComputer jVM1=new MediumComputer("M1",new MediumComputer());
			this.addJoueur(jVM1);
			MediumComputer jVM2=new MediumComputer("M2",new MediumComputer());
			this.addJoueur(jVM2);
			MediumComputer jVM3=new MediumComputer("M3",new MediumComputer());
			this.addJoueur(jVM3);
		}
		else if(this.nbVirtuel==4 && a==2) {
			MediumComputer jVM1=new MediumComputer("M1",new MediumComputer());
			this.addJoueur(jVM1);
			MediumComputer jVM2=new MediumComputer("M2",new MediumComputer());
			this.addJoueur(jVM2);
			MediumComputer jVM3=new MediumComputer("M3",new MediumComputer());
			this.addJoueur(jVM3);
			MediumComputer jVM4=new MediumComputer("M4",new MediumComputer());
			this.addJoueur(jVM4);
		}
		
		else if(this.nbVirtuel==3 && a==3) {
			DifficultComputer jVM1=new DifficultComputer("D1",new DifficultComputer() );
			this.addJoueur(jVM1);
			DifficultComputer jVM2=new DifficultComputer("D2",new DifficultComputer() );
			this.addJoueur(jVM2);
			DifficultComputer jVM3=new DifficultComputer("D3",new DifficultComputer() );
			this.addJoueur(jVM3);
		}
		else if(this.nbVirtuel==1 && a==3) {
			DifficultComputer jVD1=new DifficultComputer("D1",new DifficultComputer() );
			System.out.println("1 "+jVD1.getNom());
			this.addJoueur(jVD1);
			//System.out.println(this.joueurs.get(3).getNom());
		}
		else if(this.nbVirtuel==2 && a==3) {
			DifficultComputer jVD1=new DifficultComputer("D1",new DifficultComputer() );
			this.addJoueur(jVD1);
			DifficultComputer jVD2=new DifficultComputer("D2",new DifficultComputer() );
			this.addJoueur(jVD2);
		}
		else if (this.nbVirtuel==4 && a==3) {
			DifficultComputer jVM1=new DifficultComputer("D1",new DifficultComputer() );
			this.addJoueur(jVM1);
			DifficultComputer jVM2=new DifficultComputer("D2",new DifficultComputer() );
			this.addJoueur(jVM2);
			DifficultComputer jVM3=new DifficultComputer("D3",new DifficultComputer() );
			this.addJoueur(jVM3);
			DifficultComputer jVD4=new DifficultComputer("D4",new DifficultComputer() );
			this.addJoueur(jVD4);
		}
	}
	System.out.println("Vous avez cree le jeu avec succes");
	for(int i=0;i<this.nbJoueur;i++) {
		System.out.println(this.joueurs.get(i).getNom());	
	}
}
	
	/**
	 * savoir le nombre de joueurs
	 * @return this.nbJoueur
	 */
	public int getNbJoeur() {
		return this.nbJoueur;
	}
	
	/**
	 * savoir le nombre de joueurs physiques
	 * @return this.nbPhysique
	 */
	public int getNbJoueurPhysique() {
		return this.nbPhysique;
	}
	
	/**
	 * getter la liste des joueurs
	 * @return this.joueurs
	 */
	public ArrayList<Joueur> getJoueurs(){
		return this.joueurs;
	}
	
	/**
	 * ajouter un joueur a la liste de joueurs
	 * setter le nombre de joueur par la taille de la liste
	 * @param a
	 * un joueur
	 */
	public void addJoueur(Joueur a) {
		this.joueurs.add(a);
		this.nbJoueur=joueurs.size();
	}
	
	/**
	 * decider la(s) trophie(s)
	 */
	public void getTrophies() {
		this.partieEncours=false;
		if (this.nbJoueur==3) {
			this.trophie1=cards.tirerCard();
			this.trophie2=cards.tirerCard();
			
			System.out.println("Trophie 1 est   " + this.trophie1.toString());
			System.out.println("Trophie 2 est   " + this.trophie2.toString());
		}
		else {
			this.trophie1=cards.tirerCard();
			System.out.println("Trophie est   " + this.trophie1.toString());
		}
	}
	
	/**
	 * getter la premier trophie
	 * @return this.trophie1
	 */
	public Cards getTrophie1() {
		return this.trophie1;
	}
	
	/**
	 * getter la deuxieme trophie
	 * @return this.trophie2
	 */
	public Cards getTrophie2() {
		return this.trophie2;
	}
	
	/**
	 * distribuer les cartes aux joueurs
	 */
	public void dealer() {
		System.out.println("Licence chaque joueur");
			int nbjoueurs=1;
			int nbcards=1;
			Iterator<Joueur> i = joueurs.iterator();
			Iterator<Cards> k =cards.getCardPile().iterator();
			while(k.hasNext()&& nbcards<=2*nbJoueur) {
				while(i.hasNext()&& nbjoueurs<=nbJoueur) {
					nbjoueurs++;
					nbcards+=2;
					Joueur j=(Joueur) i.next();
					Cards c1;
					Cards c2;
					c1= k.next();
					k.remove();
					c2= k.next();
					k.remove();
					System.out.println(j.getNom());
					j.getCards(c1,c2);
					}
			
		}
			for(int j=0;j<this.joueurs.size();j++) {
				this.joueurs.get(j).marque=true;
			}
	}
	
	/**
	 * les joueurs choisissent la carte visible pour les autres
	 */
	public void chooseCardUp() {
		for(int i=0;i<this.nbJoueur;i++) {
			joueurs.get(i).chooseCardUp();
		}
	}
	
	/**
	 * les joueurs virtuels choisissent la carte visible pour les autres
	 */
	public void chooseCardUpVirtuel() {
		for(int i=this.nbPhysique;i<this.nbJoueur;i++) {
			joueurs.get(i).chooseCardUp();
		}
	}
	
	/**
	 * savoir s'il n'y a plus de cartes dans la pile de cartes 
	 * @return this.cards.isEmpty()
	 */
	public boolean isEmpty() {
		return this.cards.isEmpty();
	}
	
	/**
	 * savoir le nombre de cartes dans la pile 
	 * @return this.cards.size()
	 */
	public int getNbPile() {
		return this.cards.size();
	}
	
	/**
	 * comparer les tailles des trois cartes visibles des trois joueurs
	 * utilise la methode trier
	 * @param a
	 * une carte
	 * @param b
	 * une carte
	 * @param c
	 * une carte
	 */
	public void compare(Cards a, Cards b, Cards c) {
		int x,y,z;
		x=a.getValue();
		y=b.getValue();
		z=c.getValue();
		trier(x,y,z);
		System.out.println("La premiere personne a choisir une carte est " +this.getJoueurs().get(ordre[0]).getNom());		
	}
	
	/**
	 * comparer les tailles des quatre cartes visibles des quatre joueurs
	 * utilise la methode trier
	 * @param o
	 * une carte
	 * @param p
	 * une carte
	 * @param q
	 * une carte
	 * @param r
	 * une carte
	 */
	public void compare(Cards o, Cards p, Cards q, Cards r) {
			int a,b,c,d;
			a=o.getValue();
			b=p.getValue();
			c=q.getValue();
			d=r.getValue();
			trier(a,b,c,d);
			System.out.println("La premiere personne a choisir une carte est " +this.getJoueurs().get(ordre[0]).getNom());
			
	}

	/**
	 * decider l'ordre salon les notes des deux cartes
	 * @param x
	 * la note de la carte transmit par la methode comparer
	 * @param y
	 * la note de la carte transmit par la methode comparer
	 */
	public void trier(int x, int y) {
		if (x>y) {
			ordre[0]=ordre[0];
		}
		else {
			ordre[0]=ordre[1];
		}
	}
	
	/**
	 * decider l'ordre salon les notes des trois cartes
	 * @param x 
	 * la note de la carte transmit par la methode comparer
	 * @param y 
	 * la note de la carte transmit par la methode comparer
	 * @param z
	 * la note de la carte transmit par la methode comparer
	 */
	public void trier(int x,int y,int z){
		if (x>y&y>z) {
			ordre=new int [] {0,1,2};
		}
		else if (x>z&z>y) {
			ordre=new int [] {0,2,1};
		}
		else if (y>x&x>z) {
			ordre=new int [] {1,0,2};
		}
		else if (y>z&z>x) {
			ordre=new int [] {1,2,0};
		}
		else if (z>x&x>y) {
			ordre=new int [] {2,0,1};
		}
		else {
			ordre=new int [] {2,1,0};
		}
	}
	
	/**
	 * decider l'ordre salon les notes des quatre cartes
	 * @param a
	 * la note de la carte transmit par la methode comparer
	 * @param b
	 * la note de la carte transmit par la methode comparer
	 * @param c
	 * la note de la carte transmit par la methode comparer
	 * @param d
	 * la note de la carte transmit par la methode comparer
	 */
	public void trier(int a,int b,int c,int d) {
		int[] num=new int[] {a,b,c,d};
		ordre= new int [] {0,1,2,3};
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4 - 1 - i; j++) {
				if (num[j + 1] > num[j]) {
					int temp = num[j + 1];
					int to=ordre[j+1];
					num[j + 1] = num[j];
					num[j] = temp;
					ordre[j+1]=ordre[j];
					ordre[j]=to;
		        }
		     }
		}
	}
	
	/**
	 * retour le numero du joueur qui peut choisir la carte premierement
	 * @return ordre[0]
	 * la nombre du joueur qui choisit la carte
	 */
	public int getOrdre0() {
		return ordre[0];
	}
	
	/**
	 * changer l'ordre des joueurs
	 * l'ordre de joueurs suivant est decide par chaque joueur
	 * @param a
	 * l'ordre
	 * @param b
	 * le nombre du joueur
	 */
	public void changerOrdre(int a,int b) {
		this.ordre[a]=b;
	}
	
	/**
	 * retour le numero de joueur qui peut choisir a l'ordre i
	 * @param i
	 * l'ordre i
	 * @return this.ordre[i]
	 * le nombre du joueur
	 */
	public int getOrdreIndex(int i) {
		return this.ordre[i];
	}
	
	/**
	 * le joueur chosit une carte d'un autre joueur qui n'a pas ete choisit
	 * s'il est le dernier joueur et seulement ses cartes n'ont pas ete choisits, il doit choisir sa carte
	 */
	public void takeCards() {
		int a;
		String b=new String();
		for (int i=0;i<this.nbJoueur;i++) {
			/**
			 *n pour marquer si le joueur peut choisir lui-meme
			 * si !n=0 le joueur chosit une carte d'un autre joueur qui n'a pas ete choisit
			 * si n=0 le joueur doit choisir ses cartes
			 */
			int n=0;
			System.out.println(this.joueurs.get(ordre[i]).getNom() + "  Vous pouvez choisir parmi ces joueurs");
			for(int j=0;j<this.nbJoueur;j++) {
				if (j!=ordre[i]&joueurs.get(j).marque==true) {
					System.out.println(joueurs.get(j).getNom());
					n++;
				}
			}
			
			if (n!=0) {
				System.out.println(this.joueurs.get(ordre[i]).getNom()+"  Vous pouvez chosir une carte maintenant");
				System.out.println("Attention, Vous ne pouvez pas choisir vous-meme ou choisir des joueurs qui ont deja selectionnee.");
				System.out.println("Quel joueur voulez-vous choisir? Entrez le nombre,svp");
				System.out.println("1: " + joueurs.get(0).getNom());
				System.out.println("2: " + joueurs.get(1).getNom());
				System.out.println("3: " + joueurs.get(2).getNom());
				if (this.nbJoueur==4) {
					System.out.println("4: " + joueurs.get(3).getNom());
				}
				if (joueurs.get(ordre[i]) instanceof EasyComputer) {
					EasyComputer easy=(EasyComputer) joueurs.get(ordre[i]);
					a=easy.takeCards(joueurs, ordre, i, n);
					System.out.println("easy  " +joueurs.get(ordre[i]).getNom());
					}
				else if(joueurs.get(ordre[i]) instanceof MediumComputer) {
					MediumComputer medi=(MediumComputer) joueurs.get(ordre[i]);
					a=medi.takeCards(joueurs, ordre, i, n);
					System.out.println("medi  " +joueurs.get(ordre[i]).getNom());
				}
				else if(joueurs.get(ordre[i]) instanceof DifficultComputer) {
					DifficultComputer diff=(DifficultComputer) joueurs.get(ordre[i]);
					a=diff.takeCards(joueurs, ordre, i, n);
					System.out.println("diff  " +joueurs.get(ordre[i]).getNom());
				}
			else {
				a=joueurs.get(ordre[i]).takeCards(joueurs, ordre, i, n);
				System.out.println("physique  " +joueurs.get(ordre[i]).getNom());
			}
				
			if(this.nbJoueur==3&&i==0&&a-1!=ordre[1]) {
				int c;
				c=ordre[1];
				ordre[1]=a-1;
				ordre[2]=c;
			}			
			
			if(this.nbJoueur==4&&i+1<this.nbJoueur-1&&a-1!=ordre[i+1]) {
				if(i==0) {
					int c=0;
					if(a-1==ordre[2]) {
						c=ordre[1];
						ordre[1]=a-1;
						ordre[2]=c;
					}
					else if(a-1==ordre[3]) {
						c=ordre[1];
						ordre[1]=a-1;
						ordre[3]=ordre[2];
						ordre[2]=c;}
					}
					else if(i==1&&a-1==ordre[3]){
						int c=0;
						c=ordre[3];
						ordre[3]=ordre[2];
						ordre[2]=c;
						}
				}
			}
			else {
				System.out.println("Vous ne pouvez choisir que votre carte");
				System.out.println("La carte Up ou la carte Down? S'il vous plait entrez Up ou Dwon");
				if (joueurs.get(ordre[i]) instanceof EasyComputer) {
					EasyComputer easy=(EasyComputer) joueurs.get(ordre[i]);
					a=easy.takeCards(this.joueurs, ordre, i, n);
					}
				else if(joueurs.get(ordre[i]) instanceof MediumComputer) {
					MediumComputer easy=(MediumComputer) joueurs.get(ordre[i]);
					a=easy.takeCards(this.joueurs, ordre, i, n);
					}
				else if(joueurs.get(ordre[i]) instanceof DifficultComputer) {
					DifficultComputer easy=(DifficultComputer) joueurs.get(ordre[i]);
					a=easy.takeCards(this.joueurs, ordre, i, n);
					}
				else {
					joueurs.get(ordre[i]).takeCards(joueurs, ordre, i, n);
				}
				
			}
			
	}
		
		for (int j=0;j<this.nbJoueur;j++) {
				joueurs.get(j).marque=true;
		}
	}
	
	/**
	 * le joueur virtuel chosit une carte d'un autre joueur qui n'a pas ete choisit pour l'interface graphique
	 * s'il est le dernier joueur et seulement ses cartes n'ont pas ete choisits, il doit choisir sa carte
	 * @param a
	 * le nombre du joueur
	 * @return this.getJoueurs().get(b).takeCardsV(joueurs, ordre, b, n)
	 * retourner le numero du joueur suivant qui est choisit par le joueur maintenant
	 */
	public int takeCardsV(int a) {
		int b=a;
		int n=0;	
		for(int j=0;j<this.nbJoueur;j++) {
			if (j!=b&joueurs.get(j).marque==true) {
				n++;
			}
		}
		return this.getJoueurs().get(b).takeCardsV(joueurs, ordre, b, n);
	}
	  
	/**
	 * apres tous les joueurs ont choisit les carte, le reste des cartes sera mis dans la pile de cartes
	 * utiliser la methode melanger() de la classe CardPile pour melanger la pile
	 */
	public void takeCardsBack() {
		if(joueurs.get(0).cardUp==null&&joueurs.get(0).cardDownIsNull()) {
			System.out.println("C'est le premier tour");
		}
		for (int j=0;j<this.nbJoueur;j++) {
			if(joueurs.get(j).cardUp ==null&&!joueurs.get(j).cardDownIsNull()) {
				System.out.println(joueurs.get(j).getNom()+" Up  "+joueurs.get(j).cardUp);
				System.out.println(joueurs.get(j).getNom()+" Down "+joueurs.get(j).cardDown);
				if (joueurs.get(j) instanceof EasyComputer) {
					EasyComputer e=(EasyComputer) joueurs.get(j);
					cards.putCardsBack(e.getCardDown());
					System.out.println("La carte face cachee de "+ e.getNom()+" a ete recyclee");
				}
				else if (joueurs.get(j) instanceof MediumComputer) {
					MediumComputer e=(MediumComputer) joueurs.get(j);
					cards.putCardsBack(e.getCardDown());
					System.out.println("La carte face cachee de "+ e.getNom()+" a ete recyclee");
				}
				else if (joueurs.get(j) instanceof DifficultComputer) {
					DifficultComputer e=(DifficultComputer) joueurs.get(j);
					cards.putCardsBack(e.getCardDown());
					System.out.println("La carte face cachee de "+ e.getNom()+" a ete recyclee");
				}
				else {
					cards.putCardsBack(joueurs.get(j).getCardDown());
					System.out.println("La carte face cachee de "+ joueurs.get(j).getNom()+" a ete recyclee");
				}
				
			}
			else if(joueurs.get(j).cardDownIsNull()&&joueurs.get(j).cardUp!=null)
			{
				System.out.println(joueurs.get(j).getNom()+" Up  "+joueurs.get(j).cardUp);
				System.out.println(joueurs.get(j).getNom()+" Down "+joueurs.get(j).cardDown);
				if (joueurs.get(j) instanceof EasyComputer) {
					EasyComputer e=(EasyComputer) joueurs.get(j);
					cards.putCardsBack(e.getCardUP());
					System.out.println("La carte tourne ver le haut de "+ e.getNom()+" a ete recyclee");
				}
				else if (joueurs.get(j) instanceof MediumComputer) {
					MediumComputer e=(MediumComputer) joueurs.get(j);
					cards.putCardsBack(e.getCardUP());
					System.out.println("La carte tourne ver le haut de "+ e.getNom()+" a ete recyclee");
				}
				else if (joueurs.get(j) instanceof DifficultComputer) {
					DifficultComputer e=(DifficultComputer) joueurs.get(j);
					cards.putCardsBack(e.getCardUP());
					System.out.println("La carte tourne ver le haut de "+ e.getNom()+" a ete recyclee");
				}
				
				else{
					cards.putCardsBack(joueurs.get(j).getCardUP());
				System.out.println("La carte tourne ver le haut de "+ joueurs.get(j).getNom()+" a ete recyclee");
			}
				}
		}
		cards.melanger();
	}
	
	/**
	 * @return this.cards.size()
	 * retour le nombre de cartes dans la pile
	 */
	public int size() {
		return this.cards.size();
	}
		
	/**
	 * recycle les cartes
	 */
	public void takeLastCard() {
		for(int i=0;i<this.nbJoueur;i++) {
			if(this.joueurs.get(i).cardUp==null) {
				this.joueurs.get(i).takeCard(this.joueurs.get(i).getCardDown());
			}
			else {
				this.joueurs.get(i).takeCard(this.joueurs.get(i).getCardUP());
			}
		}
	}
	
	/**
	 * distuibuer les Tropphies, s'il y a Joker, on distribuer Joker d'abord
	 * utiliser la methode distrubuer(Cards c)
	 */
	public void distrubuerTrophies() {
		//
		System.out.println("Ordre 0 :"+ordre[0]);
		if (this.trophie2==null) {
			distrubuer(this.trophie1);
			joueurs.get(ordre[0]).takeCard(trophie1);
			this.trophie1=null;
		}
		else {
			if(this.trophie2.getValeur()==Valeur.JOKER){
				distrubuer(this.trophie2);
				System.out.println("Ordre 0 :"+ordre[0]);
				joueurs.get(ordre[0]).takeCard(trophie2);
				this.trophie2=null;
				distrubuer(this.trophie1);
				//
				System.out.println("Ordre 0 :"+ordre[0]);
				joueurs.get(ordre[0]).takeCard(trophie1);
				this.trophie1=null;
				}
			else {
				distrubuer(this.trophie1);
				//
				System.out.println("Ordre 0 :"+ordre[0]);
				joueurs.get(ordre[0]).takeCard(trophie1);
				this.trophie1=null;
				//
				System.out.println("Ordre 0 :"+ordre[0]);
				distrubuer(this.trophie2);
				joueurs.get(ordre[0]).takeCard(trophie2);
				this.trophie2=null;
			}
		}
	}
	
	/**
	 * distribuer la(les) trophie(s)
	 * a la fin, la(les) trophie(s) est distribuer au besoin 
	 * @param c
	 * une de trophies
	 */
	public void distrubuer(Cards c) {
		//4
		if(c.getSuit()==Suit.CARREAU&&c.getValeur()==Valeur.AS) {
			if(this.nbJoueur==3) {
				trier(joueurs.get(0).nbQuatre(),joueurs.get(1).nbQuatre(),joueurs.get(2).nbQuatre());
				}
			else {
				trier(joueurs.get(0).nbQuatre(),joueurs.get(1).nbQuatre(),joueurs.get(2).nbQuatre(),joueurs.get(3).nbQuatre());
				}
			
			if(ordre[0]==ordre[1]&&this.nbJoueur==3) {
				trier(joueurs.get(0).maxQuatre(),joueurs.get(1).nbQuatre(),joueurs.get(2).nbQuatre());
			}
			else if(ordre[0]==ordre[1]&&this.nbJoueur==4) {
				trier(joueurs.get(0).maxQuatre(),joueurs.get(1).nbQuatre(),joueurs.get(2).nbQuatre(),joueurs.get(3).nbQuatre());
			}
			
		}
		//3
		if(c.getSuit()==Suit.PIQUE&&c.getValeur()==Valeur.DEUX) {
			if(this.nbJoueur==3) {
				trier(joueurs.get(0).nbTrois(),joueurs.get(1).nbTrois(),joueurs.get(2).nbTrois());
				}
			else {
				trier(joueurs.get(0).nbTrois(),joueurs.get(1).nbTrois(),joueurs.get(2).nbTrois(),joueurs.get(3).nbTrois());
				}
			if(ordre[0]==ordre[1]&&this.nbJoueur==3) {
				trier(joueurs.get(0).maxTrois(),joueurs.get(1).maxTrois(),joueurs.get(2).maxTrois());
			}
			else if(ordre[0]==ordre[1]&&this.nbJoueur==4) {
				trier(joueurs.get(0).maxTrois(),joueurs.get(1).maxTrois(),joueurs.get(2).maxTrois(),joueurs.get(3).maxTrois());
			}
			}
		//2
		if(c.getSuit()==Suit.PIQUE&&c.getValeur()==Valeur.TROIS) {
			if(this.nbJoueur==3) {
				trier(joueurs.get(0).nbDeux(),joueurs.get(1).nbDeux(),joueurs.get(2).nbDeux());
				}
			else {
				trier(joueurs.get(0).nbDeux(),joueurs.get(1).nbDeux(),joueurs.get(2).nbDeux(),joueurs.get(3).nbDeux());
				}
			if(ordre[0]==ordre[1]||this.nbJoueur==3) {
				trier(joueurs.get(0).maxDeux(),joueurs.get(1).maxDeux(),joueurs.get(2).maxDeux());
			}
			else if(ordre[0]==ordre[1]||this.nbJoueur==4) {
				trier(joueurs.get(0).maxDeux(),joueurs.get(1).maxDeux(),joueurs.get(2).maxDeux(),joueurs.get(3).maxDeux());
			}
			}
		
		if(c.getSuit()==Suit.JOKER) {
			if(this.nbJoueur==3) {
				trier(joueurs.get(0).value(),joueurs.get(1).value(),joueurs.get(2).value());
				}
			else {
				trier(joueurs.get(0).value(),joueurs.get(1).value(),joueurs.get(2).value(),joueurs.get(3).value());
				}
			if (this.nbJoueur==4)
			{	
				if(joueurs.get(ordre[0]).value()==joueurs.get(ordre[1]).value()&&joueurs.get(ordre[2]).value()==joueurs.get(ordre[1]).value()&&joueurs.get(ordre[3]).value()==joueurs.get(ordre[0]).value()) {
					trier(joueurs.get(ordre[0]).maxCard(),joueurs.get(ordre[1]).maxCard(),joueurs.get(ordre[2]).maxCard(),joueurs.get(ordre[3]).maxCard());
			}
				else if(joueurs.get(ordre[0]).value()==joueurs.get(ordre[1]).value()&&joueurs.get(ordre[2]).value()==joueurs.get(ordre[1]).value()) {
					trier(joueurs.get(ordre[0]).maxCard(),joueurs.get(ordre[1]).maxCard(),joueurs.get(ordre[2]).maxCard());
				}
				else if(joueurs.get(ordre[0]).value()==joueurs.get(ordre[1]).value()) {
					trier(joueurs.get(ordre[0]).maxCard(),joueurs.get(ordre[1]).maxCard());
				}
			
			}
			else {
				if(joueurs.get(ordre[0]).value()==joueurs.get(ordre[1]).value()&&joueurs.get(ordre[2]).value()==joueurs.get(ordre[1]).value()) {
					trier(joueurs.get(ordre[0]).maxCard(),joueurs.get(ordre[1]).maxCard(),joueurs.get(ordre[2]).maxCard());
				}
				else if(joueurs.get(ordre[0]).value()==joueurs.get(ordre[1]).value()) {
					trier(joueurs.get(ordre[0]).maxCard(),joueurs.get(ordre[1]).maxCard());
			}
			
			}
		}

		if(c.getSuit()==Suit.PIQUE&&c.getValeur()==Valeur.QUATRE) {
			
			if(this.nbJoueur==3) {
				trier(joueurs.get(0).minTrefle(),joueurs.get(1).minTrefle(),joueurs.get(2).minTrefle());
				}
			else {
				trier(joueurs.get(0).minTrefle(),joueurs.get(1).minTrefle(),joueurs.get(2).minTrefle(),joueurs.get(3).minTrefle());
				}
		}
		
		else if(c.getSuit()==Suit.TREFLE&&c.getValeur()==Valeur.QUATRE) {
			
			if(this.nbJoueur==3) {
				trier(joueurs.get(0).minPique(),joueurs.get(1).minPique(),joueurs.get(2).minPique());
				}
			else {
				trier(joueurs.get(0).minPique(),joueurs.get(1).minPique(),joueurs.get(2).minPique(),joueurs.get(3).minPique());
				}
			
		}
		
		else if(c.getSuit()==Suit.PIQUE&&c.getValeur()==Valeur.AS) {
			
			if(this.nbJoueur==3) {
				trier(joueurs.get(0).maxTrefle(),joueurs.get(1).maxTrefle(),joueurs.get(2).maxTrefle());
				}
			else {
				trier(joueurs.get(0).maxTrefle(),joueurs.get(1).maxTrefle(),joueurs.get(2).maxTrefle(),joueurs.get(3).maxTrefle());
				}
			
		}
		
		else if(c.getSuit()==Suit.TREFLE&&c.getValeur()==Valeur.AS) {
			
			if(this.nbJoueur==3) {
				trier(joueurs.get(0).maxPique(),joueurs.get(1).maxPique(),joueurs.get(2).maxPique());
				}
			else {
				trier(joueurs.get(0).maxPique(),joueurs.get(1).maxPique(),joueurs.get(2).maxPique(),joueurs.get(3).maxPique());
				}
			
		}
		
		//Max coeur
		else if(c.getSuit()==Suit.TREFLE&&c.getValeur()==Valeur.DEUX) {
			
			if(this.nbJoueur==3) {
				trier(joueurs.get(0).minCoeur(),joueurs.get(1).minCoeur(),joueurs.get(2).minCoeur());
				}
			else {
				trier(joueurs.get(0).minCoeur(),joueurs.get(1).minCoeur(),joueurs.get(2).minCoeur(),joueurs.get(3).minCoeur());
				}
		}
		
		//Max carreau
		else if(c.getSuit()==Suit.CARREAU&&c.getValeur()==Valeur.DEUX) {
			
			if(this.nbJoueur==3) {
				trier(joueurs.get(0).maxCarreau(),joueurs.get(1).maxCarreau(),joueurs.get(2).maxCarreau());
				}
			else {
				trier(joueurs.get(0).maxCarreau(),joueurs.get(1).maxCarreau(),joueurs.get(2).maxCarreau(),joueurs.get(3).maxCarreau());
				}
		
		}
		
		//Max Coeur
		else if(c.getSuit()==Suit.TREFLE&&c.getValeur()==Valeur.TROIS) {
			
			if(this.nbJoueur==3) {
				trier(joueurs.get(0).maxCoeur(),joueurs.get(1).maxCoeur(),joueurs.get(2).maxCoeur());
				}
			else {
				trier(joueurs.get(0).maxCoeur(),joueurs.get(1).maxCoeur(),joueurs.get(2).maxCoeur(),joueurs.get(3).maxCoeur());
				}
			
		}
		
		else if(c.getSuit()==Suit.CARREAU&&c.getValeur()==Valeur.TROIS) {
			
			if(this.nbJoueur==3) {
				trier(joueurs.get(0).minCarreau(),joueurs.get(1).minCarreau(),joueurs.get(2).minCarreau());
				}
			else {
				trier(joueurs.get(0).minCarreau(),joueurs.get(1).minCarreau(),joueurs.get(2).minCarreau(),joueurs.get(3).minCarreau());
				}
		}
		
		//joker
		else if(c.getSuit()==Suit.COEUR&&c.getValeur()==Valeur.AS||c.getSuit()==Suit.COEUR&&c.getValeur()==Valeur.DEUX||c.getSuit()==Suit.COEUR&&c.getValeur()==Valeur.TROIS||c.getSuit()==Suit.COEUR&&c.getValeur()==Valeur.QUATRE) {
			for(int i=0;i<this.nbJoueur;i++) {
				if(joueurs.get(i).avoirJoker()) {
					ordre[0]=i;
					
					break;
				}
			}
		}
			
		else if(c.getSuit()==Suit.CARREAU&&c.getValeur()==Valeur.QUATRE) {//CARREAU QUATRE
			if(this.nbJoueur==3) {
				trier(joueurs.get(0).value(),joueurs.get(1).value(),joueurs.get(2).value());
				}
			else {
				trier(joueurs.get(0).value(),joueurs.get(1).value(),joueurs.get(2).value(),joueurs.get(3).value());
				}
		
			if (this.nbJoueur==4)
			{	
				if(joueurs.get(ordre[0]).value()==joueurs.get(ordre[1]).value()&&joueurs.get(ordre[2]).value()==joueurs.get(ordre[1]).value()&&joueurs.get(ordre[3]).value()==joueurs.get(ordre[0]).value()) {
					trier(joueurs.get(ordre[0]).maxCard(),joueurs.get(ordre[1]).maxCard(),joueurs.get(ordre[2]).maxCard(),joueurs.get(ordre[3]).maxCard());
			}
				else if(joueurs.get(ordre[0]).value()==joueurs.get(ordre[1]).value()&&joueurs.get(ordre[2]).value()==joueurs.get(ordre[1]).value()) {
					trier(joueurs.get(ordre[0]).maxCard(),joueurs.get(ordre[1]).maxCard(),joueurs.get(ordre[2]).maxCard());
				}
				else if(joueurs.get(ordre[0]).value()==joueurs.get(ordre[1]).value()) {
					trier(joueurs.get(ordre[0]).maxCard(),joueurs.get(ordre[1]).maxCard());
				}
			}
		}
		else {
			if(joueurs.get(ordre[0]).value()==joueurs.get(ordre[1]).value()&&joueurs.get(ordre[2]).value()==joueurs.get(ordre[1]).value()) {
				trier(joueurs.get(ordre[0]).maxCard(),joueurs.get(ordre[1]).maxCard(),joueurs.get(ordre[2]).maxCard());
			}
			else if(joueurs.get(ordre[0]).value()==joueurs.get(ordre[1]).value()) {
				trier(joueurs.get(ordre[0]).maxCard(),joueurs.get(ordre[1]).maxCard());
			}
			if(ordre[0]<joueurs.size()&&joueurs.get(ordre[0]).avoirJoker()) {
				ordre[0]=ordre[1];
			}
		}
		System.out.println("Le joueur " + joueurs.get(ordre[0]).getNom()+" gagne la trophie " +c.toString());
	}
	
	/**
	 * 
	 * @return this.partieEncours
	 * si le jeu est en cours
	 */
	public boolean partiEncours() {
		return this.partieEncours;
	}
	
	/**
	 * 
	 * @return
	 * null
	 */
	public Accueuil restart() {
		String s= new String();
		System.out.println("Voulez-vous jouer un autre tour? ");
		Scanner scan=new Scanner(System.in);
		if (scan.hasNext()) {
			s=scan.next();
		}
			while (!s.equals("Oui")&&!s.equals("Non")) {
				
				System.out.println("Entrez Oui ou Non,svp");
				if(scan.hasNext()) {
					s = scan.next();
				}
				continue;
			}
		if(s.equals("Oui")) {
			this.partieEncours=true;
			Accueuil a= new Accueuil();
			a.nbJoueur=this.nbJoueur;
			a.joueurs=this.joueurs;
			a.nbPhysique=this.nbPhysique;
			a.nbVirtuel=this.nbVirtuel;
			for(int i=0;i<a.getNbJoeur();i++) {
				a.getJoueurs().get(i).jest.clear();
			}
			return a;
		}
		scan.close();
		return null;
	}
	
	/**
	 * mise a jour
	 * afficher la carte que le joueur a choisit
	 */
	public void update(Object o1,Object o2) {
		
		if((int)o2%2==0) {
			System.out.println(this.joueurs.get((int)o1).getNom()+ " a choisi la carte up de " +this.joueurs.get((int)o2/2).getNom());
		}
		else {
			System.out.println(this.joueurs.get((int)o1).getNom()+ " a choisi la carte down de " +this.joueurs.get((int)o2/2).getNom());	
		}
	}

}
