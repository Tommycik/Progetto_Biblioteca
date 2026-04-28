package Code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca di napoli");
        Scanner in = new Scanner(System.in);

        // 1. Creazione Utente e registrazione
        System.out.println("--- Registrazione Nuovo Utente ---");
        System.out.print("Inserisci il nome: ");
        String nome = in.nextLine();
        System.out.print("Inserisci l'ID Utente: ");
        String id = in.nextLine();
        Risorsa risorsa= new Libro("Il libro di Napoli", 2021, "123456789", "Napoleone Bonaparte");
        Utente utente = new Utente(nome, id);
        biblioteca.inserisciUtente(utente);
        biblioteca.inserisciRisorsa(risorsa);
        while(true){// 2. Menu per inserire una risorsa
            System.out.println("\n--- Menu ---");
            System.out.println("1. Aggiungi Utente");
            System.out.println("2. Aggiungi Risorsa");
            System.out.println("3. Stampa Inventario");
            System.out.println("4. Prendi in prestito una risorsa: ");
            System.out.println("5. Esci");

            int scelta = in.nextInt();
            in.nextLine(); 
            String idUtente;
            switch (scelta) {
                case 1:
                    System.out.print("Inserisci il nome dell'utente: ");
                    String nomeUtente = in.nextLine();
                    System.out.print("Inserisci l'ID dell'utente: ");
                    idUtente = in.nextLine();
                    Utente nuovoUtente = new Utente(nomeUtente, idUtente);

                case 2:
                     // 2. Aggiungi Risorsa
                    /*System.out.print("Inserisci il titolo della risorsa: ");
                    String titolo = in.nextLine();
                    System.out.print("Inserisci l'autore della risorsa: ");
                    String autore = in.nextLine();
                    System.out.print("Inserisci l'anno di pubblicazione: ");
                    int anno = in.nextInt();
                    in.nextLine(); 
                    Risorsa nuovaRisorsa = new Risorsa(titolo, autore, anno);
                    biblioteca.inserisciRisorsa(nuovaRisorsa);
                    System.out.println("Risorsa aggiunta con successo");
                    break;*/
                
                case 3:
                    // 3. Stampa Inventario
                    biblioteca.stampaInventario();
                    break;
                case 4:
                    //mostrare risorse disponibili
                    if(biblioteca.getListaRisorse().isEmpty()){
                        System.out.println("Nessuna risorsa disponibile");
                        break;
                    }
                    //scegli utente e prendi in prestito una risorsa
                    System.out.print("Inserisci l'ID dell'utente: ");
                    idUtente = in.nextLine();
                    Utente utenteAttivo = biblioteca.cercaUtentePerId(idUtente);
                    if(utenteAttivo==null){
                        System.out.println("Utente non trovato");
                        break;
                    }
                    System.out.println("Risorse disponibili:");
                    ArrayList<Risorsa> risorseDisponibili = new ArrayList<Risorsa>();
                    for(Risorsa ris : biblioteca.getListaRisorse()){
                        if(ris.isDisponibile()){
                            ris.visualizzaDettagli();
                            risorseDisponibili.add(ris);
                        }
                    }
                    if(risorseDisponibili.isEmpty()){
                        System.out.println("Nessuna risorsa disponibile");
                        break;
                    }
                    Risorsa risorsaTrovata = null;
                    // 4. Prendi in prestito una risorsa con nome
                    System.out.print("Inserisci il nome della risorsa: ");
                    String nomeRisorsa = in.nextLine();
                    ArrayList<Risorsa> risorse = biblioteca.cercaRisorsaPerTitolo(nomeRisorsa);
                    if(risorse.isEmpty()){
                        System.out.println("Risorsa non trovata");
                        break;
                    }else if(risorse.size()>1){
                        // Scelta tra le risorse trovate
                        System.out.println("Scegli una risorsa: ");
                        for(int i=0;i<risorse.size();i++){
                            System.out.println(i+": ");
                            risorse.get(i).visualizzaDettagli();
                        }
                        System.out.print("Inserisci la risorsa: ");
                        int sceltaRisorsa = in.nextInt();
                        in.nextLine();
                        risorsaTrovata = risorse.get(sceltaRisorsa);
                        utenteAttivo.prendiInPrestito(risorsaTrovata);
                        //biblioteca.inserisciRisorsa(risorsaTrovata);
                        System.out.println("Risorsa Prenotata");
                    }else{
                        risorsaTrovata = risorse.get(0);
                        utenteAttivo.prendiInPrestito(risorsaTrovata);
                        System.out.println("Risorsa Prenotata");
                    }
                    break;
                case 5:
                    System.out.println("Arrivederci");
                    return;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }
            }
        }
    }
