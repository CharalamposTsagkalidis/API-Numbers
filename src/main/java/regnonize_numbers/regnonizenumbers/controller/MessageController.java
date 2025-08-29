package regnonize_numbers.regnonizenumbers.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import regnonize_numbers.regnonizenumbers.services.messageBroker.ProducerMessage;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/service/messages")
@RestController
public class MessageController {

    private final ProducerMessage producerMessage;

    public MessageController(ProducerMessage producerMessage) {
        this.producerMessage = producerMessage;
    }


    @PostMapping
    public String sendMessage(@RequestBody String message) {
        producerMessage.sendMessage(message);
        return "Message sent to the queue: " + message;
    }
}
