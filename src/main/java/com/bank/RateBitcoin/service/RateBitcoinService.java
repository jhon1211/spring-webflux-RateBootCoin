package com.bank.RateBitcoin.service;

import com.bank.RateBitcoin.model.RateBitcoin;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RateBitcoinService {
    public Flux<RateBitcoin> findAll();
    public Mono<Boolean> save(String key, RateBitcoin rateBitcoin);
    public Mono<RateBitcoin> findByKey(String key);
    public Mono<Boolean> delete(String key);
    public void sendPayments(RateBitcoin rateBitcoin);
    public void recibePayments();
}
