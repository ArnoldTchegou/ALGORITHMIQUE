
/**
 * TP4: Algorithmes de tri
 */
import java.util.Random;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.PrintWriter;

/**
 * Classe utilisée pour l'évaluation du temps d'exécution des algorithmes de tri
 */
public class Timer {
    private long start;

    /**
     * Constructeur (il initialise start)
     */
    public Timer() {
        start = System.nanoTime();
    }

    /**
     * Reinitialise start
     */
    public void reset() {
        start = System.nanoTime();
    }

    /**
     * Renvoie le temps écoulé depuis start (en nanosecondes)
     */
    public long elapsed() {
        return System.nanoTime() - start;
    }

    /**
     * Évalue les performance du tri passé en paramètre et écrit les résultats dans
     * le fichier 'fname'
     */
    public static void performanceTri(Consumer<int[]> tri, String fname) {
        Random rng = new Random();
        Timer timer = new Timer();
        int nReps = 10; // On répète le tri nReps fois
        int [] ns = IntStream.range(1, 100).map(x -> x * 1000).toArray(); // Tailles du tableau à trier : de 1000 à 100 000 (de 1000 en 1000). N'hésitez pas à modifier.
        double[] ts = new double[ns.length]; // Temps d'exécution (en millisecondes)
        for (int curr = 0; curr < ns.length; ++curr) {
            int[] tableau = new int[ns[curr]];
            long elapsed = 0;
            for (int rep = 0; rep < nReps; ++rep) {
                // On remplit le tableau avec des entiers aléatoires
                for (int i = 0; i < ns[curr]; ++i)
                    tableau[i] = rng.nextInt();
                // On trie le tableau
                timer.reset();
                tri.accept(tableau);
                elapsed += timer.elapsed(); // On mesure le temps d'exécution
            }
            ts[curr] = elapsed / 1e6; // Temps en millisecondes
        }
        for (int curr = 0; curr < ns.length; ++curr) {
            System.out.println("n = " + ns[curr] + " t = " + ts[curr]);
        }

        try (PrintWriter writer = new PrintWriter(fname)) {
            /*
             * A COMPLETER : écrire 'ns' et 'ts' dans le fichier (utiliser writer.write()),
             * en respectant le format de l'utilitaire choisi pour générer les graphiques.
             */
        } catch (Exception e) {
            System.out.println("Impossible d'ouvrir le fichier '" + fname + "'!");
        }

    }

    public static void main(String[] args) {
        System.out.println("**** Timing triBulles:");
        performanceTri(Tri::triBulles, "triBulles.dat");
        System.out.println("**** Timing triInsertion:");
        performanceTri(Tri::triInsertion, "triInsertion.dat");
        System.out.println("**** Timing triFusion:");
        performanceTri(Tri::triFusion, "triFusion.dat");
        System.out.println("**** Timing Arrays.sort:");
        performanceTri(Arrays::sort, "arraysSort.dat");
    }
}
