public class Contador {

    private int cuenta = 0;

    synchronized int getCuenta() {
        return cuenta;
    }

    synchronized void incrementa(){
        this.cuenta++;
    }
}
