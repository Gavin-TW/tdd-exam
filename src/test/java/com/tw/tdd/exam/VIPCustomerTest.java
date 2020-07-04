package com.tw.tdd.exam;

import com.tw.tdd.exam.exception.StoreException;
import com.tw.tdd.exam.pojo.Bag;
import com.tw.tdd.exam.pojo.Locker;
import com.tw.tdd.exam.pojo.Ticket;
import com.tw.tdd.exam.type.BagType;
import com.tw.tdd.exam.type.LockerType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Gavin
 */
public class VIPCustomerTest {
    
    @Test
    public void should_return_STicket_when_store_given_SLockers_has_capacity_LockerRobotManage() throws StoreException {
        Locker sLock = new Locker(LockerType.S, 1);
        
        LockerRobotManage lockerRobotManage = new LockerRobotManage();
        lockerRobotManage.manage(sLock);
        Bag bag = new Bag(BagType.S);
        Ticket result = lockerRobotManage.store(bag, new VIPCard());
        
        Assertions.assertEquals(result.getLockerType(), LockerType.S);
    }
    
    @Test
    public void should_throw_exception_when_store_given_SLockers_has_no_capacity_LockerRobotManage() throws StoreException {
        Locker sLock = new Locker(LockerType.S, 0);
        
        LockerRobotManage lockerRobotManage = new LockerRobotManage();
        lockerRobotManage.manage(sLock);
        Bag bag = new Bag(BagType.S);
        
        Assertions.assertThrows(StoreException.class, () -> {
            lockerRobotManage.store(bag, new VIPCard());
        });
    }
}
