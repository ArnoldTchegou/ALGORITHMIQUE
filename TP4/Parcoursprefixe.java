import java.util.NoSuchElementException;
import java.util.Deque;
import java.util.LinkedList;
public class Parcoursprefixe {
        Deque<Node>  b;     // 
        // Constructeur
        Parcoursprefixe(Tree t) {
            b = new LinkedList<>();     // Création de la pile
            if (t.root != null) {
                b.add(t.root);
            } 
        }
        boolean hasNext() {
            return !b.isEmpty();      // La pile contient les racines des 
        }	                        // sous-arbres encore à traiter
        Node next() {
            if (hasNext()) {
                Node c = b.pollLast();	// Noeud à traiter
            if (c.rs != null) b.add(c.rs);  // Empilement du fils droit
            if (c.ls != null) b.add(c.ls);  // Empilement du fils gauche
            return c;
            } else
                throw new NoSuchElementException();
        }
        public int less(Integer x){
            int count  = 0;
            while (this.hasNext()) {
                if(x>this.next().val){
                    count++;
                }
            }
            return count;
        }
        public Integer getMax(){
            int MAX  = 0;
            while (this.hasNext()) {
                MAX = this.next().val>MAX?this.next().val:MAX;
            }
            return MAX;
        }
    }
