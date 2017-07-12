package edu.uci.cc;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
public class AddItem extends HttpServlet
{
	private static final Logger log = Logger.getLogger("CLOUD_COMPUTING");

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
      String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String website = req.getParameter("website");
		
		log.log(Level.INFO, "Add record to DAL");
		DAL dal = new DAL();
		Key key = dal.add(name, phone, email, website);

		log.log(Level.INFO, "Get the latest list from DAL");
		List<Entity> list =  dal.getAll();

		log.log(Level.INFO, "Storing list of Items to cache");
		LookupCache lookupCache = new LookupCache();
		lookupCache.storeIntoCache(list);
		
		try
 		{

 			if (key != null)
 			{
 	 			log.log(Level.INFO, "Setting Message attribute to Success");
	 			req.setAttribute("Message", "Success");
 			}
			else
			{
 	 			log.log(Level.INFO, "Setting Message attribute to Failed");
	 			req.setAttribute("Message", "Failed");
			}	

 			log.log(Level.INFO, "Forwarding the add request to add.jsp");
 			req.getRequestDispatcher("add.jsp").forward(req, resp);

		}
 		catch (ServletException e)
		{
 			log.log(Level.SEVERE, "Exception occured while forwarding the request to add.jsp");
			e.printStackTrace();
		}
		
	}
}
