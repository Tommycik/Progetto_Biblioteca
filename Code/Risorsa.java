package Code;
public abstract class Risorsa {
    private String titolo;
    private int annoPubblicazione;
    private String codice;
    private boolean disponibile = true;
    //costruttore
    public Risorsa(String titolo, int annoPubblicazione, String codice) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.codice = codice;
    }
    //getter e setter
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getCodice() {
        return codice;
    }

    //stampa risorsa
    public void visualizzaDettagli(){
        System.out.println("Titolo: " + this.titolo + " Anno: " + this.annoPubblicazione + " Codice: " + this.codice + " Disponibile: " + this.disponibile);
    }
    
}
