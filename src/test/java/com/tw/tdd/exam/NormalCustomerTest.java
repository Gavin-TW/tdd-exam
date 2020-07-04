package com.tw.tdd.exam;

import com.tw.tdd.exam.exception.StoreException;
import com.tw.tdd.exam.pojo.Bag;
import com.tw.tdd.exam.pojo.Locker;
import com.tw.tdd.exam.pojo.Ticket;
import com.tw.tdd.exam.type.BagType;
import com.tw.tdd.exam.type.LockerType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Gavin
 */
public class NormalCustomerTest {
    
    @Test
    public void should_return_STicket_when_store_bag_by_waiter_given_SBag_SLocker_has_capacity() throws StoreException {
        Locker sLock = new Locker(LockerType.S, 1);
        
        Waiter xiaoY = new Waiter();
        xiaoY.manage(sLock);
        Bag bag = new Bag(BagType.S);
        Ticket result = xiaoY.store(bag);
        
        Assertions.assertEquals(result.getLockerType(), LockerType.S);
    }
    
    @Test
    public void should_throw_exception_when_store_bag_by_waiter_given_SBag_SLocker_has_no_capacity() {
        Locker sLock = new Locker(LockerType.S, 0);
        
        Waiter xiaoY = new Waiter();
        xiaoY.manage(sLock);
        Bag bag = new Bag(BagType.S);
        
        Assertions.assertThrows(StoreException.class, () -> {
            xiaoY.store(bag);
        });
    }
    
    @Test
    public void should_return_MTicket_when_store_bag_by_waiter_given_MBag_2_MLockers_has_capacity_primaryLockerRobot() throws StoreException {
        Locker mLock1 = new Locker(LockerType.M, 1);
        Locker mLock2 = new Locker(LockerType.M, 2);
        
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        primaryLockerRobot.manage(mLock1);
        primaryLockerRobot.manage(mLock2);
        Waiter xiaoY = new Waiter();
        xiaoY.manage(primaryLockerRobot);
        Bag bag = new Bag(BagType.M);
        
        Ticket ticket = xiaoY.store(bag);
        
        Assertions.assertEquals(LockerType.M, ticket.getLockerType());
        Assertions.assertEquals(bag, primaryLockerRobot.getLockers().get(0).getBag(ticket));
        
    }
    
    @Test
    public void should_return_MTicket_when_store_bag_by_waiter_given_MBag_2_MLockers_only_1_has_capacity_primaryLockerRobot() throws StoreException {
        Locker mLock1 = new Locker(LockerType.M, 0);
        Locker mLock2 = new Locker(LockerType.M, 2);
        
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        primaryLockerRobot.manage(mLock1);
        primaryLockerRobot.manage(mLock2);
        Waiter xiaoY = new Waiter();
        xiaoY.manage(primaryLockerRobot);
        Bag bag = new Bag(BagType.M);
        
        Ticket ticket = xiaoY.store(bag);
        
        Assertions.assertEquals(LockerType.M, ticket.getLockerType());
        Assertions.assertEquals(bag, primaryLockerRobot.getLockers().get(1).getBag(ticket));
    }
    
    @Test
    public void should_throw_exception_when_store_bag_by_waiter_given_MBag_2_MLockers_has_no_capacity_primaryLockerRobot() throws StoreException {
        Locker mLock1 = new Locker(LockerType.M, 0);
        Locker mLock2 = new Locker(LockerType.M, 0);
        
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        primaryLockerRobot.manage(mLock1);
        primaryLockerRobot.manage(mLock2);
        Waiter xiaoY = new Waiter();
        xiaoY.manage(primaryLockerRobot);
        Bag bag = new Bag(BagType.M);
        
        Assertions.assertThrows(StoreException.class, () -> {
            xiaoY.store(bag);
        });
    }
    
    @Test
    public void should_return_LTicket_when_store_bag_by_waiter_given_LBag_2_LLockers_has_capacity_superLockerRobot() throws StoreException {
        Locker lLock1 = new Locker(LockerType.L, 2);
        Locker lLock2 = new Locker(LockerType.L, 10);
        
        SuperLockerRobot superLockerRobot = new SuperLockerRobot();
        superLockerRobot.manage(lLock1);
        superLockerRobot.manage(lLock2);
        Waiter xiaoY = new Waiter();
        xiaoY.manage(superLockerRobot);
        Bag bag1 = new Bag(BagType.L);
        Bag bag2 = new Bag(BagType.L);
        Bag bag3 = new Bag(BagType.L);
        
        xiaoY.store(bag1);
        xiaoY.store(bag2);
        
        Ticket result = xiaoY.store(bag3);
        
        Assertions.assertEquals(LockerType.L, result.getLockerType());
        Assertions.assertEquals(bag3, superLockerRobot.getLockers().get(1).getBag(result));
    }
    
    @Test
    public void should_throw_exception_when_store_bag_by_waiter_given_LBag_2_LLockers_has_no_capacity() throws StoreException {
        Locker lLock1 = new Locker(LockerType.L, 1);
        Locker lLock2 = new Locker(LockerType.L, 1);
        
        SuperLockerRobot superLockerRobot = new SuperLockerRobot();
        superLockerRobot.manage(lLock1);
        superLockerRobot.manage(lLock2);
        Waiter xiaoY = new Waiter();
        xiaoY.manage(superLockerRobot);
        Bag bag1 = new Bag(BagType.L);
        Bag bag2 = new Bag(BagType.L);
        Bag bag3 = new Bag(BagType.L);
        
        xiaoY.store(bag1);
        xiaoY.store(bag2);
        
        Assertions.assertThrows(StoreException.class, () -> {
            xiaoY.store(bag3);
        });
    }
    
    
    @ParameterizedTest
    @CsvSource({
            LockerType.S,
            LockerType.M,
            LockerType.L,
    })
    public void shoud_return_bag_when_get_bag_given_ticket(String ticketType) throws StoreException {
        Locker sLock = new Locker(ticketType, 1);
        
        Waiter xiaoY = new Waiter();
        xiaoY.manage(sLock);
        Bag bag = new Bag(BagType.S);
        Ticket result = xiaoY.store(bag);
        
        Assertions.assertEquals(result.getLockerType(), ticketType);
    }
}
