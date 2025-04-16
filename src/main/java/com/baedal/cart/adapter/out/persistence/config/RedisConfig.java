package com.baedal.cart.adapter.out.persistence.config;

import com.baedal.cart.adapter.in.web.dto.CartDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, CartDto> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, CartDto> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(CartDto.class));
        return template;
    }
}