package com.tw.tdd.exam;

import com.tw.tdd.exam.exception.PickException;
import com.tw.tdd.exam.exception.StoreException;
import com.tw.tdd.exam.pojo.Bag;
import com.tw.tdd.exam.pojo.Locker;
import com.tw.tdd.exam.pojo.Ticket;
import com.tw.tdd.exam.type.BagType;
import com.tw.tdd.exam.type.LockerType;
import com.tw.tdd.exam.type.MessageContent;
import lombok.Data;

/**
 * @author Gavin
 */
@Data
public class AbstractManager {
    
    private Locker locker;
    private PrimaryLockerRobot primaryLockerRobot;
    private SuperLockerRobot superLockerRobot;
    
    public void manage(PrimaryLockerRobot primaryLockerRobot) {
        this.primaryLockerRobot = primaryLockerRobot;
    }
    
    public void manage(Locker locker) {
        this.locker = locker;
    }
    
    public void manage(SuperLockerRobot superLockerRobot) {
        this.superLockerRobot = superLockerRobot;
    }
    
    public Ticket store(Bag bag) throws StoreException {
        switch (bag.getType()) {
            case BagType.S:
                return locker.store(bag);
            case BagType.M:
                return primaryLockerRobot.store(bag);
            case BagType.L:
                return superLockerRobot.store(bag);
            default:
                throw new StoreException(MessageContent.UN_SUPPORT);
        }
    }
    
    public Bag getBag(Ticket ticket) throws PickException {
        switch (ticket.getLockerType()) {
            case LockerType.S:
                return locker.takeBag(ticket);
            case LockerType.M:
                return primaryLockerRobot.takeBag(ticket);
            case LockerType.L:
                return superLockerRobot.takeBag(ticket);
            default:
                throw new PickException(MessageContent.TICKET_NOT_SUPPORT);
        }
    }
}
