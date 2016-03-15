/**
 * TP1 : taquin - Recherche opérationnelle et aide à la décision
 * Classe HeuristiqueManhattan : utilisation de la distance de Manhattan pour calculer
 * la distance de l'état donné au plus proche état final (parmi les 2 états finaux).
 * 
 * @version 2016-02-22
 * @author quiniou-s-1
 *
 */


public class HeuristiqueManhattan implements FonctionHeuristique {

	/**
	 * Méthode qui calcule la valeur de la fonction heuristique, 
	 * pour l'état e, en utilisant la somme des distances de Manhattan
	 * pour chaque plaquette, c'est-à-dire la somme des distances 
	 * de chaque plaquette à sa position finale dans l'état final le plus proche.
	 * @return la somme des distances de Manhattan de l'état courant à l'état final. 
	 */
	public int heuristique(Etat e) {
		int hamming1 = 0,hamming2 = 0;
		int x1,x2,y1,y2;
		for (int x=0;x<e.NB_LIGNES;x++){
			for (int y=0;y<e.NB_LIGNES;y++){
				x1=x-e.getX(e.TAB_ETAT_FINAL_1[x][y]);
				y1=y-e.getY(e.TAB_ETAT_FINAL_1[x][y]);
				hamming1+=Math.abs(x1)+Math.abs(y1);
				
				x2=x-e.getX(e.TAB_ETAT_FINAL_2[x][y]);
				y2=y-e.getY(e.TAB_ETAT_FINAL_2[x][y]);
				hamming2+=Math.abs(x2)+Math.abs(y2);
			}
		}
		return Math.min(hamming1,hamming2);
	}

}
