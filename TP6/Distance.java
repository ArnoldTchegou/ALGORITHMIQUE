/**
 * TP 6: Programmation dynamique - distance d’alignement
 */


public class Distance {
    /* A COMPLETER: attributs privés */
    String a;
    String b;
    int[][] M;
    Fleche[][] F;
    boolean exchange;
    public enum Fleche { HAUT, HAUT_GAUCHE, GAUCHE };
    /**
     * Constructeur
     */
    public Distance(String word1, String word2) {
        /* A COMPLETER */
        if(word1.length()<=word2.length()){
            this.a = word1;
            this.b = word2;
            this.exchange = false;
        }
        else{
            this.a = word2;
            this.b = word1;
            this.exchange = true;
        }
        this.M = new int[a.length()+1][b.length()+1];
        this.F = new Fleche[a.length()+1][b.length()+1];
    }

    /**
     * Calcule le coût du remplacement du symbole a par b
     */
    int cost(char c, char d) {
        /* A COMPLETER */
        if(c==d){
            return 0;
        }
        else{
            return 1;
        }
    }

    /**
     * Calcule la matrice de coûts
     */
    public void computeCosts() {
        /* A COMPLETER */
        int n = M.length-1;
        int m = M[0].length-1;
        //initialisation de la matrice des couts
        for(int i=0; i<=n; i++){
            M[i][0] = i;
            F[i][0] = Fleche.HAUT;
        }
        for(int j=1; j<=m; j++){
            M[0][j] = j;
            F[0][j] = Fleche.GAUCHE;
        }
        //Boucle principale
        int x1, x2, x3;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                x1 = M[i-1][j-1] + cost(a.charAt(i-1), b.charAt(j-1));
                x2 = M[i][j-1] + 1;
                x3 = M[i-1][j] + 1;
                if(x1>=x2){
                    if(x2>=x3){
                        M[i][j] = x3;
                        F[i][j] = Fleche.HAUT;
                    }
                    else{
                        M[i][j] = x2;
                        F[i][j] = Fleche.GAUCHE;
                    }
                }
                else if(x3>=x1){
                    M[i][j] = x1;
                    F[i][j] = Fleche.HAUT_GAUCHE;
                } 
            } 
        }
        affiche(M);
    }
    public void affiche(int[][] M){
        int n = M.length-1;
        int m = M[0].length-1;
        for(int i=0; i<=n; i++){
            String s ="";
            for(int j=0; j<=m; j++){
                s +=M[i][j]+" ";
            }
            System.out.println(s);
        }
    }
    public void affiche_deplace(Fleche[][] F){
        int n = F.length-1;
        int m = F[0].length-1;
        for(int i=0; i<=n; i++){
            String s ="";
            for(int j=0; j<=m; j++){
                s +=F[i][j]+" ";
            }
            System.out.println(s);
        }
    }
    /**
     * Retourne la distance d’alignement
     */
    public int distance() {
        /* A COMPLETER */
        int n = a.length();
        int m = b.length();
        this.computeCosts();
        return M[n][m];
    }

    /**
     * Retourne une représentation des deux mots alignés
     * 
     * Exemple: si les deux mots sont "and" et "ad" la méthode doit renvoyer
     * la chaine de caractères :
     *   "and
     *    a-d"
     */
    public String alignment() {
        /* A COMPLETER */
        String S1 ="";
        String S2 ="";
        int i = this.F.length-1;
        int j = this.F[0].length-1;
        while(i>0&&j>0){
            int stop = 1;
            while(stop!=0){
                if(this.F[i][j]==Fleche.HAUT_GAUCHE&&F[i-1][j-1]!=null){
                    S1 = a.charAt(i-1) + S1;
                    S2 = b.charAt(j-1) + S2;
                    i--;
                    j--;
                    stop=0;
                }
                else if(this.F[i][j]==Fleche.GAUCHE){
                    if(F[i][j-1]!=null){
                        S1 = "-"+ S1;
                        S2 = b.charAt(j-1)+ S2;
                        j--;
                    }
                    else{
                        S1 = a.charAt(i-1) + S1;
                        S2 = b.charAt(j-1) + S2;
                        i--;
                        j--;
                    }
                    stop=0;
                }
                else if(this.F[i][j]==Fleche.HAUT){
                    if(this.F[i-1][j]!=null){
                        S1 = b.charAt(i-1) + S1;
                        S2 = "-"+ S2;
                        i--;
                    }
                    else{
                        S1 = a.charAt(i-1) + S1;
                        S2 = b.charAt(j-1) + S2;
                        i--;
                        j--;    
                    }
                    stop=0;
                }
                else if(this.F[i][j]==null){
                    S1 = a.charAt(i-1) + S1;
                    S2 = b.charAt(j-1) + S2;
                    i--;
                    j--;
                    stop=0;
                }
            }
        }
        if(!this.exchange){
            return S1+"\n"+S2;
        }
        return S2+"\n"+S1;
    }

    /**
     * Teste l’implémentation
     */
    public static void testImplementation() {
        int score = 0;
        int nTests = 10;

        System.out.println("Testing the implementation:");

        Distance dist1 = new Distance("chien", "chat");
        if (dist1.distance() == 3) {
            System.out.println("\t- test  1: pass");
            score++;
        } else {
            System.out.println("\t- test  1: fail");
        }

        Distance dist2 = new Distance("book", "back");
        if (dist2.distance() == 2) {
            System.out.println("\t- test  2: pass");
            score++;
        } else {
            System.out.println("\t- test  2: fail");
        }

        Distance dist3 = new Distance("elephant", "relevant");
        if (dist3.distance() == 3) {
            System.out.println("\t- test  3: pass");
            score++;
        } else {
            System.out.println("\t- test  3: fail");
        }

        Distance dist4 = new Distance("Saturday", "Sunday");
        if (dist4.distance() == 3) {
            System.out.println("\t- test  4: pass");
            score++;
        } else {
            System.out.println("\t- test  4: fail");
        }

        Distance dist5 = new Distance("Google", "Facebook");
        if (dist5.distance() == 8) {
            System.out.println("\t- test  5: pass");
            score++;
        } else {
            System.out.println("\t- test  5: fail");
        }

        Distance dist6 = new Distance("semaine", "madeleine");
        if (dist6.distance() == 5) {
            System.out.println("\t- test  6: pass");
            score++;
        } else {
            System.out.println("\t- test  6: fail");
        }

        Distance dist7 = new Distance("potato", "patata");
        dist7.distance();
        if ("potato\npatata".equals(dist7.alignment())) {
            System.out.println("\t- test  7: pass");
            score++;
        } else {
            System.out.println("\t- test  7: fail");
        }

        Distance dist8 = new Distance("man", "mad");
        dist8.distance();
        if ("man\nmad".equals(dist8.alignment())) {
            System.out.println("\t- test  8: pass");
            score++;
        } else {
            System.out.println("\t- test  8: fail");
        }

        Distance dist9 = new Distance("and", "ad");
        dist9.distance();
        if ("and\na-d".equals(dist9.alignment())) {
            System.out.println("\t- test  9: pass");
            score++;
        } else {
            System.out.println("\t- test  9: fail");
        }

        Distance dist10 = new Distance("wong", "wrong");
        dist10.distance();
        if ("w-ong\nwrong".equals(dist10.alignment())) {
            System.out.println("\t- test 10: pass");
            score++;
        } else {
            System.out.println("\t- test 10: fail");
        }

        System.out.println("Score " + score + "/" + nTests);
    }

    public static void main(String[] args) {
        testImplementation();
        //Distance dist10 = new Distance("wong", "wrong");
        //System.out.println(dist10.distance());
        //dist10.affiche_deplace(dist10.F);
        //System.out.println(dist10.alignment());
        //System.out.println("w-ong\nwrong".equals(dist10.alignment()));
}
}
