package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGridBagLayout extends JFrame {
    public static final String MENSAJE_INICIO = "Bienvenido a Carta Mayor \n"
            + "Presiona 'Sacar' para jugar"+ "\nSi jugador y máquina sacan cartas de igual valor el " +
            "ganador será definido por el Palo, teniendo en cuenta que Oros es mayor que Copas, Copas es mayor que Espadas y Espadas es mayor que Bastos."+
            "\nSi ambos sacan el mismo palo, se definirá por el valor de la carta";

    private Header headerProject;
    private JLabel usuario,bot;
    private JButton lanzar, ayuda, salir;
    private JPanel panelDados;
    private ImageIcon imagenCarta;
    private JTextArea mensajeSalida, resultados;
    private Escucha escucha;
    private ModelCartas modelCartas;

    public GUIGridBagLayout(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Juego Cartas");
        this.setUndecorated(true);
        this.setBackground(new Color(255, 255,255,255));
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //Create Listener Object or Control Object
        escucha = new Escucha();
        modelCartas = new ModelCartas();
        //Set up JComponents
        headerProject = new Header("Mesa Juego Cartas", Color.BLACK);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints);

        ayuda = new JButton(" ? ");
        ayuda.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        this.add(ayuda,constraints);

        salir = new JButton("Salir");
        salir.addActionListener(escucha);
        constraints.gridx=2;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_END;
        this.add(salir,constraints);

        imagenCarta = new ImageIcon(getClass().getResource("/Recursos/carta.jpg"));
        usuario = new JLabel(imagenCarta);
        bot = new JLabel(imagenCarta);

        panelDados = new JPanel();
        panelDados.setPreferredSize(new Dimension(250, 350));
        panelDados.setBorder(BorderFactory.createTitledBorder("Usuario"));
        panelDados.add(usuario);

        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;

        add(panelDados,constraints);

        panelDados = new JPanel();
        panelDados.setPreferredSize(new Dimension(250, 350));
        panelDados.setBorder(BorderFactory.createTitledBorder("Maquina"));
        panelDados.add(bot);

        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;

        add(panelDados,constraints);

        resultados = new JTextArea(4,31);
        resultados.setBorder(BorderFactory.createTitledBorder("Resultados"));
        resultados.setText("Debes sacar una carta");
        resultados.setEditable(false);
        constraints.gridx=2;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(resultados,constraints);

        lanzar = new JButton("Sacar");
        lanzar.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        add(lanzar,constraints);

        mensajeSalida = new JTextArea(4, 31);
        mensajeSalida.setText("Usa el botón (?) para ver las reglas del juego");
        mensajeSalida.setBorder(BorderFactory.createTitledBorder("Mensajes"));
        mensajeSalida.setEditable(false);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        add(mensajeSalida,constraints);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIGridBagLayout miProjectGUI = new GUIGridBagLayout();
        });
    }

    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                if (e.getSource()==lanzar){
                    modelCartas.iniciar();
                    imagenCarta = new ImageIcon(getClass().getResource("/recursos/"+ modelCartas.valorPaloUser()+".jpeg"));
                    usuario.setIcon(imagenCarta);
                    imagenCarta = new ImageIcon(getClass().getResource("/recursos/" + modelCartas.valorPaloBOT()+ ".jpeg"));
                    bot.setIcon(imagenCarta);
                    modelCartas.DeterminarGanador();
                    resultados.setText("Usuario: \n    Valor: " + modelCartas.valorCartaUser() +
                                                "\n Maquina: \n   Valor: " + modelCartas.valorCartaBOT() );
                    mensajeSalida.setText(modelCartas.textoFinal);
                }
                if(e.getSource()==ayuda){
                    JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
                }
                if(e.getSource()==salir){
                    System.exit(0);
                }
        }
    }
}
