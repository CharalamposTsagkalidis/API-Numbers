package regnonize_numbers.regnonizenumbers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import regnonize_numbers.regnonizenumbers.models.GeneralNumbersModel;
import regnonize_numbers.regnonizenumbers.services.GeneralNumbersService;
import java.util.List;

@RequestMapping("/service")
@RestController
public class NumbersController {

    private final GeneralNumbersService generalNumbersService;

    public NumbersController(GeneralNumbersService generalNumbersService) {
        this.generalNumbersService = generalNumbersService;
    }

    @GetMapping("/test-mono")
    public Mono<String> test() {
        return Mono.just("Hello, this is a test endpoint!");
    }

    @GetMapping("/test")
    public String testString() {
        return "Hello, this is a test endpoint!";
    }

    @GetMapping("/testnumber")
    public Flux<List<Long>> typeNumber() {
        return null;
    }

    @PostMapping("/numbers")
    public String getAllNumbers(@RequestBody GeneralNumbersModel generalNumbersModel) {
        return this.generalNumbersService.getAllNumbers(generalNumbersModel.getNumbers())
                .toString();
    }

}
