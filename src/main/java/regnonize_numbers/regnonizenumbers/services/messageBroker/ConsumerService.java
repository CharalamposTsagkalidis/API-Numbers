package regnonize_numbers.regnonizenumbers.services.messageBroker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @RabbitListener(queues = "demo-queue")
    public void receiveMessage(String message) {
        System.out.println("Received message from the queue: " + message);
    }
}
