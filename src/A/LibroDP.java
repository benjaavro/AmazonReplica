package A;

import java.util.*;

public class LibroDP {
    private String titulo;
    private String autor;
    private String editorial;
    private int precio;
    private int stock;

    public LibroDP() {
        this.titulo = "";
        this.autor = "";
        this.editorial = "";
        this.precio = 0;
        this.stock = 0;

    }

    public LibroDP(String datos) {
        StringTokenizer st = new StringTokenizer(datos,"_");
        this.titulo = st.nextToken();
        this.autor = st.nextToken();
        this.editorial = st.nextToken();
        this.precio = Integer.parseInt(st.nextToken());
        this.stock = Integer.parseInt(st.nextToken());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
