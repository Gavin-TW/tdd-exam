package com.tw.tdd.exam.pojo;

import lombok.Data;

/**
 * @author Gavin
 */
@Data
public class Bag {
    
    private String type;
    
    public Bag(String type) {
        this.type = type;
    }
}
