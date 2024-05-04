/**
 * TP 9: codage d'un graphe - classe Graph
 */

import java.util.*;


public class Graph {
    private boolean isDirected;
    private int vertexSize;
    private List<List<Edge>> adjacency;
    

    /**
     * Constructeur sans paramètre
     */
    public Graph() {
        /* A COMPLETER */
        this.isDirected = true;
        this.adjacency = new ArrayList<List<Edge>>();
        this.adjacency.add(new ArrayList<Edge>());
        this.vertexSize++;
    }

    /**
     * Constructeur avec paramètres
     */
    public Graph(boolean isDir, int n) {
        /* A COMPLETER */
            this.isDirected = isDir;
            this.adjacency = new ArrayList<List<Edge>>();
            for(int i=0; i<n; i++){
                this.adjacency.add(new ArrayList<Edge>());
            }
            this.vertexSize = n;  
    }

    /**
     * Retourne le type du graphe (true = dirigé)
     */
    public boolean getDir() {
        return isDirected;
    }

    /**
     * Retourne true si et seulement si i est un sommet du graphe
     */
    public boolean isVertex(int i) {
        /* A COMPLETER */
        if(i<this.vertexSize&&i>=0){
            return true;
        }
        return false;
    }

    /**
     * Ajoute un sommet déconnecté à la liste des sommets et retourne son numéro
     */
    public int addVertex() {
        /* A COMPLETER */
        this.adjacency.add(new ArrayList<Edge>());
        vertexSize ++;
        return vertexSize-1;
    }

    /**
     * Retourne la liste des arcs entre src et dst (la liste doit être vide
     * s'il n'y a pas de tel arc dans le graphe)
     */
    public List<Edge> getEdges(int src, int dst) {
        /* A COMPLETER */
        List<Edge> res = new ArrayList<Edge>();
        for (Edge e : this.adjacency.get(src)){
            if(e.getDst()==dst){
                res.add(e);
            }
        }
        return res;
    }

    /**
     * Ajoute un ou deux arcs (en fonction du type de graphe) entre src et dst
     * avec l'étiquette lab
     * Retourne true si l’opération a été effectuée avec succès et false sinon
     */
    public boolean addEdge(int src, int dst, String lab) {
        /* A COMPLETER */
        if(isVertex(src)&&isVertex(dst)){
            if(this.isDirected==true){
                Edge arc = new Edge(src, dst, lab, true);
                this.adjacency.get(src).add(arc);
            }
            else{
                Edge arc1 = new Edge(src, dst, lab, false);
                Edge arc2 = new Edge(dst, src, lab, false);
                this.adjacency.get(src).add(arc1);
                this.adjacency.get(dst).add(arc2);
            }
            return true;
        }
        return false;
    }

    /**
     * Affiche la liste d'adjacence du graphe dans une chaîne de caractères
     * (dans le même format que pour la classe Edge). Si le graphe n'est pas
	 * orienté, chaque arête ne doit apparaître qu'une seule fois.
     * 
     * Exemple (non dirig): [0 -- 1 [label = a], 0 -- 2 [label = b], 1 -- 2 [label = c]
     * Exemple (dirig): [0 -> 2 [label = b], 1 -> 0 [label = a], 1 -> 2 [label = a]
     */
    @Override
    public String toString() {
        String s = "[";
        String param;
        if(this.isDirected==true){
            param = " -> ";
        }
        else{
            param = " -- ";
        }
        for(int i=0; i<this.vertexSize-1; i++){
            for (Edge e : this.adjacency.get(i)){
                s += e.getSrc()+param+e.getDst()+" [label = "+e.getLab()+"], ";
            } 
        }
        int st = this.adjacency.get(this.vertexSize-1).size();
        Edge e;
        for (int j=0; j<st-1; j++){
            e = this.adjacency.get(this.vertexSize-1).get(j);
            s += e.getSrc()+param+e.getDst()+" [label = "+e.getLab()+"], ";
        } 
        e = this.adjacency.get(this.vertexSize-1).get(st-1);
        s += e.getSrc()+param+e.getDst()+" [label = "+e.getLab()+"]]";  
        return s;
    }

    /**
     * Renvoie le chemin (s'il existe) entre n1 et n2 en effectuant un parcours
     * en largeur du graphe. La chaîne de caractère doit être de la forme 
	 * "1 -> 3 -> 5 -> 2"
     */
    public String searchPathBFS(int n1, int n2) {
        /* A COMPLETER */
        if(isVertex(n1)&&isVertex(n2)){
            Integer i;
            boolean[] mark = new boolean[vertexSize];
            Integer tab[] = new Integer[vertexSize];
            Deque<Integer>  W = new LinkedList<>();     
            W.addLast(n1);
            i = n1;
            while(!W.isEmpty()&&i!=n2){
                i = W.remove(); //FILE avec deque
                System.out.println("Visiste du noeud: "+i);
                if(!mark[i]){
                    mark[i] = true;
                    for(Edge e : this.adjacency.get(i)){
                        if(!mark[e.getDst()]){    
                            W.addLast(e.getDst());
                            if(tab[e.getDst()]==null){
                                tab[e.getDst()] = i;//on garde l'indice du premier père du noeud
                            }
                        }
                    }
                }
            }
            Integer k = n2;
            String s = "";
            while(k!=n1){
                s = " -> "+k+s;
                k = tab[k];
            }
            s = k+s;
                return s;
        }
        return "";
    }

    /**
     * Renvoie le chemin (s'il existe) entre n1 et n2 en effectuant un parcours
     * en profondeur du graphe
     */
    public String searchPathDFS(int n1, int n2) {
        /* A COMPLETER */
        if(isVertex(n1)&&isVertex(n2)){
            Integer i;
            boolean[] mark = new boolean[vertexSize];
            Deque<Integer>  W = new LinkedList<>();     
            W.addFirst(n1);
            String s = ""+n1;
            i = n1;
            while(!W.isEmpty()&&i!=n2){
                i = W.remove(); //PILE avec deque
                System.out.println("Visiste du noeud: "+i);
                if(!mark[i]){
                    if(i!=n1){
                        s += " -> "+i;
                    } 
                    mark[i] = true;
                    for(Edge e : this.adjacency.get(i)){
                        if(!mark[e.getDst()]){
                            W.addFirst(e.getDst());
                        }
                    }
                }
            }
            if(s.equals(""+n1)){
                return "";
            }
            else{
                return s;
            }
        }
        return "";
    }

    /**
     * Teste l’implémentation
     */
    public static void testImplementation() {
        int score = 0;
        int nTests = 10;

        System.out.println("Testing the implementation:");

        Graph g1 = new Graph();
        if (g1.isVertex(0)) {
            System.out.println("\t- test 1: pass");
            score++;
        } else {
            System.out.println("\t- test 1: fail");
        }

        if (g1.getDir()) {
            System.out.println("\t- test 2: pass");
            score++;
        } else {
            System.out.println("\t- test 2: fail");
        }

        g1.addVertex();
        if (g1.isVertex(1)) {
            System.out.println("\t- test 3: pass");
            score++;
        } else {
            System.out.println("\t- test 3: fail");
        }

        Graph g2 = new Graph(true, 6);
        g2.addEdge(0, 1, "a");
        g2.addEdge(0, 2, "b");
        g2.addEdge(1, 3, "c");
        g2.addEdge(1, 4, "d");

        List<Edge> edges = g2.getEdges(0, 1);
        if (edges.size() == 1) {
            System.out.println("\t- test 4: pass");
            score++;
        } else {
            System.out.println("\t- test 4: fail");
        }

        edges = g2.getEdges(4, 5);
        if (edges.size() == 0) {
            System.out.println("\t- test 5: pass");
            score++;
        } else {
            System.out.println("\t- test 5: fail");
        }

        edges = g2.getEdges(4, 15);
        if (edges.size() == 0) {
            System.out.println("\t- test 6: pass");
            score++;
        } else {
            System.out.println("\t- test 6: fail");
        }

        g2.addEdge(4, 5, "e");
        edges = g2.getEdges(4, 5);
        if (edges.size() == 1) {
            System.out.println("\t- test 7: pass");
            score++;
        } else {
            System.out.println("\t- test 7: fail");
        }

        Graph g3 = new Graph(true, 2);
        g3.addEdge(0, 1, "a");
        g3.addVertex();
        g3.addEdge(2, 0, "b");
        g3.addEdge(1, 2, "c");
        if("[0 -> 1 [label = a], 1 -> 2 [label = c], 2 -> 0 [label = b]]".equals(g3.toString())){
            System.out.println("\t- test 8: pass");
            score++;
        } else {
            System.out.println("\t- test 8: fail");
        }

        Graph g4 = new Graph(true, 7);
        g4.addEdge(0, 1, "a");
        g4.addEdge(0, 2, "b");
        g4.addEdge(0, 3, "c");
        g4.addEdge(1, 4, "c");
        g4.addEdge(2, 5, "d");
        g4.addEdge(3, 6, "d");
        g4.addEdge(4, 5, "d");
        g4.addEdge(6, 5, "d");
        if ("0 -> 2 -> 5".equals(g4.searchPathBFS(0, 5))) {
            System.out.println("\t- test 9: pass");
            score++;
        } else {
            System.out.println("\t- test 9: fail");
        }
        if ("0 -> 1 -> 4 -> 5".equals(g4.searchPathDFS(0, 5)) || "0 -> 3 -> 6 -> 5".equals(g4.searchPathDFS(0, 5))) {
            System.out.println("\t- test 10: pass");
            score++;
        } else {
            System.out.println("\t- test 10: fail");
        }

        System.out.println("Score " + score + "/" + nTests);
    }

    public static void main(String[] args) {
        testImplementation();
        Graph g3 = new Graph(true, 7);
        g3.addEdge(0, 1, "a");
        g3.addEdge(0, 2, "b");
        g3.addEdge(0, 3, "c");
        g3.addEdge(1, 4, "c");
        g3.addEdge(2, 5, "d");
        g3.addEdge(3, 6, "d");
        g3.addEdge(4, 5, "d");
        g3.addEdge(6, 5, "d");
        //System.out.println("Recherche en Largeur");
        //System.out.println(g3.searchPathBFS(0, 5));
        //System.out.println("Recherche en profondeur");
        //System.out.println(g3.searchPathDFS(0, 5));
    }
}
