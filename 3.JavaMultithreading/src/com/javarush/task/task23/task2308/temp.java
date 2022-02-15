package com.javarush.task.task23.task2308;

import com.javarush.task.task23.task2309.AbstractDbSelectExecutor;
import com.javarush.task.task23.task2309.vo.Subscription;

import java.util.List;

public class temp {



    public List<Subscription> getSubscriptions() {
        AbstractDbSelectExecutor<Subscription> abstractDbSelectExecutor = new AbstractDbSelectExecutor<>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM " + Subscription.class.getSimpleName() ;
            }
            @Override
            public List<Subscription> execute() {
                return super.execute();
            }
        };
        return abstractDbSelectExecutor.execute();
    }

//    "Id=5, name='User-5', description=Received from executing 'SELECT * FROM USER'
//    "Id=1, name='User-1', description=Received from executing 'SELECT * FROM User'
//
}
