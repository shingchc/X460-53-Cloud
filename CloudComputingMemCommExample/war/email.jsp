<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Email</title>
  </head>

  <body>
    <h1>Email</h1>
<%
	User user = (User)session.getAttribute("user");
	String fromEmail = "";

	if (user != null)
		fromEmail = user.getEmail(); 
%>

	<form method="POST" action="message">	
    <table>
      <tr>
        <td>To:</td>        
        <td><input type="text" name="to" size="100" value="<%= request.getParameter("email")%>"></td>        
      </tr>
      <tr>
        <td>From:</td>        
        <td><input type="text" name="from" size="100" value="<%= fromEmail %>"></td>        
      </tr>
      <tr>
        <td>Subject:</td>        
        <td><input type="text" name="subject" size="100"></td>        
      </tr>
      <tr>
        <td colspan="2">Message:</td>        
        </tr>
	  <tr>
        <td></td>        
        <td colspan="2"><textarea rows="40" cols="70" name="message"></textarea></td>        
      </tr>
      <tr>
        <td><input type="Reset"  value="Reset"></td>        
        <td><input type="Submit" value="Submit"></td>        
      </tr>
    </table>
<p>
     <table>
      <tr>
        <td><a href="index.jsp">Main Page</a></td>
      </tr>
    </table>
</p>

    </form>
  </body>
</html>
