package com.bank.RateBitcoin.config;

import com.bank.RateBitcoin.model.RateBitcoin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {
    @Bean
    ReactiveRedisOperations<String, RateBitcoin> redisOperations(ReactiveRedisConnectionFactory factory) {
    Jackson2JsonRedisSerializer<RateBitcoin> serializer = new Jackson2JsonRedisSerializer<>(RateBitcoin.class);

    RedisSerializationContext.RedisSerializationContextBuilder<String, RateBitcoin> builder =
        RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

    RedisSerializationContext<String, RateBitcoin> context = builder.value(serializer).build();

    return new ReactiveRedisTemplate<>(factory, context);
  }
}
