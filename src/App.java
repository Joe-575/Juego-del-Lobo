import loboGame.Jugador;

public class App {
    public static Jugador jugador = new Jugador(); //por brevedad, esto no es adecuado

    //genero el constructor
    public App(){
        jugador = new Jugador();
    }

    public static void main(String[] args) throws Exception {
        //jugador.jugar();
        App.jugador.ingresar();
        
    }
}
