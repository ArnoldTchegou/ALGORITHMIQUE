/*
 * Codage de l'algorithme pour evaluation d'expressions en forme Polonaise
 * inverse.
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.NoSuchElementException;


public class Polonaise {
    String[] expression;

    /**
     * Constructeur qui initialise l'attribut en utilisant l'argument
     */
    public Polonaise(String arg) {
        this.expression = arg.split(" ");
    }

    /**
     * Retourne une representation de l'expression sous forme de chaine de
     * caracteres
     */
    public String toString() {
        String s = "";
        int i = 0;
        while(this.expression.length>i){
            s += this.expression[i]+" ";
        }
        return s;
    }
    public boolean isInteger(String s){
        try{
           Integer.valueOf(s);
        }
        catch (NumberFormatException ex){
            return false;
        }
        return true;
    }

    /**
     * Evaluation de l'expression en forme polonaise.
     * @return valeur de l'expression ou null
     */
    public Integer eval() {
        Integer a, b;
        int longueur = this.expression.length;
        int i = 0;
        int j = i + 1;
        int k = j + 1;
        Integer result = 0;
        if((j>=longueur)){
            return null;
        }
        while((longueur>i)&&(longueur>j)&&(longueur>k)){
            if(this.isInteger(this.expression[i])==true&&this.isInteger(this.expression[j])){
                a = Integer.valueOf(this.expression[i]);
                b = Integer.valueOf(this.expression[j]);
            }
            else{
                return null;
            }
            String op = this.expression[k];
            if(op.equals("*")){
                result =  a*b;
            } 
            else if(op.equals("+")){
                result = a+b;
            }
            else if(op.equals("-")){
                result = a-b;
            }
            else if(op.equals("/")){
                result = a/b;
            }
            else{
                result = null;
            }
            this.expression[k] = Integer.toString(result);
            i = k;
            j = i + 1;
            k = j + 1;
        }
        return result;
    }

    /**
     * Teste l'algorithme
     */
    public static void testPolonaise() {
        String[] expressions = {
            "10 7 -", "", "2 3 + 5 *", "2 2 * 2 /", "5 5 / 1 -",
            "10 * /", "/ 10 1", "87 7 - 2 / 4 /", "1 1 *", "a b +"
        };
        Integer[] expected = {
            3, null, 25, 2, 0,
            null, null, 10, 1, null
        };

        System.out.println("**** Test:");
        int nbTests = expressions.length;
        int score = 0;
        for (int i = 0; i < nbTests; i++) {
            Polonaise p = new Polonaise(expressions[i]);
            Integer result = p.eval();
            if (result == expected[i]) {
                System.out.println("Test " + i + " passed!");
                score++;
            } else {
                System.out.println("Test " + i + " failed with " + result + " != " + expected[i]);
            }
        }
        System.out.println("**** Final score: " + score + "/" + nbTests);
    }

    public static void main(String[] args) {
        testPolonaise();
    }
}
