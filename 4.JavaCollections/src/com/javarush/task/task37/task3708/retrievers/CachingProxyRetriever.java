package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{
    OriginalRetriever retriever;
    LRUCache cache = new LRUCache(16);

    public CachingProxyRetriever(Storage storage) {
        retriever = new OriginalRetriever(storage);
    }


    @Override
    public Object retrieve(long id) {
        Object o =  cache.find(id);

        if (o == null){
            Object result = retriever.retrieve(id);
            cache.set(id,result);
            return result;
        }
        return o;
    }
}
