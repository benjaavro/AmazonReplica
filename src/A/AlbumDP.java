package A;

import java.util.*;

public class AlbumDP {
    private String artista;
    private String nombre;
    private String edicion;
    private String imagen;
    private int precio;
    private int stock;

    public AlbumDP() {
        this.artista = "";
        this.nombre = "";
        this.edicion = "";
        this.imagen = "";
        this.precio = 0;
        this.stock = 0;
    }

    public AlbumDP(String datos) {
        StringTokenizer st = new StringTokenizer(datos,"_");
        this.artista    = st.nextToken();
        this.nombre     = st.nextToken();
        this.edicion    = st.nextToken();
        this.imagen     = st.nextToken();
        this.precio     = Integer.parseInt(st.nextToken());
        this.stock     = Integer.parseInt(st.nextToken());
    }

    public String getArtista() {
        return artista;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdicion() {
        return edicion;
    }

    public String getImagen() {
        return imagen;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toJson() {
        return "";
    }
}
