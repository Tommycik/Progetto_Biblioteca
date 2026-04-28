package Code;

import java.util.ArrayList;

public class Biblioteca {
    private String nomeBiblioteca;// nome della Biblioteca
    private ArrayList<Risorsa>listaRisorsa;//Lista della risorsa
    private ArrayList<Utente>listaUtenti;//Lista degli

    public Biblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
        this.listaRisorsa = new ArrayList<>();
        this.listaUtenti = new ArrayList<>();
    }

    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }

    public void setNomeBiblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
    }

    public ArrayList<Risorsa> getListaRisorsa() {
        return listaRisorsa;
    }

    public ArrayList<Utente> getListaUtenti() {
        return listaUtenti;
    }

    public void setListaUtenti(ArrayList<Utente> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }

    public void setListaRisorsa(ArrayList<Risorsa> listaRisorsa) {
        this.listaRisorsa = listaRisorsa;
    }

       public void inserisciRisorsa(Risorsa risorsa){
        for(Risorsa ris : listaRisorsa){
            if(ris.getCodice().toLowerCase().equals(risorsa.getCodice().toLowerCase())){
                System.out.println("Esiste già una risorsa con questo Codice: "+ris.getCodice());
                return;// esci dal metodo
            }
     }
     System.out.println("Risorsa Aggiunta");
     listaRisorsa.add(risorsa);
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
        if(!listaRisorsa.isEmpty()) {// se non la lista non è vuota stampa i dettagli
            for (Risorsa risorsa : listaRisorsa) {
                risorsa.visualizzaDettagli();
            }
        }else{//Altrimenti stampa il messaggio di errore
            System.out.println("Errore: Non ci sono Risorse inserisci almeno una risorsa!");
        }
        
    }

    public ArrayList<Risorsa> cercaRisorsaPerTitolo(String titolo){
       ArrayList<Risorsa> risorsaTrovata = new ArrayList<>();
        for (Risorsa risorsa : listaRisorsa){
            if(risorsa.getTitolo().equalsIgnoreCase(titolo)){
                risorsaTrovata.add(risorsa);
            }
        }
        return risorsaTrovata;
    }


}
