/**
 * TP1 : taquin - Recherche opérationnelle et aide à la décision
 * Interface FonctionHeuristique
 * 
 * @version 2016-02-22
 * @author quiniou-s-1
 *
 */


public interface FonctionHeuristique {
	/**
	 * Méthode qui calcule la valeur de la fonction heuristique, 
	 * pour l'état e.
	 * @return la valeur de l'état e par la fonction heuristique.
	 */
	public int heuristique(Etat e);
}
