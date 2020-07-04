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
    
    @Test
    public void should_return_MTicket_when_store_given_MLockers_has_capacity_LockerRobotManage_and_primaryLockerRobot() throws StoreException {
        Locker mLock = new Locker(LockerType.M, 1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        primaryLockerRobot.manage(mLock);
        
        LockerRobotManage lockerRobotManage = new LockerRobotManage();
        lockerRobotManage.manage(primaryLockerRobot);
        Bag bag = new Bag(BagType.M);
        Ticket result = lockerRobotManage.store(bag, new VIPCard());
        
        Assertions.assertEquals(result.getLockerType(), LockerType.M);
    }
    
    @Test
    public void should_throw_exception_when_store_given_MLockers_has_no_capacity_and_LockerRobotManage_and_primaryLockerRobot() throws StoreException {
        Locker mLock = new Locker(LockerType.M, 0);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        primaryLockerRobot.manage(mLock);
        
        LockerRobotManage lockerRobotManage = new LockerRobotManage();
        lockerRobotManage.manage(primaryLockerRobot);
        Bag bag = new Bag(BagType.M);
        
        Assertions.assertThrows(StoreException.class, () -> {
            lockerRobotManage.store(bag, new VIPCard());
        });
    }
    
    @Test
    public void should_return_LTicket_when_store_given_LLockers_has_capacity_and_LockerRobotManage_and_superLockerRobot() throws StoreException {
        Locker lLock = new Locker(LockerType.L, 1);
        
        SuperLockerRobot superLockerRobot = new SuperLockerRobot();
        superLockerRobot.manage(lLock);
        LockerRobotManage lockerRobotManage = new LockerRobotManage();
        lockerRobotManage.manage(superLockerRobot);
        Bag bag = new Bag(BagType.L);
        Ticket result = lockerRobotManage.store(bag, new VIPCard());
        Assertions.assertEquals(result.getLockerType(), LockerType.L);
    }
}
