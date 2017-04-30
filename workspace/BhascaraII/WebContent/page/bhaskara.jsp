<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bhaskara</title>
</head>
<body>
<jsp:useBean id="bhaskara" scope="page" type="br.com.uninove.bean.BhaskaraBean"/>

	<jsp:setProperty property="a" name="bhaskara" value='<%=request.getParameter("a")%>' />
	<jsp:setProperty property="b" name="bhaskara" value='<%=request.getParameter("b")%>' />
	<jsp:setProperty property="c" name="bhaskara" value='<%=request.getParameter("c")%>' />
	
	
	Delta: <%= bhaskara.getDelta() %>
	Raiz Positiva: <%= bhaskara.getRaizPositiva() %>
	Raiz Negativa: <%= bhaskara.getRaizNegativa() %>


</body>
</html>