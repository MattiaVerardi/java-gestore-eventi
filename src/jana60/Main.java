package jana60;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * MILESTONE 2 1. Creare una classe Main di test, in cui si chiede all’utente di
 * inserire un nuovo evento con tutti i parametri. 2. Dopo che l’evento è stato
 * istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare
 * ad effettuarle, implementando opportuni controlli e gestendo eventuali
 * eccezioni. 3. Stampare a video il numero di posti prenotati e quelli
 * disponibili 4. Chiedere all’utente se e quanti posti vuole disdire 5. Provare
 * ad effettuare le disdette, implementando opportuni controlli e gestendo
 * eventuali eccezioni 6. Stampare a video il numero di posti prenotati e quelli
 * disponibili
 *
 */

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Inserisci un nuovo evento");
		System.out.print("Titolo: ");
		String inputTitolo = scan.nextLine();
		System.out.print("Giorno: ");
		int inputGiorno = Integer.parseInt(scan.nextLine());
		System.out.print("Mese: ");
		int inputMese = Integer.parseInt(scan.nextLine());
		System.out.print("Anno: ");
		int inputAnno = Integer.parseInt(scan.nextLine());
		LocalDate inputData = LocalDate.of(inputAnno, inputMese, inputGiorno);
		System.out.print("Posti Totali: ");
		int inputPostiTotali = Integer.parseInt(scan.nextLine());

		try {
			Evento evento1 = new Evento(inputTitolo, inputData, inputPostiTotali);

			System.out.print("Premere SI per procedere con la prenotazione: ");
			String risp = scan.nextLine();

			if (risp.equalsIgnoreCase("si")) {
				System.out.print("Inserire il numero di posti che si vuole prenotare: ");
				int numeroPrenotazioni = Integer.parseInt(scan.nextLine());
				for (int i = 0; i < numeroPrenotazioni; i++) {
					evento1.prenota();
				}
				System.out.println("Numero posti prenotati: " + numeroPrenotazioni);
				System.out.println("Numero posti disponibili: " + evento1.postiDisponibili());

				System.out.println();

				System.out.print("Inserire il numero di posti da disdire: ");
				int numeroDisdette = Integer.parseInt(scan.nextLine());
				for (int i = 0; i < numeroDisdette; i++) {
					evento1.disdici();
				}
				System.out.println("Numero posti disdetti: " + numeroDisdette);
				System.out.println("Numero posti disponibili: " + evento1.postiDisponibili());
			} else if (risp.equalsIgnoreCase("no")) {
				System.out.println("Grazie e arrivederci");
			} else {
				System.out.println("Riprova");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// chiudo scanner
		scan.close();
	}

}
