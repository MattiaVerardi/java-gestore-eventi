package jana60;

import java.time.LocalDate;

/**
 * MILESTONE 3 Creare una classe Conferenza che estende Evento, che ha anche gli
 * attributi - argomento - oratore L’oratore, a sua volta, è caratterizzato da:
 * - nome - cognome - titolo Modificare il metodo main in modo che al momento
 * della creazione dell’evento venga richiesto se è una conferenza, e in tal
 * caso valorizzare tutti i parametri. Quando si stampano i dettagli della
 * Conferenza, oltre a data e titolo, devono apparire anche le informazioni
 * sull’oratore e sull’argomento.
 *
 */

public class Conferenza extends Evento {

	private String argomento;
	private Oratore oratore;

	public Conferenza(String titolo, LocalDate data, int postiTotali, String argomento, Oratore oratore)
			throws Exception {
		super(titolo, data, postiTotali);
		this.argomento = argomento;
		this.oratore = oratore;
	}

	public String getArgomento() {
		return argomento;
	}

	public Oratore getOratore() {
		return oratore;
	}

	@Override
	public String toString() {
		return super.toString() + " " + argomento + " " + oratore;
	}
}
