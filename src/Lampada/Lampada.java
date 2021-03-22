package Lampada;

public class Lampada {
    private  boolean status;

    public void acender(){
        status = true ;
    }

    public  void apagar(){
        status = false;
    }

    public boolean estaAcessa(){
        return status;
    }
}
