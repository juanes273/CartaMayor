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

    public void iniciar() {
        cartasCompletas[0] = carta1.getValorCarta();
        cartasCompletas[1] = carta1.getPalo();
        cartasCompletas[2] = carta2.getValorCarta();
        cartasCompletas[3] = carta2.getPalo();
        while (cartasCompletas[0] == cartasCompletas[2]) {
            cartasCompletas[2] = carta2.getValorCarta();
        }
    }

    public int valorPaloUser(){
        return cartasCompletas[1];
    }

    public int valorPaloBOT(){
        return cartasCompletas[3];
    }

    public int valorCartaBOT(){
        return cartasCompletas[2];
    }

    public int valorCartaUser(){
        return cartasCompletas[0];
    }
}