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
public class SuperLockerRobot implements Storeable {
    private List<Locker> lockers = new ArrayList<>();
    
    private double vacancyRateFlag = 0;
    private int lockerIndex = -1;
    
    @Override
    public Ticket store(Bag bag) throws StoreException {
        for (int i = 0; i < lockers.size(); i++) {
            if ((vacancyRateFlag <= getVancacy(lockers.get(i)))) {
                vacancyRateFlag = getVancacy(lockers.get(i));
                lockerIndex = i;
            }
        }
        return lockers.get(lockerIndex).store(bag);
    }
    
    private double getVancacy(Locker locker) {
        return (locker.capacity - locker.getBagMap().size()) / locker.capacity;
    }
    
    public void manage(Locker locker) {
        lockers.add(locker);
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
