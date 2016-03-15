/**
 * TP1 : taquin - Recherche opérationnelle et aide à la décision
 * Classe ApplicationTaquin
 * 
 * @version 2016-02-22
 * @author quiniou-s-1
 *
 */


public class ApplicationTaquin {
	/**
	 * Le tableau représentant le premier état initial.
	 */
	public static final int[][] TAB_ETAT_INITIAL_1 = {
			{2,8,3},
			{1,6,4},
			{7,0,5}};
	
	/**
	 * Le tableau représentant le second état initial.
	 */
	public static final int[][] TAB_ETAT_INITIAL_2 = {
			{2,0,4},
			{1,6,3},
			{7,5,8}};
	
	
	/**
	 * Méthode principale pour tester les deux heuristiques en partant des deux états initiaux.
	 */
	public static void main(String[] args){
		/* algo A* avec le 1er état initial */
		System.out.println("\n\t***** En partant du premier état initial *****\n\n");
		
		//heuristique 1
		System.out.println("Algorithme A* avec l'heuristique de Hamming");
		Taquin taquin1 = new Taquin(new Etat(TAB_ETAT_INITIAL_1), new HeuristiqueHamming());
		Etat etatFinal1 = taquin1.getEtatFinal();
		if(etatFinal1 != null){
			System.out.println("Nombre de déplacements : " + etatFinal1.getNbCoups());
			etatFinal1.afficherParcours();
		}
		else{
			System.out.println("Aucune solution");
		}
		System.out.println("\n**********\n");
		
		//heuristique 2
		System.out.println("Algorithme A* avec l'heuristique de Manhattan");
		Taquin taquin2 = new Taquin(new Etat(TAB_ETAT_INITIAL_1), new HeuristiqueManhattan());
		Etat etatFinal2 = taquin2.getEtatFinal();
		if(etatFinal2 != null){
			System.out.println("Nombre de déplacements : " + etatFinal2.getNbCoups());
			etatFinal2.afficherParcours();
		}
		else{
			System.out.println("Aucune solution");
		}		

		
		//algo A* avec le 2e état initial
		System.out.println("\n\t***** En partant du deuxieme état initial *****\n\n");
		
		//heuristique 1
		System.out.println("Algorithme A* avec l'heuristique de Hamming");
		Taquin taquin3 = new Taquin(new Etat(TAB_ETAT_INITIAL_2), new HeuristiqueHamming());
		Etat etatFinal3 = taquin3.getEtatFinal();
		if(etatFinal3 != null){
			System.out.println("Nombre de déplacements : " + etatFinal3.getNbCoups());
			etatFinal3.afficherParcours();
		}
		else{
			System.out.println("Aucune solution");
		}
		System.out.println("\n**********\n");
		
		//heuristique 2
		System.out.println("Algorithme A* avec l'heuristique de Manhattan");
		Taquin taquin4 = new Taquin(new Etat(TAB_ETAT_INITIAL_2), new HeuristiqueManhattan());
		Etat etatFinal4 = taquin4.getEtatFinal();
		if(etatFinal4 != null){
			System.out.println("Nombre de déplacements : " + etatFinal4.getNbCoups());
			etatFinal4.afficherParcours();
		}
		else{
			System.out.println("Aucune solution");
		}	
	}
}
