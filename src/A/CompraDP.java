package A;

import java.util.*;

public class CompraDP {
    private String correo;
    private String nombre;
    private String direccion;
    private String tarjeta;
    private String articulo;
    private int cantidad;
    private int total;
    private String fecha;
    private String hora;

    public CompraDP() {
        this.correo = "";
        this.nombre = "";
        this.direccion = "";
        this.tarjeta = "";
        this.articulo = "";
        this.cantidad = 0;
        this.total = 0;
        this.fecha = "";
        this.hora = "";
    }

    public CompraDP(String datos) {
        StringTokenizer st = new StringTokenizer(datos,"_");
        this.correo = st.nextToken();
        this.nombre = st.nextToken();
        this.direccion = st.nextToken();
        this.tarjeta = st.nextToken();
        this.articulo = st.nextToken();
        this.cantidad = Integer.parseInt(st.nextToken());
        this.total = Integer.parseInt(st.nextToken());
        this.fecha = st.nextToken();
        this.hora = st.nextToken();
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public String getArticulo() {
        return articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getTotal() {
        return total;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
