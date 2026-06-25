import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Evento {
    private String nome;
    private LocalDate data;
    private TipoEvento tipoEvento;
    private String codice;

    public Evento(String nome, LocalDate data, TipoEvento tipoEvento ) throws IllegalAccessException {
        if (nome.isEmpty() || nome == null){
            throw new IllegalAccessException("Il nome non può essere vuoto");
        }
        if (data.isBefore(LocalDate.now())){
            throw new DateTimeException("La data non può trovarsi nel passato");
        }
        this.nome = nome;
        this.data = data;
        this.tipoEvento = tipoEvento;
        this.codice = generaCodice(data);
    }

    public String generaCodice(LocalDate data){
        int randomNum = (int) (Math.random() * 900) + 100;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedData = data.format(formato);
        return ("EVT" + formattedData + randomNum);
    }
}
