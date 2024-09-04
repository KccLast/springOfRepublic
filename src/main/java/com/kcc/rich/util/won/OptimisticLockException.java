package com.kcc.rich.util.won;

public class OptimisticLockException extends Exception{
    public OptimisticLockException(String msg){
        super(msg);
    }
}
