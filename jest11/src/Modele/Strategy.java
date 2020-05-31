package Modele;

import java.util.ArrayList;

/**
 * Cette interface est pour realiser le patron Strategy
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 *
 */
public interface Strategy {
	
	public void chooseCardUp();
	
	public int takeCards(ArrayList<Joueur> l,int []ordre,int i,int n);

}