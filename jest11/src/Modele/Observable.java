package Modele;

/**
 * Cette l'interface est pour realiser le patron Observor
 * 
 * @author Keze WEI
 * @author Xinyue ZHANG
 *
 */
public interface Observable {
	public void addObserver(Observer o);
	public void notifyObserver(Object o1,Object o2);
}
