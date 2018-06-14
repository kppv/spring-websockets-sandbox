package ru.sandbox.websocks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.sandbox.websocks.dto.PayloadDto;

import java.util.Random;

import static ru.sandbox.websocks.config.StompConfig.NOTIFICATIONS_BROKER_ADDRESS;

/**
 * Created by kurdyukovpv on 14.06.2018.
 */
@Service
public class SomeService {

    private final SimpMessagingTemplate template;

    @Autowired
    public SomeService(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Scheduled(fixedDelay = 1000L)
    public void toXYZ() {
        PayloadDto payload = PayloadDto.builder().id(new Random().nextLong()).text("xyz").build();
        template.convertAndSendToUser("xyz", NOTIFICATIONS_BROKER_ADDRESS, payload);
    }

    @Scheduled(fixedDelay = 1500L)
    public void toZYX() {
        PayloadDto payload = PayloadDto.builder().id(new Random().nextLong()).text("zyx").build();
        template.convertAndSendToUser("zyx", NOTIFICATIONS_BROKER_ADDRESS, payload);
    }

    @Scheduled(fixedDelay = 2500L)
    public void forAll() {
        PayloadDto payload = PayloadDto.builder().id(new Random().nextLong()).text("FOR ALL").build();
        template.convertAndSend(NOTIFICATIONS_BROKER_ADDRESS, payload);
    }
}
