<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<%@ page import="com.google.appengine.api.datastore.PhoneNumber" %>
<%@ page import="com.google.appengine.api.datastore.Link" %>
<%@ page import="com.google.appengine.api.datastore.Email" %>

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>List</title>
  </head>

  <body>
   <h1>List</h1>
    <table>
<%
	List<Entity> entityList = (List<Entity>)request.getAttribute("list");
	
    if (entityList != null && !entityList.isEmpty())
	{
		for (int i = 0; i < entityList.size(); i++)
		{
			Entity entity = entityList.get(i);
%>
		<tr>
			<td><%= ((String)entity.getProperty("name")) %> - </td>
			<td><%= ((PhoneNumber)entity.getProperty("phone")).getNumber() %> - </td>
			<td><%= ((Email)entity.getProperty("email")).getEmail() %> - </td>
			<td><%= ((Link)entity.getProperty("website")).getValue() %> </td>
		</tr>
<%
		}
    	
	}
    else
    {
%>
		<tr><td>There are no items to display</td></tr>
<%
    }
%>	
	</table>
<p>
     <table>
      <tr>
        <td><a href="index.html">Main Page</a></td>
      </tr>
      <tr>
        <td><a href="add.jsp">Add Item</a></td>
      </tr>
    </table>
</p>
  </body>
</html>
