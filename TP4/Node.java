public class Node {
    Integer val;  //valeur du noeud
    Node ls;      // Fils gauche
    Node rs;      // Fils droit
   //Constructeur d'un nœud avec clé donnée
   public Node(Integer val) {
       this.val = val;
       this.ls = null;
       this.rs = null;
   }
   
   /**
    * Constructeur d'un nœud avec clé et fils indiqués en argument
    */
   public Node(Integer val, Node lson, Node rson) {
       this.val = val;
       this.ls = lson;
       this.rs = rson;
   }
}
