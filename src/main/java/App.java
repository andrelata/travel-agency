import spark.Spark;

public class App {

    private static final int PORT = 8080;

    /**
     * Inicio de la aplicacion
     *
     * @param args argumentos de entrada
     */
    public static void main(final String[] args) {
        Spark.port(PORT);
        new Router().init();
    }
}
