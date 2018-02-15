<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%! Random rnd=new Random(); %>
	<%
		System.out.println("hi");
		out.print("hello");

	
	%>
	
	<table border="1" cellpadding="10">
		<% for (int i=0;i<100;i++){ %>
		<tr>
			<td><%= rnd.nextInt(999) %></td>
			<td><%= rnd.nextInt(999) %></td>
			<td><%= rnd.nextInt(999) %></td>
		</tr>
		<%} %>
		
	</table>
</body>
</html>