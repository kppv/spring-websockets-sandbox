package ru.sandbox.websocks.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer {

    public static final String NOTIFICATIONS_BROKER_ADDRESS = "/notifications";

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Точка входа для подключения SockJs
        registry.addEndpoint("/socket/sockJs/")
                .setAllowedOrigins("*")
                .withSockJS();
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry
                .setApplicationDestinationPrefixes("/app")
                .enableSimpleBroker(NOTIFICATIONS_BROKER_ADDRESS);
    }

}
