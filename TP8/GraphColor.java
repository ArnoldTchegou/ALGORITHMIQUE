
/**
 * TP 8: codage d'un graphe non orienté- classe Graph
 */

import java.util.*;

public class GraphColor extends Graph {
    /* A COMPLETER: attributs privés */

    /**
     * Constructeur sans paramètre
     */
    public GraphColor() {
        this(1);
    }

    /**
     * Constructeur avec paramètres (à compléter)
     */
    public GraphColor(int n) {
		super(n);
    }
	
    /**
     * Ajoute un sommet déconnecté à la liste des sommets et retourne son numéro (à compléter)
     */
	@Override
    public int addVertex() {
		int n = super.addVertex();
		return n;
    }
	
    /**
     * Getter et Setter pour le tableau colors
     */
    public Integer[] getColors() {
		return null;
    }
	
    public void setColors(Integer[] tab) {
    }
	
    /**
     * Renvoie la couleur du sommet src
     */	
	public Integer getColor(int src){
		return -1;
	}
	
    /**
     * Renvoie le nombre de voisins du sommet sélectionné.
	 * Renvoie -1 si le sommet n'est pas dans le graphe.
     */
    public int degree(int v) {
		return -1;
    }
	
    /**
     * Renvoie le degré maximal du graphe
     */
    public int maxDegree() {
		return -1;
    }
	
    /**
     * Vérifie que la coloration du graphe est bonne :
	 * Il faut que chaque sommet ait une couleur non null.
	 * Il faut que deux voisins aient des couleurs différentes.
	 * Toutes les couleurs doivent être comprises entre 0 et maxDegree.
     */
    public boolean goodColors() {
		return false;
    }
	
    /**
     * Renvoie le tableau qui dit quelles couleurs sont présentes dans le voisinage de src
     */
    public boolean[] colorNeighbors(int src) {
		return new boolean[0];
    }
	
    /**
     * Donne une couleur à chacun des noeuds du graphe
     */
    public void fillColors() {
    }

    public static void testImplementation() {
        int score = 0;
        int nTests = 11;

        System.out.println("Testing the implementation:");

        GraphColor g1 = new GraphColor();
		g1.addVertex();
		try{
			if (g1.getColor(1) == null){
				System.out.println("\t- test 1: pass");
				score++;
			}
			else{
				System.out.println("\t- test 1: fail");
			}
		}
		catch (Exception e){
			System.out.println("\t- test 1: fail");
		}
		
		g1.setColors(new Integer[]{0,1});
		try{
			if (g1.getColor(1) == 1){
				System.out.println("\t- test 2: pass");
				score++;
			}
			else{
				System.out.println("\t- test 2: fail");
			}
		}
		catch (Exception e){
			System.out.println("\t- test 2: fail");
		}
		
		GraphColor g2 = new GraphColor(6);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 3);
        g2.addEdge(1, 4);
		if (g2.degree(0) == 2){
			System.out.println("\t- test 3: pass");
			score++;
		}
		else{
			System.out.println("\t- test 3: fail");
		}
		if (g2.degree(5) == 0){
			System.out.println("\t- test 4: pass");
			score++;
		}
		else{
			System.out.println("\t- test 4: fail");
		}
		if (g2.degree(6) == -1){
			System.out.println("\t- test 5: pass");
			score++;
		}
		else{
			System.out.println("\t- test 5: fail");
		}
		if (g2.maxDegree() == 3){
			System.out.println("\t- test 6: pass");
			score++;
		}
		else{
			System.out.println("\t- test 6: fail");
		}
		if (!g2.goodColors()){
			System.out.println("\t- test 7: pass");
			score++;
		}
		else{
			System.out.println("\t- test 7: fail");
		}
		g2.setColors(new Integer[]{0,1,2,3,4,5});
		if (!g2.goodColors()){
			System.out.println("\t- test 8: pass");
			score++;
		}
		else{
			System.out.println("\t- test 8: fail");
		}
		g2.setColors(new Integer[]{0,1,1,0,0,2});
		if (g2.goodColors()){
			System.out.println("\t- test 9: pass");
			score++;
		}
		else{
			System.out.println("\t- test 9: fail");
		}
		g2.addEdge(3,4);
		if (!g2.goodColors()){
			System.out.println("\t- test 10: pass");
			score++;
		}
		else{
			System.out.println("\t- test 10: fail");
		}
		boolean[] tab = g2.colorNeighbors(3);
		if ((tab.length==3) && (tab[0]==true) && (tab[1]==false) && (tab[2]==true)){
			System.out.println("\t- test 11: pass");
			score++;
		}
		else{
			System.out.println("\t- test 11: fail");
		}
		g2.fillColors();
		if (g2.goodColors()){
			System.out.println("\t- test 12: pass");
			score++;
		}
		else{
			System.out.println("\t- test 12: fail");
		}

        System.out.println("Score " + score + "/" + nTests);
	}


    public static void main(String[] args) {
		testImplementation();
    }
}
