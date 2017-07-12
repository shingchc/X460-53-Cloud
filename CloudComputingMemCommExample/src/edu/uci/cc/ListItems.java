package edu.uci.cc;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class ListItems extends HttpServlet
{
	private static final Logger log = Logger.getLogger("CLOUD_COMPUTING");

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		
		log.log(Level.INFO, "Retrieving Items from cache");
		LookupCache lookupCache = new LookupCache();
		List<Entity> list = lookupCache.retrieveFromCache();
		
		if (list == null || list.isEmpty())
		{
			DAL dal = new DAL();
			list =  dal.getAll();

			log.log(Level.INFO, "Storing Items to cache");
			lookupCache.storeIntoCache(list);
		}
		
 		try
 		{
 			log.log(Level.INFO, "Forwarding the list request to list.jsp");
 			req.setAttribute("list", list);
				
			req.getRequestDispatcher("list.jsp").forward(req, resp);

		}
 		catch (ServletException e)
		{
 			log.log(Level.SEVERE, "Exception occured while forwarding the request to list.jsp");
			e.printStackTrace();
		}

	}
}
