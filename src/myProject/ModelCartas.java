package myProject;

public class ModelCartas {
    private Cartas carta1, carta2;
    public String textoFinal;
    private int[] cartasCompletas;

    public ModelCartas() {
        carta1 = new Cartas();
        carta2 = new Cartas();
        cartasCompletas = new int [4];
    }

    /**
     * Method that decide who´s the winner by comparing some numbers of the array
     * @return String that says who´s the winner
     */
    public String DeterminarGanador() {
        if (cartasCompletas[1] < cartasCompletas[3]) {
            textoFinal = "Ganó Maquina";
        } else if (cartasCompletas[1] > cartasCompletas[3]) {
            textoFinal = "Ganó Usuario";
        } else if (cartasCompletas[1] == cartasCompletas[3]) {
            if (cartasCompletas[0] < cartasCompletas[2]) {
                textoFinal = "Ganó Maquina";
            } else if (cartasCompletas[0] > cartasCompletas[2]) {
                textoFinal  = "Ganó Usuario";
            }
        }
        return textoFinal;
    }

    /**
     * Method that inicializate the values for Carta and Palo, also put the data in the array "cartasCompletas"
     */
    public void iniciar(){
        cartasCompletas[0] = carta1.getValorCarta();
        cartasCompletas[1] = carta1.getPalo();
        cartasCompletas[2] = carta2.getValorCarta();
        cartasCompletas[3] = carta2.getPalo();
        while((cartasCompletas[0]==cartasCompletas[2])  &&  (cartasCompletas[1]==cartasCompletas[3])){
            cartasCompletas[2] = carta2.getValorCarta();
        }
    }

    /**
     * Method that give the value of Carta for user
     * @return value from the array "cartasCompletas"
     */
    public int valorPaloUser(){
        return cartasCompletas[1];
    }

    /**
     * Method that give the value of palo for BOT
     * @return Value form the array "cartasCompletas"
     */
    public int valorPaloBOT(){
        return cartasCompletas[3];
    }

    /**
     * Method that give the value of Carta for BOT
     * @return Value form the array "cartasCompletas"
     */
    public int valorCartaBOT(){
        return cartasCompletas[2];
    }

    /**
     * Method that give the value of Carta for User
     * @return Value form the array "cartasCompletas"
     */
    public int valorCartaUser(){
        return cartasCompletas[0];
    }
}