/**
 * Implementation d'une liste d'entiers
 */


public class ListInteger {
    private CellInteger head;

    /**
     * Constructeur sans paramètres
     */
    public ListInteger() {
        this.head = new CellInteger();
    }

    /**
     * Ajoute une cellule au début de la liste
     */
    public void addFirst(Integer d) {
        CellInteger c = new CellInteger(d);
        if(this.head.getNext() == null){
            this.head.setNext(c);
        }
        else{
            CellInteger a = this.head.getNext();
            this.head.setNext(c);
            c.setNext(a);
        }
    }

    /**
     * Retourne une chaîne représentant les données contenues dans la liste
     */
    public String toString() {
        CellInteger cell = this.head.getNext();
        String s = "le contenu de la liste est: "+cell.getData()+"-->";
        while(cell.getNext()!=null){
            cell = cell.getNext();
            s += cell.getData()+"-->";
        }
        s += "null";
        return s;
    }

    /**
     * Ajoute une cellule à la fin de la liste
     */
    public void add(Integer d) {
        CellInteger c = new CellInteger(d);
        if(this.head.getNext() == null){
            this.head.setNext(c);
        }
        else{
            CellInteger a = this.head.getNext();
            CellInteger temp = new CellInteger();
            while(a!=null){
                temp = a;
                a = a.getNext();
            }
            temp.setNext(c);
        }
    }

    /**
     * Renvoie le premier entier de la liste ou null si la liste est vide
     */
    public Integer element() {
        if(this.head.getNext() == null){
            return null;
        }
        return this.head.getNext().getData();
    }

    /**
     * Renvoie la taille de la liste
     */
    public int size() {
        CellInteger cell = this.head.getNext();
        int taille = 0;
        while(cell!=null){
            taille++;
            cell = cell.getNext();
        }
        return taille;
    }

    /**
     * Renvoie true si la liste contient d
     */
    public boolean contains(Integer d) {
        CellInteger cell = this.head.getNext();
        while(cell!=null){
            if(cell.getData()==d){
                return true;
            }
            else{
                cell = cell.getNext();
            }
        }
        return false;
    }

    /**
     * Enlève la première cellule qui contient l'entier d et renvoie true si la
     * liste a changé
     */
    public boolean remove(Integer d) {
        CellInteger cell = this.head.getNext();
        if(cell!=null&&cell.getData()==d){
            this.head.setNext(cell.getNext());
            return true;
        }
        CellInteger temp = new CellInteger();
        while(cell!=null&&cell.getData()!=d){
            temp = cell;
            cell = cell.getNext();
        }
        if(cell.getData()==d){
            temp.setNext(cell.getNext());
            return true;
        }
        return false;
    }

    /**
     * Renvoie l'element en position idx
     */
    public Integer get(int idx) {
        CellInteger cell = this.head.getNext();
        int count=0;
        if((idx>=0)&&(this.size()>idx)){
            while((cell!=null&&this.size()>count)){
                if(count == idx){
                    return cell.getData();
                }
                cell = cell.getNext();
                count++;
            }
        }
        return null;
    }

    /**
     * Affecte l'element en position idx à d et renvoie l'ancienne valeur
     */
    public Integer set(int idx, Integer d) {
        CellInteger cell = this.head.getNext();
        int count=0;
        if((idx>=0)&&(this.size()>idx)){
            while((cell!=null&&this.size()>count)){
                if(count == idx){
                    Integer x = cell.getData();
                    cell.setData(d);
                    return x;
                }
                cell = cell.getNext();
                count++;
            }
        }
        return null;
    }

    /**
     * Enlève la cellule en tête de liste et la renvoie
     */
    public Integer removeFirst() {
        CellInteger cell = this.head.getNext();
        if(cell!=null){
            this.head.setNext(cell.getNext());
            return cell.getData();
        }
        return null;
    }

    public static void main(String[] args) {
        /* Question 10 */
        ListInteger list = new ListInteger();
        list.addFirst(3);
        list.addFirst(5);
        list.addFirst(7);
        list.add(4);
        System.out.println(list.toString());
        System.out.println(list.element());
        System.out.println("La taille de la liste est "+list.size());
        //System.out.println(list.contains(5));
        //System.out.println(list.remove(3));
        //System.out.println(list.toString());
        //System.out.println(list.get(2));
        //System.out.println(list.set(5, 10));
        //System.out.println(list.toString());
        System.out.println(list.removeFirst());
        System.out.println(list.toString());

    }
}
