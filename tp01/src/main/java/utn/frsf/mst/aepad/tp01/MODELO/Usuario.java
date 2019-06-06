package utn.frsf.mst.aepad.tp01.MODELO;

public class Usuario {

    private String nombreUsuario;
    private String email;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String email) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
