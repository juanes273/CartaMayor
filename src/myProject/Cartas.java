package myProject;

import java.util.Random;

public class Cartas {
    private int valorCarta;
    private int valorPalo;

    /**
     * Method that generate a random value to carta
     * @return number between (1,12) except 8 and 9
     */
    public int getValorCarta() {
        valorCarta = 8;
        while (valorCarta==8 || valorCarta== 9){
            Random aleatorio = new Random();
            valorCarta = aleatorio.nextInt(12) + 1;
        }
        return valorCarta;
    }

    /**
     * Method that generate a random value to palo
     * @return number between (1,4)
     */
    public int getPalo() {
        Random aleatorio = new Random();
        valorPalo = aleatorio.nextInt(4) + 1;
        return valorPalo;
    }
}
