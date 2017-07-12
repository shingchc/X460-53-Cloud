<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Add</title>
  </head>

  <body>
    <h1>Add</h1>
	
	<form method="POST" action="add">	
    <table>
      <tr>
        <td>Name:</td>        
        <td><input type="text" name="name"></td>        
      </tr>
      <tr>
        <td>Phone:</td>        
        <td><input type="text" name="phone"></td>        
      </tr>
      <tr>
        <td>Email:</td>        
        <td><input type="text" name="email"></td>        
      </tr>
      <tr>
        <td>WebSite:</td>        
        <td><input type="text" name="website"></td>        
      </tr>
      <tr>
        <td><input type="Reset"  value="Reset"></td>        
        <td><input type="Submit" value="Submit"></td>        
      </tr>
    </table>
    
<p>
    <table>
      <tr>
        <td><a href="index.html">Main Page</a></td>
      </tr>
      <tr>
        <td><a href="list">List Items</a></td>
      </tr>
    </table>
</p>
    </form>
  </body>
</html>
