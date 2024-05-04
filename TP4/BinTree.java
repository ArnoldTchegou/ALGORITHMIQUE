import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implementation des abres binaires avec valeurs entières
 */


public class BinTree {
    /* A COMPLETER: attributs privés */
    private NodeInt root;
    Deque<NodeInt>  b;     //pile deque

    /**
     *  Constructeur d'arbre vide (racine = null)
     */
    public BinTree() {
        /* A COMPLETER */
        this.root = null;
    }
    
    /** 
     * Constructeur avec un noeud
     */
    public BinTree(NodeInt r) {
        /* A COMPLETER */
        this.root = r;
        if (!this.isBST()) {
            throw new IllegalArgumentException("Input tree is not a binary search tree!");
        }
    }
	
    /**
     * Représentation en chaîne de l'arbre.
     * Retourne :
     * - "Arbre vide" si l'abre est vide.
     * - "Arbre [ contenu ]" sinon, où "contenu" est la représentation en chaîne du nœud racine.
     */
    @Override
    public String toString() {
        /* A COMPLETER */
        String s = "";
        if(this.root == null){
            return "Arbre vide";
        }
        else{
            s += this.root.toString();
        }
        return s;
    }

    /**
     * Test si l'arbre est vide 
     */
    public boolean isEmpty() {
        /* A COMPLETER */
        return this.root == null ? true: false;
    }
    
    /**
     * Calcule la hauteur de l'arbre binaire
     * -1 si arbre vide
     */
    public int height() {
	    /* A COMPLETER */
        return this.root.height();
    }

    /**
     * Test si l'are est un ABR
     */
    public boolean isBST() {
	    /* A COMPLETER */
        return this.root.isIntBST(0, 20);
    }

    boolean hasNext() {
        return !b.isEmpty();      // La pile contient les racines des 
    }	                        // sous-arbres encore à traiter
    NodeInt next() {
        if (hasNext()) {
            NodeInt c = b.pollLast();	// Le noeud à traiter se trouve à la fin de la pile (LIFO)
        if (c.getLeft() != null) b.add(c.getLeft());  // Empilement du fils gauche
        if (c.getRight() != null) b.add(c.getRight());  // Empilement du fils droit
        return c;
        } else
            throw new NoSuchElementException();
    }
    /**
     * Calcule la cle maximale si arbre est ABR
     */
    public int getMax() {
	    /* A COMPLETER */
        b = new LinkedList<>();     // Création de la pile
        if (this.root != null) {
            b.add(this.root);
        }
        if(this.root.getVal()==null){
            return Integer.MIN_VALUE;
        } 
        int MAX  = this.root.getVal();
                try{
                    NodeInt t =this.next();
                    while(t!=null){
                        MAX = t.getVal()>MAX?t.getVal():MAX;
                        t =this.next();
                    }
                }
                catch(NoSuchElementException e){

                }
        return MAX;
    }

    /**
     * Calcule le nombre de cles plus petites que x
     * -1 si arbre vide
     */
    public int less(Integer x) {
        b = new LinkedList<>();     // Création de la pile
        if (this.root != null) {
            b.add(this.root);
        }
        int count  = 0;
            try{
                NodeInt t =this.next();
                while(t!=null){
                    if(x>t.getVal()){
                        count++;
                    }
                    t =this.next();
                }
            }
            catch(NoSuchElementException e){

            }
        return count;
    }
    public boolean contains(Integer x) {
        return this.root.contains1(x);
    }
    //methode insert
    public void insert(Integer val){
        this.root.ajoutVal(val);
    }

    //méthode treesort
    static void treeSort(Integer[] elements){
        BinTree t = new BinTree(new NodeInt(elements[0]));
        for(int i= 1; i<elements.length; i++){
            t.root.ajoutVal(elements[i]);
        }
        t.root.parcoursInfixe();
    }

    public static BinTree buildTree1() {
        NodeInt one = new NodeInt(1);
        NodeInt three = new NodeInt(3);
        NodeInt two = new NodeInt(2, one, three);
        return new BinTree(two);
    }

    public static BinTree buildTree2() {
        return new BinTree(new NodeInt(1));
    }

    public static BinTree buildTree3() {
        NodeInt one = new NodeInt(1);
        NodeInt three = new NodeInt(3, one, null);
        NodeInt eight = new NodeInt(8, three, null);
        NodeInt ten = new NodeInt(10, eight, null);
        return new BinTree(ten);
    }

    /**
     * Tests unitaires de la classe
     */
    public static void testIsEmpty() {
        System.out.println("Test isEmpty:");
        int score = 0;
        int nTests = 2;

        // Test 1
        BinTree t8 = new BinTree(NodeInt.buildNodeInt8());
        if (!t8.isEmpty()) {
            System.out.println("\t- test 1: pass");
            score++;
        } else {
            System.out.println("\t- test 1: fail");
        }

        // Test 2
        BinTree empty = new BinTree();
        if (empty.isEmpty()) {
            System.out.println("\t- test 2: pass");
            score++;
        } else {
            System.out.println("\t- test 2: fail");
        }	    

	    // Score final
    	System.out.println("Test isEmpty: score " + score + "/" + nTests);
    }
    
    public static void testHeight() {
        System.out.println("Test height:");
        int score = 0;
        int nTests = 4;

	    // Test 1 
        BinTree t8 = new BinTree(NodeInt.buildNodeInt8());
    	if (t8.height() == 2) {
	        System.out.println("\t- test 1: pass");
    	    score++;
        } else {
            System.out.println("\t- test 1: fail");
        }

	    // Test 2 
        BinTree t1 = buildTree1();
    	if (t1.height() == 1) {
	        System.out.println("\t- test 2: pass");
    	    score++;
        } else {
            System.out.println("\t- test 2: fail");
        }

	    // Test 3 
        BinTree t2 = buildTree2();
    	if (t2.height() == 0) {
	        System.out.println("\t- test 3: pass");
    	    score++;
        } else {
            System.out.println("\t- test 3: fail");
        }

	    // Test 4
        BinTree t3 = buildTree3();
    	if (t3.height() == 3) {
	        System.out.println("\t- test 4: pass");
    	    score++;
        } else {
            System.out.println("\t- test 4: fail");
        }

	    // Score final
    	System.out.println("Test height: score " + score + "/" + nTests);
    }
    
    public static void testIsBST() {
        System.out.println("Test isBST:");
        int score = 0;
        int nTests = 2;

	    // Test 1
        BinTree t8 = new BinTree(NodeInt.buildNodeInt8());
        if (t8.isBST()) {
            System.out.println("\t- test 1: pass");
            score++;
        } else {
            System.out.println("\t- test 1: fail");
        }

        // Test 2
        NodeInt two = new NodeInt(2);
        NodeInt one = new NodeInt(1, two, null);
        try {
            new BinTree(one);
            System.out.println("\t- test 2: fail");
        } catch(Exception e) {
            System.out.println("\t- test 2: pass");
            score++;
        }

	    // Score final
        System.out.println("Test isBST: score " + score + "/" + nTests);
    }
    
    public static void testGetMax() {
        System.out.println("Test getMax:");
        int score = 0;
        int nTests = 4;

        // Test 1
        BinTree t8 = new BinTree(NodeInt.buildNodeInt8());
        if (t8.getMax() == 10) {
            System.out.println("\t- test 1: pass"); 
            score++;
        } else {
            System.out.println("\t- test 1: fail");
        }

	    // Test 2 
        BinTree t1 = buildTree1();
    	if (t1.getMax() == 3) {
	        System.out.println("\t- test 2: pass");
    	    score++;
        } else {
            System.out.println("\t- test 2: fail");
        }

	    // Test 3 
        BinTree t2 = buildTree2();
    	if (t2.getMax() == 1) {
	        System.out.println("\t- test 3: pass");
    	    score++;
        } else {
            System.out.println("\t- test 3: fail");
        }

	    // Test 4
        BinTree t3 = buildTree3();
    	if (t3.getMax() == 10) {
	        System.out.println("\t- test 4: pass");
    	    score++;
        } else {
            System.out.println("\t- test 4: fail");
        }

        // Score final
        System.out.println("Test getMax: score " + score + "/" + nTests);
    }

    public static void testLess() {
        System.out.println("Test less:");
        int score = 0;
        int nTests = 4;
        
        // Test 1
        BinTree t8 = new BinTree(NodeInt.buildNodeInt8());
        if (t8.less(8) == 3) {
            System.out.println("\t- test 1: pass");
            score ++;
        } else {
            System.out.println("\t- test 1: fail");
        }

	    // Test 2 
    	if (t8.less(5) == 1) {
	        System.out.println("\t- test 2: pass");
    	    score++;
        } else {
            System.out.println("\t- test 2: fail");
        }

        // Test 3
        BinTree t1 = buildTree1();
    	if (t1.less(2) == 1) {
	        System.out.println("\t- test 3: pass");
    	    score++;
        } else {
            System.out.println("\t- test 3: fail");
        }

	    // Test 4
    	if (t1.less(3) == 2) {
	        System.out.println("\t- test 4: pass");
    	    score++;
        } else {
            System.out.println("\t- test 4: fail");
        }

        // Score final
        System.out.println("Test less: score " + score + "/" + nTests);
    }

    public static void testContains() {
        System.out.println("Test contains:");
        int score = 0;
        int nTests = 4;
        
        // Test 1
        BinTree t8 = new BinTree(NodeInt.buildNodeInt8());
        if (t8.contains(8)) {
            System.out.println("\t- test 1: pass");
            score ++;
        } else {
            System.out.println("\t- test 1: fail");
        }

	    // Test 2 
    	if (t8.contains(6)) {
	        System.out.println("\t- test 2: pass");
    	    score++;
        } else {
            System.out.println("\t- test 2: fail");
        }

        // Test 3
    	if (t8.contains(9)) {
	        System.out.println("\t- test 3: pass");
    	    score++;
        } else {
            System.out.println("\t- test 3: fail");
        }

	    // Test 4
    	if (!t8.contains(77)) {
	        System.out.println("\t- test 4: pass");
    	    score++;
        } else {
            System.out.println("\t- test 4: fail");
        }

        // Score final
        System.out.println("Test less: score " + score + "/" + nTests);
    }

    public static void main(String[] args) {
        testIsEmpty();
        testIsBST();
        testHeight();
        testGetMax();
        testLess();
        testContains();

        //test de la méthode toString()
        NodeInt one = new NodeInt(1);
		NodeInt six = new NodeInt(6);
		NodeInt nine = new NodeInt(9);
		NodeInt five = new NodeInt(5, one, six);
		NodeInt ten = new NodeInt(10, nine, null);
		NodeInt eight = new NodeInt(8, five, ten);
        BinTree t1 = new BinTree(eight);
        //t1.insert(11);
        //System.out.println(t1.isBST());
        //System.out.println(t1.toString());
        //BinTree t2 = buildTree1();
        //System.out.println(t1.isBST());
        //System.out.println(t2.getMax());
        //System.out.println(t2.contains(4));

        //test de la methode treesort
        //Integer[] tab = {5, 6, 4, 1, 3, 2};
        //treeSort(tab);
    }
}

