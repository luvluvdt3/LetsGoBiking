using System;
using System.Runtime.Caching;

public class GenericProxyCache<T>
{
    private ObjectCache cache = MemoryCache.Default;
    private CacheItemPolicy defaultCachePolicy = new CacheItemPolicy { AbsoluteExpiration = ObjectCache.InfiniteAbsoluteExpiration };

    public T Get(string cacheItemName)
    {
        return Get(cacheItemName, defaultCachePolicy);
    }

    public T Get(string cacheItemName, double dt_seconds)
    {
        var expiration = DateTimeOffset.Now.AddSeconds(dt_seconds);
        var cachePolicy = new CacheItemPolicy { AbsoluteExpiration = expiration };
        return Get(cacheItemName, cachePolicy);
    }

    public T Get(string cacheItemName, DateTimeOffset dt)
    {
        var cachePolicy = new CacheItemPolicy { AbsoluteExpiration = dt };
        return Get(cacheItemName, cachePolicy);
    }

    private T Get(string cacheItemName, CacheItemPolicy cachePolicy)
    {
        if (cache.Contains(cacheItemName))
        {
            return (T)cache[cacheItemName];
        }

        var newItem = Activator.CreateInstance<T>();
        cache.Add(cacheItemName, newItem, cachePolicy);
        return newItem;
    }
}
