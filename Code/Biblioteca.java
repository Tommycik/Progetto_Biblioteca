package Code;

import java.util.ArrayList;

public class Biblioteca {
    private String nomeBiblioteca;// nome della Biblioteca
    private ArrayList<Risorsa>listaRisorse;//Lista della risorsa
    private ArrayList<Utente>listaUtenti;//Lista degli

    public Biblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
        this.listaRisorse = new ArrayList<>();
        this.listaUtenti = new ArrayList<>();
    }

    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }

    public void setNomeBiblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
    }

    public ArrayList<Risorsa> getListaRisorse() {
        return listaRisorse;
    }

    public ArrayList<Utente> getListaUtenti() {
        return listaUtenti;
    }

    public void setListaUtenti(ArrayList<Utente> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }

    public void setListaRisorse(ArrayList<Risorsa> listaRisorse) {
        this.listaRisorse = listaRisorse;
    }

       public void inserisciRisorsa(Risorsa risorsa){
        for(Risorsa ris : listaRisorse){
            if(ris.getCodice().toLowerCase().equals(risorsa.getCodice().toLowerCase())){
                System.out.println("Esiste già una risorsa con questo Codice: "+ris.getCodice());
                return;// esci dal metodo
            }
     }
     System.out.println("Risorsa Aggiunta");
     listaRisorse.add(risorsa);
    }


     public void inserisciUtente(Utente nuovoUtente){
        for(Utente utente : listaUtenti){
            if(utente.getIdUtente().toLowerCase().equals(nuovoUtente.getIdUtente().toLowerCase())){
                System.out.println("Esiste già un utente con questo Codice: "+utente.getIdUtente());
                return;// esci dal metodo
            }
        }
        System.out.println("Utente Aggiunta");
        listaUtenti.add(nuovoUtente);
    }


    public void stampaInventario(){
        if(!listaRisorse.isEmpty()) {// se non la lista non è vuota stampa i dettagli
            for (Risorsa risorsa : listaRisorse) {
                risorsa.visualizzaDettagli();
            }
        }else{//Altrimenti stampa il messaggio di errore
            System.out.println("Nessuna risorsa all'interno della biblioteca");
        }
        
    }

    public ArrayList<Risorsa> cercaRisorsaPerTitolo(String titolo){
       ArrayList<Risorsa> risorseTrovate = new ArrayList<>();
        for (Risorsa risorsa : listaRisorse){
            if(risorsa.getTitolo().equalsIgnoreCase(titolo)){
                risorseTrovate.add(risorsa);
            }
        }
        return risorseTrovate;
    }


}
