import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        /*Step by step
        * Chiedi frazione in input
        * Fa controllo validità con l'eccezione (usa try catch)
        * Usa metodi di stampa e toString per mostrare il valore (tramite calcola)
        * Aspettare corerzione del prof e sperare di essere andato bene*/

        Scanner sc = new Scanner(System.in);
        int num, den;

        System.out.println("Inserrie valore del numeratore: ");
        num = sc.nextInt();
        System.out.println("Inserrie valore del denominatore: ");
        den = sc.nextInt();

        try
        {
            Frazione fr =  new Frazione(num, den);

        }catch(DenominatoreNulloException e)
        {
            System.out.println("Errore" + e.getMessage());
        }





    }
}