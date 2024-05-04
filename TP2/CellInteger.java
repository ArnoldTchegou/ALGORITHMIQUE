/**
 * Classe qui représente une cellule de liste d'entiers
 */


public class CellInteger {
    private Integer data;
    private CellInteger next;

    /**
     * Constructeur sans paramètres
     */
    public CellInteger() {
        this.data = 0;
        this.next = null;
    }

    /**
     * Constructeur avec argument
     */
    public CellInteger(Integer val) {
        this.data = val;
        this.next = null;
    }

    /**
     * Méthode d'accès en lecture à data
     */
    public Integer getData() {
        return this.data;
    }

    /**
     * Méthode d'accès en lecture à next
     */
    public CellInteger getNext() {
        return this.next;
    }

    /**
     * Méthode d'accès en écriture pour data
     */
    public void setData(Integer val) {
        this.data = val;
    }

    /**
     * Méthode d'accès en écriture pour next
     */
    public void setNext(CellInteger n) {
        this.next = n;
    }

    /**
     * Returne une chaîne représentant le contenu de la cellule
     */
    public String toString() {
        return "cette cellule contient la valeur"+this.data;
    }

    public static void main(String[] args) {
        /* Question 5 */
        CellInteger cell1 = new CellInteger(3);
        CellInteger cell2 = new CellInteger(5);
        System.out.println(cell1.toString()+"\n");
        System.out.println(cell2.toString()+"\n");
    }
}
