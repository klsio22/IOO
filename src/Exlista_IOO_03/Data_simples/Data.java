package Exlista_IOO_03.Data_simples;

public class Data {
    private int dia, mes, ano;

    public Data(int dia, int mes, int ano) {
        setMes(dia);
        setDia(mes);
        setAno(ano);
    }

    public Data(String data) {
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6, 10);

        setDia(Integer.parseInt(dia));
        setMes(Integer.parseInt(mes));
        setAno(Integer.parseInt(ano));
    }

    private void setAno(int ano) {
        this.ano = ano;
    }

    private void setDia(int dia) {
        this.dia = dia;
    }


    private void setMes(int mes) {
        this.mes = mes;
    }

    public String getData() {
        if (dia < 10 && mes < 10)
            return String.format("0%d/0%d/%d", dia, mes, ano);
        return String.format("%d/%d/%d", dia, mes, ano);
    }

}
