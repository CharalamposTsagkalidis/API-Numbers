package regnonize_numbers.regnonizenumbers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import regnonize_numbers.regnonizenumbers.models.GeneralNumbersModel;

import java.util.List;
@RequestMapping("/api")
@RestController
public class NumbersController {

    @GetMapping("/testnumber")
    public Flux<List<Long>> typeNumber() {
        return null;
    }

    public List<GeneralNumbersModel> getAllNumbers(@RequestBody GeneralNumbersModel generalNumbersModel) {
        return null;
    }

    

}
