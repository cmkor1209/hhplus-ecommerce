package com.hanghae.e_commerce.domain.user.exception;

public class OutOfBalanceException extends Throwable {
    public OutOfBalanceException() {
        super("잔액이 부족합니다.");
    }
}
