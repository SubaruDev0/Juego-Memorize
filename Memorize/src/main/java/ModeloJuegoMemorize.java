import java.util.Random;

public class ModeloJuegoMemorize {
    private int[] tablero = new int[10];  // Arreglo que representa el tablero de juego
    private int nTurno;                   // Variable para almacenar el número de turno actual

    // Constructor de la clase ModeloJuegoMemorize
    public ModeloJuegoMemorize() {
        generarTablero();    // Genera el tablero al iniciar el juego
        reiniciarTurnos();   // Reinicia el contador de turnos al iniciar el juego
    }

    // Método para generar el tablero con parejas de números
    public void generarTablero() {
        Random random = new Random();   // Objeto Random para generar números aleatorios
        int[] numeros = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};   // Números que se emparejarán en el tablero

        // Algoritmo para mezclar los números y distribuirlos en el tablero
        for (int i = 0; i < tablero.length; i++) {
            int index = random.nextInt(tablero.length - i) + i;  // Obtener índice aleatorio dentro del rango restante
            int temp = numeros[i];   // Guardar temporalmente el número actual
            numeros[i] = numeros[index];   // Intercambiar números para mezclar
            numeros[index] = temp;
            tablero[i] = numeros[i];   // Asignar número al tablero
        }
    }

    // Método para reiniciar el número de turnos a 1
    public void reiniciarTurnos() {
        nTurno = 1;   // Reiniciar el número de turno
    }

    // Método para obtener el número de turno actual
    public int getTurno() {
        return nTurno;   // Devolver el número de turno actual
    }

    // Método para obtener el tablero actual
    public int[] getTablero() {
        return tablero;   // Devolver el arreglo que representa el tablero
    }

    // Método para incrementar el número de turno
    public void incrementarTurno() {
        nTurno++;   // Incrementar el número de turno
    }
}
