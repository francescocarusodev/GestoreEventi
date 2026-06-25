import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Evento {
    private String nome;
    private LocalDate data;
    private TipoEvento tipoEvento;
    private String codice;

    public Evento(String nome, LocalDate data, TipoEvento tipoEvento ) {
        if (nome.isEmpty() || nome == null){
            throw new IllegalArgumentException("Il nome non può essere vuoto");
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

    public void formattaNome(){

        if(this.nome.length() > 50){
            this.nome = this.nome.substring(0,50) + "...";
        }

        //formatto il nome in lower case e uso StringBuilder per evitare di creare una nuova istanza String
        StringBuilder nomeFormattato = new StringBuilder((this.nome).toLowerCase());
        //variabile di controllo
        boolean inizioParola = true;

        //ciclo n volte in base alla quantità di caratteri
        for(int i = 0;i < nomeFormattato.length(); i++){
            //Controllo se il carattere è uno spazio vuoto.
            //Se lo è, setto inizioParola a true.
            // Il ciclo riparte con i incrementato e, avendo inizioParola=true, entro nell'else if e modifico il carattere corrente.
            if(Character.isWhitespace(nomeFormattato.charAt(i))){
                inizioParola = true;
            } else if (inizioParola) {
                nomeFormattato.setCharAt(i, Character.toUpperCase(nomeFormattato.charAt(i)));
                inizioParola = false;
            }
        }
        this.nome = nomeFormattato.toString();
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData() {
        return data;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }
}
