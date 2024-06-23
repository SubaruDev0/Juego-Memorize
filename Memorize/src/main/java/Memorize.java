
public class Memorize {
    public static void main(String[] args) {
        ModeloJuegoMemorize juego = new ModeloJuegoMemorize();
        VistaMemorize vista = new VistaMemorize();
        ControladorMemorize controlador = new ControladorMemorize(juego, vista);
    }
}
