package com.tw.tdd.exam;

import com.tw.tdd.exam.exception.PickException;
import com.tw.tdd.exam.type.MessageContent;

/**
 * @author Gavin
 */
public class Waiter extends AbstractManager implements Storeable {
    
    public void makeAMistakeWhenGetBag() throws PickException {
        throw new PickException(MessageContent.WAITER_MISTAKE);
    }
}
