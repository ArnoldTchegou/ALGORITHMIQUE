import java.util.Arrays;
public class Partition{
    public static int echange(int[] tab, int m, int n){
        int a = tab[m];
        tab[m] = tab[n];
        tab[n] = a;
        return a;
    }
    public static int partiton(int[] tab, int min, int max){
        if(min<0||min>tab.length||max<0||max>tab.length){
            return 0;
        }
        int k = (int) ((Math.random()*(max - min))+min);
        int pivot = echange(tab, k, max);
        int i = min;
        int j = max;
        int tmp = 0;
        while(i<j){
            while(tab[i]<pivot){
                i = i +1;
            }
            while(tab[j]>=pivot&&j>0){
                j = j-1;
            }
            tmp = echange(tab, i, j);
        }
        tab[j] = tab[i];
        tab[i] = tab[max];
        tab[max] =  tmp;
        return i;
    }
    public static void Tri_rapide(int[] tab, int min, int max){
        int i;
        if(min<max){
            i = partiton(tab, min, max);
            Tri_rapide(tab, min, i);
            Tri_rapide(tab, i+1, max);
        }
    }
    public static void main(String[] args){
        int[] tab = {3,8,0,5,1,11,6};
        System.out.println(Arrays.toString(tab));
        Partition.Tri_rapide(tab, 0, tab.length-1);
        System.out.println(Arrays.toString(tab));
    }
}