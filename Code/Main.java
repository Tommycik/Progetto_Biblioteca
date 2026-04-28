package Code;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Creazione Biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca di napoli");
        // Creazione Scanner
        Scanner in = new Scanner(System.in);
        // Creazione Utente e registrazione di rpova
        System.out.println("--- Registrazione Nuovo Utente ---");
        System.out.print("Inserisci il nome: ");
        String nome = in.nextLine();
        System.out.print("Inserisci l'ID Utente: ");
        String id = in.nextLine();
        Risorsa risorsa = new Libro("Il libro di Napoli", 2021, "123456789", "Napoleone Bonaparte");
        Utente utente = new Utente(nome, id);
        biblioteca.inserisciUtente(utente);
        biblioteca.inserisciRisorsa(risorsa);
        while (true) {// 2. Menu per inserire una risorsa
            System.out.println("\n--- Menu ---");
            System.out.println("1. Aggiungi Utente");
            System.out.println("2. Aggiungi Risorsa");
            System.out.println("3. Stampa Inventario");
            System.out.println("4. Prendi in prestito una risorsa: ");
            System.out.println("5. Resituisci una risorsa: ");
            System.out.println("6. Stampa risorse utente: ");
            System.out.println("7. Cerca risorsa: ");
            System.out.println("8. Stampa utenti: ");
            System.out.println("9. Esci");

            int scelta = in.nextInt();
            in.nextLine();
            String idUtente;
            Utente utenteAttivo = null;
            Risorsa risorsaTrovata = null;
            ArrayList<Risorsa> risorse = null;
            String nomeRisorsa = null;
            switch (scelta) {
                case 1:
                    // 1. Aggiungi Utente
                    System.out.print("Inserisci il nome dell'utente: ");
                    String nomeUtente = in.nextLine();
                    System.out.print("Inserisci l'ID dell'utente: ");
                    idUtente = in.nextLine();
                    Utente nuovoUtente = new Utente(nomeUtente, idUtente);
                    biblioteca.inserisciUtente(nuovoUtente);
                    break;

                case 2:
                    System.out.print("Inserisci il titolo: ");
                    String titolo = in.nextLine();
                    System.out.print("Inserisci l'anno di pubblicazione: ");
                    int anno = in.nextInt();
                    in.nextLine(); 
                    System.out.print("Inserisci il codice: ");
                    String codice = in.nextLine();


                    System.out.println("Che tipo di risorsa vuoi inserire?");
                    System.out.println("1. Libro");
                    System.out.println("2. Ebook");
                    System.out.println("3. Rivista");
                    int tipo = in.nextInt();
                    in.nextLine();

                    Risorsa nuovaRisorsa = null;
                    switch (tipo) {
                        case 1:
                            System.out.print("Inserisci l'autore: ");
                            String autore = in.nextLine();
                            nuovaRisorsa = new Libro(titolo, anno, codice, autore);
                            break;
                        case 2:
                            System.out.print("Inserisci il formato (PDF/EPUB): ");
                            String formato = in.nextLine();
                            nuovaRisorsa = new Ebook(titolo, anno, codice, formato);
                            break;
                        case 3:
                            System.out.print("Inserisci il numero della rivista: ");
                            int num = in.nextInt();
                            in.nextLine();
                            nuovaRisorsa = new Rivista(titolo, anno, codice, num);
                            break;
                        default:
                            System.out.println("Tipo non valido.");
                            break;
                    }

                    if (nuovaRisorsa != null) {
                        biblioteca.inserisciRisorsa(nuovaRisorsa);
                    }
                    break;

                case 3:
                    // 3. Stampa Inventario
                    biblioteca.stampaInventario();
                    break;
                case 4:
                    //mostrare risorse disponibili
                    if (biblioteca.getListaRisorse().isEmpty()) {
                        System.out.println("Nessuna risorsa disponibile");
                        break;
                    }

                    // mostra utenti
                    if (biblioteca.getListaUtenti().isEmpty()) {
                        System.out.println("Nessun utente presente");
                        break;
                    }

                    System.out.println("Utenti presenti:");
                    for (Utente u : biblioteca.getListaUtenti()) {
                        System.out.println("Id: " + u.getIdUtente() + " Nome: " + u.getNome());
                    }

                    // scegli utente
                    System.out.print("Inserisci l'ID dell'utente: ");
                    idUtente = in.nextLine();
                    utenteAttivo = biblioteca.cercaUtentePerId(idUtente);
                    if (utente == null) {
                        System.out.println("Utente non trovato");
                        break;
                    }
                    // controlla se ci sono risorse disponibili
                    System.out.println("Risorse disponibili:");
                    for (Risorsa ris : biblioteca.getListaRisorse()) {
                        if (ris.isDisponibile()) {
                            ris.visualizzaDettagli();
                        }
                    }
                    risorsaTrovata = null;
                    // 4. Prendi in prestito una risorsa con nome
                    System.out.print("Inserisci il nome della risorsa: ");
                    nomeRisorsa = in.nextLine();
                    risorse = biblioteca.cercaRisorsaPerTitolo(nomeRisorsa);
                    if (risorse.size() == 0) {
                        System.out.println("Risorsa non trovata");
                        break;
                    } else if (risorse.size() > 1) {
                        // Scelta tra le risorse trovate
                        System.out.println("Scegli una risorsa: ");
                        for (int i = 0; i < risorse.size(); i++) {
                            System.out.println(i + ": ");
                            risorse.get(i).visualizzaDettagli();
                        }

                        System.out.print("Inserisci codice della risorsa: ");
                        String codiceRisorsa = in.nextLine();
                        for (Risorsa ris : risorse) {
                            if (ris.getCodice().equalsIgnoreCase(codiceRisorsa)) {
                                risorsaTrovata = ris;
                                break;
                            }
                        }
                        // controlla se la risorsa è stata trovata
                        if(risorsaTrovata==null){
                            System.out.println("Risorsa non trovata");
                            break;
                        }
                        utenteAttivo.prendiInPrestito(risorsaTrovata);
                        System.out.println("Risorsa Prenotata");
                    } else {
                        risorsaTrovata = risorse.get(0);
                        utenteAttivo.prendiInPrestito(risorsaTrovata);
                        System.out.println("Risorsa Prenotata");
                    }
                    break;
                case 5:
                    // 5. Resituisci una risorsa
                    // mostra utenti
                    if (biblioteca.getListaUtenti().isEmpty()) {
                        System.out.println("Nessun utente presente");
                        break;
                    }
                    System.out.println("Utenti presenti:");
                    for (Utente u : biblioteca.getListaUtenti()) {
                        System.out.println("Id: " + u.getIdUtente() + " Nome: " + u.getNome());
                    }

                    // scegli utente
                    System.out.print("Inserisci l'ID dell'utente: ");
                    idUtente = in.nextLine();
                    utenteAttivo = biblioteca.cercaUtentePerId(idUtente);
                    // controlla se l'utente esiste
                    if (utenteAttivo == null) {
                        System.out.println("Utente non trovato");
                        break;
                    }
                    // controlla se ci sono risorse in prestito
                    if (utenteAttivo.getRisorseInPrestito().isEmpty()) {
                        System.out.println("Nessuna risorsa in prestito");
                        break;
                    }
                    // stampa lista risorse utente
                    System.out.println("Risorse prese in prestito:");
                    utenteAttivo.stampaRisorse();
                    // sceglie una risorsa
                    System.out.print("Inserisci il codice della risorsa: ");
                    String codiceRisorsa = in.nextLine();
                    // controlla se la risorsa esiste
                    for (Risorsa ris : utenteAttivo.getRisorseInPrestito()) {
                        if (ris.getCodice().equalsIgnoreCase(codiceRisorsa)) {
                            risorsaTrovata = ris;
                            break;
                        }
                    }
                    //controlla se la risorsa è stata trovata
                    if (risorsaTrovata == null) {
                        System.out.println("Risorsa non trovata");
                        break;
                    }
                    utenteAttivo.restituisciRisorsa(risorsaTrovata);
                    System.out.println("Risorsa restituita");
                    break;
                case 6:
                    // 6. Stampa risorse utente scelto
                    // mostra utenti
                    if (biblioteca.getListaUtenti().isEmpty()) {
                        System.out.println("Nessun utente presente");
                        break;
                    }
                    System.out.println("Utenti presenti:");
                    for (Utente u : biblioteca.getListaUtenti()) {
                        System.out.println("Id: " + u.getIdUtente() + " Nome: " + u.getNome());
                    }

                    // scegli utente
                    System.out.print("Inserisci l'ID dell'utente: ");
                    idUtente = in.nextLine();
                    utenteAttivo = biblioteca.cercaUtentePerId(idUtente);
                    // controlla se l'utente esiste
                    if (utenteAttivo == null) {
                        System.out.println("Utente non trovato");
                        break;
                    }
                    // stampa lista risorse utente
                    System.out.println("Risorse prese in prestito:");
                    utenteAttivo.stampaRisorse();
                    break;
                case 7:
                    // 7. Cerca risorsa
                    System.out.print("Inserisci il nome della risorsa: ");
                    nomeRisorsa = in.nextLine();
                    risorse = biblioteca.cercaRisorsaPerTitolo(nomeRisorsa);
                    if (risorse.size() == 0) {
                        System.out.println("Risorsa non trovata");
                        break;
                    } else {
                        for (Risorsa ris : risorse) {
                            ris.visualizzaDettagli();
                        }
                    }
                    break;
                case 8:
                    // 8. Stampa utenti
                    if(biblioteca.getListaUtenti().isEmpty()){
                        System.out.println("Nessun utente presente");
                        break;
                    }else{
                        ArrayList<Utente> utenti = biblioteca.getListaUtenti();
                        for(Utente u : utenti){
                            System.out.println("Id: "+u.getIdUtente()+" Nome: "+u.getNome());
                        }
                    }
                    break;
                    
                case 9:
                    // 6. Esci
                    System.out.println("Arrivederci");
                    return;
                default:
                    // Scelta non valida
                    System.out.println("Scelta non valida");
                    break;
            }
        }
    }
}
