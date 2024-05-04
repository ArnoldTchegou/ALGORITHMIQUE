import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BinaryNode implements Comparable<BinaryNode>{
	private char letter;
	private int weight;
	private BinaryNode leftSon = null;
	private BinaryNode rightSon = null;
	
    /** 
     * Constructeur d'un nœud avec clé donnée
     */
    public BinaryNode(char letter, int weight) {
		this.letter = letter;
		this.weight = weight;
    }
	
    /**
     * Getters et Setters
     */
	public char getLetter(){
		return this.letter;
	}
	
	public void setLetter(char letter){
		this.letter = letter;
	}

	public int getWeight(){
		return this.weight;
	}
	
	public void setWeight(int weight){
		this.weight = weight;
	}
	
	public BinaryNode getLeftSon(){
		return this.leftSon;
	}
	
	public void setLeftSon(BinaryNode left){
		this.leftSon = left;
	}
	
	public BinaryNode getRightSon(){
		return this.rightSon;
	}
	
	public void setRightSon(BinaryNode right){
		this.rightSon = right;
	}
    /**
     * Affiche le nœud et ses fils
     * La méthode doit renvoyer "(a 4) ((b 1) (c 1))" pour le nœud
     * de l'exemple suivant :
     * 
     *             ' ' 6
     *            /     \
     *       'a' 4    ' ' 2
     *               /     \
     *           'b' 1    'c' 1
     */
	
    @Override
    public String toString() {
        if (this.isLeaf()){
			return ""+this.letter+" "+this.weight;
		}
		if (!this.isHufmal()){
			return "not an Hufman tree";
		}
        return "(" + this.leftSon + ") (" + this.rightSon + ")";
    }
	
    /**
     * Affiche un tableau d'entier (sert pour les tests)
     */
	
    public static String printTab(int[] tab) {
		String s = "{";
		for (int i = 0; i < tab.length; i++){
			if (i > 0){
				s = s+",";
			}
			s=s+tab[i];
		}
		return s+"}";
    }
	
    /**
     * Constructeur d'un nœud en fusionnant deux noeuds déjà existant
     */
    public BinaryNode(BinaryNode left, BinaryNode right) {
        /* A COMPLETER */
		this.setLeftSon(left);
		this.setRightSon(right);
		if(left!=null&right!=null){
			this.setWeight(left.getWeight()+right.getWeight());
		}
		this.setLetter(' ');
    }

    /**
     * Compare deux arbres, en comparant juste les poids deux noeuds parents.
	 * Retourne un entier négatif (si son poids est inférieur à celui de b),
	 * zéro (si ils ont le même poids) et un entier positif sinon
     */
	@Override
    public int compareTo(BinaryNode b) {
		/* A COMPLETER */
        return this.getWeight()-b.getWeight();
    }

    /**
     * Teste si noeud code une feuille de Hufman
     */
    public boolean isLeaf() {
        /* A COMPLETER */
		return (this.getLetter()>='a'&&this.getLetter()<='z')&&this.getWeight()>0;
    }

    /**
     * Teste si noeud code un arbre de Hufman
     */
    public boolean isHufmal() {
        /* A COMPLETER */
		return (this.getRightSon()==null&&this.getLeftSon()==null)||(this.getRightSon()!=null&&this.getLeftSon()!=null);
    }

    /**
     * Transforme une liste d'arbres de Hufman en un arbre de Hufman en suivant
	 * l'algorithme du code de Hufman
     */
    public static BinaryNode mergeTrees(PriorityQueue<BinaryNode> treeQueue) {
        /* A COMPLETER */
		while(treeQueue.size()>1){
			BinaryNode new_Node = new BinaryNode(treeQueue.poll(), treeQueue.poll());
			treeQueue.add(new_Node);
		}
		return treeQueue.poll();
    }

    /**
     * Compte dans une chaîne de caractère le nombre d'occurences de chaque lettre
	 * de l'alphabet et renvoie ça dans un tableau de 26 cases
     */
    public static int[] letterCount (String s) {
		int[] tab = new int[26];
        /* A COMPLETER */
		s = s.toLowerCase();
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		for(int i=0; i<s.length(); i++){
			for(int j=0; j<alpha.length(); j++){
				if(s.charAt(i)==alpha.charAt(j)){
					tab[j] += 1;
				}
			}
		}
		return tab;
    }

    /**
     * A partir d'un tableau de 26 entiers, construit l'encodage de Hufman correspondant
     */
    public static BinaryNode buildTree(int[] tab) {
		PriorityQueue<BinaryNode> treeQueue = new PriorityQueue<>();
		String alpha = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0; i<tab.length; i++){
			if(tab[i]!=0){
				treeQueue.offer(new BinaryNode(alpha.charAt(i),tab[i]));
			}
		}
		return mergeTrees(treeQueue);
    }

    /**
     * Constructeur qui produit l'arbre de Hufman à partir d'une chaîne de caractère
     */
    public BinaryNode(String input) {
		BinaryNode b = buildTree(letterCount(input));
		this.letter = b.letter;
		this.weight = b.weight;
		this.leftSon = b.leftSon;
		this.rightSon = b.rightSon;
    }

    /**
     * Renvoie le poids de l'arbre de Hufman (pour chaque feuille, on ajoute
	 * la profondeur de cette feuille fois son poids). On vous conseille d'utiliser
	 * une fonction intermédiaire.
     */	
    public int weightTree() {
        /* A COMPLETER */
		return -1;
    }
	
    public static void testImplementation() {
        int score = 0;
        int nTests = 13;

        System.out.println("Testing the implementation:");

        BinaryNode b1 = new BinaryNode('a', 4);
		if (b1.isLeaf()){
			System.out.println("\t- test 1: pass");
			score++;
		}
		else{
			System.out.println("\t- test 1: fail");
		}
		
        BinaryNode b2 = new BinaryNode('D', 12);
		if (!b2.isLeaf()){
			System.out.println("\t- test 2: pass");
			score++;
		}
		else{
			System.out.println("\t- test 2: fail");
		}
		
        BinaryNode b3 = new BinaryNode('b', 0);
		if (!b3.isLeaf()){
			System.out.println("\t- test 3: pass");
			score++;
		}
		else{
			System.out.println("\t- test 3: fail");
		}
		
		if (b1.isHufmal()){
			System.out.println("\t- test 4: pass");
			score++;
		}
		else{
			System.out.println("\t- test 4: fail");
		}
		
		BinaryNode t1 = new BinaryNode(b1, new BinaryNode(new BinaryNode('b',1), new BinaryNode('c', 1)));
		if (t1.isHufmal()){
			System.out.println("\t- test 5: pass");
			score++;
		}
		else{
			System.out.println("\t- test 5: fail");
		}
		
		BinaryNode t2 = new BinaryNode(t1, null);
		if (!t2.isHufmal()){
			System.out.println("\t- test 6: pass");
			score++;
		}
		else{
			System.out.println("\t- test 6: fail");
		}
		
		PriorityQueue<BinaryNode> p1 = new PriorityQueue<>();
		p1.offer(t1);
		try{
			if (mergeTrees(p1).toString().equals(t1.toString())){
				System.out.println("\t- test 7: pass");
				score++;
			}
			else{
				System.out.println("\t- test 7: fail");
			}
		}
		catch (Exception e){
			System.out.println("\t- test 7: fail with an exception");
		}
		
		String s;
		try{
			PriorityQueue<BinaryNode> p2 = new PriorityQueue<>();
			p2.offer(new BinaryNode('b',1));
			p2.offer(new BinaryNode('a',4));
			p2.offer(new BinaryNode('c',1));
			s = mergeTrees(p2).toString();
			if (s.equals(t1.toString()) || s.equals("(a 4) ((c 1) (b 1))") || s.equals("((c 1) (b 1)) (a 4)") || s.equals("((b 1) (c 1)) (a 4)")){
				System.out.println("\t- test 8: pass");
				score++;
			}
			else{
				System.out.println("\t- test 8: fail");
			}
		}
		catch (Exception e){
			System.out.println("\t- test 8: fail with an exception");
		}
		
		int[] tab1 = letterCount("abaaca");
		if (printTab(tab1).equals("{4,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}")){
			System.out.println("\t- test 9: pass");
			score++;
		}
		else{
			System.out.println("\t- test 9: fail");
		}
		
		int[] tab2 = letterCount("!;:azertyuIOPQS)b56dfghjklmwxcv,n ");
		if (printTab(tab2).equals("{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}")){
			System.out.println("\t- test 10: pass");
			score++;
		}
		else{
			System.out.println("\t- test 10: fail");
		}
		
		BinaryNode b4 = new BinaryNode("abaaca");
		s = b4.toString();
		if (s.equals(t1.toString()) || s.equals("(a 4) ((c 1) (b 1))") || s.equals("((c 1) (b 1)) (a 4)") || s.equals("((b 1) (c 1)) (a 4)")){
			System.out.println("\t- test 11: pass");
			score++;
		}
		else{
			System.out.println("\t- test 11: fail");
		}
		
		if (b4.weightTree() == 8){
			System.out.println("\t- test 12: pass");
			score++;
		}
		else{
			System.out.println("\t- test 12: fail");
		}

		BinaryNode b5 = new BinaryNode("Ceci est la grande phrase finale de test de cet exercice. Quel est donc son score ?");
		if (b5.weightTree() == 242){
			System.out.println("\t- test 13: pass");
			score++;
		}
		else{
			System.out.println("\t- test 13: fail");
		}
		
        // Score final
        System.out.println("Test less: score " + score + "/" + nTests);
	}
	
    public static void main(String[] args) {
		testImplementation();
    }
	
}