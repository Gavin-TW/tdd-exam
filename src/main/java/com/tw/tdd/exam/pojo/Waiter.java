package com.tw.tdd.exam.pojo;

import com.tw.tdd.exam.PrimaryLockerRobot;
import com.tw.tdd.exam.Storeable;
import com.tw.tdd.exam.exception.StoreException;
import com.tw.tdd.exam.type.BagType;
import com.tw.tdd.exam.type.MessageContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Gavin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Waiter implements Storeable {
    
    private Locker locker;
    private PrimaryLockerRobot primaryLockerRobot;
    
    @Override
    public Ticket store(Bag bag) throws StoreException {
        switch (bag.getType()) {
            case BagType.S:
                return locker.store(bag);
            case BagType.M:
                return primaryLockerRobot.store(bag);
            default:
                throw new StoreException(MessageContent.UN_SUPPORT);
        }
    }
    
    public void manage(PrimaryLockerRobot primaryLockerRobot) {
        this.primaryLockerRobot = primaryLockerRobot;
    }
    
    public void manage(Locker locker) {
        this.locker = locker;
    }
}
