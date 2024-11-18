package loboGame;

public class Jugador {

    private String usuario;
    private String clave;

    //creación del constructor
    public Jugador() {
        setUsuario("joel");
        setClave("12345");
    }

    public boolean ingresar(){
        System.out.println("Ingresaste al juego");

        return true;
    }

    public void jugar(){
        System.out.println("Bienvenido...");
    }
    
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }

}
