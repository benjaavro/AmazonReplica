<%--
  Created by IntelliJ IDEA.
  User: benjaavro
  Date: 14/06/20
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="org.json.simple.parser.*" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    String datos = session.getAttribute("respuesta").toString();
    String content_type = session.getAttribute("content").toString();

    JSONParser parser = new JSONParser();
    Object obj  = null;
    Object dataObj = null;

    // System.out.println(content_type);

    if (content_type.equals("login_data")) {
        try {
            obj = parser.parse(datos);
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject jsonDataObject;

            JSONArray data = (JSONArray) jsonObject.get("clientes");

            for (int i = 0; i < data.size(); i++) {
                dataObj = parser.parse(data.get(i).toString());
                jsonDataObject = (JSONObject) dataObj;

                String mail = jsonDataObject.get("Correo").toString();
                String name = jsonDataObject.get("Nombre").toString();
                String address = jsonDataObject.get("Direccion").toString();
                String card = jsonDataObject.get("Tarjeta").toString();

%>
    <div class="col-2"></div>
    <div class="col-8">
        <h4 style="margin-top: 15px;">Mail: <b id="compra_mail"><%=mail%></b></h4>
        <h4 style="margin-top: 15px;">Nombre: <b id="compra_name"><%=name%></b></h4>
        <h4 style="margin-top: 15px;">Direccion: <b id="compra_address"><%=address%></b></h4>
        <h4 style="margin-top: 15px;">Tarjeta: <b id="compra_card"><%=card%></b></h4>
    </div>
    <div class="col-2"></div>
<%

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    if (content_type.equals("product_data")) {
        String nombreArticulo = session.getAttribute("name").toString();
        String precioArticulo = session.getAttribute("price").toString();
        %>
    <div class="col-2"></div>
    <div class="col-8">
        <h4 style="margin-top: 15px;">Articulo: <b id="compra_article"><%=nombreArticulo%></b></h4>
        <div class="row">
            <div class="col-2">
                <h4>Cantidad:</h4>
            </div>
            <div class="form-group col-10">
                <input type="number" name="casilla" value="1" id="compra_quantity">
            </div>
        </div>
        <%
            int p = Integer.parseInt(precioArticulo);
            int total =  p * 1;
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();

        %>
        <h4 style="margin-top: 0px;">Total: $<b id="compra_total"><%=total%></b></h4>
        <h4 style="margin-top: 15px;">Fecha: <b id="compra_date"><%=date%></b></h4>
        <h4 style="margin-top: 15px;">Hora: <b id="compra_time"><%=time%></b></h4>
    </div>
    <div class="col-2"></div>

    <div class="row" style="margin-top: 30px; margin-bottom: 50px;">
        <div class="col-3"></div>
        <div class="col-3 align-items-right justify-content-center">
            <button class="btn btn-primary" style="margin: auto;  width: 100%;" onclick="registrarCompra()">Confirmar Compra</button>
        </div>
        <div class="col-3 align-items-left justify-content-center">
            <button class="btn btn-primary" style="margin: auto; width: 100%;" onclick="refreshPage()">Cancelar Compra</button>
        </div>
        <div class="col-3"></div>
    </div>
            <%
    }

    if (content_type.equals("accepted_data")) {
        String data = session.getAttribute("respuesta").toString();
        %>
<h1>TRANSACCIÓN EXITOSA</h1>
<h3><%=data%></h3>
<%
    }
%>


