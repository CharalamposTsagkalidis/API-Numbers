package regnonize_numbers.regnonizenumbers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import regnonize_numbers.regnonizenumbers.helper.ResponseNumbers;
import regnonize_numbers.regnonizenumbers.models.GeneralNumbersModel;
import regnonize_numbers.regnonizenumbers.services.GeneralNumbersService;
import regnonize_numbers.regnonizenumbers.services.RGeneralNumbersService;

import java.util.List;

@RequestMapping("/service")
@RestController
public class NumbersController {

    private final GeneralNumbersService generalNumbersService;
    private final RGeneralNumbersService rGeneralNumbersService;

    public NumbersController(GeneralNumbersService generalNumbersService, 
                             RGeneralNumbersService rGeneralNumbersService) {
        this.generalNumbersService = generalNumbersService;
        this.rGeneralNumbersService = rGeneralNumbersService;
    }

    @PostMapping("/fnumber")
    public Mono<ResponseNumbers> getAllNumbersSecond(@RequestBody GeneralNumbersModel generalNumbersModel) {
        return rGeneralNumbersService.getRAllNumbers(generalNumbersModel.getNumbers());
    }

    @GetMapping("/test")
    public String testString() {
        return "Hello, this is a test endpoint!";
    }

    @PostMapping("/numbers")
    public ResponseNumbers getAllNumbers(@RequestBody GeneralNumbersModel generalNumbersModel) {
        return this.generalNumbersService.getAllNumbers(generalNumbersModel.getNumbers());
    }

}
