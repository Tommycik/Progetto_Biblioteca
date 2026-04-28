package Code;

public class Rivista extends Risorsa{
    private int numero;
    //costruttore
    public Rivista(String titolo, int annoPubblicazione, String codice, int numero) {
        super(titolo, annoPubblicazione, codice);
        this.numero = numero;
    }
    //getter e setter
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    //override stampa risorsa
    @Override
    public void visualizzaDettagli() {
        System.out.println("Titolo: " + this.getTitolo() + " Anno: " + this.getAnnoPubblicazione() + " Codice: " + this.getCodice() + " Numero: " + this.getNumero() + " Disponibile: " + this.isDisponibile());
    }

    
}
