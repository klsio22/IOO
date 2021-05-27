package Prova_de_Recuperação;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Veiculo {

    private String dataHora;
    private int numeroDeEixos;
    private String placa;

    public Veiculo(String placa, int numeroDeEixos) {
        this.placa = placa;
        this.numeroDeEixos = numeroDeEixos;
        dataHora = getDataHoraCorrente();
    }

    public String getPlaca() {
        return placa;
    }

    public int getNumeroDeEixos() {
        return numeroDeEixos;
    }

    public String getDataHora() {
        return dataHora;
    }

    private String getDataHoraCorrente() {
        String padraDataHora = "dd/MM/yyyy HH:mm:ss";
        DateFormat formatodorDeDataHora = new SimpleDateFormat(padraDataHora);
        return formatodorDeDataHora.format(new Date());
    }

    public abstract double getTarifa();

    public abstract String getTipo();

    public abstract String getTipoDeTarifa();

}
