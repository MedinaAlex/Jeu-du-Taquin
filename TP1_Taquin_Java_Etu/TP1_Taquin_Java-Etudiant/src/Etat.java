/**

 * TP1 : taquin - Recherche opérationnelle et aide à la décision
 * Classe Etat : classe qui représente un état et qui contient son état père, les coordonnées de la case vide,
 * 				 la configuration de jeu du taquin, les valeurs des fonctions f et g ainsi que les coups joués
 * 				 depuis une configuration initiale et le nombre de coups.
 * 
 * @version 2016-02-22
 * @author quiniou-s-1
 *
 */

import java.util.Vector;


public class Etat{
	/**
	 * Le tableau représentant le premier état final.
	 */
	public static final int[][] TAB_ETAT_FINAL_1 = {
		{1,2,3},
		{8,0,4},
		{7,6,5}};
	/**
	 * Le tableau représentant le second état final.
	 */
	public static final int[][] TAB_ETAT_FINAL_2 = {
		{1,2,3},
		{4,5,6},
		{7,8,0}};
	/**
	 * Le nombre de lignes du jeu.
	 */
	public static final int NB_LIGNES = 3;
	
	
	/**
	 * L'état père de l'état courant.
	 */
	private Etat _pere; 
	
	
	/**
	 * Le tableau représentant la configuration de jeu, c'est-à-dire
	 * l'emplacement des différents nombres.
	 */
	private int[][] _taquin;
	
	/**
	 * L'abscisse de la case vide.
	 */
	private int _xVide;
	/**
	 * L'ordonnée de la case vide.
	 */
	private int _yVide;
	
	
	/**
	 * La valeur de la fonction de coût g().
	 */
	private int _valG=1;
	/**
	 * La valeur de la fonction de coût f() = g() + h().
	 */
	private int _valF;

	
	/**
	 * La suite de déplacements de la case vide, de l'état initial à l'état courant.
	 */
	private Vector<Deplacement> _coups;
	/**
	 * Le nombre de déplacements de la case vide depuis l'état initial.
	 */
	private int _nbCoups;
	
	
	
	/**
	 * Constructeur.
	 * @param tab : le tableau décrivant la configuration de jeu.
	 */
	public Etat(int[][] tab, FonctionHeuristique heurist){
		_taquin=new int[NB_LIGNES][NB_LIGNES];
		for (int x=0;x < NB_LIGNES;x++){
			for (int y=0;y < NB_LIGNES;y++){
				_taquin[x][y]=tab[x][y];
			}
		} 
		_nbCoups=0;
		_coups=new Vector<Deplacement>();
		_pere=null;
		_xVide=0;
		_yVide=0;
		_valG=1;
		_valF=1+heurist.heuristique(this);
	}
	
	
	/**
	 * Constructeur.
	 * @param tab : le tableau décrivant la configuration de jeu.
	 */
	public Etat(int[][] tab){
		_taquin=new int[NB_LIGNES][NB_LIGNES];
		for (int x=0;x < NB_LIGNES;x++){
			for (int y=0;y < NB_LIGNES;y++){
				_taquin[x][y]=tab[x][y];
				if(_taquin[x][y]==0){
					_xVide=x;
					_yVide=y;
				}
			}
		}
		_nbCoups=0;
		_coups=new Vector<Deplacement>();
		_pere=null;
		_valG=1;
		_valF=0;
	}

	
	/**
	 * Constructeur qui recopie l'état e dans l'état courant.
	 * @param e : l'état à cloner.
	 */
	public Etat(Etat e){
		_taquin=new int[NB_LIGNES][NB_LIGNES];
		_nbCoups=e.getNbCoups();
		_coups=e._coups;
		_pere=e._pere;
		_xVide=e._xVide;
		_yVide=e._yVide;
		_valG=e.getValG();
		_valF=e.getValF();
		for (int x=0;x < NB_LIGNES;x++){
			for (int y=0;y < NB_LIGNES;y++){
				_taquin[x][y]=e.getNb(x,y);
			}
		}                                                                                                                                                                                                                                                    
	}
	
	
	
	/**
	 * Méthode qui donne le père de l'état courant.
	 * @return le père de l'état courant.
	 */
	public Etat getPere(){
		return _pere;
	}
	
	
	/**
	 * Méthode qui donne le nombre de déplacements de la case vide effectués
	 * depuis l'état initial. 
	 * @return le nombre de déplacements de la case vide.
	 */
	public int getNbCoups(){
		return _nbCoups;
	}
	
	
	/**
	 * Méthode qui donne la valeur de la fonction d'évaluation g.
	 * @return la valeur de la fonction g.
	 */
	public int getValG(){
		return _valG;
	}
	
	
	/**
	 * Méthode qui donne la valeur de la fonction d'évaluation f.
	 * @return la valeur de la fonction f.
	 */
	public int getValF(){
		return _valF;
	}
	
	
	/**
	 * Méthode qui donne le nombre présent dans la case de coordonnées données.
	 * @param x : l'abscisse de la case.
	 * @param y : l'ordonnée de la case.
	 * @return la valeur de la case.
	 */
	public int getNb(int x, int y){
		return _taquin[x][y];	
	}
	
	
	/**
	 * Méthode qui donne l'abscisse du nombre n.
	 * @param n : le nombre considéré.
	 * @return l'abscisse de n.
	 */
	public int getX(int n){
		for (int x=0;x < 3;x++){
			for (int y=0;y<3;y++){
				if (_taquin[x][y]==n){
					return x;
				}
			}
		}
		return -1;
	}
	
	
	/**
	 * Méthode qui donne l'ordonnée du nombre n.
	 * @param n : le nombre considéré.
	 * @return ordonnée de n.
	 */
	public int getY(int n){
		for (int x=0;x < 3;x++){
			for (int y=0;y<3;y++){
				if (_taquin[x][y]==n){
					return y;
				}
			}
		}
		return -1;
	}
	
	
	/**
	 * Méthode qui dit si l'état courant est un état final.
	 * @return vrai si l'état courant correspond à un des 2 états finaux.
	 */
	public boolean estFinal(){
		boolean val1=true;
		boolean val2=true;
		for (int x=0;x < NB_LIGNES;x++){
			for (int y=0;y < NB_LIGNES;y++){
				if(_taquin[x][y]!=TAB_ETAT_FINAL_1[x][y]){
					val1=false;
				}
				if(_taquin[x][y]!=TAB_ETAT_FINAL_2[x][y]){
					val2=false;
				}
			}
		}
		return (val1 || val2);
	}

	
	
	/**
	 * Méthode qui indique s'il est possible de déplacer la case vide,
	 * dans la direction donnée par d.
	 * @param d : la direction pour déplacer la case vide.
	 * @return vrai si la case vide peut être déplacée dans la direction d.
	 */
	public boolean deplacementPossible(Deplacement d){
		return ((d == Deplacement.haut && _xVide>0)||
				(d == Deplacement.bas && _xVide<NB_LIGNES-1)||
				(d == Deplacement.droite && _yVide<NB_LIGNES-1)||
				(d == Deplacement.gauche && _yVide>0));
	}
	
	
	/**
	 * Méthode qui étend l'état courant, en créant un nouvel état dans lequel 
	 * la case vide est déplacée dans la direction donnée par d.
	 * @param d : la direction pour déplacer la case vide.
	 * @return l'état créé à partir de l'état courant
	 */
	public Etat etendEtat(Deplacement d, FonctionHeuristique heurist){
		Etat tmp=new Etat(this);
		if(!tmp.deplacementPossible(d)){return null;}
		switch(d){
			case bas:
				tmp._taquin[tmp._xVide][tmp._yVide]=tmp._taquin[tmp._xVide+1][tmp._yVide];
				tmp._taquin[tmp._xVide+1][tmp._yVide]=0;
				tmp._xVide+=1;
				break;
			case haut:
				tmp._taquin[tmp._xVide][tmp._yVide]=tmp._taquin[tmp._xVide-1][tmp._yVide];
				tmp._taquin[tmp._xVide-1][tmp._yVide]=0;
				tmp._xVide-=1;
				break;
			case droite:
				tmp._taquin[tmp._xVide][tmp._yVide]=tmp._taquin[tmp._xVide][tmp._yVide+1];
				tmp._taquin[tmp._xVide][tmp._yVide+1]=0;
				tmp._yVide+=1;
				break;
			case gauche:
				tmp._taquin[tmp._xVide][tmp._yVide]=tmp._taquin[tmp._xVide][tmp._yVide-1];
				tmp._taquin[tmp._xVide][tmp._yVide-1]=0;
				tmp._yVide-=1;
				break;
		}
		tmp._coups.add(d);
		tmp._nbCoups++;
		tmp._valG++;
		tmp._valF=heurist.heuristique(tmp)+tmp._valG;
		tmp._pere=this;
		return tmp;
			
		
	}
	
	
	/**
	 * Méthode qui crée les états successeurs de l'état courant,
	 * calculés selon l'emplacement de la case vide et en utilisant
	 * la fonction heuristique donnée.
	 * @return les états successeurs créés.
	 */
	public Vector<Etat> getSuccesseurs(FonctionHeuristique heurist){
		Vector<Etat> successeurs = new Vector<Etat>();
		if(etendEtat(Deplacement.bas,heurist)!=null){
			successeurs.add(etendEtat(Deplacement.bas,heurist));
		}
		if(etendEtat(Deplacement.haut,heurist)!=null){
			successeurs.add(etendEtat(Deplacement.haut,heurist));
		}
		if(etendEtat(Deplacement.gauche,heurist)!=null){
			successeurs.add(etendEtat(Deplacement.gauche,heurist));
		}
		if(etendEtat(Deplacement.droite,heurist)!=null){
			successeurs.add(etendEtat(Deplacement.droite,heurist));
		}
		return successeurs;
	}
	
	
	/**
	 * Méthode qui dit si 2 états sont égaux, du point de vue de la configuration.
	 * @param e : l'état avec lequel comparer l'état courant.
	 * @return vrai si les états correspondent à la même configuration.
	 */
	public boolean equals(Etat e){
		return _taquin==e._taquin;
	}
	
	
	
	/**
	 * Méthode qui affiche la séquence de configurations.
	 */
	public void afficherParcours(){
		System.out.println(_coups.toString()); 
	}

	
	/**
	 * Méthode qui donne la représentation de l'état, sous forme de chaîne, comprenant
	 * la configuration de jeu, les valeurs des fonctions f et g ainsi que les nombre de
	 * coups et la suite de déplacements de la case vide.
	 * @return la chaîne représentant l'état.
	 */
	public String toString(){
		String str = "";
		
		//la configuration de jeu
		str += "-------\n";
		for(int i=0; i<3; i++){
			str += "|";
			for(int j=0; j<3; j++){
				if(j > 0) str += " ";
				str += _taquin[i][j];
			}
			str += "|\n";
		}
		str += "-------\n";
		
		//les valeurs des fonctions
		str += "f = " + _valF + " (g = " + _valG + ")\n";
		
		//les déplacements de la case vide
		str += _nbCoups + " déplacements : ";
		for(int i = 0; i < _nbCoups; i++){
			if(i > 0) str += " - ";
			switch(_coups.get(i)){
			case haut:
				str += "haut";
				break;
			case bas:
				str += "bas";
				break;
			case gauche:
				str += "gauche";
				break;
			case droite:
				str += "droite";
				break;
			}
		}//for i
		
		return str;
	}

}
