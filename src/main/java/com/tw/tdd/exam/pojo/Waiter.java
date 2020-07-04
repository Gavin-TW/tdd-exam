package com.tw.tdd.exam.pojo;

import com.tw.tdd.exam.Storeable;
import com.tw.tdd.exam.exception.StoreException;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Gavin
 */
@Data
@AllArgsConstructor
public class Waiter implements Storeable {
    
    private Locker locker;
    
    @Override
    public Ticket store(Bag bag) throws StoreException {
        return locker.store(bag);
    }
}
