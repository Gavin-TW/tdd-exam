package com.tw.tdd.exam.pojo;

import lombok.Data;

/**
 * @author Gavin
 */
@Data
public class Ticket {
    private String lockerType;
    
    public Ticket(String lockerType) {
        this.lockerType = lockerType;
    }
}
