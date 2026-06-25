import java.time.DateTimeException;
import java.time.LocalDate;

public class Main {
    public static void main(String...args) throws IllegalAccessException {

        try {
            Evento concertoSbagliato = new Evento("", LocalDate.of(2026, 6, 30), TipoEvento.CONCERTO);
        } catch (IllegalArgumentException e){
            System.out.println("Errore: " + e.getMessage());
        }

        try {
            Evento concertoSbagliato = new Evento("pippo", LocalDate.of(2025, 6, 30), TipoEvento.CONCERTO);
        } catch (DateTimeException e){
            System.out.println("Errore: " + e.getMessage());
        }



        Evento concerto = new Evento("Concerto vasco rossi", LocalDate.of(2026,6,30),TipoEvento.CONCERTO);
        Evento concerto1 = new Evento("Concerto pippo rossi", LocalDate.of(2026,7,30),TipoEvento.CONCERTO);
        Evento concerto2 = new Evento("Concerto pluto rossi", LocalDate.of(2026,6,30),TipoEvento.CONFERENZA);

        concerto.formattaNome();


        GestoreEventi gestoreEventi = new GestoreEventi();

        gestoreEventi.aggiungiEvento(concerto);
        gestoreEventi.aggiungiEvento(concerto1);
        gestoreEventi.aggiungiEvento(concerto2);

        Evento[] eventiTrentaGiugno = gestoreEventi.cercaPerData(LocalDate.of(2026,6,30));
        Evento[] eventiConcerto = gestoreEventi.cercaPerTipo(TipoEvento.CONCERTO);


        System.out.println("\n---EVENTI DEL 30/06---\n");
        for(Evento e : eventiTrentaGiugno){
            if(e!=null) {
                System.out.println(e.getNome() + ".");
            } else {
                break;
            }
        }

        System.out.println("\n---EVENTI CONCERTO---\n");
        for(Evento e : eventiConcerto){
            if(e!=null) {
                System.out.println(e.getNome() + ".");
            } else {
                break;
            }
        }
    }
}
