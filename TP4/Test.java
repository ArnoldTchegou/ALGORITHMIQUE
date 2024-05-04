
public class Test {
    public static void main(String[] args){
        Node one = new Node(1);
		Node six = new Node(6);
		Node nine = new Node(9);
		Node five = new Node(5, one, six);
		Node ten = new Node(10, nine, null);
		Node eight = new Node(8, five, ten);
        Tree T = new Tree(eight);
        Parcoursprefixe p = new Parcoursprefixe(T);
        // iterating elements of the set
        //while (p.hasNext()) {
            //System.out.println(p.next().val);
        //}
        //System.out.println(p.less(12));
        System.out.println(p.getMax());
    }
}
