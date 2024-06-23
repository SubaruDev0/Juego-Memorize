import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaMemorize {
    JFrame frame;         // Ventana principal del juego
    JPanel panel;         // Panel dentro de la ventana para organizar componentes
    JButton btnInicio;    // Botón para iniciar o reiniciar el juego
    List<JButton> btnsCartas; // Lista de botones que representan las cartas del juego
    JLabel lblTurno;      // Etiqueta para mostrar "Turno:"
    JLabel lblNTurno;     // Etiqueta para mostrar el número de turno actual
    JLabel lblGanaste;    // Etiqueta para mostrar "Has ganado"
    JLabel LbldDaleAqui;  // Etiqueta para mensaje de reinicio

    // Constructor de la clase VistaMemorize
    public VistaMemorize() {
        frame = new JFrame("Memorize");  // Crear la ventana con el título "Memorize"
        frame.setSize(325, 330);         // Establecer tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cerrar la aplicación al cerrar la ventana
        frame.setLocationRelativeTo(null);  // Centrar la ventana en la pantalla
        
        panel = new JPanel();  // Crear un panel para organizar componentes
        panel.setLayout(null);  // Establecer layout nulo para posicionar manualmente los componentes
        frame.add(panel);  // Agregar el panel al JFrame
        
        // COMPONENTES 
        
        btnsCartas = new ArrayList<>();  // Inicializar la lista de botones de las cartas
        
        // Crear y posicionar los botones de las cartas en dos filas
        // Primera fila de botones
        for (int i = 0; i < 5; i++) {
            JButton btnCarta = new JButton("?");
            btnCarta.setBounds(10 + (60 * i), 140, 50, 50);  // Posicionar cada botón en coordenadas específicas
            btnsCartas.add(btnCarta);  // Agregar el botón a la lista de cartas
            panel.add(btnCarta);  // Agregar el botón al panel
        }

        // Segunda fila de botones
        for (int i = 0; i < 5; i++) {
            JButton btnCarta = new JButton("?");
            btnCarta.setBounds(10 + (60 * i), 200, 50, 50);  // Posicionar cada botón en coordenadas específicas
            btnsCartas.add(btnCarta);  // Agregar el botón a la lista de cartas
            panel.add(btnCarta);  // Agregar el botón al panel
        }
        
        // Botón de inicio
        btnInicio = new JButton("INICIAR");
        btnInicio.setBounds(190, 10, 110, 50);  // Posicionar el botón de inicio
        btnInicio.setFont(btnInicio.getFont().deriveFont(Font.BOLD, 20));  // Establecer fuente y tamaño
        panel.add(btnInicio);  // Agregar el botón al panel
        
        // Etiqueta de turno
        lblTurno = new JLabel("Turno:");
        lblTurno.setBounds(10, 10, 70, 25);  // Posicionar la etiqueta de turno
        lblTurno.setFont(lblTurno.getFont().deriveFont(Font.BOLD, 15));  // Establecer fuente y tamaño
        panel.add(lblTurno);  // Agregar la etiqueta al panel
        
        // Etiqueta de número de turno
        lblNTurno = new JLabel("1");
        lblNTurno.setBounds(70, 10, 70, 25);  // Posicionar la etiqueta de número de turno
        lblNTurno.setFont(lblNTurno.getFont().deriveFont(Font.BOLD, 15));  // Establecer fuente y tamaño
        panel.add(lblNTurno);  // Agregar la etiqueta al panel
        
        // Etiqueta de "Has ganado"
        lblGanaste = new JLabel("Has ganado");
        lblGanaste.setBounds(80, 75, 300, 30);  // Posicionar la etiqueta de "Has ganado"
        lblGanaste.setFont(lblGanaste.getFont().deriveFont(Font.BOLD, 25));  // Establecer fuente y tamaño
        lblGanaste.setVisible(false);  // Inicialmente invisible
        panel.add(lblGanaste);  // Agregar la etiqueta al panel
        
        // Etiqueta de "Da click en INICIAR para volver a jugar"
        LbldDaleAqui = new JLabel("Presiona Espacio para volver a jugar");
        LbldDaleAqui.setBounds(20, 260, 300, 25);  // Posicionar la etiqueta "Da click..."
        LbldDaleAqui.setFont(LbldDaleAqui.getFont().deriveFont(Font.BOLD, 15));  // Establecer fuente y tamaño
        LbldDaleAqui.setVisible(false);  // Inicialmente invisible
        panel.add(LbldDaleAqui);  // Agregar la etiqueta al panel
        
        // Hacer visible el frame
        frame.setVisible(true);  // Mostrar la ventana en la pantalla
    }

    // Método para añadir ActionListener al botón de inicio
    public void addActionListenerInicio(ActionListener accion) {
        btnInicio.addActionListener(accion);
    }

    // Método para añadir ActionListener a los botones de las cartas
    public void addActionListenerCartas(ActionListener accion) {
        for (JButton btnCarta : btnsCartas) {
            btnCarta.addActionListener(accion);
        }
    }

    // Método para obtener la lista de botones de las cartas
    public List<JButton> getBtnsCartas() {
        return btnsCartas;
    }

    // Método para obtener la etiqueta del número de turno
    public JLabel getLblNTurno() {
        return lblNTurno;
    }

    // Método para obtener la etiqueta de "Has ganado"
    public JLabel getLblGanaste() {
        return lblGanaste;
    }
    
    // Método para obtener la etiqueta "Da click en INICIAR para volver a jugar"
    public JLabel getLblDaleAqui() {
        return LbldDaleAqui;
    }

    // Método para obtener la etiqueta de turno
    public JLabel getLblTurno() {
        return lblTurno;
    }
}
