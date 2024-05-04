/**
 * TP3 : Arbres
 */


class Arbre {
    private int val; // Valeur du nœud
    private Arbre left; // Enfant gauche
    private Arbre right; // Enfant droit
    private boolean empty; // Booléen pour savoir si l'arbre est vide
    
     
	private class ManipulationArbreVide extends Exception {

		public ManipulationArbreVide() {
			super();
		}
  
		public ManipulationArbreVide(String s) {
			super(s);
		}
	}

    /**
     * Constructeur vide
     * Crée un Arbre vide. Il n'a aucun enfant, et sa valeur ne doit pas être utilisée
     */
    public Arbre() {
		this.empty = true;
        this.left = null;
        this.right = null;
    }

    /**
     * Constructeur 1
     * Initialise la valeur à val et les enfants gauche et droit à l'arbre vide
     */
    public Arbre(int val) {
        this.val = val;
        this.empty = false;
        this.left = new Arbre();
        this.right = new Arbre();
    }

    /**
     * Constructeur 2
     * Initialise la valeur et les enfants de l'arbre
     */
    public Arbre(int val, Arbre left, Arbre right) {
        this(val);
        this.left = left;
        this.right = right;
    }

    /**
     * Assigne la valeur du nœud
     */
    public void setVal(int val) throws ManipulationArbreVide {
		if (this.empty){
			throw new ManipulationArbreVide("Val non défini");
		}
        this.val = val;
    }

    /**
     * Assigne le enfant gauche
     */
    public void setLeft(Arbre noeud) throws ManipulationArbreVide {
		if (this.empty){
			throw new ManipulationArbreVide("Left non défini");
		}
        this.left = noeud;
    }

    /**
     * Assigne le enfant droit
     */
    public void setRight(Arbre noeud) throws ManipulationArbreVide {
		if ((this.empty)||(this==null)){
			throw new ManipulationArbreVide("Right non défini");
		}
        this.right = noeud;
    }

    /**
     * Renvoie la valeur du nœud
     */
    public int getVal() throws ManipulationArbreVide {
		if (this.empty){
			throw new ManipulationArbreVide("Val non défini");
		}
        return this.val;
    }

    /**
     * Renvoie le enfant gauche
     */
    public Arbre getLeft() throws ManipulationArbreVide {
		if (this.empty){
			throw new ManipulationArbreVide("Left non défini");
		}
        return this.left;
    }

    /**
     * Renvoie le enfant droit
     */
    public Arbre getRight() throws ManipulationArbreVide {
		if (this.empty){
			throw new ManipulationArbreVide("Right non défini");
		}
        return this.right;
    }
	
    /**
     * Vérifie si l'arbre est une feuille
     * i.e. il n'a pas d'enfants.
     */
	public boolean isLeaf() throws ManipulationArbreVide {
        if((this.getRight().empty)&&(this.getLeft().empty)){
            return true;
        }
        return false;
	}
	
    /**
     * Compare deux Arbres.
     */
	public boolean equals(Arbre n) throws ManipulationArbreVide {
        if((this.empty)&&(n.empty)){
            return true;
        }
        else if((this.isLeaf())&&(n.isLeaf())) {
            return this.val == n.val?true:false;
        }
        else{
            if(this.val != n.val){
                return false;
            }
            else{
                return (this.getRight().equals(n.getRight()))&&(this.getLeft().equals(n.getLeft()));
            }
        }
	}

    /**
     * Parcours prefixe: méthode récursive
     */
    public void parcoursPrefixe() throws ManipulationArbreVide {
        if(this.empty){
        }
        else if(this.isLeaf()){
            System.out.println(this.val);
        }
        else{
            System.out.println(this.val);
            this.getLeft().parcoursPrefixe();
            this.getRight().parcoursPrefixe();
        }
    }

    /**
     * Parcours postfixe: méthode récursive
     */
    public void parcoursPostfixe() throws ManipulationArbreVide {
        if(this.empty){
        }
        else if(this.isLeaf()){
            System.out.println(this.val);
        }
        else{
            this.getLeft().parcoursPostfixe();
            this.getRight().parcoursPostfixe();
            System.out.println(this.val);
        } 
    }

    /**
     * Parcours infixe: méthode récursive
     */
    public void parcoursInfixe() throws ManipulationArbreVide {
        if(this.empty){
        }
        else if(this.isLeaf()){
            System.out.println(this.val);
        }
        else{
            this.getLeft().parcoursInfixe();
            System.out.println(this.val);
            this.getRight().parcoursInfixe();
        } 
    }

    /**
     * Renvoie le nombre de nœuds dans l’arbre
     */
    public int nombreNoeuds() throws ManipulationArbreVide {
        if(this.empty){
            return 0;
        }
        else if(this.isLeaf()){
            return 1;
        }
        else{
            return 1 + this.getLeft().nombreNoeuds() + this.getRight().nombreNoeuds();
        }
    }

    /**
     * Renvoie la hauteur de l’arbre
     */
    public int hauteur() throws ManipulationArbreVide {
        int r, l;
        if(this.empty){
            return 0;
        }
        if((this.isLeaf())){
            return 0;
        }
        else{
            r = 1 + this.getRight().hauteur();
            l = 1 + this.getLeft().hauteur();
            return r>l?r:l;
        }
    }

    /**
     * Renvoie la représentation en chaine de caractères de l’arbre
     * La méthode doit renvoyer "4 2 3 8 7" pour l'arbre suivant:
     *         8
     *       /   \
     *      2     7
     *     / \
     *    4   3
     */
    public String toString2() throws ManipulationArbreVide {
        String s = "";
        if(this.empty){
            s += "";
        }
        else if(this.isLeaf()){
            s += this.val;
            return s;
        }
        else{
            if(this.getLeft().empty){
                s += "";
            }
            else{
                s += this.getLeft().toString2()+" ";
            }
            s += this.val;
            if(this.getRight().empty){
                s += "";
            }
            else{
                s += " "+this.getRight().toString2();
            }
            
        } 

        return s;
    }

    /**
     * Renvoie la somme des valeurs contenues dans les nœuds de l’arbre
     */
    public int somme() throws ManipulationArbreVide {
        int count = 0;
        if(this.empty){
            return 0;
        }
        else if(this.isLeaf()){
            return this.val;
        }
        else{
            count += this.getLeft().somme() + this.val + this.getRight().somme();
        } 
        return count;
    }

    /**
     * Renvoie la somme des valeurs contenus dans les feuilles de l’arbre
     */
    public int sommeFeuilles() throws ManipulationArbreVide {
        int count = 0;
        if(this.empty){
            return 0;
        }
        else if(this.isLeaf()){
            return this.val;
        }
        else{
            count += this.getLeft().sommeFeuilles() + this.getRight().sommeFeuilles();
        } 
        return count;
    }
	
    /**
     * Ajout: méthode récursive
     */
    public void ajoutVal(int val) throws ManipulationArbreVide {
        if (this.empty){
            this.val = val;
            this.empty = false;
            this.left = new Arbre();
            this.right = new Arbre();
        }
        else if (val <= this.val){
            this.getLeft().ajoutVal(val);
        }
        else if (val >= this.val){
            this.getRight().ajoutVal(val);
        }
    }

    /**
     * Constructeur à partir d'un tableau
     */
    public Arbre(int[] tab) throws ManipulationArbreVide {
        this();
        for(int i = 0; i<tab.length; i++){
            this.ajoutVal(tab[i]);
        }
    }
	
    /**
     * isDeRecherche - Question facultative
     */
    public boolean isDeRecherche() throws ManipulationArbreVide {
        if(this.empty){
        }
        else if(this.isLeaf()){
            return true;  
        }
        else if((this.val<=this.getLeft().val)&&(this.val>=this.getRight().val)){
            return false;
        }
        else if((this.val>this.getLeft().val)&&(this.val<this.getRight().val)){
            return this.getLeft().isDeRecherche()&&this.getRight().isDeRecherche();
        }
        return false;
    }
	
    public static void testArbre1() throws ManipulationArbreVide {
        Arbre d = new Arbre(1, new Arbre(), new Arbre());
        Arbre b = new Arbre(2, d, new Arbre());
        Arbre c = new Arbre(7, new Arbre(), new Arbre());
        Arbre arbre = new Arbre(5, b, c);
        Arbre d2 = new Arbre(1, new Arbre(), new Arbre());
        Arbre b2 = new Arbre(2, d2, new Arbre());
        Arbre c2 = new Arbre(7, new Arbre(), new Arbre());
        Arbre a2 = new Arbre(5, b2, c2);
        int score = 0;
        System.out.println("**** Test arbre1");
        if (arbre.nombreNoeuds() == 4) {
            System.out.println("\t nombreNoeuds: OK!");
            ++score;
        } else {
            System.out.println("\t nombreNoeuds: fail!");
        }
        if (arbre.hauteur() == 2) {
            System.out.println("\t hauteur: OK!");
            ++score;
        } else {
            System.out.println("\t hauteur: fail!");
        }
        if (arbre.toString2().equals("1 2 5 7")) {
            System.out.println("\t toString: OK!");
            ++score;
        } else {
            System.out.println("\t toString: fail!");
        }
        if (arbre.somme() == 15) {
            System.out.println("\t somme: OK!");
            ++score;
        } else {
            System.out.println("\t somme: fail!");
        }
        if (arbre.sommeFeuilles() == 8) {
            System.out.println("\t sommeFeuilles: OK!");
            ++score;
        } else {
            System.out.println("\t sommeFeuilles: fail!");
        }
        if (arbre.equals(a2)) {
            System.out.println("\t equals: OK!");
            ++score;
        } else {
            System.out.println("\t equals: fail!");
        }
        System.out.println("**** Score: " + score + "/6");
    }

    public static void testArbre2() throws ManipulationArbreVide {
        Arbre c = new Arbre(6, new Arbre(), new Arbre());
        Arbre b = new Arbre(5, c, new Arbre());
        Arbre arbre = new Arbre(3, b, new Arbre());
        Arbre c2 = new Arbre(6, new Arbre(), new Arbre());
        Arbre b2 = new Arbre(5, c2, new Arbre());
        Arbre a2 = new Arbre(3, b2, new Arbre());
        int score = 0;
        System.out.println("**** Test arbre2");
        if (arbre.nombreNoeuds() == 3) {
            System.out.println("\t nombreNoeuds: OK!");
            ++score;
        } else {
            System.out.println("\t nombreNoeuds: fail!");
        }
        if (arbre.hauteur() == 2) {
            System.out.println("\t hauteur: OK!");
            ++score;
        } else {
            System.out.println("\t hauteur: fail!");
        }
        if (arbre.toString2().equals("6 5 3")) {
            System.out.println("\t toString: OK!");
            ++score;
        } else {
            System.out.println("\t toString: fail!");
        }
        if (arbre.somme() == 14) {
            System.out.println("\t somme: OK!");
            ++score;
        } else {
            System.out.println("\t somme: fail!");
        }
        if (arbre.sommeFeuilles() == 6) {
            System.out.println("\t sommeFeuilles: OK!");
            ++score;
        } else {
            System.out.println("\t sommeFeuilles: fail!");
        }
        if (arbre.equals(a2)) {
            System.out.println("\t equals: OK!");
            ++score;
        } else {
            System.out.println("\t equals: fail!");
        }
        System.out.println("**** Score: " + score + "/6");
    }

    public static void testArbre3() throws ManipulationArbreVide {
        Arbre arbre = new Arbre(2);
        Arbre b = new Arbre(1);
        Arbre c = new Arbre(3);
        Arbre d = new Arbre(4);
        Arbre e = new Arbre(5);
        Arbre f = new Arbre(9);
        Arbre g = new Arbre(10);
        arbre.setLeft(b);
        arbre.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);
        Arbre a2 = new Arbre(2);
        Arbre b2 = new Arbre(1);
        Arbre c2 = new Arbre(3);
        Arbre d2 = new Arbre(4);
        Arbre e2 = new Arbre(5);
        Arbre f2 = new Arbre(9);
        Arbre g2 = new Arbre(10);
        a2.setLeft(b2);
        a2.setRight(c2);
        b2.setLeft(d2);
        b2.setRight(e2);
        c2.setLeft(f2);
        c2.setRight(g2);
        int score = 0;
        System.out.println("**** Test arbre3");
        if (arbre.nombreNoeuds() == 7) {
            System.out.println("\t nombreNoeuds: OK!");
            ++score;
        } else {
            System.out.println("\t nombreNoeuds: fail!");
        }
        if (arbre.toString2().equals("4 1 5 2 9 3 10")) {
            System.out.println("\t toString: OK!");
            ++score;
        } else {
            System.out.println("\t toString: fail!");
        }
        if (arbre.hauteur() == 2) {
            System.out.println("\t hauteur: OK!");
            ++score;
        } else {
            System.out.println("\t hauteur: fail!");
        }
        if (arbre.somme() == 34) {
            System.out.println("\t somme: OK!");
            ++score;
        } else {
            System.out.println("\t somme: fail!");
        }
        if (arbre.sommeFeuilles() == 28) {
            System.out.println("\t sommeFeuilles: OK!");
            ++score;
        } else {
            System.out.println("\t sommeFeuilles: fail!");
        }
        if (arbre.equals(a2)) {
            System.out.println("\t equals: OK!");
            ++score;
        } else {
            System.out.println("\t equals: fail!");
        }
        System.out.println("**** Score: " + score + "/6");
    }

    public static void testArbre4() throws ManipulationArbreVide {
        Arbre arbre = new Arbre(2);
        Arbre a2 = new Arbre(2);
        int score = 0;
        System.out.println("**** Test arbre4");
        if (arbre.nombreNoeuds() == 1) {
            System.out.println("\t nombreNoeuds: OK!");
            ++score;
        } else {
            System.out.println("\t nombreNoeuds: fail!");
        }
        if (arbre.toString2().equals("2")) {
            System.out.println("\t toString: OK!");
            ++score;
        } else {
            System.out.println("\t toString: fail!");
        }
        if (arbre.hauteur() == 0) {
            System.out.println("\t hauteur: OK!");
            ++score;
        } else {
            System.out.println("\t hauteur: fail!");
        }
        if (arbre.somme() == 2) {
            System.out.println("\t somme: OK!");
            ++score;
        } else {
            System.out.println("\t somme: fail!");
        }
        if (arbre.sommeFeuilles() == 2) {
            System.out.println("\t sommeFeuilles: OK!");
            ++score;
        } else {
            System.out.println("\t sommeFeuilles: fail!");
        }
        if (arbre.equals(a2)) {
            System.out.println("\t equals: OK!");
            ++score;
        } else {
            System.out.println("\t equals: fail!");
        }
        System.out.println("**** Score: " + score + "/6");
    }

    public static void testArbre5() throws ManipulationArbreVide {
        Arbre arbre = new Arbre(7);
        Arbre b = new Arbre(1);
        Arbre c = new Arbre(2);
        Arbre d = new Arbre(4);
        arbre.setLeft(b);
        b.setLeft(c);
        c.setLeft(d);
        Arbre a2 = new Arbre(7);
        Arbre b2 = new Arbre(1);
        Arbre c2 = new Arbre(2);
        Arbre d2 = new Arbre(4);
        a2.setLeft(b2);
        b2.setLeft(c2);
        c2.setLeft(d2);
        int score = 0;
        System.out.println("**** Test arbre5");
        if (arbre.nombreNoeuds() == 4) {
            System.out.println("\t nombreNoeuds: OK!");
            ++score;
        } else {
            System.out.println("\t nombreNoeuds: fail!");
        }
        if (arbre.toString2().equals("4 2 1 7")) {
            System.out.println("\t toString: OK!");
            ++score;
        } else {
            System.out.println("\t toString: fail!");
        }
        if (arbre.hauteur() == 3) {
            System.out.println("\t hauteur: OK!");
            ++score;
        } else {
            System.out.println("\t hauteur: fail!");
        }
        if (arbre.somme() == 14) {
            System.out.println("\t somme: OK!");
            ++score;
        } else {
            System.out.println("\t somme: fail!");
        }
        if (arbre.sommeFeuilles() == 4) {
            System.out.println("\t sommeFeuilles: OK!");
            ++score;
        } else {
            System.out.println("\t sommeFeuilles: fail!");
        }
        if (arbre.equals(a2)) {
            System.out.println("\t equals: OK!");
            ++score;
        } else {
            System.out.println("\t equals: fail!");
        }
        System.out.println("**** Score: " + score + "/6");
    }
	
	public static void testAjout() throws ManipulationArbreVide {
        System.out.println("**** Test fonction ajout");
		Arbre arbre = new Arbre(4);
		int[] tab = {2, 6, 1, 7, 3, 5};
		for (int i = 0; i<tab.length; i++){
			arbre.ajoutVal(tab[i]);
		}
		Arbre a = new Arbre(4);
        Arbre b = new Arbre(2);
        Arbre c = new Arbre(6);
        Arbre d = new Arbre(1);
        Arbre e = new Arbre(3);
        Arbre f = new Arbre(5);
        Arbre g = new Arbre(7);
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);
		
        if (a.equals(arbre)) {
            System.out.println("\t ajout: OK!");
        } else {
            System.out.println("\t ajout: fail!");
		}	
		
	}

	public static void testDeRecherche() throws ManipulationArbreVide {
        System.out.println("**** Test isDeRecherche");
		int score = 0;
		Arbre arbre = new Arbre(4);
        Arbre b = new Arbre(2);
        Arbre c = new Arbre(6);
        Arbre d = new Arbre(1);
        Arbre e = new Arbre(3);
        Arbre f = new Arbre(5);
        Arbre g = new Arbre(7);
        arbre.setLeft(b);
        arbre.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);
        if (arbre.isDeRecherche()) {
            System.out.println("\t IsBinaire 1: OK!");
            ++score;
        } else {
            System.out.println("\t IsBinaire 1: fail!");
		}
		
		 arbre = new Arbre(4);
         b = new Arbre(2);
         c = new Arbre(6);
         d = new Arbre(3);
         e = new Arbre(1);
         f = new Arbre(5);
         g = new Arbre(7);
        arbre.setLeft(b);
        arbre.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);
        if (!arbre.isDeRecherche()) {
            System.out.println("\t IsBinaire 2: OK!");
            ++score;
        } else {
            System.out.println("\t IsBinaire 2: fail!");
		}
		
		 arbre = new Arbre(4);
         b = new Arbre(3);
         c = new Arbre(6);
         d = new Arbre(1);
         e = new Arbre(7);
         f = new Arbre(2);
         g = new Arbre(8);
        arbre.setLeft(b);
        arbre.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);
        if (arbre.isDeRecherche()) {
            System.out.println("\t IsBinaire 3: OK!");
            ++score;
        } else {
            System.out.println("\t IsBinaire 3: fail!");
		}
		
		 arbre = new Arbre(4);
         b = new Arbre(4);
        arbre.setRight(b);
        if (!arbre.isDeRecherche()) {
            System.out.println("\t IsBinaire 4: OK!");
            ++score;
        } else {
            System.out.println("\t IsBinaire 4: fail!");
		}
		
		 arbre = new Arbre(4);
         b = new Arbre(4);
        arbre.setLeft(b);
        if (!arbre.isDeRecherche()) {
            System.out.println("\t IsBinaire 5: OK!");
            ++score;
        } else {
            System.out.println("\t IsBinaire 5: fail!");
		}
        System.out.println("**** Score: " + score + "/5");
	}
	
	public static void testTableau() throws ManipulationArbreVide {
        System.out.println("**** Test constructeur Tableau");
    int[][] inputs = {
		{4, 2, 6, 1, 7, 3, 5},
		{4, 4, 4},
		{1, 2, 3, 4, 5},
		{5, 4, 3, 2, 1},
		{2, 6, 9, 1, 5, 3, 4, 6, 0, 8, 7}};
    String[] outputs = {
		"1 2 3 4 5 6 7",
		"4 4 4",
		"1 2 3 4 5",
		"1 2 3 4 5",
		"0 1 2 3 4 5 6 6 7 8 9"};
		
	int nbTests = inputs.length;
       int score = 0;
       for (int i = 0; i < nbTests; i++) {
           Arbre arbre = new Arbre(inputs[i]);
           String s = arbre.toString2();
           if (s.equals(outputs[i])) {
               System.out.println("Test " + i + " passed!");
               score++;
           } else {
               System.out.println("Test " + i + " failed!");
           }
       }
    System.out.println("**** Final score: " + score + "/" + nbTests);
    }
		
		

    public static void main(String[] args) throws ManipulationArbreVide{
			testArbre1();
			testArbre2();
			testArbre3();
			testArbre4();
			testArbre5();
			testAjout();
			testTableau();
			testDeRecherche();

            //Test de parcours en longueur d'un arbre binaire
            Arbre a4 = new Arbre (4);
            Arbre a3 = new Arbre(3);
            Arbre a2 = new Arbre (2, a3, a4);
            Arbre a7 = new Arbre(7);
            Arbre a6 = new Arbre (6);
            Arbre a5 = new Arbre (5, a7, a6);
            Arbre arbre = new Arbre (1, a2, a5);
            //arbre.parcoursPrefixe();
            //arbre.parcoursPostfixe();
            //arbre.parcoursInfixe();

            //Test de la methode toString2()
            Arbre arbre1 = new Arbre(7);
            Arbre b1 = new Arbre(1);
            Arbre c1 = new Arbre(2);
            Arbre d1 = new Arbre(4);
            arbre1.setLeft(b1);
            b1.setLeft(d1);
            d1.setRight(c1);
            //System.out.println(arbre1.toString2());
            //String S = arbre1.toString2();
            //System.out.println(S.equals("3 2 4 1 7 5 6"));

            //Test de la methode ajoutVal()
            Arbre a = new Arbre(4);
            Arbre b = new Arbre(2);
            Arbre c = new Arbre(7);
            Arbre d = new Arbre(1);
            Arbre e = new Arbre(3);
            Arbre f = new Arbre(6);
            Arbre g = new Arbre(8);
            a.setLeft(b);
            a.setRight(c);
            b.setLeft(d);
            b.setRight(e);
            c.setLeft(f);
            c.setRight(g);
            //System.out.println(a.toString2());
            a.ajoutVal(5);
            //System.out.println(a.toString2());

            //Test du constructeur
            int[] tab = {1, 2, 3, 4, 5};
            Arbre ar = new Arbre(tab);
            String S = ar.toString2();
            System.out.println(S);
            System.out.println(S.equals("1 2 3 4 5"));
            //System.out.println(ar.toString2());

    }
}
