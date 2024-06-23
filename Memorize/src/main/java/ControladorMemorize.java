import javax.swing.JButton;

public class ControladorMemorize {
    private ModeloJuegoMemorize juego;   // Referencia al modelo del juego
    private VistaMemorize vista;         // Referencia a la vista del juego
    private JButton primeraCarta;         // Botón de la primera carta seleccionada
    private JButton segundaCarta;         // Botón de la segunda carta seleccionada

    // Constructor que recibe el modelo y la vista del juego
    public ControladorMemorize(ModeloJuegoMemorize juego, VistaMemorize vista) {
        this.juego = juego;
        this.vista = vista;

        // Añadir ActionListener al botón de inicio en la vista
        vista.addActionListenerInicio(e -> {
            reiniciarJuego();   // Método para reiniciar el juego al hacer clic en INICIAR
        });

        // Añadir ActionListener a cada carta en la vista
        vista.addActionListenerCartas(e -> {
            manejarCarta((JButton) e.getSource());   // Método para manejar el evento de clic en una carta
        });
    }

    // Método para reiniciar el juego
    private void reiniciarJuego() {
        juego.generarTablero();   // Generar un nuevo tablero en el modelo
        juego.reiniciarTurnos();  // Reiniciar el contador de turnos en el modelo
        vista.getLblNTurno().setText(String.valueOf(juego.getTurno()));   // Actualizar etiqueta de número de turno en la vista

        // Reiniciar todas las cartas en la vista
        for (JButton btn : vista.getBtnsCartas()) {
            btn.setText("?");    // Restablecer texto oculto en cada carta
            btn.setEnabled(true);   // Habilitar todas las cartas para poder interactuar con ellas
        }

        primeraCarta = null;    // Reiniciar la referencia a la primera carta seleccionada
        segundaCarta = null;    // Reiniciar la referencia a la segunda carta seleccionada
        vista.getLblGanaste().setVisible(false);   // Ocultar el mensaje "Has Ganado" al reiniciar el juego
        vista.getLblDaleAqui().setVisible(false);  // Ocultar el mensaje "Da click en INICIAR para volver a jugar" al reiniciar el juego
    }

    // Método para manejar el evento de clic en una carta
    private void manejarCarta(JButton btn) {
        int index = vista.getBtnsCartas().indexOf(btn);   // Obtener el índice de la carta seleccionada en la lista de cartas de la vista

        // Verificar si la carta seleccionada está habilitada (no ha sido emparejada aún)
        if (index != -1 && btn.isEnabled()) {
            // Verificar si ya se han seleccionado dos cartas previamente
            if (primeraCarta != null && segundaCarta != null) {
                // Ocultar las cartas si no son iguales
                if (!primeraCarta.getText().equals(segundaCarta.getText())) {
                    primeraCarta.setText("?");   // Ocultar texto de la primera carta
                    segundaCarta.setText("?");   // Ocultar texto de la segunda carta
                }
                primeraCarta = null;   // Reiniciar referencia a la primera carta
                segundaCarta = null;   // Reiniciar referencia a la segunda carta
            }

            // Mostrar el número de la carta seleccionada
            btn.setText(String.valueOf(juego.getTablero()[index]));

            // Asignar la carta seleccionada a las variables correspondientes
            if (primeraCarta == null) {
                primeraCarta = btn;   // Asignar la primera carta seleccionada
            } else if (segundaCarta == null && btn != primeraCarta) {
                segundaCarta = btn;   // Asignar la segunda carta seleccionada
                // Verificar si las dos cartas seleccionadas son iguales
                if (primeraCarta.getText().equals(segundaCarta.getText())) {
                    primeraCarta.setEnabled(false);   // Deshabilitar la primera carta
                    segundaCarta.setEnabled(false);   // Deshabilitar la segunda carta
                    // Verificar si todas las cartas están desactivadas (todos los pares encontrados)
                    if (botonesDesactivados()) {
                        vista.getLblGanaste().setVisible(true);   // Mostrar mensaje "Has Ganado" en la vista
                        vista.getLblDaleAqui().setVisible(true);  // Mostrar mensaje "Da click en INICIAR para volver a jugar" en la vista
                    }
                }

                // Incrementar el turno y actualizar la etiqueta correspondiente
                juego.incrementarTurno();
                vista.getLblNTurno().setText(String.valueOf(juego.getTurno()));
            }
        }
    }

    // Método para verificar si todas las cartas están desactivadas
    private boolean botonesDesactivados() {
        for (JButton btn : vista.getBtnsCartas()) {
            if (btn.isEnabled()) {
                return false;   // Si encuentra una carta activada, retorna falso
            }
        }
        return true;   // Retorna verdadero si todas las cartas están desactivadas
    }
}
