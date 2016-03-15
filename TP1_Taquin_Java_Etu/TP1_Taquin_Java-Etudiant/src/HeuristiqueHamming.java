/**
 * TP1 : taquin - Recherche opérationnelle et aide à la décision
 * Classe HeuristiqueHamming : utilisation de la distance de Hamming pour calculer
 * la distance de l'état donné au plus proche état final (parmi les 2 états finaux).
 * 
 * @version 2016-02-22
 * @author quiniou-s-1
 *
 */


public class HeuristiqueHamming implements FonctionHeuristique {

	/**
	 * Méthode qui calcule la valeur de la fonction heuristique, 
	 * pour l'état e, en utilisant la distance de Hamming, c'est-à-dire
	 * le nombre de plaquettes mal placées par rapport à l'état final le plus proche.
	 * @return le nombre de plaquettes mal placées.
	 */
	public int heuristique(Etat e) {
		int hamming1 = 0,hamming2 = 0;
		for (int x=0;x<e.NB_LIGNES;x++){
			for (int y=0;y<e.NB_LIGNES;y++){
				if (e.getNb(x,y)!=e.TAB_ETAT_FINAL_1[x][y]){
					hamming1+=1;
				}
				if (e.getNb(x,y)!=e.TAB_ETAT_FINAL_2[x][y]){
					hamming2+=1;
				}
			}
		}
		return Math.min(hamming1,hamming2);
	}

}
