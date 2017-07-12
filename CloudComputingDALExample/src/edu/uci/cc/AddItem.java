package edu.uci.cc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
public class AddItem extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
        String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String website = req.getParameter("website");
		
		DAL dal = new DAL();
		Key key = dal.add(name, phone, email, website);
		
		try
 		{
			if (key != null)
	 			req.setAttribute("Message", "Success");
			else
	 			req.setAttribute("Message", "Failed");
				
			req.getRequestDispatcher("add.jsp").forward(req, resp);

		}
 		catch (ServletException e)
		{
			e.printStackTrace();
		}
		
	}
}
