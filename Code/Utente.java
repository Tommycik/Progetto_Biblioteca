package Code;

import java.util.ArrayList;

public class Utente { // classe Utente
    private String nome;
    private String idUtente;
    protected ArrayList<Risorsa> risorseInPrestito;

    public Utente(String nome, String idUtente) { // costruttore
        this.nome = nome;
        this.idUtente = idUtente;
        this.risorseInPrestito = new ArrayList<>();
    }
    // getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(String idUtente) {
        this.idUtente = idUtente;
    }
    public ArrayList<Risorsa> getRisorseInPrestito() {
        return risorseInPrestito;
    }
    // Metodo per prendere in prestito
    public void prendiInPrestito(Risorsa r) {
        risorseInPrestito.add(r);
        r.setDisponibile(false);
    }

    // Metodo per restituire
    public void restituisciRisorsa(Risorsa r) {
        risorseInPrestito.remove(r);
        r.setDisponibile(true);
    }

    // Metodo per stampare la lista
    public void stampaRisorse() {
        System.out.println("Risorse di " + nome + ":");
        for (Risorsa r : risorseInPrestito) {
            System.out.println("Titolo: " + r.getTitolo() + " Codice: " + r.getCodice());
        }
    }
}