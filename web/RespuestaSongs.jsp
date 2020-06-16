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
                    <th scope="col">Cancion</th>
                    <th scope="col">Album</th>
                    <th scope="col">Compositor</th>
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

                        JSONArray data = (JSONArray) jsonObject.get("songs");
                        // System.out.println("---> After Parse:");

                        for (int i = 0; i < data.size(); i++) {
                            dataObj = parser.parse(data.get(i).toString());
                            jsonDataObject = (JSONObject) dataObj;

                            String name = jsonDataObject.get("Nombre").toString();
                            String artist = jsonDataObject.get("Artista").toString();
                            String compositor = jsonDataObject.get("Compositor").toString();

                            // System.out.println(name + "_" + artist);
                %>
                <tr>
                    <td><b><h5 id="name_<%=i%>"><%=name%></h5></b></td>
                    <td id="artist_<%=i%>"><%=artist%></td>
                    <td id="edition_<%=i%>"><%=compositor%></td>
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
