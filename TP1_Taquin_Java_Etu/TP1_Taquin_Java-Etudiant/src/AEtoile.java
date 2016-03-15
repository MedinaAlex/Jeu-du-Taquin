import java.util.Vector;

/**
 * TP1 : taquin - Recherche opérationnelle et aide à la décision
 * Classe AEtoile
 * 
 * @version 2016-02-22
 * @author quiniou-s-1
 *
 */


public class AEtoile {
	
	/**
	 * Méthode qui implémente l'algorithme A*.
	 * @param etatInit : l'état initial à partir duquel réaliser l'algorithme A*.
	 * @param heurist : la fonction heuristique utilisée dans l'algorithme A*.
	 * @return l'état final obtenu par l'algorithme A* (ou null s'il n'y a pas de résultat).
	 */
	public static Etat algoAEtoile(Etat etatInit, FonctionHeuristique heurist){
		FileTaquin ouverts=new FileTaquin();
		ouverts.add(etatInit);
		SetTaquin fermes=new SetTaquin();
		Etat etatFinal=null;
		while(!ouverts.isEmpty() && etatFinal==null){
			Etat etat=ouverts.first();
			if (etat.estFinal()){
				etatFinal=etat;		
			}else{
				fermes.add(etat);
				for(Etat succ:etat.getSuccesseurs(heurist)){
					if (fermes.get(succ)!=null){
						Etat succ_ferme=fermes.get(succ);
						if(succ.getValF()<succ_ferme.getValF()){
							fermes.remove(succ_ferme);
							ouverts.add(succ);
							System.out.println("ajout a ouverts de succ_ferme et suppression de fermes");
						}
					}else if(ouverts.get(succ)!=null){
						Etat succ_ouvert=ouverts.get(succ);
						if(succ.getValF()<succ_ouvert.getValF()){
							ouverts.remove(succ_ouvert);
							ouverts.add(succ);
							System.out.println("ajouts a ouverts de succ et suppression de succ_ouvert");
						}
					}else{
						ouverts.add(succ);
					}
				}
			}
		}
		return etatFinal;
	}
}
