public class Frazione implements Operando
{
    //Attributi
    private int numeratore;
    public int denominatore;

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
        System.out.println(this.numeratore + "/" + this.denominatore);
    }

    @Override
    public double calcola()
    {
        return this.numeratore / this.denominatore;
    }

    @Override
    public String toString()
    {
        return " " + this.numeratore + "\n" + "____" + "\n" + " " + this.denominatore;
    }

    //funzioni cancro
    public int trovaBaseComue(Frazione f1, Frazione f2)
    {
        int[] numeri = {2,3,5,7,11};
        int denC = 0;

        //Controlli che mi hanno fatto impazzire
        if(f1.denominatore%f2.denominatore==0)
        {
            denC = f1.denominatore;
        }else if(f2.denominatore%f1.denominatore==0)
        {
            denC = f2.denominatore;
        }else//Se non sonno contenibili uno nell'altro fa questo casino, spro sia corretto
        {
            int mag, min;//Trovo il maggiroe dei due per poterlo moltpliccare e capire wquak'è il coso comune
            if(f1.denominatore > f2.denominatore)
            {
                mag = f1.denominatore;
                min = f2.denominatore;
            }
            else
            {
                mag = f2.denominatore;
                min = f1.denominatore;
            }
            int i = 0;

            while(denC == 0 && i < numeri.length)
            {
                if((mag*i)%min==0)
                {
                    denC = mag*i;
                }
                i++;
            }

            if(denC == 0)
            {
                System.out.println("Il denomeratore comune era troppo alto. \nTi supplico cambia i denominatori sennò il mio programma piange");
            }
        }
        //o è uno dei due se è divisibile per l'altro OPPURE un multiplo di entrambi

        return denC;
    }

    public Frazione semplifica(Frazione f)
    {
        int i = 2;
        while(i < 20) //20 perché mi sembra abbastanza grande, se non dovesse bastare, mi dispiace ma non è un mio problema (lo è perchè mi ssi abbassa il voto, però dettagli...)
        {
            if(f.numeratore%i==0 && f.denominatore%i==0)
            {
                f.numeratore = f.numeratore/i;
                f.denominatore = f.denominatore/i;
            }
        }
        return f;
    }

    public Frazione inversione(Frazione f) //Yokoso, sakasama sekai ni
    {
        try
        {
            Frazione ff = new Frazione(f.denominatore, f.numeratore);
            return ff;
        }catch(DenominatoreNulloException e)
        {
            System.out.println("Errore" + e.getMessage());
        }

        return null;
    }

    public void somma(Frazione f2) throws DenominatoreNulloException
    {

        Frazione f3;

        int numF;
        int denC = trovaBaseComue(this, f2);


        numF = ((denC/this.denominatore)*this.numeratore) + ((denC/f2.denominatore)*f2.numeratore);

        f3 = new Frazione(numF, denC);
        semplifica(f3);
        f3.stampa();
    }

    public void sottrazione(Frazione f2) throws DenominatoreNulloException
    {
        Frazione f3;
        int numF;
        int denC = trovaBaseComue(this, f2);

        numF = ((denC/this.denominatore)*this.numeratore) - ((denC/f2.denominatore)*f2.numeratore);

        f3 = new Frazione(numF, denC);
        semplifica(f3);
        f3.stampa();
    }

    public void moltiplicazione(Frazione f2)  throws DenominatoreNulloException
    {
        int num = this.numeratore * f2.numeratore;
        int den= this.denominatore *  f2.denominatore;

        Frazione f3 = new Frazione(num, den);
        semplifica(f3);
        f3.stampa();
    }

    public void divisione(Frazione f2) throws DenominatoreNulloException
    {
        f2 = inversione(f2);

        int num = this.numeratore * f2.numeratore;
        int den= this.denominatore *  f2.denominatore;


        Frazione f3 = new Frazione(num, den);
        semplifica(f3);
        f3.stampa();
    }
}
