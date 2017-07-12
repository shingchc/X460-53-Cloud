package edu.uci.cc;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Link;
import com.google.appengine.api.datastore.PhoneNumber;
import com.google.appengine.api.datastore.Email;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.api.datastore.Query.FilterPredicate;

public class DAL
{
	public Key add(String name, String phone, String email, String website)
	{
		Key key = null;

		if (name != null && email != null && phone != null && website != null)
		{
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

			Entity entity = null;
			entity = new Entity("Contact");

			entity.setProperty("name", name);
			entity.setProperty("phone", new PhoneNumber(phone));
			entity.setProperty("email", new Email(email));
			entity.setProperty("website", new Link(website));

			key = datastore.put(entity);

		}
		return key;
	}

	public List<Entity> getAll()
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		Query findQuery = new Query("Contact");
		findQuery.addSort("name", SortDirection.ASCENDING);

		PreparedQuery pq = datastore.prepare(findQuery);
		FetchOptions option = FetchOptions.Builder.withLimit(500);

		List<Entity> results = pq.asList(option);
		

		return results;
	}

	public List<Entity> queryByEmail(String email)
	{
		List<Entity> results = null;

		if (email != null && !email.isEmpty())
		{
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

			Query findQuery = new Query("Contact");
			Filter emailFilter = new FilterPredicate("email",FilterOperator.EQUAL,email.toLowerCase());
			findQuery.setFilter(emailFilter);
			findQuery.addSort("email", SortDirection.ASCENDING);
			results = datastore.prepare(findQuery).asList(FetchOptions.Builder.withLimit(10));
		}

		return results;
	}

}
