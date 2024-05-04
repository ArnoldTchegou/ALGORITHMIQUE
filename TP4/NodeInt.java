/**
 * Implementation des noeuds d'abres binaires avec valeurs entières
 */


public class NodeInt {
	private Integer val; // Valeur du noeud
	private NodeInt left; // Fils gauche
	private NodeInt right; // Fils droit
	
    /** 
     * Constructeur d'un nœud avec clé donnée
     */
    public NodeInt(Integer val) {
		this.val = val;
		this.left = null;
		this.right = null;
    }
	
    /**
     * Constructeur d'un nœud avec clé et fils indiqués en argument
     */
    public NodeInt(Integer val, NodeInt lson, NodeInt rson) {
		this.val = val;
		this.left = lson;
		this.right = rson;
    }

	/* Accesseurs (getters) pour tous les attributs */

	public Integer getVal() {
		return this.val;
	}

	public NodeInt getLeft() {
		return this.left;
	}

	public NodeInt getRight() {
		return this.right;
	}

	/* Mutateurs (setters) pour tous les attributs */

	public void setVal(Integer val) {
		this.val = val;
	}

	public void setLeft(NodeInt left) {
		this.left = left;
	}

	public void setRight(NodeInt right) {
		this.right = right;
	}


    /**
     * Teste si noeud est une feuille
     */
    public boolean isLeaf() {
		if((this.getRight()==null)&&(this.getLeft()==null)){
            return true;
        }
		return false;
    }

	/**
	 * Affiche le nœud et ses fils
	 * La méthode doit renvoyer "((1) 5 (6)) 8 ((9) 10 ())" pour le nœud 8
	 * de l'exemple suivant :
	 * 
	 *          8
	 *        /   \
	 *       5    10
	 *     /  \   /
	 *    1   6  9
	 */
    @Override
    public String toString() {
		String s = "";
		if(this.getVal() == null){
            s += "";
        }
       	else if(this.isLeaf()){
            s += "("+this.getVal()+")";
            return s;
        }
        else{
            if(this.getLeft()==null){
                s += "(";
				s += "(()"+" ";
            }
            else{
				if(this.getLeft().isLeaf()){
					s += "(";
					s +=this.getLeft().toString()+" ";
				}
				else{
					s +=this.getLeft().toString()+" ";
				}  
            }
            s += this.getVal();
            if(this.getRight()==null){
                s += " "+"()";
            }
            else{
				if(this.getRight().isLeaf()){
					s +=" "+this.getRight().toString();
					s += ")";
				}
				else{
					s += " "+this.getRight().toString()+")";
				}
            }    
        } 
        return s;
    }

    /**
     * Teste si le nœud est la racine d'un ABR ayant des valeurs entre
	 * min et max
     */
    public boolean isIntBST(Integer min, Integer max) {
		if((this.getVal()==null)){
			return false;
		}
		else if(this.isLeaf()){
			return (min<=this.val&&this.getVal()<=max);
        }
		else if((this.getLeft()==null)&&(this.getRight()!=null)){
			return (min<=this.val&&this.getVal()<=max)&&(this.getRight().isIntBST(min, this.getVal()));
		}
		else if((this.getRight()==null)&&(this.getLeft()!=null)){
			return (min<=this.val&&this.getVal()<=max)&&(this.getLeft().isIntBST(min, this.getVal()));
		}
		else if ((this.getLeft()!=null)&&(this.getRight()!=null)){
			//if((this.getLeft()!=null)&&(this.getRight()!=null)){
			return (min<=this.val&&this.getVal()<=max)&&(this.getLeft().isIntBST(min, this.getVal()))&&(this.getRight().isIntBST(this.getVal(), max));
			//}
		}
		return false;
    }

    public boolean contains1(Integer x) {
        if(this.getVal()== null){
            return false;
        }
		else if(this.getVal()== x){
            return true;
        }
        else if(this.isLeaf()){
            return this.getVal() == x?true:false;
        }
        else{
            if((x>this.getVal())&&(this.getRight()!=null)){
                return this.getRight().contains1(x);
            }
            else if((this.getVal()>x)&&(this.getLeft()!=null)){
                return this.getLeft().contains1(x);
            }
        }
        return false;
    }

	public int height(){
        int r=0, l=0;
        if(this.val == null){
            return -1;
        }
        else if((this.isLeaf())){
            return 0;
        }
        else{
			if(this.getRight()!=null){
				r = 1 + this.getRight().height();
			}
			else if(this.getLeft()!=null){
				l = 1 + this.getLeft().height();
			}
            return r>l?r:l;
        }
    }
	//methode d'insertion: on l'appel dans la methode insertion de la classe BinTree
    public void ajoutVal(Integer val){
        if (this.val == null){
			this.val = val;
			this.left = null;
			this.right = null;
        }
		else if (val < this.val){
			if(this.getLeft()!=null){
				this.getLeft().ajoutVal(val);
			}
			else{
				this.setLeft(new NodeInt(val));
			}
		}
		else if (val > this.val){
			if(this.getRight()!=null){
				this.getRight().ajoutVal(val);
			}
			else{
				this.setRight(new NodeInt(val));
			}
		}
    }

	//Parcours Infixe
	public void parcoursInfixe(){
        if(this.val == null){
        }
        else if(this.isLeaf()){
            System.out.print(this.val);
        }
        else{
			if(this.getLeft()!=null){
				this.getLeft().parcoursInfixe();
			}
            System.out.print(this.val);
			if(this.getRight()!=null){
				this.getRight().parcoursInfixe();
			}
        } 
    }

    /**
     * Tests unitaires de la classe
     */

    /**
     * Construit le noeud ((1) 5 (6)) 8 ((9) 10 ())
     */ 
    public static NodeInt buildNodeInt8() {
		NodeInt one = new NodeInt(1);
		NodeInt six = new NodeInt(6);
		NodeInt nine = new NodeInt(9);
		NodeInt five = new NodeInt(5, one, six);
		NodeInt ten = new NodeInt(10, nine, null);
		NodeInt eight = new NodeInt(8, five, ten);
		return eight;
    }

    public static void testIsLeaf() {
		System.out.println("Test isLeaf:");
		int score = 0;

		// Test 1
		NodeInt n8 = buildNodeInt8();
		if (!n8.isLeaf()) {
			System.out.println("\t- test 1: pass");
			score ++;
		}
		else {
			System.out.println("\t- test 1: fail");
		}

		/* A COMPLETER: ajouter des tests */

		// Score final
		System.out.println("Test isLeaf: score " + score + "/1");
    }
    
    public static void testToString() {
		System.out.println("Test toString:");
		int score = 0;

		// Test 1
		NodeInt n8 = buildNodeInt8();
		if (n8.toString().equals("((1) 5 (6)) 8 ((9) 10 ())")) {
			System.out.println("\t- test 1: pass");
			score ++;
		}
		else {
			System.out.println("\t- test 1: fail");
		}

		/* A COMPLETER: ajouter des tests */

		// Score final
		System.out.println("Test toString: score " + score + "/1");
    }
    
    public static void testIsIntBst() {
		System.out.println("Test isIntBST:");
		int score = 0;

		// Test 1
		NodeInt n8 = buildNodeInt8();
		if (n8.isIntBST(0,20)) {
			System.out.println("\t- test 1: pass");
			score ++;
		}
		else {
			System.out.println("\t- test 1: fail");
		}

		/* A COMPLETER: ajouter des tests */

		// Score final
        System.out.println("Test isIntBST: score " + score + "/1");
    }
    
    public static void main(String[] args) {
		testIsLeaf();
		testToString();
		testIsIntBst();

		//Test de toString
		NodeInt one = new NodeInt(1);
		NodeInt six = new NodeInt(6);
		NodeInt nine = new NodeInt(9);
		NodeInt five = new NodeInt(5, one, six);
		NodeInt ten = new NodeInt(10, nine, null);
		NodeInt eight = new NodeInt(8, five, ten);
		System.out.println(eight.toString());
    }
}

