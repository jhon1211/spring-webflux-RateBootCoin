package com.bank.RateBitcoin.service.Impl;

import com.bank.RateBitcoin.model.RateBitcoin;
import com.bank.RateBitcoin.service.RateBitcoinService;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@AllArgsConstructor
@Service
public class RateBitcoinServiceImpl implements RateBitcoinService {
    private final ReactiveRedisOperations<String, RateBitcoin> rateBitcoinOpps;
    private final KafkaTemplate<String, RateBitcoin> kafkaTemplate;


    @Override
    public Flux<RateBitcoin> findAll() {
        return rateBitcoinOpps.opsForList().range("rates", 0, 10);
    }

    @Override
    public Mono<Boolean> save(String key, RateBitcoin rateBitcoin) {
        return  rateBitcoinOpps.opsForValue().set(key, rateBitcoin);
    }

    @Override
    public Mono<RateBitcoin> findByKey(String key) {
        return rateBitcoinOpps.opsForValue().get(key);
    }

    @Override
    public Mono<Boolean> delete(String key) {
        return rateBitcoinOpps.opsForValue().delete(key);
    }

    @Override
    public void sendPayments(RateBitcoin rateBitcoin) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void recibePayments() {
        // TODO Auto-generated method stub
        
    }
    
}
