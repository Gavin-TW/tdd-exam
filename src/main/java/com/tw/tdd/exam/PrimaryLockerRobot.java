package com.tw.tdd.exam;

import com.tw.tdd.exam.exception.StoreException;
import com.tw.tdd.exam.pojo.Bag;
import com.tw.tdd.exam.pojo.Locker;
import com.tw.tdd.exam.pojo.Ticket;
import com.tw.tdd.exam.type.MessageContent;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gavin
 */
@Data
public class PrimaryLockerRobot implements Storeable {
    
    private List<Locker> lockers = new ArrayList<>();
    
    public void manage(Locker locker) {
        lockers.add(locker);
    }
    
    @Override
    public Ticket store(Bag bag) throws StoreException {
        for (Locker locker : lockers) {
            try {
                return locker.store(bag);
            } catch (StoreException e) {
            }
        }
        throw new StoreException(MessageContent.NO_CAPACITY);
    }
    
    public Bag takeBag(Ticket ticket) throws StoreException {
        for (Locker locker : lockers) {
            if (locker.getBagMap().get(ticket) != null) {
                return locker.getBagMap().get(ticket);
            }
        }
        throw new StoreException(MessageContent.BAG_NOT_FPUND);
    }
}
