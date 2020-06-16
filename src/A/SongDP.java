package A;

import java.util.*;

public class SongDP {
    private String cancion;
    private String album;
    private String compositor;

    public SongDP() {
        this.cancion = "";
        this.album = "";
        this.compositor = "";
    }

    public SongDP(String datos) {
        StringTokenizer st = new StringTokenizer(datos,"_");
        this.cancion = st.nextToken();
        this.album = st.nextToken();
        this.compositor = st.nextToken();
    }

    public String getCancion() {
        return cancion;
    }

    public String getAlbum() {
        return album;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }


}
