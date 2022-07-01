package jana60;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Creare una classe ProgrammEventi con metodo main in cui creare una lista di
 * eventi di test (non è necessario usare lo Scanner). Stampare la lista degli
 * eventi ordinati per data e a parità di data ordinati per titolo. Creare altre
 * due liste: prossimiEventi ed eventiFuturi, in cui inserire rispettivamente
 * gli eventi che avverranno entro un mese e quelli in cui la data è successiva
 * a un mese da oggi.
 */

public class ProgrammaEventi {

	public static void main(String[] args) throws Exception {

		Evento evento1 = new Evento("Sfilata", LocalDate.of(2022, 7, 2), 100);
		Evento evento2 = new Evento("Commedia", LocalDate.of(2022, 8, 20), 200);
		Evento evento3 = new Evento("Cinema", LocalDate.of(2022, 7, 2), 300);
		Evento evento4 = new Evento("Teatro", LocalDate.of(2022, 7, 17), 400);

		List<Evento> listaEventi = new ArrayList<Evento>();
		listaEventi.add(evento1);
		listaEventi.add(evento2);
		listaEventi.add(evento3);
		listaEventi.add(evento4);
		System.out.println(listaEventi);

		Collections.sort(listaEventi);
		System.out.println(listaEventi);

		List<Evento> prossimiEventi = new ArrayList<Evento>();
		List<Evento> eventiFuturi = new ArrayList<Evento>();

	}

}
