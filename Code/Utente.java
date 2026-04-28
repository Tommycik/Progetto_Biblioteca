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

    // Metodo per prendere in prestito
    public void prendiInPrestito(Risorsa r) {
        risorseInPrestito.add(r);
    }

    // Metodo per restituire
    public void restituisciRisorsa(Risorsa r) {
        risorseInPrestito.remove(r);
    }

    // Metodo per stampare la lista
    public void stampaRisorse() {
        System.out.println("Risorse di " + nome + ":");
        for (Risorsa r : risorseInPrestito) {
            System.out.println("- " + r.getTitolo()); 
        }
    }
}