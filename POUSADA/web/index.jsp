<% response.setHeader("Cache-Control","no-cache"); %>
<% response.setHeader("Pragma","no-cache");        %>
<%@page contentType="text/html" language="java"%>
<%@ page language="java" import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Pousada Tabajara</title>
    </head>
    <% 
	Integer n = (Integer)application.getAttribute("numVisitas"); 
	if (n==null) {
	   n= new Integer(1);
	   application.setAttribute("numVisitas",n);
	}
	else
	{
	   n = new Integer(n.intValue() + 1);
	   application.setAttribute("numVisitas",n);
	}
    %>
    <script language="JavaScript">
       location.href("/POUSADA/main/menu/index.jsp");
    </script>
</html>
