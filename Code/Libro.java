package Code;
public class Libro extends Risorsa{
    private String autore;
    //costruttore
    public Libro(String titolo, int annoPubblicazione, String codice, String autore) {
        super(titolo, annoPubblicazione, codice);
        this.autore = autore;
    }
    //getter e setter
    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    //override stampa risorsa
    @Override
    public void visualizzaDettagli() {
        System.out.println("Titolo: " + this.getTitolo() + " Anno: " + this.getAnnoPubblicazione() + " Codice: " + this.getCodice() + " Autore: " + this.getAutore());
    }
    
}
