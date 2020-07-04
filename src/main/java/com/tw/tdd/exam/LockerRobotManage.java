package com.tw.tdd.exam;

import com.tw.tdd.exam.exception.StoreException;
import com.tw.tdd.exam.pojo.Bag;
import com.tw.tdd.exam.pojo.Ticket;
import com.tw.tdd.exam.type.MessageContent;

/**
 * @author Gavin
 */
public class LockerRobotManage extends AbstractManager implements Storeable {
    
    public Ticket store(Bag bag, VIPCard vipCard) throws StoreException {
        if (vipCard != null) {
            return super.store(bag);
        }
        throw new StoreException(MessageContent.NOT_VIP);
    }
}
