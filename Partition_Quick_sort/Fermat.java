public class Fermat{
    public static int Test(double nbits){
        int  n = (int) Math.pow(2.0, nbits);
        System.out.println(n);
        double N = n/Math.log(n);
        System.out.println(N);
        int somme = 0;
        int cmpt = 1;
        int count1 = 0;
        double count2 = 0.0;
        double p = 0.01;
        while(p>=0.005){
            //System.out.println(premier);
            int stop =0;
            while(stop!=1){
                int  premier =(int) ((Math.random()*(n-1)));
                while(premier%2!=1){
                    count1 += 1;
                    premier = (int) ((Math.random()*(n-1)));
                    System.out.println(premier);                 
                }
                if(Math.pow(premier, n-1)%n==1){
                    stop = 1;
                }
                else{
                    count2 += 1;
                }
            }
            somme +=count1;
            cmpt += 1;
            p = count2/N;
            System.out.println(p);
        }
        return somme/cmpt;
    }
    public static void main(String[] args){
        System.out.println(Fermat.Test(3.0));
    }
}