package cn.sixlab.minesitex.lib.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

public interface MqContainer {
    
    @Bean
    default RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
    
        container.setConnectionFactory(connectionFactory);
        addListener(container);
        
        return container;
    }
    
    void addListener(RedisMessageListenerContainer container);
}
