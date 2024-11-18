package loboGame;

public class Jugador {

    private String usuario;
    private String clave;

    //creación del constructor
    public Jugador() {
        setUsuario("joel");
        setClave("12345");

        System.out.println(getUsuario());
    }

    public boolean ingresar(){
        System.out.println("Ingresaste al juego");
        return true;
    }

    public void jugar(){
        
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if (usuario == null || usuario.isEmpty()) {
            usuario = "Anonimo";
        }
        this.usuario = usuario.toUpperCase();
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        if (clave == null || clave.isEmpty()) {
            clave = "";
        }
        this.clave = clave;
    }

}
