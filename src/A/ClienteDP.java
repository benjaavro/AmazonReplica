package A;

import java.util.*;

public class ClienteDP {
    private String correo;
    private String password;
    private String nombre;
    private String direccion;
    private String telefono;
    private String tarjeta;
    private String tipo;

    public ClienteDP() {
        this.correo = "";
        this.password = "";
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
        this.tarjeta = "";
        this.tipo = "";
    }

    public ClienteDP(String datos) {
        StringTokenizer st = new StringTokenizer(datos,"_");
        this.correo = st.nextToken();
        this.password = st.nextToken();
        this.nombre = st.nextToken();
        this.direccion = st.nextToken();
        this.telefono = st.nextToken();
        this.tarjeta = st.nextToken();
        this.tipo = st.nextToken();
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
