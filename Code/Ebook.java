package Code;

public class Ebook extends Risorsa{
    private String formato;
    //costruttore
    public Ebook(String titolo, int annoPubblicazione, String codice, String formato) {
        super(titolo, annoPubblicazione, codice);
        this.formato = formato;
    }
    //getter e setter
    public String getFormato() {
        return formato;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }

    //override stampa risorsa
    @Override
    public void visualizzaDettagli() {
        System.out.println("Titolo: " + this.getTitolo() + " Anno: " + this.getAnnoPubblicazione() + " Codice: " + this.getCodice() + " Formato: " + this.getFormato() + " Disponibile: " + this.isDisponibile());
    }
    
}
