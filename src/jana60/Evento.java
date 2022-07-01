package jana60;

import java.time.LocalDate;

/**
 * MILESTONE 1 La consegna � di creare una classe Evento che abbia le seguenti
 * propriet�: - titolo - data - numero di posti totali (cio� la capienza della
 * location) - numero di posti prenotati Quando si istanzia un nuovo evento
 * questi attributi devono essere tutti valorizzati nel costruttore, tranne
 * posti prenotati che va inizializzato a 0. Inserire il controllo che la data
 * non sia gi� passata e che il numero di posti totali sia un numero positivo.
 * In caso contrario sollevare opportune eccezioni. Aggiungere metodi getter e
 * setter in modo che: - titolo sia in lettura e in scrittura - data sia in
 * lettura e scrittura - numero di posti totali sia solo in lettura - numero di
 * posti prenotati sia solo in lettura Vanno inoltre implementati dei metodi
 * public che svolgono le seguenti funzioni: 1. prenota: aggiunge uno ai posti
 * prenotati. Se l�evento � gi� passato o non ha pi� posti disponibili deve
 * sollevare un�eccezione. 2. disdici: riduce di uno i posti prenotati. Se
 * l�evento � gi� passato o non ci sono prenotazioni deve sollevare
 * un�eccezione. 3. l�override del metodo toString() in modo che venga
 * restituita una stringa contenente: data formattata - titolo Aggiungere
 * eventuali metodi (public e private) che vi aiutino a svolgere le funzioni
 * richieste.
 *
 */

public class Evento {

	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;

	public Evento(String titolo, LocalDate data, int postiTotali) throws Exception {
		if (data.isBefore(LocalDate.now())) {
			throw new Exception("Errore nell'inserimento della data");
		}
		if (!(postiTotali > 0)) {
			throw new Exception("Il numero di posti inserito � errato");
		}

		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	public int prenota() throws Exception {
		if (data.isBefore(LocalDate.now()) || !(postiPrenotati < postiTotali)) {
			throw new Exception("Attenzione, errore nell'inserimento della data o nell'operazione di prenotazione");
		} else {
			return postiPrenotati += 1;
		}
	}

	public int disdici() throws Exception {
		if (data.isBefore(LocalDate.now()) || !(postiPrenotati > 0)) {
			throw new Exception("Attenzione, errore nell'inserimento della data o nell'operazione di disdetta");
		} else {
			return postiPrenotati -= 1;
		}
	}

	public int postiDisponibili() throws Exception {
		return postiTotali - postiPrenotati;
	}

	@Override
	public String toString() {
		return data + titolo;
	}
}
