<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Hello App Engine</title>
  </head>

  <body>
    <h1>Hello App Engine!</h1>
<p>	
    <table>
      <tr>
        <td colspan="2" style="font-weight:bold;">Available Servlets:</td>        
      </tr>
      <tr>
        <td><a href="cloudcomputingmemcommexample">CloudComputingMemCommExample</a></td>
      </tr>
      <tr>
        <td><a href="add.jsp">Add Item</a></td>
      </tr>
      <tr>
        <td><a href="list">List Items</a></td>
      </tr>
      <tr>
        <td><a href="email.jsp">Email</a></td>
      </tr>

    </table>
</p>    
 <p>
     <table>
<%
    User user = (User)session.getAttribute("user");
    
    if (user != null)
    {
%>
        <tr>
            <td>User ID: </td><td><%= user.getUserId() %></td>
        </tr>
        <tr>
            <td>User Nick Name:</td><td><%= user.getNickname() %></td>
        </tr>
        <tr>
            <td>User Email:</td><td><%= user.getEmail() %></td>
        </tr>
<%

        String strDestURL = "http://" +
                            request.getServerName() + ":" +
                            request.getServerPort() + "/";

        UserService userService = UserServiceFactory.getUserService();
        String logoutURL = userService.createLogoutURL(strDestURL);
%>
        <tr>
            <td colspan="2"><a href="<%= logoutURL %>">Logout</a></td>
        </tr>
<%  
    }
    else
    {
%>
        <tr><td>There are no user information</td></tr>
<%
    }
%>  
    </table>
 
 </p>
  </body>
</html>
