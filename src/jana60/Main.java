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

		System.out.print("Premere 1 per Conferenza, 2 per Evento Generico: ");
		String tipoEvento = scan.nextLine();

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

		String risp = "";
		switch (tipoEvento) {

		case "1":
			System.out.print("Argomento: ");
			String inputArgomento = scan.nextLine();
			System.out.print("Nome: ");
			String inputNome = scan.nextLine();
			System.out.print("Cognome: ");
			String inputCognome = scan.nextLine();
			System.out.print("Titolo Oratore: ");
			String inputTitoloOr = scan.nextLine();

			try {
				Oratore oratore1 = new Oratore(inputNome, inputCognome, inputTitoloOr);
				Conferenza conferenza1 = new Conferenza(inputTitoloOr, inputData, inputPostiTotali, inputArgomento,
						oratore1);
				// System.out.println(conferenza1);

				while (!risp.equalsIgnoreCase("si") || !risp.equalsIgnoreCase("no")) {
					System.out.print("Premere SI per procedere con la prenotazione: ");
					risp = scan.nextLine();

					if (risp.equalsIgnoreCase("si")) {
						System.out.print("Inserire il numero di posti che si vuole prenotare: ");
						int numeroPrenotazioni = Integer.parseInt(scan.nextLine());
						for (int i = 0; i < numeroPrenotazioni; i++) {
							conferenza1.prenota();
						}
						System.out.println("Numero posti prenotati: " + numeroPrenotazioni);
						System.out.println("Numero posti disponibili: " + conferenza1.postiDisponibili());

						System.out.println();

						System.out.print("Inserire il numero di posti da disdire: ");
						int numeroDisdette = Integer.parseInt(scan.nextLine());
						for (int i = 0; i < numeroDisdette; i++) {
							conferenza1.disdici();
						}
						System.out.println("Numero posti disdetti: " + numeroDisdette);
						System.out.println("Numero posti disponibili: " + conferenza1.postiDisponibili());
					} else if (risp.equalsIgnoreCase("no")) {
						System.out.println("Grazie e arrivederci");
					} else {
						System.out.println("Riprova");
					}
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;

		case "2":
			try {
				Evento evento1 = new Evento(inputTitolo, inputData, inputPostiTotali);
				// System.out.println(evento1);

				while (!risp.equalsIgnoreCase("si") || !risp.equalsIgnoreCase("no")) {
					System.out.print("Premere SI per procedere con la prenotazione: ");
					risp = scan.nextLine();

					if (!risp.equalsIgnoreCase("si") || !risp.equalsIgnoreCase("no")) {
						System.out.print("Premere SI per procedere con la prenotazione: ");
						risp = scan.nextLine();

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
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;

		default:
			break;
		}

		// chiudo scanner
		scan.close();

	}

}
