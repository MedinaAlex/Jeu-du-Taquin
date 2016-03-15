/**
 * TP1 : taquin - Recherche opérationnelle et aide à la décision
 * Classe ComparateurEtat
 * 
 * @version 2016-02-22
 * @author quiniou-s-1
 *
 */

import java.util.Comparator;


public class ComparateurEtat implements Comparator<Etat> {

	@Override
	public int compare(Etat e1, Etat e2) {
		int valf1=e1.getValF();
		int valf2=e2.getValF();
		int valg1=e1.getValG();
		int valg2=e2.getValG();
		return valf1 != valf2 ? (valf1>valf2 ? 1 : -1) : (valg1==valg2 ? 0 : (valg1>valg2 ? 1 : -1) ) ;
	}
	
}
