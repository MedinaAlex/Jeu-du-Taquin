/**
 * TP1 : taquin - Recherche opérationnelle et aide à la décision
 * Classe SetTaquin : les états dans l'ensemble doivent être tous différents.
 * 
 * @version 2016-02-22
 * @author quiniou-s-1
 *
 */

import java.util.Iterator;
import java.util.HashSet;


/**
 * @author quiniou-s-1
 *
 */
public class SetTaquin {
	/**
	 * L'ensemble des états tous différents, sans ordre particulier.
	 */
	private HashSet<Etat> _ensembleEtats;
	
	
	/**
	 * Constructeur d'un ensemble vide.
	 */
	public SetTaquin(){
		_ensembleEtats=new HashSet<Etat>();
	}

	
	/**
	 * Méthode qui donne l'élément de l'ensemble correspondant 
	 * à l'élément donné en paramètre.
	 * @param elem : l'élément recherché.
	 * @return l'élément recherché, s'il existe (null sinon).
	 */
	public Etat get(Etat elem){
		if(_ensembleEtats.contains(elem)){
			return elem;
		}else{
			return null;
		}
	}


	/**
	 * Méthode qui ajoute un état à l'ensemble.
	 * @param etat : l'état à ajouter.
	 */
	public void add(Etat etat) {
		_ensembleEtats.add(etat);
	}


	/**
	 * Méthode qui supprime un état de l'ensemble.
	 * @param etat : l'état à supprimer.
	 */
	public void remove(Etat etat) {
		_ensembleEtats.remove(etat);
	}
	
	
	/**
	 * Méthode qui donne la représentation de la file.
	 * @return la représentation de la file sous forme de chaîne.
	 */
	public String toString(){
		String str = "";
		
		Iterator<Etat> iter = _ensembleEtats.iterator();
		while(iter.hasNext()){
			str += iter.next().toString() + "\n";
		}
		
		return str;
	}
}
