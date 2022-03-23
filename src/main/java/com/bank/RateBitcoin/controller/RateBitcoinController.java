package com.bank.RateBitcoin.controller;

import com.bank.RateBitcoin.model.RateBitcoin;
import com.bank.RateBitcoin.service.RateBitcoinService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@AllArgsConstructor
@RestController
@RequestMapping("rate-bitcoin")
public class RateBitcoinController {
    private final RateBitcoinService service;


    @GetMapping()
    public Flux<RateBitcoin> findAll() {
      return service.findAll();
    }
    @GetMapping("/{key}")
    public Mono<RateBitcoin> findByKey(@PathVariable("key") String key) {
        return service.findByKey(key);
    }
    @PostMapping("/{key}")
      public Mono<Boolean> save(@PathVariable("key") String key, @RequestBody RateBitcoin rateBitcoin) {
          return  service.save(key, rateBitcoin);
         
      }
    @DeleteMapping("/{key}")
      public Mono<Boolean> delete(@PathVariable("key") String key) {   
          return service.delete(key);
      }
      @PostMapping("send")
      public void send(@RequestBody RateBitcoin rateBitcoin){
          service.sendPayments(rateBitcoin);
      }
    
}
