package com.tw.tdd.exam;

import com.tw.tdd.exam.exception.StoreException;
import com.tw.tdd.exam.pojo.Bag;
import com.tw.tdd.exam.pojo.Locker;
import com.tw.tdd.exam.pojo.Ticket;
import com.tw.tdd.exam.pojo.Waiter;
import com.tw.tdd.exam.type.BagType;
import com.tw.tdd.exam.type.LockerType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Gavin
 */
public class NormalCustomerTest {
    
    @Test
    public void should_return_STicket_when_store_bag_by_waiter_given_SBag_SLocker_has_capacity() throws StoreException {
        Locker sLock = new Locker(LockerType.S, 1);
        
        Waiter xiaoY = new Waiter(sLock);
        Bag bag = new Bag(BagType.S);
        Ticket result = xiaoY.store(bag);
        
        Assertions.assertEquals(result.getLockerType(), LockerType.S);
    }
}
