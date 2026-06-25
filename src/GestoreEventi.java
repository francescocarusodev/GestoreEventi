import java.time.LocalDate;

public class GestoreEventi {

    private final Evento[] listaEventi = new Evento[100];
    private int numeroEventi = 0;


    public void aggiungiEvento(Evento e) {
        if (numeroEventi < 100) {
            listaEventi[numeroEventi] = e;
            numeroEventi++;
        } else {
            System.out.println("Limite massimo di eventi raggiunto");
        }
    }

    public Evento[] cercaPerData(LocalDate d) {
        Evento[] eventiData = new Evento[100];
        int j = 0;


        for (int i = 0; i < numeroEventi; i++) {
            if (d.equals(listaEventi[i].getData())) {
                eventiData[j] = listaEventi[i];
                j++;
            }
        }

        return eventiData;
    }

    public Evento[] cercaPerTipo(TipoEvento e) {
        Evento[] eventiData = new Evento[100];
        int j = 0;

        for (int i = 0; i < numeroEventi; i++) {
            if (e.equals(listaEventi[i].getTipoEvento())) {
                eventiData[j] = listaEventi[i];
                j++;
            }
        }
        return eventiData;
    }

}

