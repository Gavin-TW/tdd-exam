package com.tw.tdd.exam;

import com.tw.tdd.exam.exception.StoreException;
import com.tw.tdd.exam.pojo.Bag;
import com.tw.tdd.exam.pojo.Ticket;

/**
 * @author Gavin
 */
public interface Storeable {
    Ticket store(Bag bag) throws StoreException;
}
