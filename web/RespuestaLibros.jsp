<%--
  Created by IntelliJ IDEA.
  User: benjaavro
  Date: 14/06/20
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="org.json.simple.*" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.parser.ParseException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid" style="margin-top: 70px; text-align: center;">
    <div class="row">
        <div class="col-12">
            <table class="table" style="width: 100%;">
                <thead class="bg-primary">
                <tr>
                    <th scope="col">Titulo</th>
                    <th scope="col">Autor</th>
                    <th scope="col">Editorial</th>
                    <th scope="col">Imagen</th>
                    <th scope="col">Precio</th>
                </tr>
                </thead>
                <tbody>
                <%
                    String datos = session.getAttribute("respuesta").toString();
                    //System.out.println("---> Respuesta: \n" + datos);

                    JSONParser parser = new JSONParser();
                    Object obj  = null;
                    Object dataObj = null;

                    try {
                        obj = parser.parse(datos);
                        JSONObject jsonObject = (JSONObject) obj;
                        JSONObject jsonDataObject;

                        JSONArray data = (JSONArray) jsonObject.get("libros");
                        // System.out.println("---> After Parse:");

                        for (int i = 0; i < data.size(); i++) {
                            dataObj = parser.parse(data.get(i).toString());
                            jsonDataObject = (JSONObject) dataObj;

                            String title = jsonDataObject.get("Titulo").toString();
                            String author = jsonDataObject.get("Autor").toString();
                            String edit = jsonDataObject.get("Editorial").toString();
                            String image = jsonDataObject.get("Titulo").toString() + ".png";
                            int price = Integer.parseInt(jsonDataObject.get("Precio").toString());
                            int stock = Integer.parseInt(jsonDataObject.get("Stock").toString());

                            // System.out.println(name + "_" + artist);
                %>
                <tr>
                    <td><b id="name_<%=i%>"><%=title%></b></td>
                    <td><%=author%></td>
                    <td><%=edit%></td>
                    <td><img src="/AmazonDAI_war_exploded/img/<%=image%>" alt=""></td>
                    <td>
                        <div class="row align-items-center justify-content-center"><h4 style="margin-top: 40px;"><b id="price_<%=i%>">$<%=price%></b></h4></div>
                        <div class="row align-items-center justify-content-center"><button class="btn btn-primary" style="margin-top: 10px;" onclick="requestCompra(<%=i%>)" id="<%=i%>">Comprar</button></div>
                    </td>
                </tr>
                <%

                        }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                %>
                </tbody>
            </table>
        </div>
    </div>
</div>


