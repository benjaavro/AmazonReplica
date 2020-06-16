<%--
  Created by IntelliJ IDEA.
  User: benjaavro
  Date: 14/06/20
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.StringTokenizer" %>
<%@ page import="org.json.simple.*" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.parser.ParseException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    private class param {
    }

    private class forward {
    }
%>
<jsp:useBean id="amazonAD" class="A.AmazonADjdbc">

</jsp:useBean>
<jsp:useBean id="librodp" class="A.LibroDP">

</jsp:useBean>
<jsp:useBean id="albumdp" class="A.AlbumDP">

</jsp:useBean>
<jsp:useBean id="songdp" class="A.SongDP">

</jsp:useBean>
<jsp:useBean id="compradp" class="A.CompraDP">

</jsp:useBean>
<jsp:useBean id="clientedp" class="A.ClienteDP">

</jsp:useBean>

<jsp:setProperty name="librodp" property="*" />
<jsp:setProperty name="albumdp" property="*" />
<jsp:setProperty name="songdp" property="*" />
<jsp:setProperty name="compradp" property="*" />
<jsp:setProperty name="clientedp" property="*" />

<%
    String solicitud;
    String datos = "";
    StringTokenizer st = null;

    if(request.getParameter("action") != null) {
        System.out.println("Action: " + request.getParameter("action"));
        solicitud = request.getParameter("action");

        if (solicitud.equals("getAlbums")) {
            datos = amazonAD.consultarAlbums();
            System.out.println("Respuesta: " + datos);
            session.setAttribute("respuesta",datos);
            %>
<jsp:forward page="/RespuestaAlbums.jsp">
    <jsp:param name="respuesta" value="<%=datos%>" />
</jsp:forward>
<%
        }

        if (solicitud.equals("getArtista")) {
            String artist = request.getParameter("artist");
            datos = amazonAD.consultarArtista(artist);
            System.out.println("Respuesta: " + datos);
            session.setAttribute("respuesta",datos);
%>
<jsp:forward page="/RespuestaAlbums.jsp">
    <jsp:param name="respuesta" value="<%=datos%>" />
</jsp:forward>
<%
        }

        if (solicitud.equals("getLibros")) {
            datos = amazonAD.consultarLibros();
            System.out.println("Respuesta: " + datos);
            session.setAttribute("respuesta",datos);
%>
<jsp:forward page="/RespuestaLibros.jsp">
    <jsp:param name="respuesta" value="<%=datos%>" />
</jsp:forward>
<%
        }

        if (solicitud.equals("getEditorial")) {
            String edit = request.getParameter("editorial");
            datos = amazonAD.consultarEditorial(edit);
            System.out.println("Respuesta: " + datos);
            session.setAttribute("respuesta",datos);
%>
<jsp:forward page="/RespuestaLibros.jsp">
    <jsp:param name="respuesta" value="<%=datos%>"/>
</jsp:forward>
<%
        }

        if (solicitud.equals("getTitulo")) {
            String title = request.getParameter("titulo");
            datos = amazonAD.consultarTitulo(title);
            System.out.println("Respuesta: " + datos);
            session.setAttribute("respuesta",datos);
%>
<jsp:forward page="/RespuestaLibros.jsp">
    <jsp:param name="respuesta" value="<%=datos%>"/>
</jsp:forward>
<%
        }

        if (solicitud.equals("newLibro")) {
            datos = amazonAD.capturarLibro(librodp);
            System.out.println("Respuesta: " + datos);
            session.setAttribute("respuesta",datos);
%>
<jsp:forward page="/RespuestaLibros.jsp">
    <jsp:param name="respuesta" value="<%=datos%>"/>
</jsp:forward>
<%
        }

    if (solicitud.equals("logIn")) {
        String user = request.getParameter("user");
        String password = request.getParameter("pwd");
        datos = amazonAD.logIn(user, password);
        System.out.println("Respuesta: " + datos);
        session.setAttribute("respuesta",datos);
        session.setAttribute("content","login_data");
%>
<jsp:forward page="/RespuestaCompra.jsp">
    <jsp:param name="respuesta" value="<%=datos%>"/>
    <jsp:param name="content" value="login_data"/>
</jsp:forward>
<%
        }

    if (solicitud.equals("signUp")) {
        String data = request.getParameter("data");
        datos = amazonAD.signUp(data);
        System.out.println("Respuesta: " + datos);
        session.setAttribute("respuesta",datos);
        session.setAttribute("content","login_data");
%>
<jsp:forward page="/RespuestaCompra.jsp">
    <jsp:param name="respuesta" value="<%=datos%>"/>
    <jsp:param name="content" value="login_data"/>
</jsp:forward>
<%
    }

    if (solicitud.equals("selectionData")) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        session.setAttribute("name",name);
        session.setAttribute("price",price);
        session.setAttribute("content","product_data");
        System.out.println(session.getAttribute("content"));
%>
<jsp:forward page="/RespuestaCompra.jsp">
    <jsp:param name="content" value="product_data"/>
    <jsp:param name="name" value="<%=name%>"/>
    <jsp:param name="price" value="<%=price%>"/>
</jsp:forward>
<%
        }

    if (solicitud.equals("newPurchase")) {
        String data = request.getParameter("datos");
        System.out.println(session.getAttribute("content"));
        datos = amazonAD.newPurchase(data);
        session.setAttribute("respuesta",datos);
        session.setAttribute("content","accepted_data");
%>
<jsp:forward page="/RespuestaCompra.jsp">
    <jsp:param name="content" value="accepted_data"/>
    <jsp:param name="respuesta" value="<%=datos%>"/>
</jsp:forward>
<%
        }

    if (solicitud.equals("getSongs")) {
        String data = request.getParameter("datos");
        System.out.println(session.getAttribute("content"));
        datos = amazonAD.newPurchase(data);
        session.setAttribute("respuesta",datos);
        session.setAttribute("content","accepted_data");
%>
<jsp:forward page="/RespuestaCompra.jsp">
    <jsp:param name="content" value="accepted_data"/>
    <jsp:param name="respuesta" value="<%=datos%>"/>
</jsp:forward>
<%
        }
    }
%>
