package myProject;

import java.util.Random;

public class Cartas {
    private int valorCarta;
    private int valorPalo;

    /**
     * Method that generate a random value to carta
     * @return number between (1,6)
     */

    public int getValorCarta() {
        Random aleatorio = new Random();
        valorCarta = aleatorio.nextInt(12) + 1;
        return valorCarta;
    }
    public int getPalo() {
        Random aleatorio = new Random();
        valorPalo = aleatorio.nextInt(4) + 1;
        return valorPalo;
    }
}
