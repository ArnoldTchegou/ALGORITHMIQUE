/**
 * Classe qui encode un numéro d’étudiant
 */

public class NoEtud {
    private int s;
    private int aa;
    private int mm;
    private int xxx;

    /**
     * Construit le numéro d’étudiant dont les composants sont donnés en paramètre.
     * Si les paramètres ne sont pas cohérent, le numéro doit être 2 15 01 000
     */
    public NoEtud(int s, int aa, int mm, int xxx) {
        /* A COMPLETER */
    }

    /**
     * Constructeur à partir d'un entier
     */
    public NoEtud(int n) {
        /* A COMPLETER */
    }

    /**
     * Getters et Setters
     */

    public int getS(){
		return s;
	}

    public int getAa(){
		return aa;
	}

    public int getMm(){
		return mm;
	}

    public int getXxx(){
		return xxx;
	}
	
	public void setS(int s){
		this.s = s;
	}
	
	public void setAa(int aa){
		this.aa = aa;
	}
	
	public void setMm(int mm){
		this.mm = mm;
	}
	
	public void setXxx(int xxx){
		this.xxx = xxx;
	}

    /**
     * Renvoie la chaîne de caractères correspondant au numéro d'étudiant
     * 
     * Exemple : si s=1, aa=0, mm=1 et xxx=0, alors la méthode doit renvoyer "1 00
     * 01 000"
     * 
     * Si vous avez des doutes sur le formatage de chaines de caractères :
     * https://koor.fr/Java/Tutorial/java_system_out_printf.wp
     */
    public String toString() {
        /* A COMPLETER */
        return "";
    }

    /**
     * Renvoie l'entier qui représente le numéro d'étudiant.
     *
     * Exemple : si s=1, aa=0, mm=1 et xxx=0, alors la méthode doit renvoyer
     * l'entier 10001000
     */
    private int toInteger() {
        /* A COMPLETER */
        return -1;
    }

    /**
     * Fonction de hachage 1
     */
    public int hashCodeInt() {
        /* A COMPLETER */
        return -1;
    }

    /**
     * Fonction de hachage 2
     */
    public int hashCodeUniform(int m) {
        /* A COMPLETER */
        return -1;
    }

    /**
     * Fonction de hachage 3
     */
    public int hashCodeMod(int m) {
        /* A COMPLETER */
        return -1;
    }

    /**
     * Fonction de hachage 4
     */
    public int hashCodeGold(int m) {
        /* A COMPLETER */
        return -1;
    }

    /**
     * Redéfinition de la méthode equals pour qu'elle corresponde à l'égalité
     * structurelle (c'est-à-dire, ici : equals retourne true si et seulement si
     * elle compare deux instances de NoEtud contenant la même séquence de
     * chiffres).
     * 
     * Remarque : pour deux objets "égaux" selon la méthode equals, il faut
     * s'assurer que la méthode hashCode retourne la même valeur.
     * 
     * Pour plus d'info : https://cs108.epfl.ch/archive/16/c/CSET/CSET-notes.html
     */
    @Override
    public boolean equals(Object n) {
        return this.toInteger() == ((NoEtud) n).toInteger();
    }

    /**
     * Redéfinition de la méthode hashCode
     */
    @Override
    public int hashCode() {
        /* A COMPLETER */
        return -1;
    }

    /**
     * Teste l’implémentation
     */
    public static void testImplementation() {
        int score = 0;
        int nTests = 0;

        System.out.println("Test NoEtud:");

        // Test 1
        nTests++;
        NoEtud etud1 = new NoEtud(1, 9, 3, 111);
        if (etud1.toString().equals("1 09 03 111")) {
            System.out.println("\t- test  1: pass");
            score++;
        } else {
            System.out.println("\t- test  1: fail");
        }

        // Test 2
        nTests++;
        NoEtud etud2 = new NoEtud(5, 9, 3, 111);
        if (etud2.toString().equals("2 15 01 000")) {
            System.out.println("\t- test  2: pass");
            score++;
        } else {
            System.out.println("\t- test  2: fail");
        }

        // Test 3
        nTests++;
        NoEtud etud3 = new NoEtud(1, 9, 15, 999);
        if (etud3.toString().equals("2 15 01 000")) {
            System.out.println("\t- test  3: pass");
            score++;
        } else {
            System.out.println("\t- test  3: fail");
        }

        // Test 4
        nTests++;
        NoEtud etud4 = new NoEtud(1, 9, 12, 1982);
        if (etud4.toString().equals("2 15 01 000")) {
            System.out.println("\t- test  4: pass");
            score++;
        } else {
            System.out.println("\t- test  4: fail");
        }

        // Test 5
        nTests++;
        NoEtud etud5 = new NoEtud(10003123);
        if (etud5.toString().equals("1 00 03 123")) {
            System.out.println("\t- test  5: pass");
            score++;
        } else {
            System.out.println("\t- test  5: fail");
        }

        // Test 6
        nTests++;
        NoEtud etud6 = new NoEtud(10000123);
        if (etud6.toString().equals("1 00 01 000")) {
            System.out.println("\t- test  6: pass");
            score++;
        } else {
            System.out.println("\t- test  6: fail");
        }

        // Test 7
        nTests++;
        if (etud1.toInteger() == 10903111) {
            System.out.println("\t- test  7: pass");
            score++;
        } else {
            System.out.println("\t- test  7: fail");
        }

        // Test 8
        nTests++;
        if (etud2.toInteger() == 21501000) {
            System.out.println("\t- test  8: pass");
            score++;
        } else {
            System.out.println("\t- test  8: fail");
        }

        // Test 9
        nTests++;
        if (etud2.hashCodeInt() == 21501000) {
            System.out.println("\t- test  9: pass");
            score++;
        } else {
            System.out.println("\t- test  9: fail");
        }

        // Test 10
        nTests++;
        if (etud2.hashCodeUniform(2) == 43002000) {
            System.out.println("\t- test 10: pass");
            score++;
        } else {
            System.out.println("\t- test 10: fail");
        }

        // Test 11
        nTests++;
        if (etud5.hashCodeUniform(1) == 10003123) {
            System.out.println("\t- test 11: pass");
            score++;
        } else {
            System.out.println("\t- test 11: fail");
        }

        // Test 12
        nTests++;
        if (etud1.hashCodeMod(100) == 11) {
            System.out.println("\t- test 12: pass");
            score++;
        } else {
            System.out.println("\t- test 12: fail");
        }

        // Test 13
        nTests++;
        if (etud5.hashCodeMod(100) == 23) {
            System.out.println("\t- test 13: pass");
            score++;
        } else {
            System.out.println("\t- test 13: fail");
        }

        // Test 14
        nTests++;
        if (etud1.hashCodeGold(77) == 13) {
            System.out.println("\t- test 14: pass");
            score++;
        } else {
            System.out.println("\t- test 14: fail");
        }

        // Test 15
        nTests++;
        if (etud5.hashCodeGold(77) == 0) {
            System.out.println("\t- test 15: pass");
            score++;
        } else {
            System.out.println("\t- test 15: fail");
        }

        System.out.println("Score " + score + "/" + nTests);
    }

    public static void main(String[] args) {
        testImplementation();
    }
}
