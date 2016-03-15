/**
 * TP1 : taquin - Recherche opérationnelle et aide à la décision
 * Classe Taquin : pour représenter une partie de taquin.
 * 
 * @version 2016-02-22
 * @author quiniou-s-1
 *
 */


public class Taquin {
	/**
	 * L'état initial du taquin.
	 */
	private Etat _etatInitial;
	
	/**
	 * La fonction heuristique utilisée pour évaluer les états.
	 */
	private FonctionHeuristique _heuristique;
	
	
	/**
	 * Constructeur d'une partie de taquin.
	 * @param etatInitial : l'état initial du jeu.
	 * @param heuristique : l'heuristique utilisée pour évaluer les états du jeu.
	 */
	public Taquin(Etat etatInitial, FonctionHeuristique heuristique){
		_etatInitial=new Etat(etatInitial);
		_heuristique=heuristique;
		}
	
	
	/**
	 * Méthode qui calcule l'état final atteint à partir de l'état initial, en utilisant
	 * l'algorithme A* avec l'heuristique considérée.
	 * @return l'état final s'il est accessible ou null sinon;
	 */
	public Etat getEtatFinal(){
		return AEtoile.algoAEtoile(_etatInitial, _heuristique);
	}
}
