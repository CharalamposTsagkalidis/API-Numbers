package regnonize_numbers.regnonizenumbers.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import regnonize_numbers.regnonizenumbers.helper.ResponseNumbers;
import regnonize_numbers.regnonizenumbers.models.GeneralNumbersModel;
import regnonize_numbers.regnonizenumbers.services.GeneralNumbersService;
import regnonize_numbers.regnonizenumbers.services.RGeneralNumbersService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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

    @PostMapping("/fnumbers")
    public Mono<ResponseNumbers> getAllNumbersSecond(@RequestBody GeneralNumbersModel generalNumbersModel) {
        return this.rGeneralNumbersService.getRAllNumbers(generalNumbersModel.getNumbers());
    }

    @GetMapping("/test")
    public String testString() {
        return "Hello, this is a test endpoint!";
    }

    @PostMapping("/numbers")
    public ResponseNumbers getAllNumbers(@RequestBody GeneralNumbersModel generalNumbersModel) {
        return this.generalNumbersService.getAllNumbers(generalNumbersModel.getNumbers());
    }

    @PostMapping("/prime-or-composite")
    public List<String> checkPrimeOrComposite(@RequestBody GeneralNumbersModel longNumbers) {
        return this.generalNumbersService.primeOrComposite(longNumbers);
    }

    @PostMapping("/fibonacci")
    public Integer fibonacciResult(@RequestBody ArrayList<Integer> numbers) {
        return this.generalNumbersService.fibonacciResult(numbers);

    }

}
