public class Frazione implements Operando
{
    //Attributi
    private int numeratore;
    private int denominatore;

    //Costruttori
    //Maidenless
    public Frazione() {}

    //Questo invece li ha
    public Frazione(int num, int den) throws DenominatoreNulloException
    {
        if(den == 0)
        {
            throw new DenominatoreNulloException("Non si può dividere per 0, tornatene alle elementari!");
        }
        numeratore = num;
        denominatore = den;

    }

    @Override
    public void stampa()
    {


    }

    @Override
    public double calcola()
    {
        return 0;
    }

    @Override
    public String toString()
    {
        return "Frazione";
    }
}
