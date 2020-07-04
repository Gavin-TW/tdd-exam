package com.tw.tdd.exam.pojo;

import com.tw.tdd.exam.Storeable;
import com.tw.tdd.exam.exception.StoreException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gavin
 */
public class Locker implements Storeable {
    
    private Map<Ticket, Bag> bagMap = new HashMap<>();
    public String type;
    public int capacity;
    
    public Locker(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }
    
    @Override
    public Ticket store(Bag bag) throws StoreException {
        if (checkCapacity()) {
            Ticket ticket = new Ticket(type);
            bagMap.put(ticket, bag);
            return ticket;
        } else {
            throw new StoreException(type + "型储物柜已满");
        }
    }
    
    private boolean checkCapacity() {
        return capacity > bagMap.size();
    }
}
