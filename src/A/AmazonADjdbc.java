package A;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import org.json.simple.*;

public class AmazonADjdbc {
    private PrintWriter archivoOut;
    private BufferedReader archivoIn;

    private Connection conexion;
    private Statement  statement;

    private A.AlbumDP albumDP;
    private A.LibroDP libroDP;
    private A.SongDP songDP;
    private A.ClienteDP clienteDP;
    private A.CompraDP compraDP;

    public AmazonADjdbc()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/Amazon?serverTimezone=GMT-5","root", "IpadB33nji");

            System.out.println("Conexion exitosa a la BD ...");
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("Error Class.forName(): "+cnfe);
        }
        catch(InstantiationException ie)
        {
            System.out.println("Error al crear la Instancia: "+ie);
        }
        catch(IllegalAccessException iae)
        {
            System.out.println("Error IllegalAccess: "+iae);
        }
        catch(SQLException sqle)
        {
            System.out.println("Error Sql Exception: "+sqle);
        }

    }

    private String obtenerAlbums(String query) {
        String datos = "";
        ResultSet tr;

        // creating JSONObject and JSONArray
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        Map jsonMap;

        albumDP = new AlbumDP();

        try
        {
            // 1. Abrir el conexión para leer  DB
            statement = conexion.createStatement();

            // 2. Ejecutar Query
            tr = statement.executeQuery(query);

            // 3. Procesar los datos
            while(tr.next())
            {
                albumDP.setArtista(tr.getString("Artista"));
                albumDP.setNombre(tr.getString("Nombre"));
                albumDP.setEdicion(tr.getString("Edicion"));
                albumDP.setImagen(tr.getString("Imagen"));
                albumDP.setPrecio(tr.getInt("Precio"));
                albumDP.setStock(tr.getInt("Stock"));

                jsonMap = new LinkedHashMap(6);

                jsonMap.put("Artista",albumDP.getArtista());
                jsonMap.put("Nombre",albumDP.getNombre());
                jsonMap.put("Edicion",albumDP.getEdicion());
                jsonMap.put("Imagen",albumDP.getImagen());
                jsonMap.put("Precio",albumDP.getPrecio());
                jsonMap.put("Stock",albumDP.getStock());
                jsonArray.add(jsonMap);
            }

            jsonObject.put("albums", jsonArray);

            datos = jsonObject.toString();

            // 4. Cerrar conexión a DB
            statement.close();
        }
        catch(SQLException ioe)
        {
            datos = "Error en consultar: "+ioe;
            System.out.println("Error: "+ioe);
        }

        return datos;
    }

    public String consultarAlbums() {
        String query = "SELECT * FROM Album";

        String datos = obtenerAlbums(query);

        return datos;
    }

    public String consultarArtista(String artist) {
        System.out.println("Searching: " + artist);
        String query = "SELECT * FROM Album WHERE Artista='" + artist + "'";

        String datos = obtenerAlbums(query);

        return datos;
    }

    public String consultarCanciones() {
        return "";
    }

    private String obtenerLibros(String query) {
        String datos = "";
        ResultSet tr;

        // creating JSONObject and JSONArray
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        Map jsonMap;

        // System.out.println(query);

        libroDP = new LibroDP();

        try
        {
            // 1. Abrir el conexión para leer  DB
            statement = conexion.createStatement();

            // 2. Ejecutar Query
            tr = statement.executeQuery(query);

            // 3. Procesar los datos
            while(tr.next())
            {
                libroDP.setTitulo(tr.getString("Titulo"));
                libroDP.setAutor(tr.getString("Autor"));
                libroDP.setEditorial(tr.getString("Editorial"));
                libroDP.setPrecio(tr.getInt("Precio"));
                libroDP.setStock(tr.getInt("Stock"));

                jsonMap = new LinkedHashMap(5);

                jsonMap.put("Titulo",libroDP.getTitulo());
                jsonMap.put("Autor",libroDP.getAutor());
                jsonMap.put("Editorial",libroDP.getEditorial());
                jsonMap.put("Precio",libroDP.getPrecio());
                jsonMap.put("Stock",libroDP.getStock());
                jsonArray.add(jsonMap);
            }

            jsonObject.put("libros", jsonArray);

            datos = jsonObject.toString();

            // 4. Cerrar conexión a DB
            statement.close();
        }
        catch(SQLException ioe)
        {
            datos = "Error en consultar: "+ioe;
            System.out.println("Error: "+ioe);
        }

        return datos;
    }

    public String capturarLibro(A.LibroDP libroDP) {
        return "";
    }

    public String consultarLibros() {
        String query = "SELECT * FROM Libro";

        String datos = obtenerLibros(query);

        return datos;
    }

    public String consultarTitulo(String title) {
        String query = "SELECT * FROM Libro WHERE Titulo='" + title + "'";

        String datos = obtenerLibros(query);

        return datos;
    }

    public String consultarEditorial(String editorial) {
        String query = "SELECT * FROM Libro WHERE Editorial='" + editorial + "'";

        String datos = obtenerLibros(query);

        return datos;
    }

    public String editarLibro() {
        return "";
    }

    public String logIn(String user, String password) {
        String query = "SELECT * FROM Cliente WHERE Correo='" + user + "' AND Password='" + password + "';";

        String datos = "";
        ResultSet tr;

        // creating JSONObject and JSONArray
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        Map jsonMap;

        System.out.println(query);

        clienteDP = new ClienteDP();

        try {
            // 1. Abrir el conexión para leer  DB
            statement = conexion.createStatement();

            // 2. Ejecutar Query
            tr = statement.executeQuery(query);

            // 3. Procesar los datos
            while(tr.next()) {
                clienteDP.setCorreo(tr.getString("Correo"));
                clienteDP.setPassword(tr.getString("Password"));
                clienteDP.setNombre(tr.getString("Nombre"));
                clienteDP.setDireccion(tr.getString("Direccion"));
                clienteDP.setTelefono(tr.getString("Telefono"));
                clienteDP.setTarjeta(tr.getString("Tarjeta"));
                clienteDP.setTipo(tr.getString("Tipo"));

                jsonMap = new LinkedHashMap(7);

                jsonMap.put("Correo",clienteDP.getCorreo());
                jsonMap.put("Password",clienteDP.getPassword());
                jsonMap.put("Nombre",clienteDP.getNombre());
                jsonMap.put("Direccion",clienteDP.getDireccion());
                jsonMap.put("Telefono",clienteDP.getTelefono());
                jsonMap.put("Tarjeta",clienteDP.getTarjeta());
                jsonMap.put("Tipo",clienteDP.getTipo());
                jsonArray.add(jsonMap);
            }

            jsonObject.put("clientes", jsonArray);

            datos = jsonObject.toString();

            // 4. Cerrar conexión a DB
            statement.close();
        }
        catch(SQLException ioe) {
            datos = "Error en consultar: "+ioe;
            System.out.println("Error: "+ioe);
        }

        return datos;
    }

    public String signUp(String data) {
        StringTokenizer st = new StringTokenizer(data,"_");
        String mail = st.nextToken();
        String pwd = st.nextToken();
        String name = st.nextToken();
        String address = st.nextToken();
        String phone = st.nextToken();
        String card = st.nextToken();
        String type = st.nextToken();

        String query = "INSERT INTO Cliente VALUES('" + mail+ "','" + pwd + "','" + name + "','" + address + "','" + phone + "','" + card + "','" + type + "');";

        String datos = "";

        // creating JSONObject and JSONArray
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        Map jsonMap;

        System.out.println(query);

        clienteDP = new ClienteDP();

        try {
            // 1. Abrir el conexión para leer  DB
            statement = conexion.createStatement();

            // 2. Ejecutar Query
            statement.execute(query);

            // 3. Procesar los datos
                clienteDP.setCorreo(mail);
                clienteDP.setPassword(pwd);
                clienteDP.setNombre(name);
                clienteDP.setDireccion(address);
                clienteDP.setTelefono(phone);
                clienteDP.setTarjeta(card);
                clienteDP.setTipo(type);

                jsonMap = new LinkedHashMap(7);

                jsonMap.put("Correo",clienteDP.getCorreo());
                jsonMap.put("Password",clienteDP.getPassword());
                jsonMap.put("Nombre",clienteDP.getNombre());
                jsonMap.put("Direccion",clienteDP.getDireccion());
                jsonMap.put("Telefono",clienteDP.getTelefono());
                jsonMap.put("Tarjeta",clienteDP.getTarjeta());
                jsonMap.put("Tipo",clienteDP.getTipo());
                jsonArray.add(jsonMap);


            jsonObject.put("clientes", jsonArray);

            datos = jsonObject.toString();

            // 4. Cerrar conexión a DB
            statement.close();
        }
        catch(SQLException ioe) {
            datos = "Error en consultar: "+ioe;
            System.out.println("Error: "+ioe);
        }

        return datos;
    }

    public void updateStockAlbum(String name) throws SQLException {
        // 1. Abrir el conexión para leer  DB
        statement = conexion.createStatement();

        String query = "UPDATE Album SET Stock = Stock - 1 WHERE Nombre='" + name + "';";

        System.out.println(query);
        // 2. Ejecutar Query
        statement.executeUpdate(query);

    }

    public void updateStockLibro(String name) throws SQLException {
        // 1. Abrir el conexión para leer  DB
        statement = conexion.createStatement();

        String query = "UPDATE Libro SET stock = stock - 1 WHERE Titulo=" + name;

        System.out.println(query);
        // 2. Ejecutar Query
        statement.executeUpdate(query);

    }

    public String newPurchase(String data) throws SQLException, ParseException, NumberFormatException {
        String datos = "";
        StringTokenizer st = new StringTokenizer(data,"_");
        ResultSet tr;

        System.out.println("Data: " + data);
        System.out.println("Tokens Num: " + st.countTokens());


        String mail = st.nextToken();
        String name = st.nextToken();
        String address = st.nextToken();
        String card = st.nextToken();
        String product = st.nextToken();
        int number = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        String date = st.nextToken();
        String time = st.nextToken().substring(0,5);


        // 1. Abrir el conexión para leer  DB
        statement = conexion.createStatement();

        String query = "INSERT INTO Compra(correo, nombre, direccion, tarjeta, articulo, cantidad, total, fecha, hora) VALUES('"+ mail + "','"+ name + "','"+ address + "','"+ card + "','"+ product + "',"+ number + ","+ total + ",'"+ date + "','"+ time + "');";

        System.out.println(query);
        // 2. Ejecutar Query
        statement.execute(query);

        updateStockAlbum(product);
        // updateStockLibro(name);

        datos = mail + "_" + name + "_" + address + "_" + card + "_" + product + "_" + number + "_" + total + "_" + date + "_" + time;
        return datos;
    }
}
