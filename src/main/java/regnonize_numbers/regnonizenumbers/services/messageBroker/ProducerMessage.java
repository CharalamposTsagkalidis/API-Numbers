package regnonize_numbers.regnonizenumbers.services.messageBroker;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class ProducerMessage {
    private final RabbitTemplate rabbitTemplate;

    public ProducerMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("demo-queue", message);
    }
}
