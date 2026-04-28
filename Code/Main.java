package Code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 1. Creazione Utente e registrazione
        System.out.println("--- Registrazione Nuovo Utente ---");
        System.out.print("Inserisci il nome: ");
        String nome = in.nextLine();
        System.out.print("Inserisci l'ID Utente: ");
        String id = in.nextLine();
        
        Utente utente = new Utente(nome, id);

        // 2. Menu per inserire una risorsa
        System.out.println("\n--- Cosa vuoi prendere in prestito? ---");
        System.out.println("1. Libro");
        System.out.println("2. Ebook");
        System.out.println("3. Rivista");
        System.out.print("Scelta: ");
        int scelta = in.nextInt();
        in.nextLine(); 
    }
}
