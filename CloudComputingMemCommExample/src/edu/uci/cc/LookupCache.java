package edu.uci.cc;

import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

public class LookupCache
{
	private static String PRIMARY_CACHE_KEY = "PRIMARY_LOOK_UP_CACHE_KEY";

	public void storeIntoCache(List<Entity> itemsList)
	{
        MemcacheService memService = MemcacheServiceFactory.getMemcacheService();
        memService.clearAll();
        memService.put(PRIMARY_CACHE_KEY, itemsList);
	}
	
	public List<Entity> retrieveFromCache() 
	{
        MemcacheService memService = MemcacheServiceFactory.getMemcacheService();
        @SuppressWarnings("unchecked")
		List<Entity> itemsList = (List<Entity>) memService.get(PRIMARY_CACHE_KEY);
        
        return itemsList;
	}
	
}
