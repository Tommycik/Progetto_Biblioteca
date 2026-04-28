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
     for(Risorsa risorsaRisorsa : listaRisorsa){
         if(listaRisorsa.getCodice().equalsCaseIgnore(risorsaRisorsa.getCodice)){
             System.out.println("Esiste già una risorsa con questo Codice: "+risorsaRisorsa.getCodice());
             return;// esci dal metodo
         }
     }
     System.out.println("Risorsa Aggiunta");
     listaRisorsa.add(risorsa);
    }

    public void inserisciUtente(Utente utente){
        this.listaUtenti.add(utente);
    }


    public void stampaInventario(){
        for (Risorsa risorsa : listaRisorsa){
           risorsa.visualizzaDettagli();
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
