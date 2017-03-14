<%--
  Created by IntelliJ IDEA.
  User: raviagrawal
  Date: 29/01/17
  Time: 8:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>


<html>
<head>
    <title>Beer results</title>
</head>
<body>
<h1 align="center">Beer Recommendations JSP</h1>
<p>

<%
    List styles = (List) request.getAttribute("styles");
    Iterator it = styles.iterator();
    while (it.hasNext()){
        out.print("<br> try: " + it.next());
    }
%>
</body>
</html>
